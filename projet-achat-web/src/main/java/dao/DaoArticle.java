package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface DaoArticle {

	// select pour la liste de tous les articles
	public static String selectAll() throws ClassNotFoundException, SQLException {
		String res = "idArticle\tnom\tdescription\ttarif\n";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");

		String sql = "select * from articles";

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next())

			res += rs.getObject(1) + "\t" + rs.getObject(2) + "\t" + rs.getObject(3) + "\t" + rs.getObject(4) + "\n";

		conn.close();
		return res;
	}

	// select article via son id
	public static String selectByIdArticle(int idArticle) throws ClassNotFoundException, SQLException {
		String res = "idArticle\tnom\tdescription\ttarif\n";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");

		String sql = "select * from articles where idArticle=" + idArticle;

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next())

			res += rs.getObject(1) + "\t" + rs.getObject(2) + "\t" + rs.getObject(3) + "\t" + rs.getObject(4) + "\n";

		conn.close();
		return res;
	}

	// suppression d'un article via id
	public static void deleteById(int idArticle) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");
		System.out.println("connexion ok");

		String sql = "delete from articles where idArticle=";

		Statement st = (Statement) conn.createStatement();
		int count = st.executeUpdate(sql);
		if (count > 0)
			System.out.println("delete ok " + count);
		else
			System.out.println("delete ko " + count);
		conn.close();
	}

	// update d'un article
	public static void updateArticle(Article p) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgi-db1", "root", "root");
		System.out.println("connexion ok");

		String sql = "update  articles set nom='" + p.getNom() + "',prix='" + p.getTarif() + "',tarif'"
				+ p.getDescription() + "',description'" + "where idArticle =" + p.getIdArticle();

		Statement st = conn.createStatement();

		System.out.println("Update ok");
		conn.close();
	}

	// insert d'un article
	public static void insertArticle(int idArticle, String nom, String description, int tarif) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");
		String sql = "insert into article values (?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, idArticle);
		ps.setString(2, nom);
		ps.setString(3, description);
		ps.setInt(4, tarif);
		
		ps.executeUpdate();
		System.out.println("Insert ok");
		conn.close();
	}

}
