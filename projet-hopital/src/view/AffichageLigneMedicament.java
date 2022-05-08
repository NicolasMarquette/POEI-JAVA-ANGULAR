package view;

import model.LigneMedicament;
import model.Medicament;

public class AffichageLigneMedicament {

	public String ligneCommande(LigneMedicament ligneMedicament) {

		Medicament medicament = ligneMedicament.getMedicament();
		int quantite = ligneMedicament.getQuantite();
		int prix = ligneMedicament.getPrix();
		int total = ligneMedicament.getTotal();
		AffichageMedicament afficherMedicament = new AffichageMedicament();

		String ligneCommande = " - nom du médicament : " + medicament + " - prix : " + prix + " € - quantité : "
				+ quantite + " - total : " + total;
		return ligneCommande;
	}

}
