package fr.eni.projet.troc.exception;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public class Errors {
	/**
	 * Echec le pseudo de l'utilisateur est dï¿½jï¿½ en BDD
	 */
	public static final String REGLE_UTILISATEUR_PSEUDO_ALREADY_IN_DB_ERREUR = "Le pseudo de l'utilisateur est déjà utilisé.";

	/**
	 * Echec le pseudo de l'utilisateur ne respecte pas les rï¿½gles dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_PSEUDO_NULL_ERREUR = "Le pseudo de l'utilisateur est obligatoire et est composé d'au moins 4 caractères.";

	/**
	 * Echec le pseudo de l'utilisateur ne respecte pas les rï¿½gles dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_PWD_NULL_ERREUR = "Le mot de passe de l'utilisateur ne peut pas être nul.";

	/**
	 * Echec le pseudo de l'utilisateur ne respecte pas les rï¿½gles dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_NEW_PWD_MUST_BE_DIFFERENT_ERREUR = "Le nouveau mot de passe doit être différent de l'ancien.";

	/**
	 * Echec le nom de l'utilisateur ne respecte pas les rï¿½gles dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_NOM_ERREUR = "Le nom de l'utilisateur est obligatoire et ne doit pas dépasser 30 caractï¿½res.";

	/**
	 * Echec le prï¿½nom de l'utilisateur ne respecte pas les rï¿½gles dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_PRENOM_ERREUR = "Le prénom de l'utilisateur est obligatoire et ne doit pas dï¿½passer 30 caractères.";

	/**
	 * Echec le pseudo de l'utilisateur ne respecte pas les rï¿½gles dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_PSEUDO_ERREUR = "Le pseudo de l'utilisateur est obligatoire et ne doit pas dï¿½passer 30 caractères alpha.";

	/**
	 * Echec le mail ne respecte pas les rï¿½gles dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_EMAIL_ERREUR = "L'adresse email est incorrecte et doit être sous la forme : exemple@nomdedomaine.com";

	/**
	 * Echec le mail ne respecte pas les rï¿½gles dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_TELEPHONE_ERREUR = "Le téléphone est incorrecte et doit contenir 10 chiffres.";

	/**
	 * Echec le mot de passe de l'utilisateur ne respecte pas les rï¿½gles
	 * dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_PWD_ERREUR = "Le mot de passe doit contenir entre 8 et 12 caractï¿½res (1 chiffre, 1 majuscule, 1 caractère spécial).";

	/**
	 * Echec le mot de passe de l'utilisateur ne respecte pas les rï¿½gles
	 * dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_ANCIEN_PWD_ERREUR = "Le mot de passe de passe saisi n'est pas le même que l'ancien.";

	/**
	 * Echec la rue de l'utilisateur ne respecte pas les rï¿½gles dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_RUE_ERREUR = "L'adresse de l'utilisateur est obligatoire et ne doit pas dï¿½passer 30 caractères.";

	/**
	 * Echec le code postal de l'utilisateur ne respecte pas les rï¿½gles dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_CODE_POSTAL_ERREUR = "Le code postal de l'utilisateur est obligatoire et ne doit pas dï¿½passer 10 caractères.";

	/**
	 * Echec la ville de l'utilisateur ne respecte pas les rï¿½gles dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_VILLE_ERREUR = "La ville de l'utilisateur est obligatoire et ne doit pas dï¿½passer 50 caractères.";

	/**
	 * Echec le mot de passe de l'utilisateur ne respecte pas les rï¿½gles
	 * dï¿½finies
	 */
	public static final String REGLE_UTILISATEUR_PWD_DIFFERENT_ERREUR = "Les deux mots de passe doivent être identiques.";

	/**
	 * Echec gï¿½nï¿½ral quand erreur non gï¿½rï¿½e Ã  l'insertion
	 */
	public static final String INSERT_UTILISATEUR_ECHEC = "Une erreur non gérée est survenue lors de l'enregistrement des informations.";

	/**
	 * Echec gï¿½nï¿½ral quand erreur non gï¿½rï¿½e Ã  l'insertion
	 */
	public static final String UPDATE_ARTICLE_ECHEC = "Une erreur non gérée est survenue lors de la mise à jour de l'annonce.";

	/**
	 * Echec récupération du mot de passe en BDD
	 */
	public static final String SELECT_PASSWORD_UTILISATEUR_ECHEC = "Une erreur non gérée est survenue lors de la récupération du mot de passe.";

	/**
	 * Echec lors de la suppression de l'utilisateur en BDD
	 */
	public static final String SUPPRESSION_UTILISATEUR_ERREUR = "Une erreur non gérée est survenue lors de la suppresion de l'utilisateur.";

	/**
	 * Echec lors de la suppression de l'utilisateur en BDD
	 */
	public static final String SUPPRESSION_ARTICLE_ERREUR = "Une erreur non gérée est survenue lors de la suppresion de l'article.";

	/**
	 * Echec lors de la suppression de l'enchere en BDD
	 */
	public static final String SUPPRESSION_ENCHERE_ERREUR = "Une erreur non gérée est survenue lors de la suppresion de l'enchere en BDD.";

	/**
	 * Echec lors de la suppression du retrait en BDD
	 */
	public static final String SUPPRESSION_RETRAIT_ERREUR = "Une erreur non gérée est survenue lors de la suppresion du retrait en BDD.";

	
	/**
	 * Echec rï¿½cupï¿½ration de l'utilisateur en BDD
	 */
	public static final String SELECT_UTILISATEUR_ECHEC = "Une erreur non gérée est survenue lors de la récupération de l'utilisateur en BDD.";

	/**
	 * EnchÃ¨re trop basse
	 */
	public static final String INSERT_ENCHERE_ECHEC = "Vous ne pouvez pas faire une enchère inferieur a l'enchère en cours";

	public static final String REGLE_ARTICLE_UPDATE_PRIX = "Vous ne pouvez pas mettre un prix supérieur au prix de l'enchère en cours";
}
