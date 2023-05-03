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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pIdUtil = request.getParameter("IDUtilisateur");
		var isMyProfil = request.getParameter("MonProfil");
		if (pIdUtil != null && !pIdUtil.isBlank()) {
			int id = Integer.valueOf(pIdUtil);
			Utilisateurs utils = new Utilisateurs();
			
			
			
			utils = bll.selectById(id);
			
			request.setAttribute("Utilisateur", utils);
			
			if(isMyProfil != null && !isMyProfil.isBlank())
				request.setAttribute("MonProfil", isMyProfil);
		}
		
		
		request.getRequestDispatcher("/WEB-INF/MonProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
