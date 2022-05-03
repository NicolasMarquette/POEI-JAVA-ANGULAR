package model;

import java.util.LinkedList;

public class Hopital {

	private static Hopital hopital;
	private String secretaire;
	private LinkedList<Patient> fileAttente = new LinkedList<Patient>();

	private Hopital() {
	}

	public void setSecretaire(String secretaire) {
		this.secretaire = secretaire;
	}

	public static Hopital getHopital() {
		if (hopital == null) {
			hopital = new Hopital();
		}
		return hopital;
	}

	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}

	public Patient getProchainPatientEnFileAttente() {
		Patient prochainPatientEnFileAttente = fileAttente.peek();
		return prochainPatientEnFileAttente;
	}

	public void addPatient(Patient patient) {
		fileAttente.add(patient);
	}

}
