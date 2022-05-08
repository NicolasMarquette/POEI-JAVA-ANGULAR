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
		int total = ordonnance.getTotalOrdonnance();
		String listMedicament = "";
		for (LigneMedicament lm : ligneMedicament) {

			listMedicament += new AffichageLigneMedicament().afficherLigneCommande(lm) + "\n";
		}

		String affichage = "Voici l'ordonnance de M/Mme: " + nomPatient + "\nPrescrite par le medecin: " + medecin
				+ "\nEn date du: " + dateVisite[0] + "\n\ncomportant:\n" + listMedicament + "\nTotal de la prescription: " + total + "€";

		return affichage;
	}

}
