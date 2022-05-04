package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class ListVisiteSalle1 implements ListVisite <LinkedList<Visite>> {

	private static LinkedList<Visite> visites = new LinkedList<Visite>();
	private Visite visite;
	private static final int TARIF_CONSULTATION_GENENERALE = 23;

	public LinkedList<Visite> getVisites() {
		return visites;
	}

	public void setVisites(int id_patient, String medecin, int id_salle) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = dateTime.format(formatDateTime);
		visite = new Visite(id_patient, formattedDateTime, medecin, id_salle, TARIF_CONSULTATION_GENENERALE);
		//visite.setTarif(TARIF_CONSULTATION_GENENERALE);
		visites.add(visite);
		
	}

	@Override
	public String toString() {
		return "ListVisiteSalle1 [visite=" + visite + "]";
	}

}
