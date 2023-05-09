package fr.eni.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BLL.ArticleBLL;
import BLL.EncheresBLL;
import BLL.RetraitsBLL;
import BLL.UtilisateurBLL;

/**
 * Servlet implementation class DetailVente
 */
@WebServlet("/DetailVente")
public class DetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticleBLL bllArticle;
	private UtilisateurBLL bllUtilisateur;
	private EncheresBLL bllEnchere;
	private RetraitsBLL bllRetraits;
	
	@Override
	public void init() throws ServletException {
		bllArticle = new ArticleBLL();
		bllUtilisateur = new UtilisateurBLL();
		bllEnchere = new EncheresBLL();
		bllRetraits = new RetraitsBLL();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var idVendeur = request.getAttribute("idVendeur");
		var idArticle = request.getAttribute("idArticle");
		
		request.setAttribute("article", bllArticle.getArticleByIdAll((int)idArticle));
		
		request.setAttribute("utilVendeur", bllUtilisateur.selectById((int)idVendeur));
		
		request.setAttribute("topEnchere", bllEnchere.topEnchere((int)idArticle));
		
		request.setAttribute("retrait", bllRetraits.selectRetraitById((int)idArticle));
		
		request.getRequestDispatcher("/WEB-INF/DetailVente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
