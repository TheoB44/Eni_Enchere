package fr.eni.enchere.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BLL.UtilisateurBLL;

/**
 * Servlet implementation class SupprimerProfil
 */
@WebServlet("/SupprimerProfil")
public class SupprimerProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private UtilisateurBLL bll;

	@Override
	public void init() throws ServletException {
		bll = new UtilisateurBLL();
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		// TODO : récuperer l'utilisateur connecté via la variable de session, puis le supprimer
		
		bll.delete();
	}
	
	
	
	
	

}
