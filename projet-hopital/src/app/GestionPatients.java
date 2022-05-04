package app;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;
import view.MenuPrincipal;

public class GestionPatients {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		MenuPrincipal view = new MenuPrincipal();
		Controller controller = new Controller(view);
		
		controller.run();
	}

}
