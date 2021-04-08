package fr.eni.projet.troc.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.troc.bll.ArticlesVendusManager;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Servlet implementation class SupprimerAnnonceServlet
 */
@WebServlet("/SupprimerAnnonceServlet")
public class SupprimerAnnonceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupérer infos article :
		int noArticle = Integer.parseInt(request.getParameter("a"));
		try {
			ArticlesVendusManager.getInstance().deleteByNoArticle(noArticle);
			request.getRequestDispatcher("/AccueilServlet").forward(request, response);
		} catch (BusinessException be) {
			be.printStackTrace();
			request.setAttribute("errors", be.getErrors());
			request.getRequestDispatcher("/AccueilServlet").forward(request, response);
		}
	}
}
