package model;

public class Visite {

	private int id;
	private int idPatient;
	private String date;
	private String medecin;
	private int num_salle;
	private int tarif;
	// private Ordonnance[] ordonnances;

	public Visite() {
	}

	public Visite(int id, int idPatient, String date, String medecin, int num_salle, int tarif) {
		this.idPatient = idPatient;
		this.date = date;
		this.medecin = medecin;
		this.num_salle = num_salle;
		this.tarif = tarif;
		// this.ordonnances = ordonnances;
	}

	public Visite(int idPatient, String date, String medecin, int num_salle, int tarif) {
		this.idPatient = idPatient;
		this.date = date;
		this.medecin = medecin;
		this.num_salle = num_salle;
		this.tarif = tarif;
	}

	public Visite(int idPatient, String date, String medecin, int num_salle) {
		this.idPatient = idPatient;
		this.date = date;
		this.medecin = medecin;
		this.num_salle = num_salle;
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

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	// public Ordonnance[] getOrdonnances() {
	// return ordonnances;
	// }
	// public void setOrdonnances(Ordonnance[] ordonnances) {
	// this.ordonnances = ordonnances;
	// }

	@Override
	public String toString() {
		return "Visite [idPatient=" + idPatient + ", date=" + date + ", medecin=" + medecin
				+ ", num_salle=" + num_salle + ", tarif=" + tarif + "]\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
