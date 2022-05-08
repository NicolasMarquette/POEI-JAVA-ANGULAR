package view;

import model.Visite;

public class AffichageVisite {

	public String afficherVisite(Visite visite) {

		String dateVisite = visite.getDate();
		int idPatient = visite.getIdPatient();
		String medecin = visite.getMedecin();
		int numSalle = visite.getNum_salle();
		int tarif = visite.getTarif();
		String affichage = "Date de la visite : " + dateVisite
				+ " - Id du patient : " + idPatient + " - Nom du médecin : " + medecin + " - Numéro de la salle : "
				+ numSalle + " - Tarif : " + tarif + " €";
		return affichage;
	}

}
