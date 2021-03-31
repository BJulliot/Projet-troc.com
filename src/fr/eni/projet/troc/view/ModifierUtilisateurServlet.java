package fr.eni.projet.troc.view;

import java.io.IOException;

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
		Utilisateur nouvelUtilisateur = new Utilisateur();
		nouvelUtilisateur.setPseudo(request.getParameter("pseudo"));
		nouvelUtilisateur.setNom(request.getParameter("nom"));
		nouvelUtilisateur.setPrenom(request.getParameter("prenom"));
		nouvelUtilisateur.setEmail(request.getParameter("email"));
		nouvelUtilisateur.setTelephone(request.getParameter("telephone"));
		nouvelUtilisateur.setRue(request.getParameter("rue"));
		nouvelUtilisateur.setCodePostal(request.getParameter("codePostal"));
		nouvelUtilisateur.setVille(request.getParameter("ville"));
		nouvelUtilisateur.setMotDePasse(request.getParameter("motDePasse"));
		nouvelUtilisateur.setCredit(100);
		nouvelUtilisateur.setAdministrateur(false);

		UtilisateursManager um = UtilisateursManager.getInstance();
		String confirmationMotDePasse = request.getParameter("confirmationMotDePasse");
		System.out.println("mot de passe : " + nouvelUtilisateur.getMotDePasse());
		System.out.println("confirmation : " + confirmationMotDePasse);
		try {
			um.create(nouvelUtilisateur, confirmationMotDePasse);
			request.getRequestDispatcher("/AccueilServlet").forward(request, response);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("errors", e.getErrors());
			request.setAttribute("nouvelUtilisateur", nouvelUtilisateur);
			request.getRequestDispatcher("/WEB-INF/nouvelUtilisateur.jsp").forward(request, response);
		}
	}
}
