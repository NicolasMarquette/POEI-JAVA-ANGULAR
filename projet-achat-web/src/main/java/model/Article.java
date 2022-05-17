package model;

public class Article {

	private int idArticle;
	private String nom;
	private String description;
	private int tarif;
	private String image;

	public Article() {
	}

	public Article(int idArticle, String nom, String description, int tarif, String image) {
		super();
		this.idArticle = idArticle;
		this.nom = nom;
		this.description = description;
		this.tarif = tarif;
		this.image = image;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nom=" + nom + ", description=" + description + ", tarif=" + tarif
				+ ", image=" + image + "]";
	}

}
