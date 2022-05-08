package view;

import java.util.ArrayList;

import model.LigneMedicament;
import model.Ordonnance;

public class AffichageOrdonnance {

	public String afficherOrdonnance(Ordonnance ordonnance) {

		String nomPatient = ordonnance.getPatient();
		String medecin = ordonnance.getMedecin();
		String [] dateVisite = ordonnance.getDateVisite().split(" ");
		ArrayList<LigneMedicament> ligneMedicament = ordonnance.getLigneMedicament();
		String afficherMedicament;
		int total = ordonnance.getTotalOrdonnance();
		String listMedicament = "";
		for (LigneMedicament lm : ligneMedicament) {

			listMedicament += new AffichageLigneMedicament().afficherLigneCommande(lm) + "\n";
		}

		String affichage = "Voici l'ordonnance de M/Mme: " + nomPatient + " - prescrite par le medecin: " + medecin
				+ " - en date du: " + dateVisite[0] + " - comportant:  " + listMedicament + " Total : " + total;

		return affichage;
	}

}
