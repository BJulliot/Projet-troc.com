package fr.eni.projet.troc.view;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.troc.bll.UtilisateursManager;
import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Servlet implementation class NouvelleListeServlet
 */
@WebServlet("/ModifierUtilisateurServlet")
public class ModifierUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurEnSession");
		session.setAttribute("utilisateurEnSession", utilisateur);

		request.getRequestDispatcher("/WEB-INF/modifierUtilisateur.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupération infos de l'utilisateur en session:
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurEnSession");

		// Récupération et intégration des données saisies dans le formulaire
		// modifierUtilisateur.jsp
		request.setCharacterEncoding("UTF-8");
		int noUtilisateur = utilisateur.getNoUtilisateur();
		System.out.println("numero utilisateur : " + noUtilisateur);
		String ancienPseudo = utilisateur.getPseudo();
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");

		String ancienMotDePasse = request.getParameter("ancienMotDePasse");
		String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
		String confirmationMotDePasse = request.getParameter("confirmationMotDePasse");	
		
		try {
			UtilisateursManager um = UtilisateursManager.getInstance();
			um.update(noUtilisateur, ancienPseudo, pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					ancienMotDePasse, nouveauMotDePasse, confirmationMotDePasse);
			
			// on set les nouvelles infos à l'utilisateur en session :
			utilisateur.setPseudo(pseudo);
			utilisateur.setNom(nom);
			utilisateur.setPrenom(prenom);
			utilisateur.setEmail(email);
			utilisateur.setTelephone(telephone);
			utilisateur.setRue(rue);
			utilisateur.setCodePostal(codePostal);
			utilisateur.setVille(ville);
			
			if (nouveauMotDePasse != null) {
				utilisateur.setMotDePasse(nouveauMotDePasse);
			}
			// on les transmets vers session
			session.setAttribute("utilisateurEnSession", utilisateur);

			request.getRequestDispatcher("/AccueilServlet").forward(request, response);

		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("errors", e.getErrors());
			request.getRequestDispatcher("/AccueilServlet").forward(request, response);
		}
		
	}
}
