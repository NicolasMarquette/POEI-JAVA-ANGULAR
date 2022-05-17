package dao;

import java.io.IOException;
import java.sql.SQLException;

import model.Client;

public interface DaoClient extends Dao<Client, String>{
	public Client findByEmailMdp(String email, String mdp) throws ClassNotFoundException, SQLException, IOException;
}
