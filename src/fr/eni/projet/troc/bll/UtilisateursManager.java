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
	BusinessException be = new BusinessException();

	private UtilisateursManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public static UtilisateursManager getInstance() {
		if (instance == null) {
			instance = new UtilisateursManager();
		}
		return instance;
	}

	public void create(Utilisateur utilisateur, String confirmationMotDePasse) throws BusinessException {
		BusinessException be = new BusinessException();
		validerPseudo(utilisateur.getPseudo(), be);
		validerNom(utilisateur.getNom(), be);
		validerPrenom(utilisateur.getPrenom(), be);
		validerEmail(utilisateur.getEmail(), be);
		validerTelephone(utilisateur.getTelephone(), be);
		validerRue(utilisateur.getRue(), be);
		validerCodePostal(utilisateur.getCodePostal(), be);
		validerVille(utilisateur.getVille(), be);
		validerMotDePasse(utilisateur.getMotDePasse(), be);
		validerMotDePasseIdentique(utilisateur.getMotDePasse(), confirmationMotDePasse, be);

		if (!be.hasErreurs()) {
			utilisateurDAO.create(utilisateur);
		} else {
			throw be;
		}
	}

	private boolean validerTelephone(String telephone, BusinessException be) {
		if (telephone == null) {
			be.addError("Le numéro de téléphone est obligatoire");
			return false;
		}
		if (!telephone.matches(Constants.PATTERN_TEL)) {
			be.addError(Errors.REGLE_UTILISATEUR_TELEPHONE_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerMotDePasse(String motDePasse, BusinessException be) {
		if (motDePasse == null) {
			be.addError("Le mot de passe est obligatoire");
			return false;
		}
		if (!motDePasse.matches(Constants.PATTERN_PWD)) {
			be.addError(Errors.REGLE_UTILISATEUR_PWD_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerMotDePasseIdentique(String motDePasse, String confirmationMotDePasse, BusinessException be) {
		if (!motDePasse.equals(confirmationMotDePasse)) {
			be.addError(Errors.REGLE_UTILISATEUR_PWD_DIFFERENT_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerEmail(String email, BusinessException be) {
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

	private boolean validerNom(String nom, BusinessException be) {
		if (nom == null || nom.trim().isEmpty() || nom.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_NOM_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerPrenom(String prenom, BusinessException be) {
		if (prenom == null || prenom.trim().isEmpty() || prenom.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_PRENOM_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerPseudo(String pseudo, BusinessException be) {
		if (pseudo == null || pseudo.trim().isEmpty() || pseudo.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_PSEUDO_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerRue(String rue, BusinessException be) {
		if (rue == null || rue.trim().isEmpty() || rue.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_RUE_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerCodePostal(String codePostal, BusinessException be) {
		if (codePostal == null || codePostal.trim().isEmpty() || codePostal.trim().length() > 10) {
			be.addError(Errors.REGLE_UTILISATEUR_CODE_POSTAL_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerVille(String ville, BusinessException be) {
		if (ville == null || ville.trim().isEmpty() || ville.trim().length() > 50) {
			be.addError(Errors.REGLE_UTILISATEUR_VILLE_ERREUR);
			return false;
		}
		return true;
	}

	public Utilisateur validateConnection(String pseudo, String motDePasse) throws BusinessException {
		// Validation des données par rapport au métier

		boolean isValidPseudo = validerPseudo(pseudo, be);
		boolean isValidMotDePasse = validerMotDePasse(motDePasse, be);
		if (isValidPseudo && isValidMotDePasse) {
			// Appelle de la couche DAL
			return utilisateurDAO.find(pseudo, motDePasse);
		} else {
			throw be;
		}
	}
}
