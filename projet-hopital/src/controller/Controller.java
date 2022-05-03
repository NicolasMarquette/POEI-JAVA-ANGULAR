package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

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

	public Controller(MenuView view) {
		super();
		this.view = view;
		view.setController(this);
		hopital = new Hopital();
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

	public void verifPatient(int idPatient) {
		
		}

	public void addPatient() { //pas oublier le paramètre Patient
		
	}
	
	public Patient getProchainPatient() { //hopital.getProchainPatient..
		Patient patient = new Patient(); 
		return patient;
	}

	public LinkedList<Patient> getFile() { 
		LinkedList<Patient> list=null;
		return list;
	}

	public void addVisite() {
		// TODO Auto-generated method stub
		
	}

}
