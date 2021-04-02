/**
 * 
 */
package fr.eni.projet.troc.bll;

import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Enchere;
import fr.eni.projet.troc.dal.ArticleVenduDAO;
import fr.eni.projet.troc.dal.DAOFactory;
import fr.eni.projet.troc.dal.EnchereDAO;
import fr.eni.projet.troc.exception.BusinessException;
import fr.eni.projet.troc.exception.Errors;

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
	BusinessException be = new BusinessException();

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

	public void create(Enchere enchere) throws BusinessException {
		enchereOK(enchere.getNoArticle(), enchere.getMontantEnchere(), be);
		if (!be.hasErreurs()) {
			enchereDAO.create(enchere);
		} else {
			throw be;
		}

	}

	public void getEnchereId(int id) throws Exception {
		enchereDAO.selectById(id);
	}

	public ArticleVendu selectByIdSell(int id) throws BusinessException {
		return articleVenduDAO.selectByIdSell(id);
	}

	public boolean enchereOK(int idArticle, int prixEnchere, BusinessException be) throws BusinessException {
		ArticleVendu ArticleAncienPrix = selectByIdSell(idArticle);
		if (ArticleAncienPrix.getPrixVente() >= prixEnchere) {
			be.addError(Errors.INSERT_ENCHERE_ECHEC);
			System.out.println("Prix pas bon");
			return false;
		} else
			System.out.println("Prix bon");
		return true;
	}
}
