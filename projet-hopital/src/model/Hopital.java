package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class Hopital {

	private static Hopital hopital;
	private String secretaire;
	private LinkedList<Patient> fileAttente = new LinkedList<Patient>();
	private ArrayList<SalleConsultation> salles = new ArrayList<SalleConsultation>();

	private Hopital() {
		setSalles(new SalleConsultation(1, new ListVisiteSalle1()));
		setSalles(new SalleConsultation(2, new ListVisiteSalle2()));
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

	public void setSalles(SalleConsultation salle) {
		salles.add(salle);
	}

	public ArrayList<SalleConsultation> getSalles() {
		return salles;
	}

	
	public void update(int arg) {
		salles.get(arg-1).setPatient(fileAttente.pop());
		
	}

}
