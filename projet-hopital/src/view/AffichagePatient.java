package view;

import model.Patient;

public class AffichagePatient {

	
	public String afficherPatient(Patient patient) {
		
		int idPatient = patient.getId();
		String nomPatient = patient.getNom();
		String prenomPatient = patient.getPrenom();
		int agePatient = patient.getAge();
		String affichage = "Id du patient : " + idPatient + " - Nom du patient : " + nomPatient + 
				" - Prénom du patient : " + prenomPatient + " - Age du patient : "+ agePatient + " ans.";
		return affichage;
	}
	
}
