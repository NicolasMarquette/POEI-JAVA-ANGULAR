package srv;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoClientMySql;
import model.Client;
import model.Panier;
import verification.VerificationClient;

/**
 * Servlet implementation class ServletAuthentification
 */
@WebServlet("/servletAuthentification")
public class ServletAuthentification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAuthentification() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession x = request.getSession();
		VerificationClient verificationClient = new VerificationClient();
		Client client;
		boolean verifLogin;

		DaoClientMySql daoClientMySql;
		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		String res = "WEB-INF/";

		try {
			verifLogin = verificationClient.verify(email, mdp);
			if (verifLogin) {

				client = new DaoClientMySql().findById(email);
				x.setAttribute("client", client);
				res += "choixArticles";
			} else
				res = "authentification";
			res += ".jsp";
			request.getRequestDispatcher(res).forward(request, response);

			//HashMap<Integer, LigneArticle> articles = new HashMap<Integer, LigneArticle>();
			Panier articles = new Panier();
			x.setAttribute("panier", articles);

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

		response.getWriter().append("Served at: ").append(request.getContextPath());
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
