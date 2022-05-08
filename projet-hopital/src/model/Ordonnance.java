package model;

import java.util.ArrayList;

public class Ordonnance {

	private String patient;
	private String medecin;
	private int totalOrdonnance;
	private String dateVisite;
	private ArrayList<LigneMedicament> ligneMedicament;

	public Ordonnance(String patient , String dateVisite) {
		this.patient = patient;
		this.dateVisite = dateVisite;
		this.ligneMedicament = new ArrayList<LigneMedicament>();
	}

	public String getPatient() {
		return patient;
	}

	public String getMedecin() {
		return medecin;
	}

	public int getTotalOrdonnance() {
		return totalOrdonnance;
	}

	public String getDateVisite() {
		return dateVisite;
	}

	public ArrayList<LigneMedicament> getLigneMedicament() {
		return ligneMedicament;
	}

	public void setLigneMedicament (LigneMedicament ligneMedicament) {
		this.ligneMedicament.add(ligneMedicament);
		totalOrdonnance += ligneMedicament.getTotal();
	}

	@Override
	public String toString() {
		return "Ordonnance [patient=" + patient + ", totalOrdonnance=" + totalOrdonnance + ", ligneMedicament="
				+ ligneMedicament + "]";
	}

}
