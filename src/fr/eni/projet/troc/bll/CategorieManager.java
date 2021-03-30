/**
 * 
 */
package fr.eni.projet.troc.bll;

import java.util.List;

import fr.eni.projet.troc.bo.Categorie;
import fr.eni.projet.troc.dal.CategorieDAO;
import fr.eni.projet.troc.dal.DAOFactory;

/**
 * Classe en charge
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 30 mars 2021 - 10:44:41
 */
public class CategorieManager {

	private CategorieDAO categorieDAO;
	private static CategorieManager instance;

	private CategorieManager() {
		categorieDAO = DAOFactory.getCategorieDAO();
	}

	public static CategorieManager getInstance() {
		if (instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}
	
    public List<Categorie> getCategorie() throws Exception {
        return categorieDAO.selectAll();
    }
    
    public Categorie getNoCategorie(int noCategorie)throws Exception {
    	return categorieDAO.selectById(noCategorie);
    }
	
}
