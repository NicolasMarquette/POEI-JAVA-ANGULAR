package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import dao.DaoAuthentificationMySql;
import dao.DaoPatientMySql;
import dao.DaoVisiteMySql;
import model.Authentification;
import model.Hopital;
import model.Patient;
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
	private LinkedList<Visite> listVis;
	private Authentification user;

	
	public Controller(MenuView view) {
		this.view = view;
		view.setController(this);
		hopital = Hopital.getHopital();
		verif = new VerificationAuthentification();
		addObserver();
		
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

	public void addVisite(int idPatient, SalleConsultation salle) {
		salle.addVisite(idPatient);
	}

	public SalleConsultation getSalle(int salle) {
		return hopital.getSalles().get(salle-1);
	}

	public void medProchainPatient(int salle) {
		hopital.getSalles().get(salle-1).notifyObservers();
		
	}
	
	public void addObserver() {
		for(SalleConsultation s : hopital.getSalles())
			s.addObserver(hopital);
	}
	}

