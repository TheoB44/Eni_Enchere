package fr.eni.enchere.servlets;


import java.io.IOException;
import java.time.LocalTime;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/")
public class Redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws
            ServletException, IOException {
    	request.getRequestDispatcher("/Accueil").forward(request, response);
    }
}