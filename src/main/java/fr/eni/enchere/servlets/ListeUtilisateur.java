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
 * Servlet implementation class ListeUtilisateur
 */
@WebServlet("/ListeUtilisateur")
public class ListeUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UtilisateurBLL bll;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeUtilisateur() {
        super();
        bll = new UtilisateurBLL();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = 0;
		
		String pid = (String) request.getParameter("idUtil");
		
		int idTest = request.getAttribute("id") != null ? (int) request.getAttribute("id") : Integer.MAX_VALUE;
		
		if((pid != null && !pid.isBlank()) && idTest > 0)
			id = Integer.valueOf(pid);
		
		if(id == 0)
		{
		HttpSession session = request.getSession();
		
		boolean admin = (boolean) session.getAttribute("admin");
				
		if(admin)
		{
			var lesUtilisateurs = bll.selectAll();
			request.setAttribute("ListeUtilisateur", lesUtilisateurs);
		}
		
		request.getRequestDispatcher("/WEB-INF/ListeUtil.jsp").forward(request, response);
		}else
		{
			doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idAsuppr = 0;
		
		String pid = (String) request.getParameter("idUtil");
		
		if(pid != null && !pid.isBlank())
			idAsuppr = Integer.valueOf(pid);
		
		if(idAsuppr > 0)
			bll.delete(idAsuppr);
		
		request.setAttribute("id", 0);
		
		doGet(request, response);
	}

}
