package model;

public class Medicament {

	private int idMedicament;
	private String nomMedicament;
	private int prix;
	private int quantite;

	public Medicament() {
	}

	public Medicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}

	public Medicament(int idMedicament, int quantite) {
		this.idMedicament = idMedicament;
		this.quantite = quantite;
	}

	public Medicament(String nomMedicament, int prix, int quantite) {
		this.nomMedicament = nomMedicament;
		this.prix = prix;
		this.quantite = quantite;
	}

	public Medicament(int idMedicament, String nomMedicament, int prix, int quantite) {
		this.idMedicament = idMedicament;
		this.nomMedicament = nomMedicament;
		this.prix = prix;
		this.quantite = quantite;
	}

	public int getIdMedicament() {
		return idMedicament;
	}

	public void setIdMedicament(int idMedicament) {
		this.idMedicament = idMedicament;
	}

	public String getNomMedicament() {
		return nomMedicament;
	}

	public void setNomMedicament(String nomMedicament) {
		this.nomMedicament = nomMedicament;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Medicament [idMedicament=" + idMedicament + ", nomMedicament=" + nomMedicament + ", prix=" + prix
				+ ", quantite=" + quantite + "]";
	}

}
