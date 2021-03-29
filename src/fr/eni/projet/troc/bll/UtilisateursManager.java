/**
 * 
 */
package fr.eni.projet.troc.bll;

import fr.eni.projet.troc.bo.Utilisateur;
import fr.eni.projet.troc.dal.DAOFactory;
import fr.eni.projet.troc.dal.UtilisateurDAO;
import fr.eni.projet.troc.exception.BusinessException;
import fr.eni.projet.troc.exception.Errors;
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

	public void create(Utilisateur utilisateur) throws BusinessException {
		BusinessException be = new BusinessException();
		validerPseudo(utilisateur, be);
		validerNom(utilisateur, be);
		validerPrenom(utilisateur, be);
		validerEmail(utilisateur, be);
		validerTelephone(utilisateur, be);
		validerRue(utilisateur, be);
		validerCodePostal(utilisateur, be);
		validerVille(utilisateur, be);
		validerMotDePasse(utilisateur, be);

		if (!be.hasErreurs()) {
			utilisateurDAO.create(utilisateur);
		} else {
			throw be;
		}
	}

	private boolean validerTelephone(Utilisateur utilisateur, BusinessException be) {
		String telephone = utilisateur.getTelephone();
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

	private boolean validerMotDePasse(Utilisateur utilisateur, BusinessException be) {
		String pwd = utilisateur.getMotDePasses();
		if (pwd == null) {
			be.addError("Le mot de passe est obligatoire");
			return false;
		}
		if (!pwd.matches(Constants.PATTERN_PWD)) {
			be.addError(Errors.REGLE_UTILISATEUR_PWD_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerEmail(Utilisateur utilisateur, BusinessException be) {
		String email = utilisateur.getEmail();
		if (email == null) {
			be.addError("L'email est obligatoire");
			return false;
		}
		if (!email.matches(Constants.PATTERN_EMAIL)) {
			be.addError(Errors.REGLE_UTILISATEUR_EMAIL_ERREUR);
			return false;
		}
		return true;
	}

	private void validerNom(Utilisateur utilisateur, BusinessException be) {
		String nom = utilisateur.getNom();

		if (nom == null || nom.trim().isEmpty() || nom.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_NOM_ERREUR);
		}
	}

	private void validerPrenom(Utilisateur utilisateur, BusinessException be) {
		String prenom = utilisateur.getPrenom();

		if (prenom == null || prenom.trim().isEmpty() || prenom.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_PRENOM_ERREUR);
		}
	}

	private void validerPseudo(Utilisateur utilisateur, BusinessException be) {
		String pseudo = utilisateur.getPseudo();

		if (pseudo == null || pseudo.trim().isEmpty() || pseudo.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_PSEUDO_ERREUR);
		}
	}

	private void validerRue(Utilisateur utilisateur, BusinessException be) {
		String rue = utilisateur.getRue();

		if (rue == null || rue.trim().isEmpty() || rue.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_RUE_ERREUR);
		}
	}

	private void validerCodePostal(Utilisateur utilisateur, BusinessException be) {
		String codePostal = utilisateur.getCodePostal();

		if (codePostal == null || codePostal.trim().isEmpty() || codePostal.trim().length() > 10) {
			be.addError(Errors.REGLE_UTILISATEUR_CODE_POSTAL_ERREUR);
		}
	}

	private void validerVille(Utilisateur utilisateur, BusinessException be) {
		String ville = utilisateur.getVille();

		if (ville == null || ville.trim().isEmpty() || ville.trim().length() > 50) {
			be.addError(Errors.REGLE_UTILISATEUR_VILLE_ERREUR);
		}
	}
}
