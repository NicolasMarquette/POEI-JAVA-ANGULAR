package view;

import model.Visite;

public class AffichageVisite {

	public String afficherVisite(Visite visite) {

		int idVisite = visite.getId();
		String dateVisite = visite.getDate();
		int idPatient = visite.getIdPatient();
		String medecin = visite.getMedecin();
		int numSalle = visite.getNum_salle();
		int tarif = visite.getTarif();
		String affichage = "Id de la visite : " + idVisite + " - Date de la visite : " + dateVisite
				+ " - Id du patient : " + idPatient + " - Nom du médecin : " + medecin + " - Numéro de la salle : "
				+ numSalle + " - Tarif : " + tarif + " €.";
		return affichage;
	}

}
