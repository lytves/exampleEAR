package es.uv.dbcd;

import java.io.IOException;

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

@WebServlet("/GetUserName")
public class ControladorGuardaNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Solicitamos la inyección de un EJB
//	@EJB	
//	private ConsultaAutoresRemote consulta;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorGuardaNombre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession(true);
		ConsultaAutoresRemote consulta = (ConsultaAutoresRemote) httpSession.getAttribute("mi_bean");
		
		if (consulta == null) {
			System.out.println("consulta == null");
			try {
				InitialContext ic = new InitialContext();
				consulta = (ConsultaAutoresRemote) ic.lookup("java:global/EjemploEAR/EjemploEAR_EJB/ConsultaAutores!es.ub.dbcd.ConsultaAutoresRemote");
				httpSession.setAttribute("mi_bean", consulta);
			} catch (NamingException e) {
				throw new ServletException(e);
			}
		}
		
		String nombre = request.getParameter("nombre");
		consulta.setUserName(nombre);
		request.setAttribute("nombre", nombre);
		request.getRequestDispatcher("./index.jsp").forward(request, response);
	}

}
