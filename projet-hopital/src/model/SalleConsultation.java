package model;

public class SalleConsultation {
	
private int id_salle;
private String medecin;
private ListVisite listVisite;

public SalleConsultation() {
}

public SalleConsultation(int id_salle, String medecin, ListVisite listVisite) {
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
public ListVisite getListVisite() {
	return listVisite;
}

public void addVisite (int id_patient, int tarif) { 
	listVisite.setVisites(id_patient, medecin, id_salle, tarif);
}

}
