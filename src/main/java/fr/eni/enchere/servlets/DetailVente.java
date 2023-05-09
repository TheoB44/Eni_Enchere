package fr.eni.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BLL.ArticleBLL;
import BLL.EncheresBLL;
import BLL.RetraitsBLL;
import BLL.UtilisateurBLL;
import BO.Encheres;
import BO.Utilisateurs;

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
		
		String etatVente = bllArticle.etatVente((int)idArticle);
		
		Encheres enchere = null;
		if(etatVente.equals("VD")) {
			enchere = bllEnchere.SelectUtil((int)idArticle);
		}
		request.setAttribute("etatVente", etatVente);
		
		HttpSession session = request.getSession();
		var id = session.getAttribute("IdUtilisateur");
		int idUtil =0;
		
		boolean acheteur = false;
		if(id != null) {
			idUtil = (int)id;
			if(enchere != null) {
				if(idUtil == enchere.getutilisateur().getNo_utilisateurs()) {
					acheteur = true;
				}
			}
		}
		request.setAttribute("acheteur", acheteur);
		
		if (idVendeur instanceof String) {
			idVendeur = Integer.parseInt((String)idVendeur);
			idArticle = Integer.parseInt((String)idArticle);
		}
		
		request.setAttribute("article", bllArticle.getArticleByIdAll((int)idArticle));
		
		request.setAttribute("idVendeur", idVendeur);
		request.setAttribute("idArticle", idArticle);
		
		request.setAttribute("utilVendeur", bllUtilisateur.selectById((int)idVendeur));
		
		request.setAttribute("topEnchere", bllEnchere.topEnchere((int)idArticle));
		
		request.setAttribute("retrait", bllRetraits.selectRetraitById((int)idArticle));
		
		request.getRequestDispatcher("/WEB-INF/DetailVente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String noArticleS = request.getParameter("noArticle");
		String montantEnchereS = request.getParameter("montantEnchere");
		String previousEnchereS = request.getParameter("previousEnchere");
		int montantEnchere = 0;
		int noArticle = 0;
		float previousEnchere = 0;
		
		if(montantEnchereS != null) {
			montantEnchere = Integer.parseInt(montantEnchereS);
			noArticle = Integer.parseInt(noArticleS);
			previousEnchere = Float.parseFloat(previousEnchereS);
		}
		
		HttpSession session = request.getSession();
		int user = (int) session.getAttribute("IdUtilisateur");
		if(montantEnchere > previousEnchere) {
			bllEnchere.insertOrUpdate(user,noArticle,montantEnchere);
		}
		
		request.setAttribute("idVendeur", request.getParameter("idVendeur"));
		request.setAttribute("idArticle", request.getParameter("idArticle"));
		
		doGet(request, response);
	}

}
