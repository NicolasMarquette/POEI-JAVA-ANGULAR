package model;

import java.util.HashMap;

public class Panier {

	private HashMap<Integer, LigneArticle> panier;

	public Panier() {
		panier = new HashMap<Integer, LigneArticle>();
	}

	public Panier(HashMap<Integer, LigneArticle> panier) {
		this.panier = panier;
	}

	@Override
	public String toString() {
		return "Panier [panier=" + panier + "]";
	}

	public HashMap<Integer, LigneArticle> getPanier() {
		return panier;
	}

	public void setPanier(int id, Article article, int quantite) {
		
		if (!panier.containsKey(id)) {
			panier.put(id, new LigneArticle(quantite, article));
			System.out.println("nouvel article : " + panier);
		} else {
			LigneArticle oldLigne = panier.get(id);
			int oldQuantite = oldLigne.getQuantite();
			panier.replace(id, new LigneArticle(oldQuantite + quantite, article));
			System.out.println("ajout quantite article : " + panier);
		}
	}

}
