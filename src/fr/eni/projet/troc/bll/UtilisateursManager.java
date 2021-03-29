/**
 * 
 */
package fr.eni.projet.troc.bll;

import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.dal.DAOFactory;
import fr.eni.projet.troc.dal.UtilisateurDAO;
import fr.eni.projet.troc.exception.BusinessException;
import fr.eni.projet.troc.util.Constants;

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

	private boolean validerTelephone(String telephone, BusinessException be) {
		if (telephone == null) {
			be.addError("Le numéro de téléphone est obligatoire");
			return false;
		}
		if (!telephone.matches(Constants.PATTERN_TEL)) {
			be.addError(
					"Mot de passe doit contenir entre 8 et 12 caractères (1 chiffre, 1 majuscule, 1 caractère spécial)");
			return false;
		}
		return true;
	}

	private boolean validerPassword(String pwd, BusinessException be) {
		if (pwd == null) {
			be.addError("Mot de passe est obligatoire");
			return false;
		}
		if (!pwd.matches(Constants.PATTERN_PWD)) {
			be.addError(
					"Mot de passe doit contenir entre 8 et 12 caractères (1 chiffre, 1 majuscule, 1 caractère spécial)");
			return false;
		}

		return true;
	}
}
