package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.entidades.Tipo;
import ec.edu.ups.entidades.Operadora;
import ec.edu.ups.entidades.Telefono;

/**
 * Servlet implementation class GuardarTelfs
 */
@WebServlet("/GuardarTelfs")
public class GuardarTelfs extends HttpServlet {
	private UsuarioDAO usuarioDao;
	private TelefonoDAO telefonoDao;
    private Usuario usuario;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuardarTelfs() {
        super();
        usuarioDao=DAOFactory.getFactory().getUsuarioDAO();
        telefonoDao=DAOFactory.getFactory().getTelefonoDAO();
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
			int cantidad=Integer.parseInt(request.getParameter("numero"));
			int id=Integer.parseInt(request.getParameter("id"));
			usuario=usuarioDao.read(id);
			for(int i=0;i<cantidad;i++) {
				String telf=request.getParameter("tel"+i);
				Tipo tipo=DAOFactory.getFactory().getTipoDAO().read(Integer.parseInt((String)request.getParameter("tipos"+i)));
				System.out.println((String)request.getParameter("tipos"+i));
				Operadora operadora=DAOFactory.getFactory().getOperadoraDAO().read(Integer.parseInt((String)request.getParameter("operadoras"+i)));
				System.out.println((String)request.getParameter("operadoras"+i));
				Telefono tel= new Telefono(telf, usuario, operadora, tipo);
				telefonoDao.create(tel);				
			}
			url="/index.html";
		}catch(Exception e) {
			System.out.println("Exception Servlet: GuardarTelfs "+e.getMessage());
			url="/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
