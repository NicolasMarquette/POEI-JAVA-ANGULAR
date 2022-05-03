package model;

import java.util.LinkedList;

public class SalleConsultation {
	
private int id_salle;
private String medecin;
private LinkedList <Visite> listVisite;


public SalleConsultation() {
}

public SalleConsultation(int id_salle, String medecin, LinkedList<Visite> listVisite) {
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
	return listVisite;
}
public void setListVisite(LinkedList<Visite> listVisite) {
	this.listVisite = listVisite;
}

public void addVisite (Visite visite) { 
	listVisite.add(visite);
}

}
