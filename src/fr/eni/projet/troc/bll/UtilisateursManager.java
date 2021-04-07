/**
 * 
 */
package fr.eni.projet.troc.bll;

import java.util.List;

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
		isPseudoUnique(utilisateur.getPseudo(), be);

		if (!be.hasErreurs()) {
			utilisateurDAO.create(utilisateur);
		} else {
			throw be;
		}
	}
	
	public Utilisateur selectUserEnchere() throws Exception {
		return utilisateurDAO.selectEnchereByPseudo();
	}

	public void update(int noUtilisateur, String ancienPseudo, String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String codePostal, String ville, String ancienMotDePasse,
			String nouveauMotDePasse, String confirmationMotDePasse) throws BusinessException {
		BusinessException be = new BusinessException();

		validerPseudo(pseudo, be);
		validerNom(nom, be);
		validerPrenom(prenom, be);
		validerEmail(email, be);
		validerTelephone(telephone, be);
		validerRue(rue, be);
		validerCodePostal(codePostal, be);
		validerVille(ville, be);
		validerAncienMotDePasseBDD(ancienMotDePasse, noUtilisateur, be);
		if (!(nouveauMotDePasse.equals(""))) {
			validerMotDePasse(nouveauMotDePasse, be);
			validerMotDePasseIdentique(nouveauMotDePasse, confirmationMotDePasse, be);
			isNouveauMotDePasseDifferent(ancienMotDePasse, nouveauMotDePasse, be);
		}

		isPseudoUniqueUpdate(ancienPseudo, pseudo, be);

		if (!be.hasErreurs()) {
			if ((nouveauMotDePasse.equals(""))) {
				utilisateurDAO.update(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
						ancienMotDePasse);
			} else if (!(nouveauMotDePasse.equals(""))) {
				utilisateurDAO.update(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
						nouveauMotDePasse);
			}
		} else {
			throw be;
		}
	}

	private boolean isNouveauMotDePasseDifferent(String ancienMotDePasse, String nouveauMotDePasse,
			BusinessException be) {
		if ((ancienMotDePasse.equals(nouveauMotDePasse))) {
			be.addError(Errors.REGLE_UTILISATEUR_NEW_PWD_MUST_BE_DIFFERENT_ERREUR);
			return false;
		}
		return true;
	}

	public void delete(int noUtilisateur) throws BusinessException {
		utilisateurDAO.delete(noUtilisateur);
	}

	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
		return utilisateurDAO.selectByPseudo(pseudo);
	}

	public List<Utilisateur> selectAll() throws BusinessException {
		return utilisateurDAO.selectAll();
	}

	private boolean validerTelephone(String telephone, BusinessException be) {
		if (telephone.trim().equals("")) {
			be.addError("Le numéro de téléphone est obligatoire");
			return false;
		}
		if (!telephone.matches(Constants.PATTERN_TEL)) {
			be.addError(Errors.REGLE_UTILISATEUR_TELEPHONE_ERREUR);
			return false;
		}
		return true;
	}

	public boolean validerAncienMotDePasseBDD(String ancienMotDePasse, int noUtilisateur, BusinessException be) {
		boolean result = true;
		if (ancienMotDePasse.trim().equals("")) {
			be.addError(Errors.REGLE_UTILISATEUR_PWD_NULL_ERREUR);
			result = false;
		}
		try {
			if (!(utilisateurDAO.getPasswordBynoUtilisateur(noUtilisateur).equals(ancienMotDePasse))) {
				be.addError(Errors.REGLE_UTILISATEUR_ANCIEN_PWD_ERREUR);
				result = false;
			} else {
				result = true;
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return result;
	}

	private boolean validerMotDePasse(String motDePasse, BusinessException be) {
		if (motDePasse.trim().equals("")) {
			be.addError(Errors.REGLE_UTILISATEUR_PWD_NULL_ERREUR);
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
		if (email.trim().equals("")) {
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
		if (nom.trim().equals("") || nom.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_NOM_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerPrenom(String prenom, BusinessException be) {
		if (prenom.trim().equals("") || prenom.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_PRENOM_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerPseudo(String pseudo, BusinessException be) {
		if (pseudo.trim().equals("") || pseudo.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_PSEUDO_ERREUR);
			return false;
		}
		return true;
	}

	private boolean isPseudoUnique(String pseudo, BusinessException be) throws BusinessException {
		if (!utilisateurDAO.isPseudoUnique(pseudo)) {
			be.addError(Errors.REGLE_UTILISATEUR_PSEUDO_ALREADY_IN_DB_ERREUR);
			return false;
		} else {
			return true;
		}
	}

	private boolean isPseudoUniqueUpdate(String pseudo, String ancienPseudo, BusinessException be)
			throws BusinessException {
		if (pseudo.equals(ancienPseudo)) {
			return true;
		} else if (!utilisateurDAO.isPseudoUnique(pseudo)) {

			be.addError(Errors.REGLE_UTILISATEUR_PSEUDO_ALREADY_IN_DB_ERREUR);
			return false;
		}
		return false;
	}

	private boolean validerRue(String rue, BusinessException be) {
		if (rue.trim().equals("") || rue.trim().length() > 30) {
			be.addError(Errors.REGLE_UTILISATEUR_RUE_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerCodePostal(String codePostal, BusinessException be) {
		if (codePostal.trim().equals("") || codePostal.trim().length() > 10) {
			be.addError(Errors.REGLE_UTILISATEUR_CODE_POSTAL_ERREUR);
			return false;
		}
		return true;
	}

	private boolean validerVille(String ville, BusinessException be) {
		if (ville.trim().equals("") || ville.trim().length() > 50) {
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
