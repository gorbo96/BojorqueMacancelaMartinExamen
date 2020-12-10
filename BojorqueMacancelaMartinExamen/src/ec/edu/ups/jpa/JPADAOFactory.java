package ec.edu.ups.jpa;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.GuiaDAO;
import ec.edu.ups.dao.OperadoraDAO;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.TipoDAO;
import ec.edu.ups.dao.UsuarioDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new JPAUsuarioDAO();
	}

	@Override
	public TelefonoDAO getTelefonoDAO() {
		// TODO Auto-generated method stub
		return new JPATelefonoDAO();
	}

	@Override
	public TipoDAO getTipoDAO() {
		// TODO Auto-generated method stub
		return new JPATipoDAO();
	}

	@Override
	public OperadoraDAO getOperadoraDAO() {
		// TODO Auto-generated method stub
		return new JPAOperadoraDAO();
	}

	@Override
	public GuiaDAO getGuiaDAO() {
		// TODO Auto-generated method stub
		return new JPAGuiaDAO();
	}

}
