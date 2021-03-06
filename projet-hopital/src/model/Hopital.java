package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class Hopital {

	private static Hopital hopital;
	private String secretaire;
	private LinkedList<Patient> fileAttente = new LinkedList<Patient>();
	private ArrayList<SalleConsultation> salles = new ArrayList<SalleConsultation>();

	private Hopital() {
		setSalles(new SalleConsultation(1, new ListVisiteSalle1()));
		setSalles(new SalleConsultation(2, new ListVisiteSalle2()));
	}

	public static Hopital getHopital() {
		if (hopital == null) {
			hopital = new Hopital();
		}
		return hopital;
	}

	public String getSecretaire() {
		return secretaire;
	}

	public void setSecretaire(String secretaire) {
		this.secretaire = secretaire;
	}

	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}

	public ArrayList<SalleConsultation> getSalles() {
		return salles;
	}

	public void setSalles(SalleConsultation salle) {
		salles.add(salle);
	}

	public Patient getProchainPatientEnFileAttente() {
		Patient prochainPatientEnFileAttente = fileAttente.peek();
		return prochainPatientEnFileAttente;
	}

	public void addPatient(Patient patient) {
		fileAttente.add(patient);
	}

	public void update(int arg) {
		salles.get(arg - 1).setPatient(fileAttente.pop());
	}

}
