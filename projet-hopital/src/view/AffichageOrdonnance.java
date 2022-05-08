package view;

import java.util.ArrayList;

import model.LigneMedicament;
import model.Ordonnance;

public class AffichageOrdonnance {

	public String afficherOrdonnance (Ordonnance ordonnance) {
		
		
		String nomPatient = ordonnance.getPatient();
		String medecin = ordonnance.getMedecin();
		String dateVisite = ordonnance.getDate();
		ArrayList<LigneMedicament> ligneMedicament = ordonnance.getLigneMedicament();
		String afficherMedicament;
		int total = ordonnance.getTotalOrdonnance();
		
		
		String affichage = "Voici l'ordonnance de M/Mme: " + nomPatient
				+ " - prescrite par le medecin: " + medecin + " - en date du: " + dateVisite + " - comportant:  " 
				+ afficherMedicament + " Total : " + total;
				
		return affichage;
	} 
	
}
