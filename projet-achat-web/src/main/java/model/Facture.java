package model;

import java.util.ArrayList;

public class Facture {

	private String client;
	private ArrayList<LigneArticle> listligne;
	private double sommeTot;

	public Facture(String client) {
		this.client = client;
		this.listligne = new ArrayList<LigneArticle>();
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public ArrayList<LigneArticle> getListligne() {
		return listligne;
	}

	public void setListligne(ArrayList<LigneArticle> listligne) {
		this.listligne = listligne;
	}

	public double getSommeTot() {
		return sommeTot;
	}

	public void setSommeTot(double sommeTot) {
		this.sommeTot = sommeTot;
	}

	public void addLigne(LigneArticle ligne) {
		listligne.add(ligne);

		sommeTot += ligne.getSomme();
	}

	// Alternative somme, il faut l'appeler quelque part
	public void calcul() {
		sommeTot = 0;
		for (LigneArticle l : listligne)
			sommeTot += l.getSomme();
	}

	public String toString() {
		String res = "Facture de : " + client + "\n" + "\nTotal facture : " + sommeTot + " euros.\n";
		for (LigneArticle l : listligne)
			res += l + "\n";
		return res;
	}

}
