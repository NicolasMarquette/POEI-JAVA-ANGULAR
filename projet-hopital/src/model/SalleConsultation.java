package model;

import java.util.LinkedList;

public class SalleConsultation {

	private int id_salle;
	private String medecin;
	private ListVisite<LinkedList<Visite>> listVisite;
	private Hopital observer;
	private Patient patient;

	public SalleConsultation() {

	}

	public SalleConsultation(int id_salle, ListVisite<LinkedList<Visite>> listVisite) {
		super();
		this.id_salle = id_salle;
		this.listVisite = listVisite;

	}

	public SalleConsultation(int id_salle, String medecin, ListVisite<LinkedList<Visite>> listVisite) {
		this.id_salle = id_salle;
		this.medecin = medecin;
		this.listVisite = listVisite;
	}

	public int getId_salle() {
		return id_salle;
	}

	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	}

	public String getMedecin() {
		return medecin;
	}

	public void setMedecin(String medecin) {
		this.medecin = medecin;
	}

	public LinkedList<Visite> getListVisite() {
		return (LinkedList<Visite>) listVisite.getVisites();
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public void addVisite(int id_patient) {
		listVisite.setVisites(id_patient, medecin, id_salle);
	}

	public synchronized void addObserver(Hopital h) {
		observer = h;
	}

	public void notifyObservers() {
		observer.update(id_salle);
	}

}
