/**
 * 
 */
package fr.eni.projet.troc.bll;

import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.dal.DAOFactory;
import fr.eni.projet.troc.dal.UtilisateurDAO;

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 29 mars 2021 - 11:36:34
 */
public class UtilisateursManager {
	private UtilisateurDAO utilisateurDAO;
	private static UtilisateursManager instance;

	private UtilisateursManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public static UtilisateursManager getInstance() {
		if (instance == null) {
			instance = new UtilisateursManager();
		}
		return instance;
	}

	public void create(Utilisateur utilisateur) throws Exception {
		utilisateurDAO.create(utilisateur);
	}

}
