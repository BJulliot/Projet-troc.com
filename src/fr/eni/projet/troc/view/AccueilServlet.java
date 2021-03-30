package fr.eni.projet.troc.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String Cat = request.getParameter("Categories");
		request.setAttribute("Cat", Cat);
		System.out.println(Cat);
		try {
			List<Categorie> categories = CategorieManager.getInstance().getCategorie();
			request.setAttribute("categories", categories);

			List<ArticleVendu> articles = ArticlesVendusManager.getInstance().getAllArticleVendus();
			request.setAttribute("articles", articles);

			ArticleVendu cateNum = ArticlesVendusManager.getInstance().getNoCategorie(Integer.parseInt(Cat));
			request.setAttribute("cateNum", cateNum);
			System.out.println(cateNum);

//			if (Cat == null) {
//				categories = CategorieManager.getInstance().getCategorie();
//
//				articles = ArticlesVendusManager.getInstance().getAllArticleVendus();
//			}
//			Categorie noCategorie = CategorieManager.getInstance().getNoCategorie(Integer.parseInt(Cat));
//			request.setAttribute("noCategorie", noCategorie);
//			System.out.println(noCategorie);

//			ArticleVendu cateNum = ArticlesVendusManager.getInstance().getNoCategorie(Integer.parseInt(Cat));
//			request.setAttribute("cateNum", cateNum);
//			System.out.println(cateNum);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

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

}
