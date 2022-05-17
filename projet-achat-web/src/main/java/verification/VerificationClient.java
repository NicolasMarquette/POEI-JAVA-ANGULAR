package verification;

import java.io.IOException;
import java.sql.SQLException;

import dao.DaoClientMySql;
import model.Client;

public class VerificationClient {

	public VerificationClient() {

	}

	public boolean verify(String email, String mdp) throws ClassNotFoundException, SQLException, IOException {
		boolean verif = false;
		Client client = new DaoClientMySql().findByEmailMdp(email, mdp);
		if (client != null)
			verif = true;
	
		return verif;
	}

}
