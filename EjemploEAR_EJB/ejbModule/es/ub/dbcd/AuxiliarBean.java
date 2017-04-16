package es.ub.dbcd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * Session Bean implementation class AuxiliarBean
 */
@Stateless
@Local
public class AuxiliarBean implements AuxiliarBeanLocal {
	
	//Solicitamos la inyección de un recurso
	@Resource(lookup = "java:jboss/datasource/Libros")
	private DataSource bd;
    /**
     * Default constructor. 
     */
    public AuxiliarBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String getAutor() {
		String autorNombre = "";
		try {
			Connection con = bd.getConnection();
			String consulta = "SELECT AU_LNAME, AU_FNAME FROM authors LIMIT 1;";
			ResultSet rs = con.createStatement().executeQuery(consulta);
			rs.beforeFirst();
			while (rs.next()) {
				 autorNombre = rs.getString(1) + " " + rs.getString(2);
			}
			rs.close();
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return autorNombre;
	}

}
