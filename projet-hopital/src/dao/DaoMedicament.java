package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import model.Medicament;

public interface DaoMedicament extends Dao<Medicament, Integer> {

	public List<Medicament> findByMedicamentName(String name) throws ClassNotFoundException, SQLException, IOException; 
	
	public void updateQuantite(Medicament obj) throws ClassNotFoundException, SQLException, IOException; 
}
