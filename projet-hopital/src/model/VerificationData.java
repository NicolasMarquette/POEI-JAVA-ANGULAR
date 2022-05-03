package model;

import java.io.IOException;
import java.sql.SQLException;

public interface VerificationData<T> {
	
	public boolean verify(T id) throws ClassNotFoundException, SQLException, IOException;

}
