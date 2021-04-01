package fr.eni.projet.troc.bo;

public class Retrait {
	private int noArticles;
	private String rue;
	private String codePostal;
	private String ville;

	public Retrait(int noArticles, String rue, String codePostal, String ville) {
		super();
		this.noArticles = noArticles;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	public Retrait() {
		
	}

	public int getNoArticles() {
		return noArticles;
	}

	public void setNoArticles(int noArticles) {
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



}
