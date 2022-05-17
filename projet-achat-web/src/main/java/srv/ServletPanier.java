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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession x = request.getSession();	
		ServletContext app=request.getServletContext();
		ArrayList<Article> listArticles= (ArrayList<Article>)app.getAttribute("articles"); 
		
		
		
		String nom = request.getParameter("article");
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		
	
		Article article = listArticles.stream().filter(a -> a.getNom().equals(nom)).findFirst().orElse(null);
		
		HashMap<Integer, LigneArticle> articles = (HashMap<Integer, LigneArticle>)x.getAttribute("panier");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}