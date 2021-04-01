/**
 * 
 */
package fr.eni.projet.troc.bll;


import fr.eni.projet.troc.bo.Enchere;
import fr.eni.projet.troc.dal.DAOFactory;
import fr.eni.projet.troc.dal.EnchereDAO;

/**
 * Classe en charge
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 1 avr. 2021 - 15:39:27
 */
public class EnchereManager {

	private EnchereDAO enchereDAO;
	private static EnchereManager instance;

	private EnchereManager() {
		enchereDAO = DAOFactory.getEnchereDAO();
	}

	public static EnchereManager getInstance() {
		if (instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}
	
	
	  public void create(Enchere enchere) throws Exception{
		  enchereDAO.create(enchere);
	  }
	
}
