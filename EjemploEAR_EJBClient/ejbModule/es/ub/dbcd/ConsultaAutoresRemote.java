package es.ub.dbcd;

import java.util.Vector;
import javax.ejb.Remote;

@Remote
public interface ConsultaAutoresRemote {
	public Vector<String> getAutores();
	public Vector<String> getAutoresYUsuario();
	public void setUserName(String userName);

}
