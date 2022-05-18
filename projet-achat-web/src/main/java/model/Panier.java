package model;

import java.util.HashMap;

public class Panier {

	private HashMap<Integer, LigneArticle> panier;
	private int total;

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
		
		System.out.println("Total: " + total);
		
		if (!panier.containsKey(id)) {
			panier.put(id, new LigneArticle(quantite, article));
			System.out.println("nouvel article : " + panier);
		} else {
			LigneArticle oldLigne = panier.get(id);
			int oldQuantite = oldLigne.getQuantite();
			panier.replace(id, new LigneArticle(oldQuantite + quantite, article));
			System.out.println("ajout quantite article : " + panier);
		}
		setTotal();
		System.out.println("Total: " + total);
	}

	public int getTotal() {
		return total;
	}

	private void setTotal() {
		this.total = panier.values().stream()
				  .map(x -> x.getSomme())
				  .reduce(0, Integer::sum);;
	}
	
	

}
