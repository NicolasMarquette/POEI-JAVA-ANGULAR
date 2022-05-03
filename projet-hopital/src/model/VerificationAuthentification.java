package model;

import java.io.IOException;
import java.sql.SQLException;

import dao.DaoAuthentificationMySql;

public class VerificationAuthentification implements VerificationData<String> {

	private String userPass;

	public VerificationAuthentification() {

	}

	@Override
	public boolean verify(String id) throws ClassNotFoundException, SQLException, IOException {

		boolean verif = false;

		String[] user = id.split("/");

		Authentification auth = new DaoAuthentificationMySql().findById(user[0]);
		if (auth != null) {
			userPass = auth.getLogin() + "/" + auth.getPassword();

			if (userPass.equals(id)) {
				verif = true;
			}
		}
		return verif;
	}

}
