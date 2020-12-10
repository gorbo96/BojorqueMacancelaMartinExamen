package ec.edu.ups.jpa;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.GuiaDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.GuiaTelefonica;
import ec.edu.ups.entidades.Usuario;

public class JPAUsuarioDAO extends JPAGenericDAO<Usuario, Integer> implements UsuarioDAO{	
	private GuiaDAO guiaDAO;
	public JPAUsuarioDAO() {
		super(Usuario.class);
		guiaDAO=DAOFactory.getFactory().getGuiaDAO();
		
	}
	public Usuario validarU(String correo, String password) {		
		Usuario usuario=null;		
		String consulta="SELECT u FROM Usuario u WHERE u.correo= :correo AND u.clave= :password ";		
		try {
			Usuario respuesta=(Usuario) em.createQuery(consulta).setParameter("correo", correo).setParameter("password", password).getSingleResult();			
		}catch(Exception e) {
			System.out.println(">>>WARNING (JPAUsuarioDAO:validarU): " + e.getMessage());
		}
		return usuario;
	}	
	public List<Usuario> findU(int id) {
		List<Usuario> respuesta = new ArrayList<Usuario>();		
		
		GuiaTelefonica guia = guiaDAO.read(id);		
		String consulta =("SELECT u FROM Usuario u WHERE u.guia=:id AND u.rol = 'U'");
		try {
				respuesta=(List<Usuario>)em.createQuery(consulta).setParameter("id", guia).getResultList();				
		}catch(Exception e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:findU): " + e.getMessage());
		}
		return respuesta;
	}
	public Usuario buscarCedula(String cedula) {
		Usuario respuesta = null;
		String consulta =("SELECT u FROM Usuario u WHERE u.cedula='"+cedula+"'");
		try {			
			respuesta=(Usuario)this.em.createQuery(consulta).getSingleResult();			
		}catch(Exception e) {
			System.out.println(">>>WARNING (JDBCUsuarioDAO:buscarCedula): " + e.getMessage());
		}		    
		return respuesta;
	}		
}
