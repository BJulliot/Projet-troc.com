package fr.eni.projet.troc.exception;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public class Errors {

	/**
	 * Echec le nom de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_NOM_ERREUR = "Le nom de l'utilisateur est obligatoire et ne doit pas d�passer 30 caract�res";

	/**
	 * Echec le pr�nom de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_PRENOM_ERREUR = "Le pr�nom de l'utilisateur est obligatoire et ne doit pas d�passer 30 caract�res";

	/**
	 * Echec le pseudo de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_PSEUDO_ERREUR = "Le pseudo de l'utilisateur est obligatoire et ne doit pas d�passer 30 caract�res";

	/**
	 * Echec le mail ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_EMAIL_ERREUR = "L'adresse email est incorrecte et doit �tre sous la forme : exemple@nomdedomaine.com";

	/**
	 * Echec le mot de passe de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_PWD_ERREUR = "Le mot de passe doit contenir entre 8 et 12 caract�res (1 chiffre, 1 majuscule, 1 caract�re sp�cial)";

	/**
	 * Echec la rue de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_RUE_ERREUR = "L'adresse de l'utilisateur est obligatoire et ne doit pas d�passer 30 caract�res";

	/**
	 * Echec le code postal de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_CODE_POSTAL_ERREUR = "Le code postal de l'utilisateur est obligatoire et ne doit pas d�passer 10 caract�res";

	/**
	 * Echec la ville de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_VILLE_ERREUR = "La ville de l'utilisateur est obligatoire et ne doit pas d�passer 50 caract�res";

	/**
	 * Echec le mot de passe de l'utilisateur ne respecte pas les r�gles d�finies
	 */
	public static final String REGLE_UTILISATEUR_PWD_DIFFERENT_ERREUR = "Les deux mots de passe doivent �tre identiques";

// ANCIEN :
// EXCEPTION D'ANNE-LISE :

	/**
	 * Echec g�n�ral quand tentative d'ajouter un objet null
	 */
	public static final String INSERT_OBJET_NULL = "Une tentative d'enrgistrement d'informations inexistantes a eu lieu.";

	/**
	 * Echec g�n�ral quand erreur non g�r�e à l'insertion
	 */
	public static final String INSERT_OBJET_ECHEC = "Une erreur non g�r�e est survenue lors de l'enrgistrement des informations.";

	/**
	 * Echec de la lecture des listes de course
	 */
	public static final String LECTURE_LISTES_ECHEC = "Les listes de course sont inaccessibles pour le moment.";

	/**
	 * Echec de la lecture des listes de course
	 */
	public static final String LECTURE_ARTICLE_ECHEC = "Les articles sont inaccessibles pour le moment.";

	/**
	 * Echec de la lecture d'une liste de course
	 */
	public static final String LECTURE_LISTE_ECHEC = "Une erreur est survenue au chargement de la liste de course";
	/**
	 * Liste de course inexistante
	 */
	public static final String LECTURE_LISTE_INEXISTANTE = "La liste de course n'existe pas.";
	/**
	 * Erreur à la suppression d'un article
	 */
	public static final String SUPPRESSION_ARTICLE_ERREUR = "Impossible de supprimer l'article.";
	/**
	 * Erreur à la suppression d'une liste
	 */
	public static final String SUPPRESSION_LISTE_ERREUR = "Impossible de supprimer la liste.";

	/**
	 * Format id liste course incorrect
	 */
	public static final String FORMAT_ID_LISTE_ERREUR = "L'identifiant de la liste n'est pas reconnu. Ce doit �tre un nombre valide.";
	/**
	 * Format id liste course incorrect
	 */
	public static final String NOM_ARTICLE_OBLIGATOIRE = "Le nom de l'article est obligatoire";
	public static final String NOM_LISTE_OBLIGATOIRE = "Le nom de la liste est obligatoire";
	public static final String FORMAT_ID_ARTICLE_ERREUR = "L'identifiant de l'article n'est pas reconnu. Ce doit �tre un nombre valide.";

}
