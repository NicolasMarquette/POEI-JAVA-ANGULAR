package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Client;

public class DaoClientMySql implements DaoClient {

	private Connection conn;

	public DaoClientMySql() throws ClassNotFoundException, IOException, SQLException {
//		conn = ConnectionManager.getInstance().getConn();
		
	}

	@Override
	public List<Client> findAll() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");
		ArrayList<Client> listClient = new ArrayList<Client>();

		String sql = "SELECT * FROM clients";

		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Client client = new Client();
			client.setEmail(rs.getString("email"));
			client.setPass(rs.getString("pass"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getString("prenom"));
			client.setAdresse(rs.getString("adresse"));
			client.setTel(rs.getString("tel"));
			client.setInstructions(rs.getString("instructions"));
			listClient.add(client);
		}
		ps.close();
		rs.close();

		return listClient;
	}

	@Override
	public Client findById(String email) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");
		Client client = null;

		String sql = "SELECT * FROM clients WHERE email = ? ";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			client = new Client(rs.getString("email"), rs.getString("pass"), rs.getString("nom"),
					rs.getString("prenom"), rs.getString("adresse"), rs.getString("tel"));
		}
		ps.close();
		rs.close();
		return client;
	}

	@Override
	public void create(Client obj) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");
		String sql = "INSERT INTO clients(email, pass, nom, prenom, adresse, tel) VALUES (?,?,?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, obj.getEmail());
		ps.setString(2, obj.getPass());
		ps.setString(3, obj.getNom());
		ps.setString(4, obj.getPrenom());
		ps.setString(5, obj.getAdresse());
		ps.setString(6, obj.getTel());
		ps.executeUpdate();

		ps.close();

	}

	@Override
	public void update(Client obj) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");
		String sql = "UPDATE clients SET instructions = ? WHERE email = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, obj.getInstructions());
		ps.setString(2, obj.getEmail());

		ps.executeUpdate();

		ps.close();

	}

	@Override
	public void delete(Client obj) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");
		String sql = "DELETE FROM clients WHERE email = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, obj.getEmail());
		ps.executeUpdate();

		ps.close();
	}

}
