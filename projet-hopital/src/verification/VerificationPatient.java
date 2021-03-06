package verification;

import java.io.IOException;
import java.sql.SQLException;

import dao.DaoPatientMySql;
import model.Patient;

public class VerificationPatient implements VerificationData<Integer> {

	private int idPatient;

	public VerificationPatient() {

	}

	@Override
	public boolean verify(Integer id) throws ClassNotFoundException, SQLException, IOException {

		boolean verif = false;

		Patient patient = new DaoPatientMySql().findById(id);
		if (patient != null) {
			idPatient = patient.getId();

			if (idPatient == id) {
				verif = true;
			}
		}
		return verif;
	}

}
