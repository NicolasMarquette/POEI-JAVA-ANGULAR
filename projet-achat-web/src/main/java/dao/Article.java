package dao;

public class Article {

	private int idArticle; 
	private String nom;
	private String description;
	private int tarif;
	
	
	public Article() {
	}

	public Article(int idArticle, String nom, String description, int tarif) {
		this.idArticle = idArticle;
		this.nom = nom;
		this.description = description;
		this.tarif = tarif;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
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

	public int getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nom=" + nom + ", description=" + description + ", tarif=" + tarif
				+ "]";
	}
	
	
	
}
