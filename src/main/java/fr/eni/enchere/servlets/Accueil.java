package fr.eni.enchere.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BLL.CategorieBLL;
import BLL.EncheresBLL;
import BLL.UtilisateurBLL;
import BO.Categories;
import BO.Encheres;
import BO.Utilisateurs;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private final long serialVersionUID = 1L;
       
	private EncheresBLL bllEncheres;
	private CategorieBLL bllCategories;
	private UtilisateurBLL bll;
	
	@Override
	public void init() throws ServletException {
		bllEncheres = new EncheresBLL();
		bllCategories = new CategorieBLL();
		bll = new UtilisateurBLL();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Encheres> listeEncheres = new ArrayList();
		List<Categories> listeCategories = new ArrayList();
		
		if(request.getAttribute("listeEncheresPost") != null) {
			request.setAttribute("listeEncheres", request.getAttribute("listeEncheresPost"));
		}
		else {
			request.setAttribute("listeEncheres", bllEncheres.listeEncheres());
		}
		
		if(request.getAttribute("listeCategoriesPost") != null) {
			request.setAttribute("listeCategories", request.getAttribute("listeCategoriesPost"));
		}
		else {
			request.setAttribute("listeCategories", bllCategories.listeCategories());
		}
		
		HttpSession session = request.getSession();
		Object loginFlag = session.getAttribute("userConnected");
		
		//récupération du cookie
		
		var cookie = request.getCookies();
		
		
		if(loginFlag != null && loginFlag.equals(true)) {
			request.setAttribute("util", session.getAttribute("currentUser"));
		}else if(cookie != null)
		{
			String id = "";
			String pwd = "";
			for(int i =0; i < cookie.length; i++)
			{
				var unCookie = cookie[i];
				if(unCookie.getName().equals("id"))
					id = unCookie.getValue();
				
				if(unCookie.getName().equals("pwd"))
					pwd = unCookie.getValue();
			}
			
			if(!pwd.isBlank() && !id.isBlank())
			{
				Utilisateurs util = new Utilisateurs();
				
				try {
					util = bll.connexion(id, pwd);
					
				} catch (Exception e) {
					request.setAttribute("erreurs", e.getMessage());
				}
				
				if(util.getNo_utilisateurs() > 0) {
					session.setAttribute("currentUser", util);

					session.setAttribute("IdUtilisateur", util.getNo_utilisateurs());
					session.setAttribute("userConnected", true);
				}
			}
		}
		else {
			request.setAttribute("userConnected",false);
		}
		
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchNomArticle = request.getParameter("searchNomArticle");
		String categorieEnchere = request.getParameter("categorieEnchere");
		
		String radio = request.getParameter("achatVente");
		
		HttpSession session = request.getSession();
		Utilisateurs user = (Utilisateurs) session.getAttribute("currentUser");
		List<String> etatVente = new ArrayList();
		
		if(radio != null) {
			if(radio.equals("achat")) {
				String enchereOuverte = request.getParameter("enchereOuverte");
				String mesEncheres = request.getParameter("mesEncheres");
				String enchereRemporte = request.getParameter("enchereRemporte");
				if(enchereOuverte != null) {etatVente.add(enchereOuverte);};
				if(mesEncheres != null) {etatVente.add(mesEncheres);};
				if(enchereRemporte != null) {etatVente.add(enchereRemporte);};
				request.setAttribute("listeEncheresPost", bllEncheres.listeEncheresSearchConnected(searchNomArticle, categorieEnchere, user.getNo_utilisateurs(),etatVente, radio));
			}
			else {
				String checkVenteEC = request.getParameter("checkVenteEC");
				String checkVenteDebute = request.getParameter("checkVenteDebute");
				String checkVenteTermine = request.getParameter("checkVenteTermine");
				if(checkVenteEC != null) {etatVente.add(checkVenteEC);};
				if(checkVenteDebute != null) {etatVente.add(checkVenteDebute);};
				if(checkVenteTermine != null) {etatVente.add(checkVenteTermine);};
				request.setAttribute("listeEncheresPost", bllEncheres.listeEncheresSearchConnected(searchNomArticle, categorieEnchere, user.getNo_utilisateurs(),etatVente, radio));
			}
			request.setAttribute("listeCategoriesPost", bllCategories.listeCategories());
		}
		else {
			if(searchNomArticle != null && categorieEnchere != null) {
				request.setAttribute("listeEncheresPost", bllEncheres.listeEncheresSearch(searchNomArticle, categorieEnchere));
				request.setAttribute("listeCategoriesPost", bllCategories.listeCategories());
			}
		}
		
		doGet(request, response);
	}

}
