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
 * Servlet implementation class MonProfil
 */
@WebServlet("/MonProfil")
public class MonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurBLL bll;

	@Override
	public void init() throws ServletException {
		bll = new UtilisateurBLL();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MonProfil() {
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
		String isMyProfil = null;
		boolean monProfil = true;
		int idVendeur = 0;
		int id = 0;

		String pidVendeur = request.getParameter("idVendeur");

		if (pidVendeur != null && !pidVendeur.isBlank()) {

			idVendeur = Integer.valueOf(pidVendeur);
		}

		
		HttpSession session = request.getSession();
		if (session != null) {
			id = session.getAttribute("IdUtilisateur") != null ? (int) session.getAttribute("IdUtilisateur") : 0;
			//id = (int) session.getAttribute("IdUtilisateur");
		}
		
		if(id == 0 && id != idVendeur)
			monProfil = false;
		

		if (monProfil) {
			

			if (id > 0) {
				Utilisateurs utils = new Utilisateurs();

				utils = bll.selectById(id);

				request.setAttribute("Utilisateur", utils);
				request.setAttribute("MonProfil", monProfil);
			}
		} else {


				Utilisateurs utils = new Utilisateurs();

				utils = bll.selectById(idVendeur);

				request.setAttribute("Utilisateur", utils);
				request.setAttribute("MonProfil", monProfil);

			}

		

		request.getRequestDispatcher("/WEB-INF/MonProfil.jsp").forward(request, response);
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
