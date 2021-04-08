package fr.eni.projet.troc.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.troc.bll.ArticlesVendusManager;
import fr.eni.projet.troc.bll.UtilisateursManager;
import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Servlet implementation class AfficherEspaceAdmin
 */

@WebServlet(name="AfficherEspaceAdmin", urlPatterns={"/espaceAdmin"})
public class AfficherEspaceAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupérer les données à afficher
		try {
			List<Utilisateur> listeUtilisateur = UtilisateursManager.getInstance().selectAll();
			// injecter dans la requête pour les transmettre à l'affichage
			request.setAttribute("listeUtilisateur", listeUtilisateur);
			
			/**
			 *  Select All article si le user veux tous les articles encore en vente
			 */
			List<ArticleVendu> listeArticles = ArticlesVendusManager.getInstance().getAllArticleVendus();
			request.setAttribute("listeArticles", listeArticles);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("errors", e.getErrors());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Redirection
		request.getRequestDispatcher("/WEB-INF/espaceAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
