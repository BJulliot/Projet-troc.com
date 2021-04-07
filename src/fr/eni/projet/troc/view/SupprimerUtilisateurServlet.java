package fr.eni.projet.troc.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.troc.bll.ArticlesVendusManager;
import fr.eni.projet.troc.bll.EnchereManager;
import fr.eni.projet.troc.bll.UtilisateursManager;
import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Servlet implementation class NouvelleListeServlet
 */

//@WebServlet("/SupprimerUtilisateurServlet")
@WebServlet(urlPatterns = { "/supprimerUtilisateur" })
public class SupprimerUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String servletPath = request.getServletPath();
		System.out.println("servlet path est : " + servletPath);
		
		if (servletPath.contains("supprimerUtilisateur")) {
			int noUtilisateur = Integer.parseInt(request.getParameter("u"));
			System.out.println("noUtilisateur = " + noUtilisateur);
//			try {
//				// suppresion utilisateur selon noUtilisateur :
//				UtilisateursManager.getInstance().delete(noUtilisateur);
//				System.out.println("Utilisateur "+noUtilisateur+" supprimé");
//				
//				// suppresion articlesVendus selon noUtilisateur :
//				ArticlesVendusManager.getInstance().deleteBynoUtilisateur(noUtilisateur);
//				System.out.println("Articles liés à utilisateur "+noUtilisateur+" supprimés");
//				
////				// suppresion retrait selon noUtilisateur :
////				RetraitManager.getInstance().deleteBynoUtilisateur(noUtilisateur);
////				System.out.println("Retraits liés à utilisateur "+noUtilisateur+" supprimés");
//				
//				// suppresion enchères noUtilisateur :
//				EnchereManager.getInstance().deleteBynoUtilisateur(noUtilisateur);
//				System.out.println("Enchères liées à utilisateur "+noUtilisateur+" supprimés");
//				
//				// redirection vers espace admin :
//				request.getRequestDispatcher("/AfficherEspaceAdmin").forward(request, response);
//				
//			} catch (BusinessException be) {
//				be.printStackTrace();
//				request.setAttribute("errors", be.getErrors());
//				request.getRequestDispatcher("/AfficherEspaceAdmin").forward(request, response);
//			}
//		}
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupérration infos de l'utilisateur en session:
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurEnSession");

		// Rï¿½cupï¿½ration du numero utilisateur avant suppresion :
		request.setCharacterEncoding("UTF-8");
		UtilisateursManager um = UtilisateursManager.getInstance();
		System.out.println("post delete");
		System.out.println("numero utilisateur en session = " + utilisateur.getNoUtilisateur());

		try {
			um.delete(utilisateur.getNoUtilisateur());
			System.out.println("supprimé");

			session.invalidate();
			request.getRequestDispatcher("/AccueilServlet").forward(request, response);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("errors", e.getErrors());
			request.getRequestDispatcher("/AfficherProfilUtilisateurServlet").forward(request, response);
		}
	}
}
