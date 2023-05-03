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
 * Servlet implementation class Liste_Encheres
 */
@WebServlet("/ListeEncheres")
public class ListeEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UtilisateurBLL bll;
	
	@Override
	public void init() throws ServletException {
		bll = new UtilisateurBLL();
	}
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeEncheres() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String pId = request.getParameter("Id_Utils");
		if (pId != null && !pId.isBlank()) {
			int id = Integer.valueOf(pId);
			
			request.setAttribute("IDUtilisateur", id);
		}

		request.getRequestDispatcher("/WEB-INF/ListeEncheres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pIdUtil = request.getParameter("IDUtilisateur");

		if (pIdUtil != null && !pIdUtil.isBlank()) {
			int id = Integer.valueOf(pIdUtil);
			
			request.setAttribute("IDUtilisateur", id);
			request.setAttribute("MonProfil", true);
			
			request.getRequestDispatcher("/MonProfil").forward(request, response);
	}

}
}