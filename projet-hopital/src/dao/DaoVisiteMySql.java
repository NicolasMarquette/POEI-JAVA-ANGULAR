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
import model.Visite;

public class DaoVisiteMySql implements DaoVisite {

	@Override
	public List<Visite> findAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Visite findById(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Visite obj) throws ClassNotFoundException, SQLException, IOException {
		
		Connection conn = ConnectionManager.getInstance().getConn();

		String sql = "insert into visites(idpatient, date, medecin, num_salle, tarif) values (?, ?, ?, ?, ?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, obj.getIdPatient());
		ps.setString(2, obj.getDate());
		ps.setString(3, obj.getMedecin());
		ps.setInt(4, obj.getNum_salle());
		ps.setInt(5, obj.getTarif());
		ps.executeUpdate();
		
	}

	@Override
	public void update(Visite obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Visite obj) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Visite> findByIdPatient(int id) throws ClassNotFoundException, SQLException, IOException {

		ArrayList<Visite> visites = new ArrayList<Visite>();
		
		Connection conn = ConnectionManager.getInstance().getConn();
		
		String sql = "SELECT * FROM visites WHERE idpatient = ? ";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Visite visite = new Visite();
			visite.setId(rs.getInt("id"));
			visite.setIdPatient(rs.getInt("idpatient"));
			visite.setDate(rs.getString("date"));
			visite.setMedecin(rs.getString("medecin"));
			visite.setNum_salle(rs.getInt("num_salle"));
			visite.setTarif(rs.getInt("tarif"));
			visites.add(visite);
		}
		
		ps.close();
		rs.close();
		
		return visites;
	}

	@Override
	public List<Visite> findByNameMedecin(String name) throws ClassNotFoundException, SQLException, IOException {

		ArrayList<Visite> visites = new ArrayList<Visite>();
		
		Connection conn = ConnectionManager.getInstance().getConn();
		
		String sql = "SELECT * FROM visites WHERE medecin = ? ";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Visite visite = new Visite();
			visite.setId(rs.getInt("id"));
			visite.setIdPatient(rs.getInt("idpatient"));
			visite.setDate(rs.getString("date"));
			visite.setMedecin(rs.getString("medecin"));
			visite.setNum_salle(rs.getInt("num_salle"));
			visite.setTarif(rs.getInt("tarif"));
			visites.add(visite);
		}
		
		ps.close();
		rs.close();
		
		return visites;
	}

}
