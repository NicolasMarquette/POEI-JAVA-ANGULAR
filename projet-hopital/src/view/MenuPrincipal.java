package view;

import java.io.IOException;
import java.sql.SQLException;

import java.util.Scanner;

import controller.Controller;

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


		System.out.println("Bienvenue à l'hopital. \n " + "Veuillez choisir parmi les options suivantes : \n"
				+ "1. Menu Login\n" + "2. Quitter l'hopital");
		int choix = clavierint.nextInt();

		switch (choix) {
		case 1:
			afficherMenuAuthentification();
			break;
		case 2:
			System.out.println("Au revoir!");
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
		if (!username.isEmpty() && !mdp.isEmpty()) {
			if (controller.verifLogin(username, mdp))
				switch (controller.getMetier()) {
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

			else {
				afficherMenuPrincipal();
			}
		} else {
			System.out.println("Vous n'avez pas saisi de username et / ou de mot de passe");
			afficherMenuAuthentification();
		}

	}

	@Override
	public void afficherMenuSecretaire() throws ClassNotFoundException, SQLException, IOException {
		
    System.out.println("Bonjour " // Afficher le nom de la secretaire : getSecretaire
		);
		System.out.println("Veuillez choisir parmi les options suivantes :\n"
				+ "1. Ajouter un patient à la file d'attente\n" + "2. Afficher la file d'attente \n"
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
		}

	}

	public void menuPatientFile(int idPatient) throws ClassNotFoundException, SQLException, IOException {

		String nomPatient;
		String prenomPatient;
		String datePatient;
		String adrPatient;
		String telPatient;
		if (idPatient == 1) {
			// Find by ID de patient
			controller.addPatient();// il ira chercher la requette SQL à partir de DAO
			System.out.println("Patient n°" + idPatient + " ajouté à la file");
			afficherMenuSecretaire();
		} else {
			System.out.println("Saisir le nom : ");
			nomPatient = clavierString.nextLine();
			System.out.println("Saisir le prénom : ");
			prenomPatient = clavierString.nextLine();
			System.out.println("Saisir la date de naissance : (AAAA-MM-JJ)");
			datePatient = clavierString.nextLine();
			System.out.println("Voulez vous saisir l'adresse et le téléphone? O/N");
			String choixPatient1 = clavierString.nextLine();
			switch (choixPatient1) {
			case "O":
			case "o":
				System.out.println("Saisir l'adresse");
				adrPatient = clavierString.nextLine();
				System.out.println("Saisir le téléphone");
				telPatient = clavierString.nextLine();
				System.out.println("Patient " + idPatient + " ajouté.");
				afficherMenuSecretaire();
				break;
			case "N":
			case "n":
				// Patient patient= new
				// Patient(nomPatient,prenomPatient,datePatient,adrPatient,telPatient);
				controller.addPatient();
				System.out.println("Patient " + idPatient + " ajouté.");
				afficherMenuSecretaire();
				break;

			}
		}
	}

	@Override
	public void afficherMenuMedecin() throws ClassNotFoundException, SQLException, IOException {


		System.out.println("Bonjour "); // Ajouter le nom du medecin et sa salle
		System.out.println("Veuillez choisir parmi les options suivantes : \n"
				+ "1. Accueillir le prochain patient (rendre la salle disponible)\n"
				+ "2. Afficher la file d'attente \n" + "3. Sauvegarder en base les visites \n" + "4. Menu principal");
		int choixMed = clavierint.nextInt();
		switch (choixMed) {
		case 1:
			System.out.println(controller.getProchainPatient());
			controller.addVisite();
			afficherMenuMedecin();
			break;
		case 2:
			System.out.println(controller.getFile());
			afficherMenuMedecin();
			break;
		case 3:
			System.out.println("Liste des visites sauvegardées en BD.");
			afficherMenuMedecin();
			break;
		case 4:
			afficherMenuPrincipal();
			break;
		}
	}

}