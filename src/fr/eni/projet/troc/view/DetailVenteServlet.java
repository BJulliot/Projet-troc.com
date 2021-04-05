package fr.eni.projet.troc.view;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.troc.bll.ArticlesVendusManager;
import fr.eni.projet.troc.bll.EnchereManager;
import fr.eni.projet.troc.bll.RetraitManager;
import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Enchere;
import fr.eni.projet.troc.bo.Retrait;
import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Servlet implementation class DetailVenteServlet
 */
@WebServlet("/DetailVenteServlet")
public class DetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idArticle = request.getParameter("a");
		try {
			ArticleVendu article = ArticlesVendusManager.getInstance().selectArticleById(Integer.parseInt(idArticle));
			request.setAttribute("article", article);
			Retrait retrait = RetraitManager.getInstance().selectRetraitById(Integer.parseInt(idArticle));
			request.setAttribute("retrait", retrait);
			HttpSession session = request.getSession();
			session.setAttribute("noArticleEnchere", idArticle);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/detailVente.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String enchereNoArticle = (String) session.getAttribute("noArticleEnchere");
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurEnSession");
		request.setCharacterEncoding("UTF-8");
		Enchere enchere = new Enchere();
		String montantEnchere = request.getParameter("prixEnchere");
		enchere.setMontantEnchere(Integer.parseInt(montantEnchere));
		EnchereManager em = EnchereManager.getInstance();
		int noUtilisateur = utilisateur.getNoUtilisateur();
		enchere.setNoUtilisateur(noUtilisateur);

		LocalDateTime date_enchere = LocalDateTime.now();
		enchere.setDateEnchere(date_enchere);



		try {
			ArticleVendu articleVendu = EnchereManager.getInstance().selectByIdSell(Integer.parseInt(enchereNoArticle));
			em.create(enchere);
			request.getRequestDispatcher("/AccueilServlet").forward(request, response);
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("errors", e.getErrors());
			String idArticle = enchereNoArticle;
			doGet(request, response);
		}

	}
}
