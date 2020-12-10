package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import ec.edu.ups.dao.DAOFactory;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String correo;
	private String clave;
	@ManyToOne
	@JoinColumn
	private GuiaTelefonica guia;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Telefono> telefonosUsuario = new ArrayList<Telefono>();
	@Transient
	private GuiaTelefonica emp=DAOFactory.getFactory().getGuiaDAO().read(1);
	public Usuario() {
		super();
	}
	public Usuario(String nombres,String apellidos,String correo,String clave,String id) {
		this.setApellidos(apellidos);
		this.setClave(clave);
		this.setCorreo(correo);
		this.setNombres(nombres);
		this.setCedula(id);		
		this.setGuia(emp);
		
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public GuiaTelefonica getGuia() {
		return guia;
	}
	public void setGuia(GuiaTelefonica guia) {
		this.guia = guia;
	}
	public List<Telefono> getTelefonos() {
		return telefonosUsuario;
	}
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonosUsuario = telefonos;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((guia == null) ? 0 : guia.hashCode());
		result = prime * result + ((nombres == null) ? 0 : nombres.hashCode());
		result = prime * result + ((telefonosUsuario == null) ? 0 : telefonosUsuario.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (guia == null) {
			if (other.guia != null)
				return false;
		} else if (!guia.equals(other.guia))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		if (telefonosUsuario == null) {
			if (other.telefonosUsuario != null)
				return false;
		} else if (!telefonosUsuario.equals(other.telefonosUsuario))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo
				+ ", clave=" + clave + ", guia=" + guia + ", telefonos=" + telefonosUsuario + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Telefono> getTelefonosUsuario() {
		return telefonosUsuario;
	}
	public void setTelefonosUsuario(List<Telefono> telefonosUsuario) {
		this.telefonosUsuario = telefonosUsuario;
	}
	public GuiaTelefonica getEmp() {
		return emp;
	}
	public void setEmp(GuiaTelefonica emp) {
		this.emp = emp;
	}
	
	
}
