package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.entidades.Telefono;

public interface TelefonoDAO extends GenericDAO<Telefono,Integer> {
	public abstract List<Telefono> buscarTelefono(int id);
	public abstract Telefono buscarporTelefono(String telefono);
}
