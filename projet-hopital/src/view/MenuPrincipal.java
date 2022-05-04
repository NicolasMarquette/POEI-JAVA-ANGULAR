package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import controller.Controller;
import model.Patient;
import model.SalleConsultation;

public class MenuPrincipal implements MenuView {

	private Controller controller;
	private Scanner clavierint = new Scanner(System.in);
	private Scanner clavierString = new Scanner(System.in);

	public MenuPrincipal() {

	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void afficherMenuPrincipal() throws ClassNotFoundException, SQLException, IOException {

		System.out.println("Bienvenue Ã  l'hopital. \n " + "Veuillez choisir parmi les options suivantes : \n"
				+ "1. Menu Login\n" + "2. Quitter l'hopital");
		int choix = clavierint.nextInt();

		switch (choix) {
		case 1:
			afficherMenuAuthentification();
			break;
		case 2:
			System.out.println("Au revoir!");
			System.exit(0);
			break;
		default:
			System.out.println("Votre saisie est incorrecte.");
			afficherMenuPrincipal();
			;
		}

	}

	@Override
	public void afficherMenuAuthentification() throws ClassNotFoundException, SQLException, IOException {

		System.out.println("Veuillez vous identifiez.");
		System.out.println("Entrez votre username : ");
		String username = clavierString.nextLine();
		System.out.println("Entrez votre mot de passe : ");
		String mdp = clavierString.nextLine();
		controller.setUser(username);
		if (!username.isEmpty() && !mdp.isEmpty()) {
			if (controller.verifLogin(username, mdp)) {
				switch (controller.getUser().getMetier()) {
				case 0:
					afficherMenuSecretaire();
					break;
				case 1:
					afficherMenuMedecin();
					break;
				default:
					System.out.println("Votre saisie est incorrecte.");
					afficherMenuAuthentification();
				}
			} else {
				System.out.println("Les identifiants sont incorrects!\n");
				afficherMenuPrincipal();
			}
		} else {
			System.out.println("Vous n'avez pas saisi de username et / ou de mot de passe");
			afficherMenuAuthentification();
		}

	}

	@Override
	public void afficherMenuSecretaire() throws ClassNotFoundException, SQLException, IOException {

		System.out.println("Bonjour " + controller.getUser().getNom());
		System.out.println("Veuillez choisir parmi les options suivantes :\n"
				+ "1. Ajouter un patient Ã  la file d'attente\n" + "2. Afficher la file d'attente \n"
				+ "3. Afficher le prochain patient de la file \n" + "4. Menu principal");
		int choixSec = clavierint.nextInt();
		switch (choixSec) {
		case 1:
			System.out.println("Saisir l'ID du patient :");
			int idPatient = clavierint.nextInt();
			menuPatientFile(idPatient);
			break;
		case 2:
			System.out.println(controller.getFile());
			afficherMenuSecretaire();
			break;
		case 3:
			System.out.println(controller.getProchainPatient());
			afficherMenuSecretaire();
			break;
		case 4:
			afficherMenuPrincipal();
			break;
		default:
			System.out.println("Saisie incorrecte");
			afficherMenuSecretaire();
		}

	}

	public void menuPatientFile(int idPatient) throws ClassNotFoundException, SQLException, IOException {

		String nomPatient = "";
		String prenomPatient = "";
		String datePatient = "";
		String adrPatient = "";
		String telPatient = "";
		Patient patient = controller.findByIdPat(idPatient);
		System.out.println(patient);
		if (patient != null) {
			controller.addPatient(patient);// il ira chercher la requette SQL Ã  partir de DAO
			System.out.println("Patient n" + idPatient + " ajouté à  la file");
			afficherMenuSecretaire();
		} else {
			System.out.println("Saisir le nom : ");
			nomPatient = clavierString.nextLine();
			System.out.println("Saisir le prénom : ");
			prenomPatient = clavierString.nextLine();
			System.out.println("Saisir la date de naissance : (AAAA-MM-JJ)");
			datePatient = clavierString.nextLine();
			Patient patient1 = new Patient(idPatient, nomPatient, prenomPatient, datePatient);
			System.out.println("Voulez vous saisir l'adresse et le téléphone? O/N");
			String choixPatient1 = clavierString.nextLine();
			switch (choixPatient1) {
			case "O":
			case "o":
				System.out.println("Saisir l'adresse");
				adrPatient = clavierString.nextLine();
				System.out.println("Saisir le téléphone");
				telPatient = clavierString.nextLine();
				patient1.setAdresse(adrPatient);
				patient1.setTelephone(telPatient);
				break;
			}
			controller.createPatient(patient1);
			controller.addPatient(controller.findByIdPat(idPatient));
			System.out.println("Patient n" + idPatient + " ajouté.");
			afficherMenuSecretaire();

		}
	}

	@Override
	public void afficherMenuMedecin() throws ClassNotFoundException, SQLException, IOException {
		
		System.out.println("Bonjour " + controller.getUser().getNom() + " dans la salle de consultation n "
				+ controller.getUser().getSalle());
		SalleConsultation salle = controller.getSalle(controller.getUser().getSalle());
		salle.setMedecin(controller.getUser().getNom());
		System.out.println("Veuillez choisir parmi les options suivantes : \n"
				+ "1. Accueillir le prochain patient (rendre la salle disponible)\n"
				+ "2. Afficher la file d'attente \n" + "3. Afficher la liste des visites\n"
				+ "4. Sauvegarder en base les visites \n" + "5. Afficher la liste des visites de la BD\n"
						+ "6. Menu principal");
		int choixMed = clavierint.nextInt();
		switch (choixMed) {
		case 1:
			// System.out.println(controller.getProchainPatient());
			if (controller.getProchainPatient() != null) {
				controller.medProchainPatient(salle.getId_salle());
				System.out.println(salle.getPatient());
				controller.addVisite(salle.getPatient().getId(), salle);
				
			} else {
				System.out.println("Il n'y a plus de patients dans la salle d'attente");
			}
			afficherMenuMedecin();
			break;
		case 2:
			System.out.println(controller.getFile());
			afficherMenuMedecin();
			break;
		case 3:
			System.out.println("Voici la liste des visites du jour (avant sauvegarde en BD) : ");
			System.out.println(controller.getListVisites(salle.getId_salle()));
			afficherMenuMedecin();
			break;
		case 4:
			controller.saveVisitesBD(salle.getId_salle());
			System.out.println("Liste des visites sauvegardées en BD.");
			afficherMenuMedecin();
			break;
		case 5:
			System.out.println(controller.voirVisitesEnBD());
			afficherMenuMedecin();
			break;
		case 6:
			afficherMenuPrincipal();
			break;

		default:
			System.out.println("Saisie incorrecte");
			afficherMenuMedecin();

		}
	}
}
