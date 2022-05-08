package model;

import java.util.ArrayList;

public class Visite {

	private int id;
	private int idPatient;
	private String date;
	private String medecin;
	private int num_salle;
	private int tarif;
	private ArrayList<String> ordonnance;

	public Visite() {
	}

	public Visite(int id, int idPatient, String date, String medecin, int num_salle, int tarif,
			ArrayList<String> ordonnance) {
		this.id = id;
		this.idPatient = idPatient;
		this.date = date;
		this.medecin = medecin;
		this.num_salle = num_salle;
		this.tarif = tarif;
		this.ordonnance = ordonnance;
	}

	public Visite(int id, int idPatient, String date, String medecin, int num_salle, int tarif) {
		this.idPatient = idPatient;
		this.date = date;
		this.medecin = medecin;
		this.num_salle = num_salle;
		this.tarif = tarif;
		this.ordonnance = new ArrayList<String>();
	}

	public Visite(int idPatient, String date, String medecin, int num_salle, int tarif) {
		this.idPatient = idPatient;
		this.date = date;
		this.medecin = medecin;
		this.num_salle = num_salle;
		this.tarif = tarif;
		this.ordonnance = new ArrayList<String>();
	}

	public Visite(int idPatient, String date, String medecin, int num_salle) {
		this.idPatient = idPatient;
		this.date = date;
		this.medecin = medecin;
		this.num_salle = num_salle;
		this.ordonnance = new ArrayList<String>();
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMedecin() {
		return medecin;
	}

	public void setMedecin(String medecin) {
		this.medecin = medecin;
	}

	public int getNum_salle() {
		return num_salle;
	}

	public void setNum_salle(int num_salle) {
		this.num_salle = num_salle;
	}

	public int getTarif() {
		return tarif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

	public ArrayList<String> getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(String ligne) {
		this.ordonnance.add(ligne);
	}

	@Override
	public String toString() {
		return "Visite [id=" + id + ", idPatient=" + idPatient + ", date=" + date + ", medecin=" + medecin
				+ ", num_salle=" + num_salle + ", tarif=" + tarif + ", ordonnance=" + ordonnance + "]";
	}

}
