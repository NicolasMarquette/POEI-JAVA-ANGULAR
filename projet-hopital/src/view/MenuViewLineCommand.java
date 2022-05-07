package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import controller.Controller;
import db.ConnectionManager;
import model.Hopital;
import model.Medicament;
import model.Patient;
import model.SalleConsultation;
import model.Visite;

public class MenuViewLineCommand implements MenuView<Patient, Integer> {

	private Controller controller;
	private Scanner clavierint = new Scanner(System.in);
	private Scanner clavierString = new Scanner(System.in);
	private AffichagePatient afficherPatient = new AffichagePatient();
	private AffichageVisite afficherVisite = new AffichageVisite();
	private AffichageMedicament afficherMedicament = new AffichageMedicament();

	public MenuViewLineCommand() {

	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MENU PRINCIPAL
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void afficherMenuPrincipal() throws ClassNotFoundException, SQLException, IOException {

		System.out.println("*********************************************");
		System.out.println("*                                           *");
		System.out.println("*           Bienvenue Ã l'hopital.          *");
		System.out.println("*                version 2.0                *");
		System.out.println("*                                           *");
		System.out.println("*********************************************");

		System.out.println(
				"\nVeuillez choisir parmi les options suivantes : \n\n" + "1. Menu Login\n" + "2. Quitter l'hopital");
		int choix = clavierint.nextInt();

		switch (choix) {
		case 1:
			afficherMenuAuthentification();
			break;
		case 2:
			System.out.println("--------------------------------------------");
			System.out.println("Fermeture du programme...");
			System.out.println("Au revoir!");
			controller.exitGestionPatient();
			break;
		default:
			System.out.println("--------------------------------------------");
			System.out.println("Votre saisie est incorrecte.");
			afficherMenuPrincipal();
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MENU LOGIN
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void afficherMenuAuthentification() throws ClassNotFoundException, SQLException, IOException {
		System.out.println("--------------------------------------------");
		System.out.println("Veuillez vous identifiez.");

		System.out.println("Entrez votre username : ");
		String username = clavierString.nextLine();

		System.out.println("Entrez votre mot de passe : ");
		String mdp = clavierString.nextLine();

		if (!username.isEmpty() && !mdp.isEmpty()) {
			if (controller.verifLogin(username, mdp)) {

				controller.setUser(username);

				switch (controller.getUser().getMetier()) {
				case 0:
					afficherMenuSecretaire();
					break;
				case 1:
					afficherMenuMedecin();
					break;
				default:
					System.out.println("--------------------------------------------");
					System.out.println("Votre saisie est incorrecte.");
					afficherMenuAuthentification();
				}
			}
			System.out.println("--------------------------------------------");
			System.out.println("Les identifiants sont incorrects!");
		} else {
			System.out.println("--------------------------------------------");
			System.out.println("Vous n'avez pas saisi de username et/ou de mot de passe");
		}
		afficherMenuPrincipal();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MENU SECRETAIRE
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void afficherMenuSecretaire() throws ClassNotFoundException, SQLException, IOException {

		System.out.println("--------------------------------------------");
		System.out.println("Bonjour " + controller.getUser().getNom() + "\n");
		System.out.println("Veuillez choisir parmi les options suivantes :\n\n"
				+ "1. Ajouter un patient Ã la file d'attente\n" + "2. Afficher la file d'attente \n"
				+ "3. Afficher le prochain patient de la file \n" + "4. Ajouter une adresse/tel à un patient\n"
				+ "5. Afficher la liste des visites en base d'un patient selon son ID\n" + "6. Menu principal");
		int choixSec = clavierint.nextInt();
		switch (choixSec) {
		case 1:
			System.out.println("--------------------------------------------");
			System.out.println("Saisir l'ID du patient :");
			int idPatient = clavierint.nextInt();
			menuPatientFile(idPatient);
			break;
		case 2:
			System.out.println("--------------------------------------------");
			System.out.println("File d'attente :");
			for (Patient p : controller.getFileAttente())
				System.out.println(afficherPatient.afficherPatient(p));
			break;
		case 3:
			System.out.println("--------------------------------------------");
			System.out.println("Prochain patient dans la file d'attente : ");
			if (controller.getProchainPatientDansFile() != null) {
				System.out.println(afficherPatient.afficherPatient(controller.getProchainPatientDansFile()));
			} else {
				System.out.println("Il n'y a pas de patient en file d'attente");
			}
			break;
		case 4:
			System.out.println("--------------------------------------------");
			System.out.println("Veuillez entrer l'ID du patient à modifier");
			int id = clavierint.nextInt();
			System.out.println("Veuillez entrer l'adresse");
			String adr = clavierString.nextLine();
			System.out.println("Veuillez entrer le téléphone");
			String tel = clavierString.nextLine();
			controller.miseAJourPatient(id, adr, tel);
			System.out.println("Mise à jour effectuée !");
			break;
		case 5:
			System.out.println("--------------------------------------------");
			System.out.println("Veuillez entrer l'ID du patient ");
			int idlist = clavierint.nextInt();
			for (Visite v : controller.voirVisitePatBD(idlist))
				System.out.println(afficherVisite.afficherVisite(v));
			break;
		case 6:
			afficherMenuPrincipal();
			break;
		default:
			System.out.println("Saisie incorrecte");
		}
		afficherMenuSecretaire();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MENU INSCRIPTION DU PATIENT EN FILE D'ATTENTE
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void menuPatientFile(Integer id) throws ClassNotFoundException, SQLException, IOException {

		String nomPatient = "";
		String prenomPatient = "";
		String datePatient = "";
		String adrPatient = "";
		String telPatient = "";
		if (controller.verifPatient(id)) {
			Patient patient = controller.findByIdPatient(id);
			System.out.println("--------------------------------------------");
			if (!controller.isPatientDansFileAttente(patient.getId())) {
				controller.addPatientDansFile(patient);
				controller.ecrireRapport(id);
				System.out.println("Patient id n°" + id + " ajouté à la file");
			} else {
				System.out.println("Ce patient n°" + id + " est déjà dans la file d'attente");
			}
		} else {
			System.out.println("--------------------------------------------");
			System.out.println("Saisir le nom : ");
			nomPatient = clavierString.nextLine();
			System.out.println("Saisir le prénom : ");
			prenomPatient = clavierString.nextLine();
			System.out.println("Saisir la date de naissance : (AAAA-MM-JJ)");
			datePatient = clavierString.nextLine();
			Patient patient = new Patient(id, nomPatient, prenomPatient, datePatient);
			System.out.println("Voulez vous saisir l'adresse et/ou le téléphone? O/N");
			String choixPatient1 = clavierString.nextLine();
			switch (choixPatient1) {
			case "O":
			case "o":
				System.out.println("--------------------------------------------");
				System.out.println("Saisir l'adresse");
				adrPatient = clavierString.nextLine();
				System.out.println("Saisir le téléphone");
				telPatient = clavierString.nextLine();
				patient.setAdresse(adrPatient);
				patient.setTelephone(telPatient);
				break;
			}
			System.out.println("--------------------------------------------");
			System.out.println(patient);
			controller.createPatient(patient);
			controller.addPatientDansFile(controller.findByIdPatient(id));
			controller.ecrireRapport(id);
			System.out.println("Patient id n°" + id + " ajouté à la file");
		}
		afficherMenuSecretaire();

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MENU MEDECIN
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void afficherMenuMedecin() throws ClassNotFoundException, SQLException, IOException {

		String username = controller.getUser().getNom();
		int numeroSalleConsultation = controller.getUser().getSalle();
		SalleConsultation salle = controller.getSalleDeConsultation(numeroSalleConsultation);

		salle.setMedecin(username);

		System.out.println("--------------------------------------------");
		System.out.println(
				"Bienvenue dans la salle de consultation n°" + numeroSalleConsultation + " " + username + "\n");
		System.out.println("Veuillez choisir parmi les options suivantes : \n\n"
				+ "1. Accueillir le prochain patient (rendre la salle disponible)\n"
				+ "2. Afficher la file d'attente \n" + "3. Afficher la liste des visites\n"
				+ "4. Sauvegarder en base les visites \n" + "5. Afficher la liste des visites en base du " + username
				+ "\n" + "6. Etablir une ordonnance\n" + "7. Menu principal");
		int choixMed = clavierint.nextInt();

		switch (choixMed) {
		case 1:
			System.out.println("--------------------------------------------");
			if (controller.getProchainPatientDansFile() != null) {
				controller.accueillirProchainPatientEnSalleDeConsultation(numeroSalleConsultation);
				System.out
						.println("Patient qui entre dans la salle de consultation " + numeroSalleConsultation + " : ");
				System.out.println(afficherPatient.afficherPatient(salle.getPatient()));
				controller.addVisite(salle.getPatient().getId(), salle);
			} else {
				System.out.println("Il n'y a plus de patients dans la salle d'attente");
			}
			break;
		case 2:
			System.out.println("--------------------------------------------");
			System.out.println("File d'attente :");
			for (Patient p : controller.getFileAttente())
				System.out.println(afficherPatient.afficherPatient(p));
			break;
		case 3:
			System.out.println("--------------------------------------------");
			System.out.println("Voici la liste des visites du jour (avant sauvegarde en BD) : ");
			for (Visite v : controller.getListeVisites(numeroSalleConsultation))
				System.out.println(afficherVisite.afficherVisite(v));
			break;
		case 4:
			System.out.println("--------------------------------------------");
			controller.saveVisitesEnBaseDonnees(numeroSalleConsultation);
			System.out.println("Liste des visites sauvegardées en BD.");
			break;
		case 5:
			System.out.println("--------------------------------------------");
			System.out.println("Liste des visites en base pour " + username);
			for (Visite v : controller.voirVisitesParMedecinEnBaseDonnees())
				System.out.println(afficherVisite.afficherVisite(v));
			break;
		case 6:
			afficherMenuOrdonnance(salle.getPatient());
			break;
		case 7:
			afficherMenuPrincipal();
			break;
		default:
			System.out.println("--------------------------------------------");
			System.out.println("Saisie incorrecte");
		}
		afficherMenuMedecin();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// MENU ORDONNANCE
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void afficherMenuOrdonnance(Patient patient) throws ClassNotFoundException, SQLException, IOException {

		int choixMedicament = 0;
		do {
			System.out.println("--------------------------------------------");
			System.out.println("Menu ordonnance");
			System.out.println("\nListe des médicaments disponibles : ");
			for (Medicament m : controller.getListeMedicament()) {
				System.out.println("* " + afficherMedicament.afficherMedicament(m));
			}
			System.out.println("0. Editer l'ordonnance\n");

			System.out.println("Veuillez saisir votre choix : ");
			choixMedicament = clavierint.nextInt();

			if (choixMedicament != 0) {
				System.out.println("Veuillez saisir la quantité : ");
				int choixQuantiteMedicament = clavierint.nextInt();
				if (controller.updateQuantiteMedicament(choixMedicament, choixQuantiteMedicament)) {
					System.out.println(choixQuantiteMedicament + " " + controller.getNomMedicamentById(choixMedicament)
							+ " prescrit sur l'ordonnance");
				} else {
					System.out.println("Il n'y a pas assez de stock de ce médicament pour la quantité désirée : "
							+ choixQuantiteMedicament);
				}

			}
		} while (choixMedicament != 0);
		afficherMenuMedecin();
	}

}
