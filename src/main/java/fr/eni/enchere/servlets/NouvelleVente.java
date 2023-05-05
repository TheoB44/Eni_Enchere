package fr.eni.enchere.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BLL.ArticleBLL;
import BLL.CategorieBLL;
import BLL.UtilisateurBLL;
import BO.Articles_Vendus;
import BO.Categories;

/**
 * Servlet implementation class NouvelleVente
 */
@WebServlet("/NouvelleVente")
public class NouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurBLL bll;
	private ArticleBLL ArticleBll;
	private CategorieBLL bllCategories;

	@Override
	public void init() throws ServletException {
		bll = new UtilisateurBLL();
		ArticleBll = new ArticleBLL();
		bllCategories = new CategorieBLL();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NouvelleVente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		List<Categories> listeCategories = new ArrayList();
		int idArticle = 0;
		Articles_Vendus article = null;
		
		var test = request.getAttribute("IsAlreadyCreated") != null && request.getAttribute("IsAlreadyCreated") != "" ? (boolean) request.getAttribute("IsAlreadyCreated") : false;

		if (test) {
			
			String pidArticle = request.getParameter("idArticle");
			
			if (pidArticle != null && !pidArticle.isBlank()) {

				idArticle = Integer.valueOf(pidArticle);
			}
			
			if(idArticle > 0) {
				article = ArticleBll.getArticleById(idArticle);
				request.setAttribute("article", article);
			}
		} 

			var adresse = bll.getAdressById((int) session.getAttribute("IdUtilisateur"));
			request.setAttribute("Adresse", adresse);
			var t = bllCategories.listeCategories();
			request.setAttribute("listeCategories", t);
			request.setAttribute("IsAlreadyCreated", test);

		request.getRequestDispatcher("/WEB-INF/NouvelleVente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO faire l'insertion de la vente
		try {
			HttpSession session = request.getSession();
			Articles_Vendus article = null;

			String nomArticle = request.getParameter("nomArticle");
			String description = request.getParameter("description");
			String categorieEnchere = request.getParameter("categorieEnchere");
			String prix = request.getParameter("prix");
			String dateDebut = request.getParameter("dateDebut");
			String dateFin = request.getParameter("dateFin");
			String rue = request.getParameter("rue");
			String code_postal = request.getParameter("code_postal");
			String ville = request.getParameter("ville");
			// String identifiant = request.getParameter("image");
			int idVendeur = (int) session.getAttribute("IdUtilisateur");
			int idCategorie = 0;
			float prixInitial = 0;
			Date dateDeb = null;
			Date dateDeFin = null;

			if (categorieEnchere != null && !categorieEnchere.isBlank()) {

				idCategorie = Integer.valueOf(categorieEnchere);
			}
			if (prix != null && !prix.isBlank()) {

				prixInitial = Float.valueOf(prix);
			}
			if (dateDebut != null && !dateDebut.isBlank()) {

				// try {
				// dateDeb = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebut);
				dateDeb = java.sql.Date.valueOf(dateDebut);
				/*
				 * } catch (ParseException e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); }
				 */
			}
			if (dateFin != null && !dateFin.isBlank()) {

				/*
				 * try { dateDeFin = new SimpleDateFormat("yyyy-MM-dd").parse(dateFin);
				 */
				dateDeFin = java.sql.Date.valueOf(dateFin);
				/*
				 * } catch (ParseException e) { e.printStackTrace(); }
				 */
			}

			if (idCategorie > 0 && prixInitial > 0 && dateDeb != null && dateDeFin != null) {
				
				article = new Articles_Vendus(0, nomArticle, description, dateDeb, dateDeFin, prixInitial, 0, idVendeur,
						idCategorie, null, null, null, null);

				
				boolean vretour = false;
				boolean modifier = false;
				
				String pModifier = request.getParameter("Modifier");
				
				if(pModifier != null && !pModifier.isBlank())
					modifier = Boolean.valueOf(pModifier);
				
				if(modifier)
				{
					int idArticle = 0;
					String pidArticle = request.getParameter("idArticle");
					
					if(pidArticle != null && !pidArticle.isBlank())
						idArticle = Integer.valueOf(pidArticle);
					article.setNo_article(idArticle);
					
					vretour = ArticleBll.update(article);
				}
				else
					vretour = ArticleBll.insert(article);
				
				
				if (vretour) {
					request.getRequestDispatcher("/Accueil").forward(request, response);
				} else {
					throw new Exception();
				}

			}
		} catch (Exception e) {
			// message d'erreur
			System.out.println("erreur à l'insertion");
		}
	}
}
