package model;

public class Commande {

	private int id;
	private String emailClient;
	private String date;
	private int prixTot;
	private String infos;

	public Commande() {
	}

	public Commande(int id, String emailClient, String date, int prixTot, String infos) {
		this.id = id;
		this.emailClient = emailClient;
		this.date = date;
		this.prixTot = prixTot;
		this.infos = infos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPrixTot() {
		return prixTot;
	}

	public void setPrixtot(int prixTot) {
		this.prixTot = prixTot;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", emailClient=" + emailClient + ", date=" + date + ", prixTot=" + prixTot
				+ ", infos=" + infos + "]";
	}

}
