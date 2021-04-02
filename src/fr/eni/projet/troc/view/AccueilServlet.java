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

		String Cat = request.getParameter("Categories");
		String search = request.getParameter("search");
		request.setAttribute("search", search);
		request.setAttribute("Cat", Cat);
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurEnSession");
		session.setAttribute("utilisateurEnSession", utilisateur);

		try {
			//Select all de categegories
			List<Categorie> categories = CategorieManager.getInstance().getCategorie();
			request.setAttribute("categories", categories);

			//Select All article 
			List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendus();
			request.setAttribute("articles", articles);
			
			//Select article by id de la categorie
			List<ArticleVendu> cateNum = ArticlesVendusManager.getInstance().getNoCategorie(Integer.parseInt(Cat));
			request.setAttribute("cateNum", cateNum);
			
			List<ArticleVendu> nameArticle = ArticlesVendusManager.getInstance().getNomArticle(search);
			request.setAttribute("nameArticle", nameArticle);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String Cat = request.getParameter("Categories");
		String search = request.getParameter("search");
		request.setAttribute("search", search);
		request.setAttribute("Cat", Cat);

		try {
			//Select all de categegories
			List<Categorie> categories = CategorieManager.getInstance().getCategorie();
			request.setAttribute("categories", categories);

			//Select All article 
			List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendus();
			request.setAttribute("articles", articles);
			
			//Select article by id
			List<ArticleVendu> cateNum = ArticlesVendusManager.getInstance().getNoCategorie(Integer.parseInt(Cat));
			request.setAttribute("cateNum", cateNum);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

}
