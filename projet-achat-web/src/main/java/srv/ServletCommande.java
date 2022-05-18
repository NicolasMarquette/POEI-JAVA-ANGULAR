package srv;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoCommandeMySql;
import model.Client;
import model.Commande;
import model.FormattedDateTime;
import model.LigneArticle;
import model.Panier;

/**
 * Servlet implementation class ServletCommande
 */
@WebServlet("/servletCommande")
public class ServletCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCommande() {
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

		Panier panier = (Panier) x.getAttribute("panier");
		Client client = (Client) x.getAttribute("client");

		String email = client.getEmail();
		String dateTime = FormattedDateTime.getFormattedDateTime();
		int prixTotal = panier.getTotal();

		String infos = "";

		for (LigneArticle la : panier.getPanier().values()) {

			if (!infos.contains(la.getQuantite() + "-" + la.getArticle().getIdArticle())) {
				if (infos == "") {
					infos += "[" + la.getQuantite() + "-" + la.getArticle().getIdArticle();
				} else {
					infos += ";" + la.getQuantite() + "-" + la.getArticle().getIdArticle();
				}

			}

		}
		infos += "]";
		
		Commande commande = new Commande(email, dateTime, prixTotal, infos);
		
		DaoCommandeMySql daoCommande = new DaoCommandeMySql();
		try {
			daoCommande.create(commande);
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
		
		x.setAttribute("total", prixTotal);
		
		Panier articles = new Panier();
		x.setAttribute("panier", articles);
		
		request.getRequestDispatcher("WEB-INF/commande.jsp").forward(request, response);
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
