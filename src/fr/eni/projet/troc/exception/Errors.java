package fr.eni.projet.troc.exception;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public class Errors {
	/**
	 * Echec le pseudo de l'utilisateur est d�j� en BDD
	 */
	public static final String REGLE_UTILISATEUR_PSEUDO_ALREADY_IN_DB_ERREUR = "Le pseudo de l'utilisateur est d�j� utilis�.";

	/**
	 * Echec le pseudo de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_PSEUDO_NULL_ERREUR = "Le pseudo de l'utilisateur est obligatoire et est compos� d'au moins 4 caract�res.";

	/**
	 * Echec le pseudo de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_PWD_NULL_ERREUR = "Le mot de passe de l'utilisateur ne peut pas �tre nul.";

	/**
	 * Echec le pseudo de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_NEW_PWD_MUST_BE_DIFFERENT_ERREUR = "Le nouveau mot de passe doit �tre diff�rent de l'ancien.";

	/**
	 * Echec le nom de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_NOM_ERREUR = "Le nom de l'utilisateur est obligatoire et ne doit pas d�passer 30 caract�res.";

	/**
	 * Echec le pr�nom de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_PRENOM_ERREUR = "Le pr�nom de l'utilisateur est obligatoire et ne doit pas d�passer 30 caract�res.";

	/**
	 * Echec le pseudo de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_PSEUDO_ERREUR = "Le pseudo de l'utilisateur est obligatoire et ne doit pas d�passer 30 caract�res alpha.";

	/**
	 * Echec le mail ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_EMAIL_ERREUR = "L'adresse email est incorrecte et doit �tre sous la forme : exemple@nomdedomaine.com";

	/**
	 * Echec le mail ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_TELEPHONE_ERREUR = "Le t�l�phone est incorrecte et doit contenir 10 chiffres.";

	/**
	 * Echec le mot de passe de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_PWD_ERREUR = "Le mot de passe doit contenir entre 8 et 12 caract�res (1 chiffre, 1 majuscule, 1 caract�re sp�cial).";

	/**
	 * Echec le mot de passe de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_ANCIEN_PWD_ERREUR = "Le mot de passe de passe saisi n'est pas le m�me que l'ancien.";

	/**
	 * Echec la rue de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_RUE_ERREUR = "L'adresse de l'utilisateur est obligatoire et ne doit pas d�passer 30 caract�res.";

	/**
	 * Echec le code postal de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_CODE_POSTAL_ERREUR = "Le code postal de l'utilisateur est obligatoire et ne doit pas d�passer 10 caract�res.";

	/**
	 * Echec la ville de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_VILLE_ERREUR = "La ville de l'utilisateur est obligatoire et ne doit pas d�passer 50 caract�res.";

	/**
	 * Echec le mot de passe de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_PWD_DIFFERENT_ERREUR = "Les deux mots de passe doivent �tre identiques.";

	/**
	 * Echec g�n�ral quand erreur non g�r�e à l'insertion
	 */
	public static final String INSERT_UTILISATEUR_ECHEC = "Une erreur non g�r�e est survenue lors de l'enregistrement des informations.";

	/**
	 * Echec r�cup�ration du mot de passe en BDD
	 */
	public static final String SELECT_PASSWORD_UTILISATEUR_ECHEC = "Une erreur non g�r�e est survenue lors de la r�cup�ration du mot de passe.";

	/**
	 * Echec r�cup�ration du mot de passe en BDD
	 */
	public static final String SUPPRESSION_UTILISATEUR_ERREUR = "Une erreur non g�r�e est survenue lors de la suppresion de l'utilisateur.";

	/**
	 * Echec r�cup�ration de l'utilisateur en BDD
	 */
	public static final String SELECT_UTILISATEUR_ECHEC = "Une erreur non g�r�e est survenue lors de la r�cup�ration de l'utilisateur en BDD.";
	
	/**
	 * Enchère trop basse 
	 */
	public static final String INSERT_ENCHERE_ECHEC = "Vous ne pouvez pas faire une enchère inferieur a l'enchère en cours";
}
