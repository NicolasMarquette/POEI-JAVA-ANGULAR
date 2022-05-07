package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionManager;
import model.Authentification;

public class DaoAuthentificationMySql implements DaoAuthentification {

	@Override
	public List<Authentification> findAll() throws ClassNotFoundException, SQLException, IOException {

		ArrayList<Authentification> listeAuth = new ArrayList<Authentification>();

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "SELECT * FROM Authentification";

		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Authentification auth = new Authentification();
			auth.setLogin(rs.getString("login"));
			auth.setPassword(rs.getString("password"));
			auth.setNom(rs.getString("nom"));
			auth.setMetier(rs.getInt("metier"));
			auth.setSalle(rs.getInt("salle"));
			listeAuth.add(auth);
		}

		ps.close();
		rs.close();

		return listeAuth;
	}

	@Override
	public Authentification findById(String id) throws ClassNotFoundException, SQLException, IOException {

		Authentification auth = null;

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "SELECT * FROM authentification WHERE login = ? ";

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
	public void create(Authentification obj) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "INSERT INTO authentification(login, password, nom, metier) VALUES (?, ?, ?, ?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, obj.getLogin());
		ps.setString(2, obj.getPassword());
		ps.setString(3, obj.getNom());
		ps.setInt(4, obj.getMetier());
		ps.executeUpdate();

		ps.close();

	}

	@Override
	public void update(Authentification obj) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "UPDATE authentification SET password = ?, nom = ?, metier = ? WHERE login = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, obj.getPassword());
		ps.setString(2, obj.getNom());
		ps.setInt(3, obj.getMetier());
		ps.setString(4, obj.getLogin());
		ps.executeUpdate();

		ps.close();
	}

	@Override
	public void delete(Authentification obj) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "DELETE FROM authentification WHERE login = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, obj.getLogin());
		ps.executeUpdate();

		ps.close();
	}

	@Override
	public void updatePassword(Authentification obj) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "UPDATE authentification SET password = ? WHERE login = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, obj.getPassword());
		ps.setString(2, obj.getLogin());
		ps.executeUpdate();

		ps.close();
	}


}
