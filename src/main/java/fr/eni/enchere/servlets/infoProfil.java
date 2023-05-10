package fr.eni.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BLL.UtilisateurBLL;

/**
 * Servlet implementation class infoProfil
 */
@WebServlet("/infoProfil")
public class infoProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UtilisateurBLL bll;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public infoProfil() {
        super();
        bll = new UtilisateurBLL();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int id = (int) session.getAttribute("IdUtilisateur");
		
		if(id > 0)
		{
			int credit = bll.getCredit(id);
			
			request.setAttribute("credit", credit);
		}
		
		
		request.getRequestDispatcher("/WEB-INF/ModifierProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
