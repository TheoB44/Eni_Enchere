package fr.eni.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BLL.UtilisateurBLL;
import BO.Utilisateurs;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurBLL bll;

	@Override
	public void init() throws ServletException {
		bll = new UtilisateurBLL();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String code_postal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String mot_de_passe = request.getParameter("password");
		String mot_de_passeConfirmation = request.getParameter("passwordConfirmation");

		if(mot_de_passe.equals(mot_de_passeConfirmation))
		{
			try {
				Utilisateurs util = new Utilisateurs();
				
				util.setPseudo(pseudo);
				util.setNom(nom);
				util.setPrenom(prenom);
				util.setEmail(email);
				util.setTelephone(telephone);
				util.setRue(rue);
				util.setCode_postal(code_postal);
				util.setVille(ville);
				util.setMot_de_passe(mot_de_passe);
				util.setAdministrateur(false);
				
				bll.insert(util);
				
				if(util.getNo_utilisateurs() > 0) {
					request.setAttribute("Id_Utils", util.getNo_utilisateurs());
					request.getRequestDispatcher("/WEB-INF/ListeEncheres.jsp").forward(request, response);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else
		{
			//TODO : Afficher un message d'erreur, les deux mdp sont différents.
		}
		
	}

}
