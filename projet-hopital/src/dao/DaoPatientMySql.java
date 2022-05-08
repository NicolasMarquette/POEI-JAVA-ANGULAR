package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionManager;
import model.Patient;

public class DaoPatientMySql implements DaoPatient {

	@Override
	public List<Patient> findAll() throws ClassNotFoundException, SQLException, IOException {

		ArrayList<Patient> patients = new ArrayList<Patient>();

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "SELECT * FROM patients";

		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Patient patient = new Patient();
			patient.setId(rs.getInt("id"));
			patient.setNom(rs.getString("nom"));
			patient.setPrenom(rs.getString("prenom"));
			patient.setDate_naissance(rs.getString("date_naissance"));
			patient.setAge(rs.getInt("age"));
			patient.setAdresse(rs.getString("adresse"));
			patient.setTelephone(rs.getString("telephone"));
			patients.add(patient);
		}

		ps.close();
		rs.close();

		return patients;
	}

	@Override
	public Patient findById(Integer id) throws ClassNotFoundException, SQLException, IOException {

		Patient patient = null;

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "SELECT * FROM patients WHERE id = ? ";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			patient = new Patient(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
					rs.getString("date_naissance"), rs.getInt("age"), rs.getString("adresse"),
					rs.getString("telephone"));
		}

		ps.close();
		rs.close();

		return patient;
	}

	@Override
	public void create(Patient obj) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "insert into patients(id, nom, prenom, date_naissance, adresse, telephone) values (?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, obj.getId());
		ps.setString(2, obj.getNom());
		ps.setString(3, obj.getPrenom());
		ps.setString(4, obj.getDate_naissance());
		ps.setString(5, obj.getAdresse());
		ps.setString(6, obj.getTelephone());
		ps.executeUpdate();

		ps.close();
	}

	@Override
	public void update(Patient obj) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "update patients set adresse = ?, telephone = ? where id = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, obj.getAdresse());
		ps.setString(2, obj.getTelephone());
		ps.setInt(3, obj.getId());
		ps.executeUpdate();

		ps.close();

	}

	@Override
	public void delete(Patient obj) throws ClassNotFoundException, SQLException, IOException {

		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "delete from patients where id = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, obj.getId());
		ps.executeUpdate();

		ps.close();
	}

}
