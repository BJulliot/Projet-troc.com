package fr.eni.projet.troc.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.troc.bll.UtilisateursManager;
import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Servlet implementation class PoolConnectionServlet
 */
@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération de la saisie
		request.setCharacterEncoding("UTF-8");
		String pseudo = request.getParameter("pseudo");
		String motDePasse = request.getParameter("motDePasse");


		// Appelle a la BLL
		try {
			Utilisateur utilisateur = UtilisateursManager.getInstance().validateConnection(pseudo, motDePasse);
			// Transmettre les informations pour la page d'accueil
			HttpSession session = request.getSession();

			// cookie qui garde le pseudo et mdp de l'utilisateur :
			if (request.getParameter("cookieConnexion") != null) {
				// map des cookies
				Cookie[] cookie = request.getCookies();
				Cookie infoUtilisateurPseudo = new Cookie("infoUtilisateurPseudo", pseudo);
				Cookie infoUtilisateurMotDePasse = new Cookie("infoUtilisateurMotDePasse", motDePasse);
				response.addCookie(infoUtilisateurPseudo);
				response.addCookie(infoUtilisateurMotDePasse);
			}

			// temps avant desactivation de la session
			session.setMaxInactiveInterval(10 * 60);

			session.setAttribute("utilisateurEnSession", utilisateur);
			request.getRequestDispatcher("/AccueilServlet").forward(request, response);

		} catch (BusinessException be) {
			be.printStackTrace();
			request.setAttribute("errors", be.getErrors());
			request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
		}
	}

}
