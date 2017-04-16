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

//@WebServlet("/Controlador")
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador","/Autores"})
public class ControladorWebApp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Solicitamos la inyección de un EJB
	@EJB
	private ConsultaAutoresRemote consulta;

	/**
	 * @see HttpServlet# HttpServlet
	 */
	public ControladorWebApp2() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession httpSession = request.getSession(true);
		ConsultaAutoresRemote consulta = (ConsultaAutoresRemote) httpSession.getAttribute("mi_bean");
		
		if (consulta == null) {
			try {
				InitialContext ic = new InitialContext();
				consulta = (ConsultaAutoresRemote) ic.lookup("java:app/EjemploEAR_EJB/ConsultaAutores!es.ub.dbcd.ConsultaAutoresRemote");
				httpSession.setAttribute("mi_bean", consulta);
			} catch (NamingException e) {
				throw new ServletException(e);
			}
		}
		
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