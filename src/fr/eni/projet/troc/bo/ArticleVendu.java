/**
 * 
 */
package fr.eni.projet.troc.bo;

import java.time.LocalDate;

/**
 * Classe en charge
 * 
 * @author Bastien
 * @version Troc.com - v1.0
 * @date 29 mars 2021 - 13:27:02
 */
public class ArticleVendu {
	private int noArticle;
	private String nom;
	private String description;
	private LocalDate dateDebutEnchere;
	private LocalDate dateFinEnchere;
	private int prixInitial;
	private int prixVente;
	private Utilisateur noUtilisateur;
	private Categorie noCategorie;

	public ArticleVendu(int noArticle, String nom, String description, LocalDate dateDebutEnchere,
			LocalDate dateFinEnchere, int prixInitial, int prixVente, Utilisateur noUtilisateur,
			Categorie noCategorie) {
		super();
		this.noArticle = noArticle;
		this.nom = nom;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}

	public ArticleVendu(int noArticle, String nom, String description, LocalDate dateDebutEnchere,
			LocalDate dateFinEnchere, Utilisateur noUtilisateur, Categorie noCategorie) {
		super();
		this.noArticle = noArticle;
		this.nom = nom;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
	}

	public ArticleVendu() {

	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public void setDateDebutEnchere(LocalDate dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public LocalDate getDateFinEnchere() {
		return dateFinEnchere;
	}

	public void setDateFinEnchere(LocalDate dateFinEnchere) {
		this.dateFinEnchere = dateFinEnchere;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public Utilisateur getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Utilisateur noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public Categorie getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(Categorie noCategorie) {
		this.noCategorie = noCategorie;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nom=" + nom + ", description=" + description
				+ ", dateDebutEnchere=" + dateDebutEnchere + ", dateFinEnchere=" + dateFinEnchere + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", noUtilisateur=" + noUtilisateur + ", noCategorie="
				+ noCategorie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebutEnchere == null) ? 0 : dateDebutEnchere.hashCode());
		result = prime * result + ((dateFinEnchere == null) ? 0 : dateFinEnchere.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + noArticle;
		result = prime * result + ((noCategorie == null) ? 0 : noCategorie.hashCode());
		result = prime * result + ((noUtilisateur == null) ? 0 : noUtilisateur.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + prixInitial;
		result = prime * result + prixVente;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleVendu other = (ArticleVendu) obj;
		if (dateDebutEnchere == null) {
			if (other.dateDebutEnchere != null)
				return false;
		} else if (!dateDebutEnchere.equals(other.dateDebutEnchere))
			return false;
		if (dateFinEnchere == null) {
			if (other.dateFinEnchere != null)
				return false;
		} else if (!dateFinEnchere.equals(other.dateFinEnchere))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (noArticle != other.noArticle)
			return false;
		if (noCategorie == null) {
			if (other.noCategorie != null)
				return false;
		} else if (!noCategorie.equals(other.noCategorie))
			return false;
		if (noUtilisateur == null) {
			if (other.noUtilisateur != null)
				return false;
		} else if (!noUtilisateur.equals(other.noUtilisateur))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prixInitial != other.prixInitial)
			return false;
		if (prixVente != other.prixVente)
			return false;
		return true;
	}

}
