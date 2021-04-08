package fr.eni.projet.troc.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.troc.bll.ArticlesVendusManager;
import fr.eni.projet.troc.bll.UtilisateursManager;
import fr.eni.projet.troc.bo.Utilisateur;
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
		// r�cup�rer infos article :
				String noArticle = request.getParameter("a");
				System.out.println("supprimer // id article :" + noArticle);
				ArticlesVendusManager.getInstance().deleteByNoArticle(noArticle);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		// R�cup�ration du numero utilisateur avant suppresion :
//		request.setCharacterEncoding("UTF-8");
//		UtilisateursManager um = UtilisateursManager.getInstance();
//		System.out.println("post delete");
//		System.out.println("numero utilisateur en session = " + utilisateur.getNoUtilisateur());
//
//		try {
//			um.delete(utilisateur.getNoUtilisateur());
//			System.out.println("supprim�");
//
//			session.invalidate();
//			request.getRequestDispatcher("/AccueilServlet").forward(request, response);
//		} catch (BusinessException e) {
//			e.printStackTrace();
//			request.setAttribute("errors", e.getErrors());
//			request.getRequestDispatcher("/AfficherProfilUtilisateurServlet").forward(request, response);
//		}
	}
}
