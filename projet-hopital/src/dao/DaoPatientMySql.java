package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.ConnectionManager;
import model.Authentification;
import model.Patient;

public class DaoPatientMySql implements DaoPatient {

	@Override
	public List<Patient> findAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient findById(Integer id) throws ClassNotFoundException, SQLException, IOException {

		Patient patient = null;
		
		Connection conn = ConnectionManager.getConnectionManager().getConn();
		
		String sql = "SELECT * FROM patients WHERE id = ? ";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

//		if (rs.next()) {
//			patient = new Authentification(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
//					rs.getString("data-naissance"), rs.getInt("age), rs.getString("adresse"), rs.getString("telephone");
//		}
		
		ps.close();
		rs.close();
		
		return patient;
	}

	@Override
	public void create(Patient obj) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = ConnectionManager.getConnectionManager().getConn();

		String sql = "insert into patients(nom, prenom, date-naissance, adresse, telephone) values (?, ?, ?, ?, ?)";

		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, obj.getNom());
//		ps.setString(2, obj.getPrenom());
//		ps.setString(3, obj.getDateNaissance());
//		ps.setString(4, obj.getAdresse());
//		ps.setString(4, obj.getTelephone());
		ps.executeUpdate();
	}

	@Override
	public void update(Patient obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Patient obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
