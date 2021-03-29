package fr.eni.projet.troc.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.troc.bll.ArticlesVendusManager;
import fr.eni.projet.troc.bo.ArticleVendu;



/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		System.out.println("servletPath : " + servletPath);
		try {
			
			List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendus();
			request.setAttribute("articles", articles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}



}
