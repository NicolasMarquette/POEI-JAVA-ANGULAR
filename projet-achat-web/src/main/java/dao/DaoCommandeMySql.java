package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Commande;

public class DaoCommandeMySql implements DaoCommande {

	@Override
	public List<Commande> findAll() throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande findById(Integer id) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Commande obj) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");
		String sql = "INSERT INTO commandes(id, emailClient, date, prixTot, infos) VALUES (?,?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, obj.getId());
		ps.setString(2, obj.getEmailClient());
		ps.setString(3, obj.getDate());
		ps.setInt(4, obj.getPrixTot());
		ps.setString(5, obj.getInfos());

		ps.executeUpdate();

		ps.close();

	}

	@Override
	public void update(Commande obj) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Commande obj) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub

	}

}
