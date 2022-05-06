package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;

import dao.DaoAuthentificationMySql;
import dao.DaoPatientMySql;
import dao.DaoVisiteMySql;
import model.Authentification;
import model.Hopital;
import model.Patient;
import model.RapportFileAttente;
import model.SalleConsultation;
import model.VerificationAuthentification;
import model.Visite;
import view.MenuView;

public class Controller {
	MenuView view;
	private boolean verifLogin;
	private Hopital hopital;
	private VerificationAuthentification verif;
	private LinkedList<Patient> listPat;
	private Authentification user;

	
	public Controller(MenuView view) {
		this.view = view;
		view.setController(this);
		hopital = Hopital.getHopital();
		verif = new VerificationAuthentification();
		addObserver();
	}
	
	public void run() throws ClassNotFoundException, SQLException, IOException {
		view.afficherMenuPrincipal();
	}

	public boolean verifLogin(String username, String mdp) throws ClassNotFoundException, SQLException, IOException {
		String id = username + "/" + mdp;
		verifLogin = verif.verify(id);
		return verifLogin;
	}
	
	
	public Authentification getUser() {
		return user;
	}

	public void setUser(String id) throws ClassNotFoundException, SQLException, IOException {		
		user = new DaoAuthentificationMySql().findById(id);		
		
	}

	public void addPatient(Patient patient) { 
		hopital.addPatient(patient);
	}

	public Patient getProchainPatient() {
		Patient patient = hopital.getProchainPatientEnFileAttente();
		return patient;
	}

	public Patient findByIdPat(int idPatient) throws ClassNotFoundException, SQLException, IOException {
		Patient patient = new DaoPatientMySql().findById(idPatient);
		return patient;
	}
	
	public void createPatient(Patient patient) throws ClassNotFoundException, SQLException, IOException {
		new DaoPatientMySql().create(patient);
	}
	
	public LinkedList<Patient> getFile() {
		listPat = hopital.getFileAttente();
		return listPat;
	}

	public void addVisite(int idPatient, SalleConsultation salle) throws ClassNotFoundException, SQLException, IOException {
		salle.addVisite(idPatient);
		if(salle.getListVisite().size()==10)
			saveVisitesBD(salle.getId_salle());
	}

	public SalleConsultation getSalle(int salle) {
		return hopital.getSalles().get(salle-1);
	}

	public void medProchainPatient(int salle) {
		if(hopital.getFileAttente().size()>0)
		hopital.getSalles().get(salle-1).notifyObservers();
		
	}
	
	public void addObserver() {
		for(SalleConsultation s : hopital.getSalles())
			s.addObserver(hopital);
	}
	
	public LinkedList<Visite> getListVisites(int id) {
		
		LinkedList<Visite> liste = hopital.getSalles().get(id-1).getListVisite();
		return liste;
	}

	public void saveVisitesBD(int id) throws ClassNotFoundException, SQLException, IOException {
		LinkedList<Visite> liste = hopital.getSalles().get(id-1).getListVisite();
		for(Visite v : liste)
			new DaoVisiteMySql().create(v);
		liste.clear();
	}
	
	public ArrayList<Visite> voirVisitesEnBD() throws ClassNotFoundException, SQLException, IOException {
		return (ArrayList<Visite>) new DaoVisiteMySql().findByNameMedecin(user.getNom());
	}

	public void miseAJourPatient(int id, String adr, String tel) throws ClassNotFoundException, SQLException, IOException {
		Patient patient = findByIdPat(id);
		if(adr.equals(""))
			adr=null;
		if(tel.equals(""))
			tel=null;
		patient.setAdresse(adr);
		patient.setTelephone(tel);
		new DaoPatientMySql().update(patient);
		
	}

	public ArrayList<Visite> voirVisitePatBD(int id) throws ClassNotFoundException, SQLException, IOException {
		return (ArrayList<Visite>) new DaoVisiteMySql().findByIdPatient(id);
	}

	public void ecrireRapport(int idPatient) throws IOException {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = dateTime.format(formatDateTime);
		RapportFileAttente rapport = new RapportFileAttente();
		rapport.ecrireRapport(idPatient, formattedDateTime);
	}
	
	public boolean isPatientDansListe(int id) {
		
		boolean verif = false;
		
		if (getFile() != null) {
			for (Patient p : getFile()) {
				if (p.getId() == id ) {
					verif = true;
				}
			}
		}
		return verif;
	}
}

