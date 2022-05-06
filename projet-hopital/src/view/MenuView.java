package view;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;

public interface MenuView {

	public void setController(Controller controller);
	
	public void afficherMenuPrincipal() throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuAuthentification() throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuSecretaire() throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuMedecin() throws ClassNotFoundException, SQLException, IOException;
	
	public void afficherMenuOrdonnance() throws ClassNotFoundException, SQLException, IOException;
	
}
