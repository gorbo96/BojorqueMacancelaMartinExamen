package ec.edu.ups.dao;

import ec.edu.ups.jpa.JPADAOFactory;

public abstract class DAOFactory {
	
	protected static DAOFactory factory = new JPADAOFactory();

	public static DAOFactory getFactory() {
		return factory;
	}
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract TelefonoDAO getTelefonoDAO();
	public abstract TipoDAO getTipoDAO();
	public abstract OperadoraDAO getOperadoraDAO();
	public abstract GuiaDAO getGuiaDAO();
	
}
