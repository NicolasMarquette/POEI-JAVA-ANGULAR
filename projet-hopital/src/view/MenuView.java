package view;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;

public interface MenuView<T, V, PK> {

	public void setController(Controller controller);
	
	public void afficherMenuPrincipal() throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuAuthentification() throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuSecretaire() throws ClassNotFoundException, SQLException, IOException;
	
	public void menuPatientFile(PK id) throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuMedecin() throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuOrdonnance(V obj) throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuAdmin() throws ClassNotFoundException, SQLException, IOException;
	
}
