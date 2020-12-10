package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Usuario;

/**
 * Servlet implementation class ListarCedula
 */
@WebServlet("/ListarCedula")
public class ListarCedula extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuDAO;
    private Usuario usu;
    private List<Telefono>listaTel;
    private TelefonoDAO telDAO;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCedula() {
        super();
        usuDAO= DAOFactory.getFactory().getUsuarioDAO();   
        telDAO= DAOFactory.getFactory().getTelefonoDAO();        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";		
		try {			
			usu=usuDAO.buscarCedula(request.getParameter("cedula"));
			listaTel=telDAO.buscarTelefono(usu.getId());					
			request.setAttribute("bcedula", usu);
			request.setAttribute("btelefonos", listaTel);			
			getServletContext().setAttribute("bcedula", usu);
			url="/HTMLs/MostrarCedula.jsp";
		}catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
