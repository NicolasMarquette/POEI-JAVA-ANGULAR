package view;

import model.LigneMedicament;
import model.Medicament;

public class AffichageLigneMedicament {

	public String afficherLigneCommande(LigneMedicament ligneMedicament) {

		Medicament medicament = ligneMedicament.getMedicament();
		int quantite = ligneMedicament.getQuantite();
		int total = ligneMedicament.getTotal();
		AffichageMedicament afficherMedicament = new AffichageMedicament();

		String ligneCommande = " - id: " + new AffichageMedicament().afficherMedicament(medicament) +
				" - total : " + total + "€";
		return ligneCommande;
	}

}
