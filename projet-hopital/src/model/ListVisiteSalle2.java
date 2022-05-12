package model;

import java.util.LinkedList;

public class ListVisiteSalle2 implements ListVisite<LinkedList<Visite>> {

	private static LinkedList<Visite> visites = new LinkedList<Visite>();
	private Visite visite;

	private static final int TARIF_CONSULTATION_GENENERALE = 23;

	@Override
	public LinkedList<Visite> getVisites() {
		return visites;
	}

	@Override
	public void setVisites(int id_patient, String medecin, int id_salle, String dateVisite) {
		visite = new Visite(id_patient, dateVisite, medecin, id_salle, TARIF_CONSULTATION_GENENERALE);
		visites.add(visite);
	}

	@Override
	public String toString() {
		return "ListVisiteSalle2 [visite=" + visite + "]";
	}

}
