package fr.eni.projet.troc.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD

=======
>>>>>>> a9c958b (MAJ connexion, deconnexion, ajout nouvel utilisateur)
import fr.eni.projet.troc.bll.ArticlesVendusManager;
import fr.eni.projet.troc.bll.CategorieManager;
import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Categorie;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
		String Cat = request.getParameter("Categories");
		request.setAttribute("Cat", Cat);
		System.out.println(Cat);
=======

>>>>>>> a9c958b (MAJ connexion, deconnexion, ajout nouvel utilisateur)
		try {
			if(Cat == null) {
			List<Categorie> categories = CategorieManager.getInstance().getCategorie();
			request.setAttribute("categories", categories);
			List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendus();
			request.setAttribute("articles", articles);
			}else if (Cat.equals("1")) {
				List<Categorie> categories = CategorieManager.getInstance().getCategorie();
				request.setAttribute("categories", categories);
				List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendus();
				request.setAttribute("articles", articles);
			}else if (Cat.equals("2")) {
				List<Categorie> categories = CategorieManager.getInstance().getCategorie();
				request.setAttribute("categories", categories);
				List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendus();
				request.setAttribute("articles", articles);
			}else if (Cat.equals("3")) {
				List<Categorie> categories = CategorieManager.getInstance().getCategorie();
				request.setAttribute("categories", categories);
				List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendus();
				request.setAttribute("articles", articles);
			}else if (Cat.equals("4")) {
				List<Categorie> categories = CategorieManager.getInstance().getCategorie();
				request.setAttribute("categories", categories);
				List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendus();
				request.setAttribute("articles", articles);
			}else {
				List<Categorie> categories = CategorieManager.getInstance().getCategorie();
				request.setAttribute("categories", categories);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

<<<<<<< HEAD
=======
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendus();
			request.setAttribute("articles", articles);
			List<Categorie> categories = CategorieManager.getInstance().getCategorie();
			request.setAttribute("categories", categories);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

>>>>>>> a9c958b (MAJ connexion, deconnexion, ajout nouvel utilisateur)
}
