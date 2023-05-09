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
 * Servlet implementation class ModifierProfil
 */
@WebServlet("/ModifierProfil")
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurBLL bll;

	@Override
	public void init() throws ServletException {
		bll = new UtilisateurBLL();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierProfil() {
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
		request.getRequestDispatcher("/WEB-INF/ModifierProfil.jsp").forward(request, response);
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
		String mot_de_passeActuel = request.getParameter("passwordActuel");
		String mot_de_passeNew = request.getParameter("passwordNew");
		String mot_de_passeConfirmation = request.getParameter("passwordConfirmation");

		// TODO : récuperer util actuel via variable de session puis update
		Utilisateurs utilActual = new Utilisateurs();
		HttpSession session = request.getSession();
		int idUtilActual = 0;
		if (session != null) {
			idUtilActual = (int) session.getAttribute("IdUtilisateur");
		}

		if (idUtilActual > 0) {
			Utilisateurs utils = new Utilisateurs();

			utilActual = bll.selectById(idUtilActual);

			try {
				if (mot_de_passeActuel != null
						&& !(bll.connexion(utilActual.getPseudo(), mot_de_passeActuel).getNo_utilisateurs() > 0))
					throw new Exception();

				Utilisateurs util = new Utilisateurs();

				util.setNo_utilisateurs(utilActual.getNo_utilisateurs());
				util.setPseudo(pseudo);
				util.setNom(nom);
				util.setPrenom(prenom);
				util.setEmail(email);
				util.setTelephone(telephone);
				util.setRue(rue);
				util.setCode_postal(code_postal);
				util.setVille(ville);
				util.setAdministrateur(false);

				if (mot_de_passeNew.equals(mot_de_passeConfirmation)) {
					util.setMot_de_passe(mot_de_passeNew);
					bll.update(util);
					
				} else {
					// TODO : Afficher un message d'erreur, les deux mdp sont différents.
					bll.update(util);
				}

				if (util.getNo_utilisateurs() > 0) {
					request.setAttribute("Id_Utils", util.getNo_utilisateurs());
					request.getRequestDispatcher("/WEB-INF/ListeEncheres.jsp").forward(request, response);
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
