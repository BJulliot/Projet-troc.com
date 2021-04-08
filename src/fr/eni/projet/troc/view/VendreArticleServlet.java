package fr.eni.projet.troc.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.troc.bll.ArticlesVendusManager;
import fr.eni.projet.troc.bll.CategorieManager;
import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Categorie;
import fr.eni.projet.troc.bo.Retrait;
import fr.eni.projet.troc.bo.Utilisateur;

/**
 * Servlet implementation class VendreArticleServlet
 */
@WebServlet("/VendreArticleServlet")
public class VendreArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Categorie> categories = CategorieManager.getInstance().getCategorie();
			request.setAttribute("categories", categories);

			HttpSession session = request.getSession();
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurEnSession");
			session.setAttribute("utilisateurEnSession", utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/vendreArticle.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurEnSession");		
		request.setCharacterEncoding("UTF-8");
		ArticleVendu articleVendu = new ArticleVendu();
		Retrait retrait = new Retrait();
		articleVendu.setNom(request.getParameter("nomArticle"));
		articleVendu.setDescription(request.getParameter("description"));
		articleVendu.setNomCategorie(request.getParameter("cateVente"));
		articleVendu.setPrixInitial(Integer.parseInt(request.getParameter("prix")));
		articleVendu.setDateDebutEnchere(java.sql.Date.valueOf(request.getParameter("dateDebut")).toLocalDate());
		articleVendu.setDateFinEnchere(java.sql.Date.valueOf(request.getParameter("dateFin")).toLocalDate());
		retrait.setRue(request.getParameter("rue"));
		retrait.setCodePostal(request.getParameter("codePostal"));
		retrait.setVille(request.getParameter("ville"));
		ArticlesVendusManager am = ArticlesVendusManager.getInstance();

		int noUtilisateur = utilisateur.getNoUtilisateur();
		articleVendu.setNoUtilisateur(noUtilisateur);
		
		try {
			am.create(articleVendu,retrait);
			request.getRequestDispatcher("/AccueilServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
