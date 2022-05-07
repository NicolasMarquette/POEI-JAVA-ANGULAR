package model;

public class LigneMedicament {

	private int quantite;
	private Medicament medicament;
	private int total;

	public LigneMedicament() {

	}

	public LigneMedicament(int quantite, Medicament medicament, int total) {
		this.quantite = quantite;
		this.medicament = medicament;
		setTotal();
	}
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public int getTotal() {
		return total;
	}

	private void setTotal() {
		this.total = quantite * medicament.getPrix();
	}

	@Override
	public String toString() {
		return "LigneMedicament [quantite=" + quantite + ", medicament=" + medicament + ", total=" + total + "]";
	}

}
