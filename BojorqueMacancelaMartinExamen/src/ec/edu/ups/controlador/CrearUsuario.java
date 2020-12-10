package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Usuario;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDao;
    private Usuario usuario;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        usuarioDao=DAOFactory.getFactory().getUsuarioDAO();
        // TODO Auto-generated constructor stub
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
		String url = null;
		try {		
			usuario= new Usuario(request.getParameter("nombres"), request.getParameter("apellidos"), request.getParameter("correo"), request.getParameter("clave"), request.getParameter("cedula"));		   
		    usuarioDao.create(usuario);		    
			request.setAttribute("usuario",usuario);
			request.setAttribute("cantidad",request.getParameter("cantidad"));	    
		    url = "/HTMLs/ingresarTelefono.jsp";
		} catch (Exception e) {
		    e.printStackTrace();
		    url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	    }	

}
