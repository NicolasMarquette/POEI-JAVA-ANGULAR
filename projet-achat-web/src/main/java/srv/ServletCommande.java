package srv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Client;
import model.FormattedDateTime;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession x = request.getSession();
		
		Panier panier = (Panier) x.getAttribute("panier");
		Client client = (Client) x.getAttribute("client");
		
		String email = client.getEmail();
		String dateTime = FormattedDateTime.getFormattedDateTime();
		int prixTotal = panier.getTotal();
		
		
		
		System.out.println(email + " " + dateTime + " " + prixTotal);
		
		
		request.getRequestDispatcher("WEB-INF/commande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
