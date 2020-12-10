package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.GuiaDAO;
import ec.edu.ups.dao.OperadoraDAO;
import ec.edu.ups.dao.TipoDAO;
import ec.edu.ups.entidades.GuiaTelefonica;
import ec.edu.ups.entidades.Operadora;
import ec.edu.ups.entidades.Tipo;

/**
 * Servlet implementation class CrearDatos
 */
@WebServlet("/CrearDatos")
public class CrearDatos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearDatos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		TipoDAO tipoDAO=DAOFactory.getFactory().getTipoDAO();		
		OperadoraDAO operDAO=DAOFactory.getFactory().getOperadoraDAO();
		GuiaDAO guiaDAO=DAOFactory.getFactory().getGuiaDAO();
		Tipo tipo1=new Tipo("Fijo",0);
		Tipo tipo2=new Tipo("Celular",0);
		Tipo tipo3=new Tipo("Satelital",0);
		tipoDAO.create(tipo1);
		tipoDAO.create(tipo2);
		tipoDAO.create(tipo3);
		Operadora oper1=new Operadora("Movistar");
		Operadora oper2=new Operadora("Claro");
		Operadora oper3=new Operadora("CNT");
		Operadora oper4=new Operadora("Tuenti");
		operDAO.create(oper1);
		operDAO.create(oper2);
		operDAO.create(oper3);
		operDAO.create(oper4);
		GuiaTelefonica guia = new GuiaTelefonica(0,"Guia Principal Cuenca");
		guiaDAO.create(guia);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
