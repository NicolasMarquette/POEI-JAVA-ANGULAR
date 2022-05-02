package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

	private String driverClass;
	private String url;
	private String username;
	private String password;
	private Connection con;

	private static ConnectionManager connectionDataBase;

	private ConnectionManager() throws ClassNotFoundException, IOException, SQLException {
		setConnection();
	}

	public static ConnectionManager getConnection() throws ClassNotFoundException, IOException, SQLException {

		if (connectionDataBase == null) {
			connectionDataBase = new ConnectionManager();
		}
		return connectionDataBase;
	}

	public void closeConnection() throws SQLException {

		if (con != null) {
			con.close();
		}
	}

	private void setConnection() throws IOException, ClassNotFoundException, SQLException {

		Properties prop = loadPropertiesFile();

		driverClass = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");

		Class.forName(driverClass);

		con = DriverManager.getConnection(url, username, password);
	}
	
	private Properties loadPropertiesFile() throws IOException {
		
		Properties prop = new Properties();
		InputStream in = new FileInputStream("jdbc.properties");
		prop.load(in);
		in.close();

		return prop;
	}

}
