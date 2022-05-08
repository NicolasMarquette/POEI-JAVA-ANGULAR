package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

import dao.DaoAuthentificationMySql;
import dao.DaoMedicamentMySql;
import dao.DaoPatientMySql;
import dao.DaoVisiteMySql;
import db.ConnectionManager;
import model.Authentification;
import model.Hopital;
import model.LigneMedicament;
import model.Medicament;
import model.Ordonnance;
import model.Patient;
import model.RapportFileAttente;
import model.SalleConsultation;
import model.Visite;
import verification.VerificationAuthentification;
import verification.VerificationPatient;
import view.MenuView;

public class Controller {

	MenuView<Patient, SalleConsultation, Integer> view;
	private Hopital hopital;
	private VerificationAuthentification verificationAuthentification;
	private VerificationPatient verificationPatient;
	private LinkedList<Patient> listePatients;
	private Authentification user;
	private DaoAuthentificationMySql daoAuth;
	private DaoPatientMySql daoPatient;
	private DaoVisiteMySql daoVisite;
	private DaoMedicamentMySql daoMedicament;
	private RapportFileAttente rapport;

	private static final int LIMIT_VISITE = 10;

	public Controller(MenuView<Patient, SalleConsultation, Integer> view) {
		this.view = view;
		view.setController(this);
		hopital = Hopital.getHopital();
		verificationAuthentification = new VerificationAuthentification();
		verificationPatient = new VerificationPatient();
		daoAuth = new DaoAuthentificationMySql();
		daoPatient = new DaoPatientMySql();
		daoVisite = new DaoVisiteMySql();
		daoMedicament = new DaoMedicamentMySql();
		rapport = new RapportFileAttente();
		addObservers();
	}

	public void run() throws ClassNotFoundException, SQLException, IOException {
		view.afficherMenuPrincipal();
	}

	private void addObservers() {
		for (SalleConsultation s : hopital.getSalles())
			s.addObserver(hopital);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// FERMETURE DU PROGRAMME
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void exitGestionPatient() throws ClassNotFoundException, SQLException, IOException {
		for (SalleConsultation sc : Hopital.getHopital().getSalles())
			if (sc.getListVisite().size() > 0) {
				saveVisitesEnBaseDonnees(sc.getId_salle());
			}
		ConnectionManager.getInstance().closeConn();
		System.exit(0);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// USERS
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Authentification getUser() {
		return user;
	}

	public void setUser(String id) throws ClassNotFoundException, SQLException, IOException {
		user = daoAuth.findById(id);
	}

	public boolean verifLogin(String username, String mdp) throws ClassNotFoundException, SQLException, IOException {
		String id = username + "/" + mdp;
		boolean verifLogin = verificationAuthentification.verify(id);
		return verifLogin;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// PATIENTS
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Patient findByIdPatient(int idPatient) throws ClassNotFoundException, SQLException, IOException {
		Patient patient = daoPatient.findById(idPatient);
		return patient;
	}

	public void createPatient(Patient patient) throws ClassNotFoundException, SQLException, IOException {
		Patient patientForCreation = patient;
		if (patientForCreation.getAdresse().equals(""))
			patientForCreation.setAdresse(null);
		if (patientForCreation.getTelephone().equals(""))
			patientForCreation.setTelephone(null);

		daoPatient.create(patientForCreation);
	}

	public void miseAJourPatient(int id, String adr, String tel)
			throws ClassNotFoundException, SQLException, IOException {
		Patient patient = findByIdPatient(id);
		if (adr.equals(""))
			adr = null;
		if (tel.equals(""))
			tel = null;
		patient.setAdresse(adr);
		patient.setTelephone(tel);
		daoPatient.update(patient);
	}

	public boolean verifPatient(int id) throws ClassNotFoundException, SQLException, IOException {
		boolean verifPatient = verificationPatient.verify(id);
		return verifPatient;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// FILE D'ATTENTE
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void addPatientDansFile(Patient patient) {
		hopital.addPatient(patient);
	}

	public Patient getProchainPatientDansFile() {
		Patient patient = hopital.getProchainPatientEnFileAttente();
		return patient;
	}

	public LinkedList<Patient> getFileAttente() {
		listePatients = hopital.getFileAttente();
		return listePatients;
	}

	public boolean isPatientDansFileAttente(int id) {
		boolean verif = false;
		if (getFileAttente() != null) {
			for (Patient p : getFileAttente()) {
				if (p.getId() == id) {
					verif = true;
				}
			}
		}
		return verif;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// RAPPORT DE LA FILE D'ATTENTE
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void ecrireRapport(int idPatient) throws IOException {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = dateTime.format(formatDateTime);
		rapport.ecrireRapport(idPatient, formattedDateTime);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// SALLE DE CONSULTATION
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public SalleConsultation getSalleDeConsultation(int salle) {
		return hopital.getSalles().get(salle - 1);
	}

	public void accueillirProchainPatientEnSalleDeConsultation(int salle) {
		if (hopital.getFileAttente().size() > 0)
			hopital.getSalles().get(salle - 1).notifyObservers();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// VISITES EN SALLE DE CONSULTATION
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void addVisite(int idPatient, SalleConsultation salle)
			throws ClassNotFoundException, SQLException, IOException {
		salle.addVisite(idPatient);
		if (salle.getListVisite().size() == LIMIT_VISITE)
			saveVisitesEnBaseDonnees(salle.getId_salle());
	}

	public Visite getCurrentVisite(SalleConsultation salle) {

		Visite visite = null;

		int visiteEnCours = salle.getListVisite().size();
		if (visiteEnCours > 0) {
			visite = salle.getListVisite().get(visiteEnCours - 1);
		}
		return visite;
	}

	public LinkedList<Visite> getListeVisites(int id) {
		LinkedList<Visite> liste = hopital.getSalles().get(id - 1).getListVisite();
		return liste;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// VISITES EN BASE DE DONNEES
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void saveVisitesEnBaseDonnees(int id) throws ClassNotFoundException, SQLException, IOException {
		LinkedList<Visite> listeVisites = hopital.getSalles().get(id - 1).getListVisite();
		for (Visite v : listeVisites)
			daoVisite.create(v);
		listeVisites.clear();
	}

	public ArrayList<Visite> voirVisitesParMedecinEnBaseDonnees()
			throws ClassNotFoundException, SQLException, IOException {
		return (ArrayList<Visite>) daoVisite.findByNameMedecin(user.getNom());
	}

	public ArrayList<Visite> voirVisitePatBD(int id) throws ClassNotFoundException, SQLException, IOException {
		return (ArrayList<Visite>) daoVisite.findByIdPatient(id);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MEDICAMENTS
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Medicament> getListeMedicament() throws ClassNotFoundException, SQLException, IOException {
		return (ArrayList<Medicament>) daoMedicament.findAll();
	}

	public boolean updateQuantiteMedicament(int id, int quantite)
			throws ClassNotFoundException, SQLException, IOException {

		boolean result = false;
		Medicament medicament = daoMedicament.findById(id);
		int oldQuantite = medicament.getQuantite();
		if (oldQuantite - quantite >= 0) {
			medicament.setQuantite(oldQuantite - quantite);
			daoMedicament.updateQuantite(medicament);
			result = true;
		}
		return result;
	}

	public Medicament getMedicamentById(int id) throws ClassNotFoundException, SQLException, IOException {
		return daoMedicament.findById(id);
	}

	public String getNomMedicamentById(int id) throws ClassNotFoundException, SQLException, IOException {
		return daoMedicament.findById(id).getNomMedicament();
	}
	
	public ArrayList<Medicament> getListeMedicamentByName(String name) throws ClassNotFoundException, SQLException, IOException {
		return (ArrayList<Medicament>) daoMedicament.findByMedicamentName(name);
	}

	public void addMedicamentInOrdonnance(Ordonnance ordonnance, Medicament medicament, SalleConsultation salle) {

		Visite visite = getCurrentVisite(salle);

		if (visite != null) {
			int quantite = medicament.getQuantite();
			LigneMedicament ligne = new LigneMedicament(quantite, medicament);

			String ligneMedicament = "Q:" + quantite + " id:" + medicament.getIdMedicament() + " nom: "
					+ medicament.getNomMedicament() + " prix unitaire:" + medicament.getPrix();

			int tarif = visite.getTarif();
			visite.setOrdonnance(ligneMedicament);
			visite.setTarif(tarif + ligne.getTotal());

			ordonnance.setLigneMedicament(ligne);
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// ADMINISTRATEUR
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void ajouterMedicament(Medicament medicament) throws ClassNotFoundException, SQLException, IOException {
		daoMedicament.create(medicament);
	}
	
	public void modifierMedicament(Medicament medicament) throws ClassNotFoundException, SQLException, IOException {
		daoMedicament.update(medicament);
	}
	
	public void supprimerMedicament(Medicament medicament) throws ClassNotFoundException, SQLException, IOException {
		daoMedicament.delete(medicament);
	}
	
	public void ajouterStockMedicament(Medicament medicament) throws ClassNotFoundException, SQLException, IOException {
		daoMedicament.updateQuantite(medicament);
	}
}
