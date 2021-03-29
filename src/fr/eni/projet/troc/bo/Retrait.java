package fr.eni.projet.troc.bo;

public class Retrait {
	private ArticleVendu noArticles;
	private String rue;
	private String codePostal;
	private String ville;

	public Retrait(ArticleVendu noArticles, String rue, String codePostal, String ville) {
		this.noArticles = noArticles;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Retrait() {

	}

	public ArticleVendu getNoArticles() {
		return noArticles;
	}

	public void setNoArticles(ArticleVendu noArticles) {
		this.noArticles = noArticles;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Retrait [noArticles=" + noArticles + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((noArticles == null) ? 0 : noArticles.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Retrait other = (Retrait) obj;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (noArticles == null) {
			if (other.noArticles != null)
				return false;
		} else if (!noArticles.equals(other.noArticles))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

}
