package ec.edu.ups.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidades.Telefono;


/**
 * Servlet implementation class ListarTelefono
 */
@WebServlet("/ListarTelefono")
public class ListarTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Telefono listaTel;
    private TelefonoDAO telDAO;  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTelefono() {
        super();          
        telDAO= DAOFactory.getFactory().getTelefonoDAO(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="";		
		try {						
			listaTel=telDAO.buscarporTelefono(request.getParameter("telefono"));			
			request.setAttribute("btelefonos", listaTel);			
			url="/HTMLs/MostrarTelefono.jsp";
		}catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
