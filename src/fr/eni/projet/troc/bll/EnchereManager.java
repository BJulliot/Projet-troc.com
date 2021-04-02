/**
 * 
 */
package fr.eni.projet.troc.bll;

import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Enchere;
import fr.eni.projet.troc.dal.ArticleVenduDAO;
import fr.eni.projet.troc.dal.DAOFactory;
import fr.eni.projet.troc.dal.EnchereDAO;

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 1 avr. 2021 - 15:39:27
 */
public class EnchereManager {

	private EnchereDAO enchereDAO;
	private static EnchereManager instance;
	
	private ArticleVenduDAO articleVenduDAO;

	private EnchereManager() {
		enchereDAO = DAOFactory.getEnchereDAO();
		articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}

	public static EnchereManager getInstance() {
		if (instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}

	public void create(Enchere enchere) throws Exception {
		enchereOK(enchere.getNoArticle(), enchere.getMontantEnchere());
		enchereDAO.create(enchere);
	}

	public void getEnchereId(int id) throws Exception {
		enchereDAO.selectById(id);
	}

	public ArticleVendu selectByIdSell(int id) throws Exception{
		return articleVenduDAO.selectByIdSell(id);
	}
	
	public boolean enchereOK(int idArticle, int prixEnchere) throws Exception {
		ArticleVendu ArticleAncienPrix = selectByIdSell(idArticle);
		if(ArticleAncienPrix.getPrixVente()>= prixEnchere) {
			System.out.println("Prix pas bon");
			return false;
		}else
			System.out.println("Prix bon");
			return true;
	}
}
