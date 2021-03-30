/**
 * 
 */
package fr.eni.projet.troc.dal;

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 29 mars 2021 - 14:11:51
 */
public class DAOFactory {

	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduImpl();
	}

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurImpl();
	}
	
	public static CategorieDAO getCategorieDAO() {
		return new CategorieImpl();
	}

}
