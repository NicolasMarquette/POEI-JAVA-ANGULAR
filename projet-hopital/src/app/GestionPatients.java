package app;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;
import view.MenuViewLineCommand;

public class GestionPatients {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		MenuViewLineCommand view = new MenuViewLineCommand();
		Controller controller = new Controller(view);
		
		controller.run();
	}

}
