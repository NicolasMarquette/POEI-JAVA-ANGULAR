package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Article;

public class DaoArticleMySql implements DaoArticle {

	@Override
	public List<Article> findAll() throws ClassNotFoundException, SQLException, IOException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");

		ArrayList<Article> articles = new ArrayList<Article>();

		String sql = "SELECT * FROM articles";

		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Article a = new Article();
			a.setIdArticle(rs.getInt("idarticles"));
			a.setNom(rs.getString("nom"));
			a.setDescription(rs.getString("description"));
			a.setTarif(rs.getInt("tarif"));
			a.setImage(rs.getString("image"));
			articles.add(a);
		}

		conn.close();
		return articles;
	}

	@Override
	public Article findById(Integer id) throws ClassNotFoundException, SQLException, IOException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant-cgi", "root", "root");

		Article article = null;

		String sql = "SELECT * FROM articles WHERE idarticles = ?";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			article = new Article();
			article.setIdArticle(rs.getInt("idarticles"));
			article.setNom(rs.getString("nom"));
			article.setDescription(rs.getString("description"));
			article.setTarif(rs.getInt("tarif"));
			article.setImage(rs.getString("image"));
		}

		conn.close();
		return article;
	}

	@Override
	public void create(Article obj) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Article obj) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Article obj) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		
	}

}
