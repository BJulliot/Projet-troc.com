package fr.eni.projet.troc.exception;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public class Errors {

	/**
	 * Echec le nom de l'utilisateur ne respecte pas les règles définies
	 */
	public static final String REGLE_UTILISATEUR_NOM_ERREUR = "Le nom de l'utilisateur est obligatoire et ne doit pas dépasser 30 caractères.";

	/**
	 * Echec le prénom de l'utilisateur ne respecte pas les règles définies
	 */
	public static final String REGLE_UTILISATEUR_PRENOM_ERREUR = "Le prénom de l'utilisateur est obligatoire et ne doit pas dépasser 30 caractères.";

	/**
	 * Echec le pseudo de l'utilisateur ne respecte pas les règles définies
	 */
	public static final String REGLE_UTILISATEUR_PSEUDO_ERREUR = "Le pseudo de l'utilisateur est obligatoire et ne doit pas dépasser 30 caractères.";

	/**
	 * Echec le mail ne respecte pas les règles définies
	 */
	public static final String REGLE_UTILISATEUR_EMAIL_ERREUR = "L'adresse email est incorrecte et doit être sous la forme : exemple@nomdedomaine.com.";

	/**
	 * Echec le mail ne respecte pas les règles définies
	 */
	public static final String REGLE_UTILISATEUR_TELEPHONE_ERREUR = "Le téléphone est incorrecte et doit contenir 10 chiffres.";

	/**
	 * Echec le mot de passe de l'utilisateur ne respecte pas les règles définies
	 */
	public static final String REGLE_UTILISATEUR_PWD_ERREUR = "Le mot de passe doit contenir entre 8 et 12 caractères (1 chiffre, 1 majuscule, 1 caractère spécial).";

	/**
	 * Echec la rue de l'utilisateur ne respecte pas les règles définies
	 */
	public static final String REGLE_UTILISATEUR_RUE_ERREUR = "L'adresse de l'utilisateur est obligatoire et ne doit pas dépasser 30 caractères.";

	/**
	 * Echec le code postal de l'utilisateur ne respecte pas les règles définies
	 */
	public static final String REGLE_UTILISATEUR_CODE_POSTAL_ERREUR = "Le code postal de l'utilisateur est obligatoire et ne doit pas dépasser 10 caractères.";

	/**
	 * Echec la ville de l'utilisateur ne respecte pas les règles définies
	 */
	public static final String REGLE_UTILISATEUR_VILLE_ERREUR = "La ville de l'utilisateur est obligatoire et ne doit pas dépasser 50 caractères.";

	/**
	 * Echec le mot de passe de l'utilisateur ne respecte pas les règles définies
	 */
	public static final String REGLE_UTILISATEUR_PWD_DIFFERENT_ERREUR = "Les deux mots de passe doivent être identiques.";
}
