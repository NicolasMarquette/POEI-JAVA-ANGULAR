package srv;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Article;
import model.LigneArticle;

/**
 * Servlet implementation class ServletPanier
 */
@WebServlet("/servletPanier")
public class ServletPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletPanier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		HttpSession x = request.getSession();
		ServletContext app = request.getServletContext();
		ArrayList<Article> listArticles = (ArrayList<Article>) app.getAttribute("articles");

		String nom = request.getParameter("article");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		Article article = listArticles.stream().filter(a -> a.getNom().equals(nom)).findFirst().orElse(null);
		int idarticle = article.getIdArticle();

		HashMap<Integer, LigneArticle> articles = (HashMap<Integer, LigneArticle>) x.getAttribute("panier");

		System.out.println("articles : " + articles);

		if (!articles.containsKey(idarticle)) {
			LigneArticle ligne = new LigneArticle(quantite, article);
			articles.put(idarticle, ligne);
			System.out.println("nouvel article : " + articles);
		} else {
			LigneArticle oldLigne = articles.get(idarticle);
			int oldQuantite = oldLigne.getQuantite();
			LigneArticle newLigne = new LigneArticle(oldQuantite + quantite, article);
			articles.replace(idarticle, newLigne);
			System.out.println("ajout quantite article : " + articles);
		}

		System.out.println("nom : " + nom + " - quantité : " + quantite + " - idarticle : " + idarticle);
		request.getRequestDispatcher("WEB-INF/choixArticles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
