/**
 * 
 */
package fr.eni.projet.troc.bll;

import java.util.List;

import fr.eni.projet.troc.bo.Retrait;
import fr.eni.projet.troc.dal.DAOFactory;
import fr.eni.projet.troc.dal.RetraitDAO;
import fr.eni.projet.troc.exception.BusinessException;

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 1 avr. 2021 - 15:15:04
 */
public class RetraitManager {

	private RetraitDAO retraitDAO;
	private static RetraitManager instance;

	private RetraitManager() {
		retraitDAO = DAOFactory.geRetraitDAO();
	}

	public static RetraitManager getInstance() {
		if (instance == null) {
			instance = new RetraitManager();
		}
		return instance;
	}

	public List<Retrait> getRetraitId(int id) throws Exception {
		return retraitDAO.selectById(id);
	}

	public Retrait selectRetraitById(int idArticle) throws Exception {
		return retraitDAO.selectRetraitById(idArticle);
	}

	public void deleteBynoUtilisateur(int noUtilisateur) throws BusinessException {
		retraitDAO.deleteBynoUtilisateur(noUtilisateur);
	}
	
}
