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
import fr.eni.projet.troc.bo.Utilisateur;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Select all de categegories pour avoir la liste des categorie dans le menu deroulant
			List<Categorie> categories = CategorieManager.getInstance().getCategorie();
			request.setAttribute("categories", categories);

			// Select All article pour lister tout les articles au moment du lancement de la page d'accueil
			List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendusStillInSell();
			request.setAttribute("articles", articles);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	/**
	 * On recupere toutes les infos du formulaire pour ensuite pouvoir les afficher en fonction des données récupérées
	 */
		String Cat = request.getParameter("Categories");
		String search = request.getParameter("search");
		String mesAnnonces = request.getParameter("voirAnnonce");
		String voirEnchere = request.getParameter("voirEnchere");
		String voirVentes = request.getParameter("voirVentes");
		String ventesFinie = request.getParameter("voirVentesFini");
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurEnSession");
	
		
		session.setAttribute("utilisateurEnSession", utilisateur);
		request.setAttribute("voirVentes", voirVentes);
		request.setAttribute("mesAnnonces", mesAnnonces);
		request.setAttribute("search", search);
		request.setAttribute("Cat", Cat);
		request.setAttribute("mesEnchere", voirEnchere);
		request.setAttribute("voirVentesFini", ventesFinie);

		try {

			/**
			 *  Select all de categegories pour afficher le choix des categorie
			 */
			List<Categorie> categories = CategorieManager.getInstance().getCategorie();
			request.setAttribute("categories", categories);
			/**
			 *  Select All article si le user veux tous les articles encore en vente
			 */
			List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendusStillInSell();
			request.setAttribute("articles", articles);

			// Select article by id pour pemmettre au user d'afficher des articles en fonctions de leurs categories
			List<ArticleVendu> cateNum = ArticlesVendusManager.getInstance().getNoCategorie(Integer.parseInt(Cat));
			request.setAttribute("cateNum", cateNum);

			/**
			 * Select par nom d'objet, le user peux chercher le nom d'un objet et tout les objet ou ce nom sera present lui sera retourné
			 */
			List<ArticleVendu> nameArticle = ArticlesVendusManager.getInstance().getNomArticle(search);
			request.setAttribute("nameArticle", nameArticle);

			List<ArticleVendu> userEnchere = ArticlesVendusManager.getInstance().getUserEnchere(utilisateur.getNoUtilisateur());
			request.setAttribute("userEnchere", userEnchere);
			/**
			 * Permet de SELECT l'article en fonction du user qui a crée l'article
			 */
			List<ArticleVendu> articleIdUser = ArticlesVendusManager.getInstance()
					.getArticleIdUser(utilisateur.getNoUtilisateur());
			request.setAttribute("articleIdUser", articleIdUser);
			
			List<ArticleVendu> enchereNonDebute = ArticlesVendusManager.getInstance().selectEnchereNonCommence(utilisateur.getNoUtilisateur());
			request.setAttribute("enchereNonDebute", enchereNonDebute);
			
			List<ArticleVendu> articleVendusFini = ArticlesVendusManager.getInstance().selectEnchereTermine(utilisateur.getNoUtilisateur());
			request.setAttribute("articleVendusFini", articleVendusFini);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

}
