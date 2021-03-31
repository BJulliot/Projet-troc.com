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
		String search = request.getParameter("search");
		request.setAttribute("search", search);
		request.setAttribute("Cat", Cat);
		System.out.println(Cat);

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
			System.out.println(cateNum);

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
		System.out.println(Cat);

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
			System.out.println(cateNum);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

}
