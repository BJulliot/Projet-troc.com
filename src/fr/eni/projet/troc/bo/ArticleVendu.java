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
	private String pseudoUtilisateur;
	private int noUtilisateur;
	private String nomCategorie;
	private int noCategorie;
 
	public ArticleVendu(int noArticle, String nom, String description, LocalDate dateDebutEnchere,
			LocalDate dateFinEnchere, int prixInitial, int prixVente, String pseudoUtilisateur, int noUtilisateur,
			String nomCategorie, int noCategorie) {
		super();
		this.noArticle = noArticle;
		this.nom = nom;
		this.description = description;
		this.dateDebutEnchere = dateDebutEnchere;
		this.dateFinEnchere = dateFinEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.pseudoUtilisateur = pseudoUtilisateur;
		this.noUtilisateur = noUtilisateur;
		this.nomCategorie = nomCategorie;
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
	public String getPseudoUtilisateur() {
		return pseudoUtilisateur;
	}
	public void setPseudoUtilisateur(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
	}
	public int getNoUtilisateur() {
		return noUtilisateur;
	}
	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nom=" + nom + ", description=" + description
				+ ", dateDebutEnchere=" + dateDebutEnchere + ", dateFinEnchere=" + dateFinEnchere + ", prixInitial="
				+ prixInitial + ", prixVente=" + prixVente + ", pseudoUtilisateur=" + pseudoUtilisateur
				+ ", noUtilisateur=" + noUtilisateur + ", nomCategorie=" + nomCategorie + ", noCategorie=" + noCategorie
				+ "]";
	}



	

}
