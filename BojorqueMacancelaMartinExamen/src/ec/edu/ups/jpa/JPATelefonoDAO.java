package ec.edu.ups.jpa;


import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.TelefonoDAO;

import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Usuario;

public class JPATelefonoDAO extends JPAGenericDAO<Telefono, Integer> implements TelefonoDAO{
	
	public JPATelefonoDAO() {
		super(Telefono.class);		
	}
	public List<Telefono> buscarTelefono(int id) {
		List<Telefono> respuesta = new ArrayList<Telefono>();
		String consulta =("SELECT t FROM Telefono t WHERE t.usuario.id='"+id+"'");
		try {			
			respuesta=(List<Telefono>)this.em.createQuery(consulta).getResultList();			
		}catch(Exception e) {
			System.out.println(">>>WARNING (JPATelefonoDAO:buscarTelefono): " + e.getMessage());
		}		    
		return respuesta;
	}
	public Telefono buscarporTelefono(String telefono) {
		Telefono respuesta = null;
		String consulta =("SELECT t FROM Telefono t WHERE t.numero='"+telefono+"'");
		try {			
			respuesta=(Telefono)this.em.createQuery(consulta).getSingleResult();			
		}catch(Exception e) {
			System.out.println(">>>WARNING (JPATlefonoDAO:buscarporTelefono): " + e.getMessage());
		}		    
		return respuesta;
	}
}
