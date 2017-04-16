package es.uv.dbcd;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.ub.dbcd.ConsultaAutoresRemote;

import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "Controlador", urlPatterns = { "/Controlador", "/Autores" })
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(lookup = "java:global/EjemploEAR/EjemploEAR_EJB/ConsultaAutores!es.ub.dbcd.ConsultaAutoresRemote")
	//nivel app - no vale
	//@EJB(lookup = "java:app/EjemploEAR_EJB/ConsultaAutores!es.ub.dbcd.ConsultaAutoresRemote")
	private ConsultaAutoresRemote consulta;

	/**
	 * @see HttpServlet# HttpServlet
	 */
	public Controlador() {
		super();
		System.out.println("Crear*************************************************************************************");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Vector<String> autores = consulta.getAutoresYUsuario();
		System.out.println("Autores: " + autores);
		request.setAttribute("autores", autores);
		request.getRequestDispatcher("/autores.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}