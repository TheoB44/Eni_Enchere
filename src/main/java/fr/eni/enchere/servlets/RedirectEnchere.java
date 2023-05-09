package fr.eni.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RedirectEnchere
 */
@WebServlet("/RedirectEnchere")
public class RedirectEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectEnchere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean monProfil = true;
		int idVendeur = 0;
		int id = 0;
		int idArticle = 0;

		String pidVendeur = request.getParameter("idVendeur");

		if (pidVendeur != null && !pidVendeur.isBlank()) {
			idVendeur = Integer.valueOf(pidVendeur);
		}

		HttpSession session = request.getSession();
		if (session != null) {
			id = session.getAttribute("IdUtilisateur") != null ? (int) session.getAttribute("IdUtilisateur") : 0;
		}

		if(id == 0 && id != idVendeur)
			monProfil = false;

		String pidArticle = request.getParameter("idArticle");
		if (pidArticle != null && !pidArticle.isBlank()) {
			idArticle = Integer.valueOf(pidArticle);
		}

		if(monProfil) {
			
		request.setAttribute("idArticle", pidArticle);
		request.setAttribute("IsAlreadyCreated", true);
		
		request.getRequestDispatcher("/NouvelleVente").forward(request, response);
			
		}
		else {
			request.setAttribute("idArticle", idArticle);
			request.setAttribute("idVendeur", idVendeur);	
			request.getRequestDispatcher("/DetailVente").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
