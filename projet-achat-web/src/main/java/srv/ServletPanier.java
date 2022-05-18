package srv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Article;
import model.Panier;

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

		Panier articles = (Panier) x.getAttribute("panier");
		articles.setPanier(idArticle, article, quantite);
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
