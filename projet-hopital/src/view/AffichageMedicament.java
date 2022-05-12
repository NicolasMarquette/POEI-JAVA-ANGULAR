package view;

import model.Medicament;

public class AffichageMedicament {

	public String afficherMedicament(Medicament medicament) {

		int idMedicament = medicament.getIdMedicament();
		String nomMedicament = medicament.getNomMedicament();
		int prix = medicament.getPrix();
		int quantite = medicament.getQuantite();
		String affichage = idMedicament + " - nom du médicament : " + nomMedicament
				+ " - prix : " + prix + " � - quantité : " + quantite;
		return affichage;
	}

}
