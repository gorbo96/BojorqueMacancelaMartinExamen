package ec.edu.ups.jpa;

import ec.edu.ups.dao.GuiaDAO;
import ec.edu.ups.entidades.GuiaTelefonica;

public class JPAGuiaDAO extends JPAGenericDAO<GuiaTelefonica, Integer> implements GuiaDAO{

	public JPAGuiaDAO() {
		super(GuiaTelefonica.class);		
	}

}
