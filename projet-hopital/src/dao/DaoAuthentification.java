package dao;

import java.io.IOException;
import java.sql.SQLException;

import model.Authentification;

public interface DaoAuthentification extends Dao<Authentification, String> {
	
	public void updatePassword(Authentification obj) throws ClassNotFoundException, SQLException, IOException; 

}
