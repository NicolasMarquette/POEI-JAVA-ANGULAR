package view;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;

public interface MenuView<T, PK> {

	public void setController(Controller controller);
	
	public void afficherMenuPrincipal() throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuAuthentification() throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuSecretaire() throws ClassNotFoundException, SQLException, IOException;
	
	public void menuPatientFile(PK id) throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuMedecin() throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuOrdonnance(T obj) throws ClassNotFoundException, SQLException, IOException;
	
}
