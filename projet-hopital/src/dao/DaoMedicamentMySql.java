package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionManager;
import model.Medicament;

public class DaoMedicamentMySql implements DaoMedicament {

	@Override
	public List<Medicament> findAll() throws ClassNotFoundException, SQLException, IOException {

		ArrayList<Medicament> listeMedicaments = new ArrayList<Medicament>();

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "SELECT * FROM medicaments";

		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Medicament medicament = new Medicament();
			medicament.setIdMedicament(rs.getInt("idMedicament"));
			medicament.setNomMedicament(rs.getString("nomMedicament"));
			medicament.setPrix(rs.getInt("prix"));
			medicament.setQuantite(rs.getInt("quantite"));
			listeMedicaments.add(medicament);
		}

		ps.close();
		rs.close();

		return listeMedicaments;
	}

	@Override
	public Medicament findById(Integer id) throws ClassNotFoundException, SQLException, IOException {

		Medicament medicament = null;
		
		Connection conn = ConnectionManager.getInstance().getConn();
		
		String sql = "SELECT * FROM medicaments where idMedicament = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			medicament = new Medicament(rs.getInt("idMedicament"), rs.getString("nomMedicament"), rs.getInt("prix"), rs.getInt("quantite"));
		}
		
		ps.close();
		rs.close();
		
		return medicament;
	}

	@Override
	public void create(Medicament obj) throws ClassNotFoundException, SQLException, IOException {
		
		Connection conn = ConnectionManager.getInstance().getConn();
		
		String sql = "INSERT INTO medicaments VALUES (?, ?, ?, ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, obj.getIdMedicament());
		ps.setString(2, obj.getNomMedicament());
		ps.setInt(3, obj.getPrix());
		ps.setInt(4, obj.getQuantite());
		ps.executeUpdate();
		
		ps.close();
	}

	@Override
	public void update(Medicament obj) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = ConnectionManager.getInstance().getConn();
		
		String sql = "UPDATE medicaments SET nomMedicament = ?, prix = ?, quantite = ? WHERE idMedicament = ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, obj.getNomMedicament());
		ps.setInt(2, obj.getPrix());
		ps.setInt(3, obj.getQuantite());
		ps.setInt(4, obj.getIdMedicament());
		ps.executeUpdate();
		
		ps.close();
	}

	@Override
	public void delete(Medicament obj) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = ConnectionManager.getInstance().getConn();
		
		String sql = "DELETE FROM medicaments WHERE idMedicament = ?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, obj.getIdMedicament());
		ps.executeUpdate();
		
		ps.close();

	}

	@Override
	public List<Medicament> findByMedicamentName(String name) throws ClassNotFoundException, SQLException, IOException {

		ArrayList<Medicament> listeMedicaments = new ArrayList<Medicament>();
		
		Connection conn = ConnectionManager.getInstance().getConn();
		
		String sql = "SELECT * FROM medicaments where nomMedicament = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
		Medicament medicament = new Medicament();
		medicament.setIdMedicament(rs.getInt("idMedicament"));
		medicament.setNomMedicament(rs.getString("nomMedicament"));
		medicament.setPrix(rs.getInt("prix"));
		medicament.setQuantite(rs.getInt("quantite"));
		listeMedicaments.add(medicament);
	}

		ps.close();
		rs.close();
	
		return listeMedicaments;
	}

	@Override
	public void updateQuantite(Medicament obj) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = ConnectionManager.getInstance().getConn();
		
		String sql = "UPDATE medicaments SET quantite = ? WHERE idMedicament = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, obj.getQuantite());
		ps.setInt(2, obj.getIdMedicament());
		ps.executeUpdate();
		
		ps.close();
	}

}
