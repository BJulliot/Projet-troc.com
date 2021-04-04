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
import fr.eni.projet.troc.bll.RetraitManager;
import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Categorie;
import fr.eni.projet.troc.bo.Retrait;
import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Servlet implementation class NouvelleListeServlet
 */
@WebServlet("/ModifierAnnonceServlet")
public class ModifierAnnonceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// récupérer infos article :
		String idArticle = request.getParameter("a");
		System.out.println("modifier // id article :" + idArticle);

		try {
			ArticleVendu article = ArticlesVendusManager.getInstance().selectArticleById(Integer.parseInt(idArticle));
			request.setAttribute("article", article);

			Retrait retrait = RetraitManager.getInstance().selectRetraitById(Integer.parseInt(idArticle));
			request.setAttribute("retrait", retrait);

			List<Categorie> categories = CategorieManager.getInstance().getCategorie();
			request.setAttribute("categories", categories);

			HttpSession session = request.getSession();
			session.setAttribute("noArticle", idArticle);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/modifierAnnonce.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération infos de l'utilisateur + idArtiche en session:
		HttpSession session = request.getSession();
		String idArticle = (String) session.getAttribute("noArticle");
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurEnSession");
		request.setCharacterEncoding("UTF-8");
		// on recupère l'article à modifier en fonction de son ID :
		ArticleVendu articleAModifier = null;
		Retrait retrait = null;

		try {

			try {
				articleAModifier = ArticlesVendusManager.getInstance().selectArticleById(Integer.parseInt(idArticle));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				retrait = RetraitManager.getInstance().selectRetraitById(Integer.parseInt(idArticle));
			} catch (Exception e) {
				e.printStackTrace();
			}

			// on modifie article et retrait avec les nouvelles infos saisies par
			// l'utilisateur :
			articleAModifier.setNom(request.getParameter("nomArticle"));
			articleAModifier.setDescription(request.getParameter("description"));
			articleAModifier.setNomCategorie(request.getParameter("cateVente"));
			articleAModifier.setPrixInitial(Integer.parseInt(request.getParameter("prix")));
			articleAModifier
					.setDateDebutEnchere(java.sql.Date.valueOf(request.getParameter("dateDebut")).toLocalDate());
			articleAModifier.setDateFinEnchere(java.sql.Date.valueOf(request.getParameter("dateFin")).toLocalDate());

			retrait.setRue(request.getParameter("rue"));
			retrait.setCodePostal(request.getParameter("codePostal"));
			retrait.setVille(request.getParameter("ville"));

			// pour vérif du mot de passe :
			String motDePasseSaisi = request.getParameter("motDePasse");

			ArticlesVendusManager am = ArticlesVendusManager.getInstance();
			am.update(articleAModifier, retrait, motDePasseSaisi);
			request.getRequestDispatcher("/AccueilServlet").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("errors", e.getErrors());

			request.getRequestDispatcher("/AccueilServlet").forward(request, response);

		}

	}
}
