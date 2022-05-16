package connnection.manager;

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
	private Connection conn;

	private static ConnectionManager connectionManager;

	private static final String PATH_PROPERTIES = "jdbc.properties";

	private ConnectionManager() throws ClassNotFoundException, IOException, SQLException {
		setConnection();
	}

	public static ConnectionManager getInstance() throws ClassNotFoundException, IOException, SQLException {

		if (connectionManager == null) {
			connectionManager = new ConnectionManager();
		}
		return connectionManager;
	}

	public void closeConn() throws SQLException {

		if (conn != null) {
			conn.close();
		}
	}

	public Connection getConn() {
		return conn;
	}

	private void setConnection() throws IOException, ClassNotFoundException, SQLException {

		Properties prop = loadPropertiesFile();

		driverClass = prop.getProperty("driver");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");

		Class.forName(driverClass);
		conn = DriverManager.getConnection(url, username, password);
	}

	private Properties loadPropertiesFile() throws IOException {

		Properties prop = new Properties();
		InputStream in = new FileInputStream(PATH_PROPERTIES);
		prop.load(in);
		in.close();

		return prop;
	}

}
