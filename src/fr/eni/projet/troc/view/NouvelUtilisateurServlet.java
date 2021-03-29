package fr.eni.projet.troc.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.troc.bll.UtilisateursManager;
import fr.eni.projet.troc.bo.Utilisateur;

/**
 * Servlet implementation class NouvelleListeServlet
 */
@WebServlet("/NouvelUtilisateurServlet")
public class NouvelUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/nouvelUtilisateur.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération des données saisies dans le formulaire
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
		nouvelUtilisateur.setMotDePasses(request.getParameter("motDePasse"));
		nouvelUtilisateur.setCredit(100);
		nouvelUtilisateur.setAdministrateur(false);

		UtilisateursManager um = UtilisateursManager.getInstance();

		try {
			um.create(nouvelUtilisateur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

}
