package fr.eni.projet.troc.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.troc.bo.Utilisateur;

/**
 * Servlet implementation class DeconnectionServlet
 */
@WebServlet("/DeconnectionServlet")
public class DeconnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Invalider la Session utilisateur
		HttpSession session = request.getSession();

		// Tracer l'utilisateur en session avant l'invalidation
		if (session.getAttribute("utilisateurEnSession") != null) {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurEnSession");
			System.out.println(utilisateur);
		}
		// invalidation :
		session.invalidate();

		HttpSession sessionAfter = request.getSession();

		// Vérifier qu'il n'est plus présent après invalidation
		System.out.println("AFTER :");
		if (sessionAfter.getAttribute("utilisateurEnSession") != null) {
			Utilisateur utilisateur = (Utilisateur) sessionAfter.getAttribute("utilisateurEnSession");
			System.out.println(utilisateur);
		}

		request.getRequestDispatcher("./AccueilServlet").forward(request, response);
	}
}
