package model;

public class Client {

	private String email;
	private String pass;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String instructions;

	public Client(String email, String pass, String nom, String prenom, String adresse, String tel) {
		super();
		this.email = email;
		this.pass = pass;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
	}

	public Client() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	@Override
	public String toString() {
		return "Client [email=" + email + ", pass=" + pass + ", nom=" + nom + ", prenom=" + prenom + ", adresse="
				+ adresse + ", tel=" + tel + ", instructions=" + instructions + "]";
	}

	
	
}
