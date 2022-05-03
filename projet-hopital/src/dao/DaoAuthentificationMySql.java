package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.ConnectionManager;
import model.Authentification;

public class DaoAuthentificationMySql implements DaoAuthentification {

	@Override
	public List<Authentification> findAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Authentification findById(String id) throws ClassNotFoundException, SQLException, IOException {

		Authentification auth = null;
		
		Connection conn = ConnectionManager.getConnectionManager().getConn();
		
		String sql = "SELECT * FROM Authentification WHERE login = ? ";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			auth = new Authentification(rs.getString("login"), rs.getString("password"), rs.getString("nom"),
					rs.getInt("metier"), rs.getInt("salle"));
		}
		
		ps.close();
		rs.close();
		
		return auth;
	}

	@Override
	public void create(Authentification obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Authentification obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Authentification obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

	}

}
