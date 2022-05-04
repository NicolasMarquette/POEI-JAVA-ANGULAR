package model;

public class Patient {

	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String adresse;
	private String telephone;
	private String date_naissance;

	// cont avec tout
	public Patient(int id, String nom, String prenom, String date_naissance, int age, String adresse, String telephone
			) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
		this.telephone = telephone;
		this.date_naissance = date_naissance;
	}

	// sans age
	public Patient(int id, String nom, String prenom,String date_naissance, String adresse, String telephone) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.date_naissance = date_naissance;
	}

	public Patient(int id, String nom, String prenom, String date_naissance) {
		this.id=id;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
	}

	public Patient() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", adresse=" + adresse
				+ ", telephone=" + telephone + "]\n";
	}

}
