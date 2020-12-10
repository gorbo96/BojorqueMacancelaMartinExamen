package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.OperadoraDAO;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.TipoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.entidades.Operadora;
import ec.edu.ups.entidades.Telefono;
import ec.edu.ups.entidades.Tipo;
import ec.edu.ups.entidades.Usuario;

/**
 * Servlet implementation class NuevoTelefono
 */
@WebServlet("/NuevoTelefono")
public class NuevoTelefono extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private TelefonoDAO telefonoDao;
	private Telefono telefono;
	private OperadoraDAO operadoraDao;
	private Operadora operadora;
	private TipoDAO tipoDao;
	private Tipo tipo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NuevoTelefono() {
        super();        
        telefonoDao=DAOFactory.getFactory().getTelefonoDAO();
        operadoraDao=DAOFactory.getFactory().getOperadoraDAO();
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
			Usuario usuario=(Usuario) request.getAttribute("usu");
			operadora=operadoraDao.read(Integer.parseInt(request.getParameter("operadora")));
			tipo=tipoDao.read(Integer.parseInt(request.getParameter("tipo")));
			telefono=new Telefono(request.getParameter("numero"), usuario, operadora, tipo);
			telefonoDao.create(telefono);
			url = "/index.html";
		}catch(Exception e) {
			 e.printStackTrace();
			    url = "/JSPs/error.jsp";
		}		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
