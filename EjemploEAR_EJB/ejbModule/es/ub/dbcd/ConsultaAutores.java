package es.ub.dbcd;

import java.sql.*;
import java.util.Calendar;
import java.util.Vector;

import javax.annotation.*;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * Session Bean implementation class ConsultaAutores
 */
//@Stateless
@Stateful
@LocalBean
public class ConsultaAutores implements ConsultaAutoresRemote {

	// Solicitamos la inyección de un recurso
	@Resource(lookup = "java:jboss/datasource/Libros")
	private DataSource bd;
	private Vector<String> autores = null;
	private String userName = null;

	@EJB
	private AuxiliarBeanLocal auxbean;
	@EJB
	private UtilsBean utilbean;
	/**
	 * Default constructor.
	 */
	public ConsultaAutores() {
		autores = new Vector<String>();
		userName = "No definido";
	}

	@PostConstruct
	public void inicia() {
		try {
			Connection con = bd.getConnection();
			String consulta = "SELECT AU_LNAME, AU_FNAME FROM authors;";
			ResultSet rs = con.createStatement().executeQuery(consulta);
			rs.beforeFirst();
			while (rs.next()) {
				autores.add(rs.getString(1) + " " + rs.getString(2));
			}
			rs.close();
			con.close();
			autores.add(auxbean.getAutor());
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Vector<String> getAutores() {
		return autores;
	}
	
	@Override
	public Vector<String> getAutoresYUsuario() {
		Vector<String> autoresYUsuario = new Vector<String>();
		autoresYUsuario.addAll(autores);
		autoresYUsuario.add(userName);
		autoresYUsuario.add("" + String.valueOf(utilbean.getDate().get(Calendar.YEAR))
			+ "-" + String.valueOf(utilbean.getDate().get(Calendar.MONTH)+1)
			+ "-" +String.valueOf(utilbean.getDate().get(Calendar.DAY_OF_MONTH)));
		autoresYUsuario.add(String.valueOf(utilbean.getHits()));
		return autoresYUsuario;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
