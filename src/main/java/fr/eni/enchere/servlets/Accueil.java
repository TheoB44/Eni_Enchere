package fr.eni.enchere.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BLL.CategorieBLL;
import BLL.EncheresBLL;
import BO.Categories;
import BO.Encheres;
import BO.Utilisateurs;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EncheresBLL bllEncheres;
	private CategorieBLL bllCategories;
	
	@Override
	public void init() throws ServletException {
		bllEncheres = new EncheresBLL();
		bllCategories = new CategorieBLL();
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
		
		
		
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchNomArticle = request.getParameter("searchNomArticle");
		String categorieEnchere = request.getParameter("categorieEnchere");
		
		request.setAttribute("listeEncheresPost", bllEncheres.listeEncheresSearch(searchNomArticle, categorieEnchere));
		request.setAttribute("listeCategoriesPost", bllCategories.listeCategories());
		
		doGet(request, response);
	}

}
