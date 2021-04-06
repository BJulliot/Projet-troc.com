package fr.eni.projet.troc.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.troc.bll.UtilisateursManager;
import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Servlet implementation class AfficherEspaceAdmin
 */
@WebServlet("/AfficherEspaceAdmin")
public class AfficherEspaceAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// R�cup�rer les donn�es � afficher
		try {
			List<Utilisateur> listeUtilisateur = UtilisateursManager.getInstance().selectAll();
			// injecter dans la requ�te pour les transmettre � l'affichage
			request.setAttribute("listeUtilisateur", listeUtilisateur);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("errors", e.getErrors());
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
