package fr.eni.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BLL.UtilisateurBLL;
import BO.Utilisateurs;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurBLL bll;
	
	@Override
	public void init() throws ServletException {
		bll = new UtilisateurBLL();
	}
	
    /**
     * Default constructor. 
     */
    public Connexion() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		request.setAttribute("ErreurConnexion", false);
		
		String identifiant = request.getParameter("connexion_identifiant");
		String mdp = request.getParameter("connexion_mdp");
		Utilisateurs util = new Utilisateurs();
		
		try {
			util = bll.connexion(identifiant, mdp);
			
		} catch (Exception e) {
			request.setAttribute("erreurs", e.getMessage());
		}
		
		if(util.getNo_utilisateurs() > 0) {
			session = request.getSession();
			session.setAttribute("currentUser", util);

			session.setAttribute("IdUtilisateur", util.getNo_utilisateurs());
			session.setAttribute("userConnected", true);
      
			request.getRequestDispatcher("/Accueil").forward(request, response);
		}else
		{
			request.setAttribute("ErreurConnexion", true);
			request.getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
		}
		
	}

}
