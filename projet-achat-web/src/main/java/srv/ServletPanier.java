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

		int idArticle = Integer.parseInt(request.getParameter("article"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		Article article = listArticles.stream().filter(a -> a.getIdArticle() == idArticle).findFirst().orElse(null);

		HashMap<Integer, LigneArticle> articles = (HashMap<Integer, LigneArticle>) x.getAttribute("panier");

		System.out.println("articles : " + articles);

		if (!articles.containsKey(idArticle)) {
			articles.put(idArticle, new LigneArticle(quantite, article));
			System.out.println("nouvel article : " + articles);
		} else {
			LigneArticle oldLigne = articles.get(idArticle);
			int oldQuantite = oldLigne.getQuantite();
			LigneArticle newLigne = new LigneArticle(oldQuantite + quantite, article);
			articles.replace(idArticle, newLigne);
			System.out.println("ajout quantite article : " + articles);
		}

		System.out.println("id : " + idArticle + " - quantité : " + quantite + " - idarticle : " + idArticle);
		
		x.setAttribute("panier", articles);
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
