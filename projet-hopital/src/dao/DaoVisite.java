package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Visite;

public interface DaoVisite extends Dao<Visite, Integer> {
	
	public List<Visite> findByIdPatient(int id) throws ClassNotFoundException, SQLException, IOException;
	
	public List<Visite> findByNameMedecin(String name) throws ClassNotFoundException, SQLException, IOException;

}
