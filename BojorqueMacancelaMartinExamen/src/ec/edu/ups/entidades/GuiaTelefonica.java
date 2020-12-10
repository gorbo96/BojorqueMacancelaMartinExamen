package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: GuiaTelefonica
 *
 */
@Entity

public class GuiaTelefonica implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public GuiaTelefonica() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "guia")
	private List<Usuario> usuarios=new ArrayList<Usuario>();	
	public GuiaTelefonica (int id, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void addUsuarios(Usuario usuarios) {
		this.usuarios.add(usuarios);
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
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
		GuiaTelefonica other = (GuiaTelefonica) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GuiaTelefonica [id=" + id + ", nombre=" + nombre + ", usuarios=" + usuarios + "]";
	}
	
   
}
