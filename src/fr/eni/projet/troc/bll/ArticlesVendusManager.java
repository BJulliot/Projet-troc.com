package fr.eni.projet.troc.bll;

import java.util.List;

import fr.eni.projet.troc.bo.ArticleVendu;
import fr.eni.projet.troc.bo.Categorie;
import fr.eni.projet.troc.dal.ArticleVenduDAO;
import fr.eni.projet.troc.dal.DAOFactory;

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
    
    public List<ArticleVendu> getNoCategorie(int noCategorie)throws Exception {
    	return articleVenduDAO.selectById(noCategorie);
    }
	
}
