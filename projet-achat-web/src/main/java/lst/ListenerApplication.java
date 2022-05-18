package lst;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dao.DaoArticleMySql;
import model.Article;

/**
 * Application Lifecycle Listener implementation class ListenerApplication
 *
 */
@WebListener
public class ListenerApplication implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public ListenerApplication() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {

		try {
			ArrayList<Article> listeArticles = (ArrayList<Article>) new DaoArticleMySql().findAll();

			sce.getServletContext().setAttribute("articles", listeArticles);
			sce.getServletContext().setAttribute("hidden_deco", "hidden");
			sce.getServletContext().setAttribute("hidden_auth", "");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
