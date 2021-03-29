package fr.eni.projet.troc.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Enchere {
	private int noEnchere;
	private LocalDateTime dateEnchere;
	private int montantEnchere;
	private ArticleVendu noArticle;
	private Utilisateur noUtilisateur;

	public Enchere(int noEnchere, LocalDateTime dateEnchere, int montantEnchere, ArticleVendu noArticle,
			Utilisateur noUtilisateur) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.noArticle = noArticle;
		this.noUtilisateur = noUtilisateur;
	}

	public int getNoEnchere() {
		return noEnchere;
	}

	public void setNoEnchere(int noEnchere) {
		this.noEnchere = noEnchere;
	}

	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public ArticleVendu getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(ArticleVendu noArticle) {
		this.noArticle = noArticle;
	}

	public Utilisateur getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(Utilisateur noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	@Override
	public String toString() {
		return "Enchere [noEnchere=" + noEnchere + ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere
				+ ", noArticle=" + noArticle + ", noUtilisateur=" + noUtilisateur + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateEnchere == null) ? 0 : dateEnchere.hashCode());
		result = prime * result + montantEnchere;
		result = prime * result + ((noArticle == null) ? 0 : noArticle.hashCode());
		result = prime * result + noEnchere;
		result = prime * result + ((noUtilisateur == null) ? 0 : noUtilisateur.hashCode());
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
		Enchere other = (Enchere) obj;
		if (dateEnchere == null) {
			if (other.dateEnchere != null)
				return false;
		} else if (!dateEnchere.equals(other.dateEnchere))
			return false;
		if (montantEnchere != other.montantEnchere)
			return false;
		if (noArticle == null) {
			if (other.noArticle != null)
				return false;
		} else if (!noArticle.equals(other.noArticle))
			return false;
		if (noEnchere != other.noEnchere)
			return false;
		if (noUtilisateur == null) {
			if (other.noUtilisateur != null)
				return false;
		} else if (!noUtilisateur.equals(other.noUtilisateur))
			return false;
		return true;
	}

}
