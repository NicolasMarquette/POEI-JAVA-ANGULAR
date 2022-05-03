package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

import dao.DaoPatientMySql;
import model.Hopital;
import model.Patient;
import model.VerificationAuthentification;
import view.MenuView;

public class Controller {
	MenuView view;
	private boolean verifLogin;
	private int metier;
	private Scanner clavierString = new Scanner(System.in);
	private Hopital hopital;
	private VerificationAuthentification verif;
	private LinkedList<Patient> list;
	private DaoPatientMySql daoPatient;

	public Controller(MenuView view) {
		this.view = view;
		view.setController(this);
		hopital = Hopital.getHopital();
		verif = new VerificationAuthentification();
	}

	public boolean verifLogin(String username, String mdp) throws ClassNotFoundException, SQLException, IOException {
		String id = username+"/"+mdp;
		verifLogin = verif.verify(id);
		return verifLogin;
	}

	public int getMetier() {
		metier=0;
		return metier;
		//Implémenter le get et setMetier à partir de la DB
	}

	
	public void addPatient(Patient patient) { //pas oublier le paramètre Patient
		hopital.addPatient(patient);
	}
	
	public Patient getProchainPatient() { 
		Patient patient = hopital.getProchainPatientEnFileAttente(); 
		return patient;
	}

	public LinkedList<Patient> getFile() { 
		list = hopital.getFileAttente();
		return list;
	}

	public void addVisite() {
		// TODO Auto-generated method stub
		
	}
	
	public Patient findById(int idPatient) throws ClassNotFoundException, SQLException, IOException {
		Patient patient = daoPatient.findById(idPatient);
		return patient;
	}

}
