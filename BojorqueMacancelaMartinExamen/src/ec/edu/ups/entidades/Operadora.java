package ec.edu.ups.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Caracteristicas
 *
 */
@Entity

public class Operadora implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "operadora")
	private List<Telefono> telefonosOperadora= new ArrayList<Telefono>();
	

	public Operadora() {
		super();
	}
   public Operadora(String nombre){
	   this.setNombre(nombre);	   
	   
   }
   public String getNombre() {
	   return nombre;
   }
   public void setNombre(String nombre) {
	   this.nombre = nombre;
   }
   public int getId() {
	   return id;
   }
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
	Operadora other = (Operadora) obj;
	if (id != other.id)
		return false;
	if (nombre == null) {
		if (other.nombre != null)
			return false;
	} else if (!nombre.equals(other.nombre))
		return false;
	return true;
}
@Override
public String toString() {
	return "Operadora [id=" + id + ", nombre=" + nombre + "]";
}
public void setId(int id) {
	this.id = id;
}
public List<Telefono> getTelefonos() {
	return telefonosOperadora;
}
public void setTelefonos(List<Telefono> telefonos) {
	this.telefonosOperadora = telefonos;
}
public void addTelefono(Telefono telf) {
	telefonosOperadora.add(telf);
}
}
