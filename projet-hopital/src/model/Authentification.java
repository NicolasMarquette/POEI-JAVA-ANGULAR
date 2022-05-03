package model;

public class Authentification {

	private String login;
	private String password;
	private String nom;
	private int metier;
	private int salle;
	
	public Authentification() {
	}
		
	public Authentification(String login, String password, String nom, int metier, int salle) {
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.metier = metier;
		this.salle = salle;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getMetier() {
		return metier;
	}
	public void setMetier(int metier) {
		this.metier = metier;
	}
	public int getSalle() {
		return salle;
	}
	public void setSalle(int salle) {
		this.salle = salle;
	}

	@Override
	public String toString() {
		return "Authentification [login=" + login + ", password=" + password + ", nom=" + nom + ", metier=" + metier
				+ ", salle=" + salle + "]";
	}

	
}
