package fr.eni.projet.troc.bll;

import java.util.List;

import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Retrait;
import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.dal.ArticleVenduDAO;
import fr.eni.projet.troc.dal.DAOFactory;
import fr.eni.projet.troc.exception.BusinessException;
import fr.eni.projet.troc.exception.Errors;

public class ArticlesVendusManager {

	private ArticleVenduDAO articleVenduDAO;
	private static ArticlesVendusManager instance;

	private ArticlesVendusManager() {
		articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}

	public static ArticlesVendusManager getInstance() {
		if (instance == null) {
			instance = new ArticlesVendusManager();
		}
		return instance;
	}

	public List<ArticleVendu> getAllArticleVendus() throws Exception {

		return articleVenduDAO.selectAll();
	}

	public List<ArticleVendu> getAllArticleVendusStillInSell() throws Exception {

		return articleVenduDAO.selectAllArticlesStillInSell();
	}

	public List<ArticleVendu> getNoCategorie(int noCategorie) throws Exception {
		return articleVenduDAO.selectByIdCat(noCategorie);
	}

	public List<ArticleVendu> getNomArticle(String name) throws Exception {
		return articleVenduDAO.selectByName(name);
	}

	public void create(ArticleVendu articleVendu, Retrait retrait) throws Exception {
		articleVenduDAO.create(articleVendu, retrait);
	}

	public void deleteBynoUtilisateur(int noUtilisateur) throws BusinessException {
		articleVenduDAO.deleteBynoUtilisateur(noUtilisateur);
	}

	public List<ArticleVendu> getArticleId(int idArticle) throws Exception {
		return articleVenduDAO.selectById(idArticle);
	}

	public List<ArticleVendu> getArticleIdUser(int idUser) throws Exception {
		return articleVenduDAO.selectByIdUser(idUser);
	}

	public ArticleVendu selectArticleById(int idArticle) throws Exception {
		return articleVenduDAO.selectArticleById(idArticle);
	}

	public void update(ArticleVendu articleAModifier, Retrait retrait, String motDePasseSaisi)
			throws BusinessException {
		BusinessException be = new BusinessException();
		isNewPrixOK(articleAModifier, be);
		validerMotDePasse(articleAModifier, motDePasseSaisi, be);

		if (!be.hasErreurs()) {
			articleVenduDAO.update(articleAModifier, retrait);
		} else {
			throw be;
		}
	}

	private boolean validerMotDePasse(ArticleVendu articleAModifier, String motDePasseSaisi, BusinessException be) {
		UtilisateursManager um = UtilisateursManager.getInstance();
		return um.validerAncienMotDePasseBDD(motDePasseSaisi, articleAModifier.getNoUtilisateur(), be);
	}

	private boolean isNewPrixOK(ArticleVendu articleAModifier, BusinessException be) {
		if (articleAModifier.getPrixVente() != 0) {
			if (articleAModifier.getPrixInitial() > articleAModifier.getPrixVente()) {
				be.addError(Errors.REGLE_ARTICLE_UPDATE_PRIX);
				return false;
			}
		}
		return true;
	}

}
