package fr.eni.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BLL.ArticleBLL;
import BLL.UtilisateurBLL;

/**
 * Servlet implementation class SupprimerVente
 */
@WebServlet("/SupprimerVente")
public class SupprimerVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArticleBLL bll;

	@Override
	public void init() throws ServletException {
		bll = new ArticleBLL();
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doDelete(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		boolean vretour = false;
		String pIdArticle = request.getParameter("idArticle");
		int idArticle = 0;

		if(pIdArticle != null && !pIdArticle.isBlank())
			idArticle = Integer.valueOf(pIdArticle);
		if(idArticle > 0)
			vretour = bll.delete(idArticle);
		
		if(vretour)
			request.getRequestDispatcher("/Accueil").forward(request, response);
		else
			response.getWriter().append("Erreur lors de la suppression de l'article. ");
	}

}
