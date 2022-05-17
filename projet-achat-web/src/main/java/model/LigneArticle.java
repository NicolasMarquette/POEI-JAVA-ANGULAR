package model;

import dao.Article;

public class LigneArticle {

	private int quantite;
	private Article article;
	private double somme;

	public LigneArticle(int quantite, Article article) {
		this.quantite = quantite;
		this.article = article;
		sommePrix();
	}

	private double sommePrix() {
		somme = quantite * article.getTarif();
		return somme;
	}

	public double getSomme() {
		return somme;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public void setSomme(double somme) {
		this.somme = somme;
	}

	public String toString() {
		return quantite + " " + article + ", total : " + somme;
	}

}