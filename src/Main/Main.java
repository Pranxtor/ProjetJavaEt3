package Main;

import Documents.*;
import Reseau.*;
import Exception.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import static Reseau.Bibliotheque.*;

public class Main {
    public static void main(String[] args){

        int selection;
        String titre;
        String nom;
        String prenom;
        int numNotice;
        int numeroSerie;
        int nombreExemplaire;
        String editeur;
        Serie serie;
        String adresse;
        String ISBN;
        String EAN;
        String bibliotheque;
        Date date;
        String debut;
        String fin;
        boolean fait;
        ArrayList<Bibliotheque> b = new ArrayList<Bibliotheque>();
    	ArrayList<Document> d = new ArrayList<Document>();
    	int i = 0;
    	int j = 0;
    	
    	if(args.length > 0)
		{
			File tempFile = new File(args[0]);
			
			if(tempFile.exists())
			{
				System.out.println("[Main] Reading the file " + args[0] + " ...");
						
				//We start by reading the CSV file
				FileReader.getDataFromCSVFile(args[0],b,d);
				
				System.out.println("[Main] End of the file " + args[0] + ".");
				
				do{
		            java.util.Scanner in = new Scanner(System.in);

		            System.out.println("Choisissez parmi ces options. Appuyez sur votre touche 1, 2, ... ou 9");

		            System.out.println("1. Ajouter une nouvelle bibliotheque"); // ok
		            System.out.println("2. Ajouter un nouveau document dans le reseau"); // TODO
		            System.out.println("3. Ajouter un nouvel utilisateur"); // ok
		            System.out.println("4. Consulter tous les documents");  // ok
		            System.out.println("5. Consulter les documents d'une serie"); // ok
		            System.out.println("6. Consulter les documents d'un auteur"); // ok
		            System.out.println("7. Rechercher un livre par son ISBN");    // ok
		            System.out.println("8. Rechercher un document par son EAN");  // ok
		            System.out.println("9. Consulter le nombre de documents publies sur une periode");  // TODO DATES !
		            System.out.println("10. Emprunter ou rendre un document pour un client"); // TODO
		            try{
		                selection = in.nextInt();

		            switch (selection) {
		                case 1:
		                    System.out.println("Donner le nom de la bibliotheque");
		                    bibliotheque = in.next();
		                    System.out.println("Donner l'adresse de la bibliotheque");
		                    adresse = in.next();

		                    Bibliotheque biblio = new Bibliotheque(bibliotheque,adresse);
		                    System.out.println("Le reseau est composé de ces bibliotheques");
		                    afficheReseau();
		                    System.out.println("");
		                    break;

		                case 2:
		                    System.out.println("Si vous ne savez pas, appuyez sur entree directement");
		                    System.out.println("Quel est le titre du documents ?");
		                    titre = in.next();
		                    System.out.println("Quel est le numero de notice ?");
		                    numNotice = in.nextInt();
		                    System.out.println("Qui est l'editeur ?");
		                    editeur = in.next();
		                    System.out.println("Quel est le nom de l'auteur");
		                    nom = in.next();
		                    System.out.println("Quel est le prenom de l'auteur");
		                    prenom = in.next();
		                    System.out.println("Quelle est la date de publication. Ecrivez sous la forme JJ/MM/AA");
		                    // TODO DATE DE PUBLICATION
		                    System.out.println("Quel est son EAN");
		                    EAN = in.next();

		                    System.out.println("Est-ce un livre ?");
		                    System.out.println("1. Oui");
		                    System.out.println("2. Non");
		                    selection = in.nextInt();
		                    if(selection == 1){
		                        System.out.println("Quel est son ISBN ?");
		                        ISBN = in.next();
		                        //Livre doc = new Livre(titre, numNotice,editeur,nom,prenom,date,EAN,numeroSerie,nombreExemplaire,ISBN,serie)
		                    }else{
		                        //Document doc = new Document(titre,numNotice,editeur,nom,prenom,date,EAN,numeroSerie,nombreExemplaire,serie);
		                    }


		                    System.out.println("Dans quelle bibliotheque voulez vous ajouter votre document ?");
		                    afficheReseau();
		                    bibliotheque = in.next();
		                    // TODO
		                    //rechercheBibliotheque(bibliotheque).ajouterDocument(doc);

		                    break;

		                case 3:

		                    System.out.println("Entrer le nom du client");
		                    nom = in.next();
		                    System.out.println("Entrer le prenom");
		                    prenom = in.next();
		                    System.out.println("Dans quel bibliotheque voulez vous l'inscrire parmi cette liste de bibliotheque ? \nEcirvez le nom de la bibliotheque");
		                    afficheReseau();
		                    bibliotheque = in.next();

		                    try{
		                        biblio = rechercheBibliotheque(bibliotheque);
		                        Client client = new Client(nom, prenom);
		                        fait = client.inscrire(biblio);
		                        if(fait)
		                            System.out.println("L'inscription est faite !");
		                        else
		                            System.out.println("L'inscription n'a pas aboutit");
		                    }catch (ExceptionBibliothequeDoesNotExist e){
		                        System.out.println(e.getMessage());
		                    }


		                    break;

		                case 4:
		                    System.out.println("1. Retour au menu");
		                    System.out.println("2. Consulter dans une bibliotheque");
		                    System.out.println("3. Consulter dans le reseau");
		                    selection = in.nextInt();
		                    if(selection == 1){
		                        // Nothing to do here
		                    }else if(selection == 2){
		                        System.out.println("Quel est le nom de votre bibliotheque parmi cette liste");
		                        afficheReseau();
		                        bibliotheque = in.next();
		                        System.out.println("Voici les differents documents");
		                        try{
		                            rechercheBibliotheque(bibliotheque).consulterToutDoc();
		                        }catch (ExceptionBibliothequeDoesNotExist e){
		                            System.out.println(e.getMessage());
		                        }

		                    }else if(selection == 3){
		                        System.out.println("Voici les differents documents");
		                        consulterToutDocReseau();
		                    }else{
		                        System.out.println("Mauvaise selection, retour au menu principal");
		                    }
		                    break;

		                case 5:
		                    System.out.println("Vous voulez consulter une serie");
		                    System.out.println("1. Dans une bibliotheque");
		                    System.out.println("2. Dans le resaeu");
		                    selection = in.nextInt();

		                    System.out.println("Entrer le titre de la serie");
		                    titre = in.next();

		                    if(selection == 1){
		                        System.out.println("Quel est le nom de la bibliotheque parmi cette liste");
		                        afficheReseau();
		                        bibliotheque = in.next();
		                        try{
		                            rechercheBibliotheque(bibliotheque).consulterSerie(titre);
		                        }catch (ExceptionBibliothequeDoesNotExist e){
		                            System.out.println(e.getMessage());
		                        }
		                    }else if(selection == 2){
		                        consulterSerieReseau(titre);
		                    }
		                    break;

		                case 6:
		                    System.out.println("Vous voulez consulter les documents d'un auteur");
		                    System.out.println("1. Dans le reseau");
		                    System.out.println("2. Dans une bibliotheque");
		                    System.out.println("Autre. Retour au menu");

		                    selection = in.nextInt();

		                    System.out.println("Entrez son nom. Si vous ne le connaissez pas, appuyez sur entree");
		                    nom = in.next();
		                    System.out.println("Entrez son prenom. Si vous ne le connaissez pas, appuyez sur entree");
		                    prenom = in.next();

		                    if(selection == 1){
		                        if(nom.isBlank() && !prenom.isBlank()){
		                            consulterPrenomReseau(prenom);
		                        }else if(!nom.isBlank() && prenom.isBlank()){
		                            consulterReseau(nom);
		                        }else if(!nom.isBlank() && !prenom.isBlank()){
		                            consulterReseau(nom, prenom);
		                        }else{
		                            System.out.println("Impossible de mener la recherche");
		                        }
		                    }else if(selection == 2){
		                        try{
		                            System.out.println("Quel est le nom de la bibliotheque parmi cette liste");
		                            afficheReseau();
		                            bibliotheque = in.next();
		                            if(nom.isBlank() && !prenom.isBlank()){
		                                rechercheBibliotheque(bibliotheque).consulterPrenom(prenom);
		                            }else if(!nom.isBlank() && prenom.isBlank()){
		                                rechercheBibliotheque(bibliotheque).consulter(nom);
		                            }else if(!nom.isBlank() && !prenom.isBlank()){
		                                rechercheBibliotheque(bibliotheque).consulter(nom, prenom);
		                            }else{
		                                System.out.println("Impossible de mener la recherche");
		                            }
		                        }catch (ExceptionBibliothequeDoesNotExist e){
		                            System.out.println(e.getMessage());
		                        }

		                    }else{
		                        System.out.println("Mauvaise selection. Retour au menu");
		                    }
		                    break;

		                case 7:
		                    System.out.println("Vous voulez chercher un document par son ISBN");
		                    System.out.println("Quel est l'ISBN de votre document ?");
		                    ISBN = in.next();
		                    System.out.println("Dans quelle bibliotheque voulez-vous chercher votre document ?");
		                    bibliotheque = in.next();
		                    try{
		                        rechercheBibliotheque(bibliotheque).rechercheISBN(ISBN).afficheDoc();
		                    }catch (ExceptionBibliothequeDoesNotExist e){
		                        System.out.println(e.getMessage());
		                    }


		                    break;

		                case 8:
		                    System.out.println("Vous voulez chercher un document par son EAN");
		                    System.out.println("Quel est l'EAN de votre document ?");
		                    EAN = in.next();
		                    System.out.println("Dans quelle bibliotheque voulez-vous chercher votre document ?");
		                    bibliotheque = in.next();
		                    try{
		                        rechercheBibliotheque(bibliotheque).rechercheEAN(EAN).afficheDoc();
		                    }catch (ExceptionBibliothequeDoesNotExist e){
		                        System.out.println(e.getMessage());
		                    }


		                    break;

		                case 9:
		                    System.out.println("Voulez vous le faire une bibliotheque particuliere ou dans le reseau ?");
		                    System.out.println("1. Reseau");
		                    System.out.println("2. Bibliotheque");
		                    selection = in.nextInt();

		                    // TODO trouver un moyen pour les dates
		                    System.out.println("Donner la date de debut sous la forme : JJ/MM/AA");
		                    debut = in.next();
		                    System.out.println("Donner la date de fin sous la forme : JJ/MM/AA");
		                    fin = in.next();

		                    if(selection == 1){
		                        //filtreperiodeReseau(debut, fin);
		                    }else if(selection == 2){
		                        System.out.println("Parmi la liste des bibliotheques, laquelle choisissez vous ?");
		                        afficheReseau();
		                        bibliotheque = in.next();

		                        //rechercheBibliotheque(bibliotheque).filtreperiode(debut, fin);
		                    }else{
		                        System.out.println("Mauvaise selection, retour au menu principal");
		                    }
		                    break;

		                case 10 :
		                    System.out.println("Que voulez vous faire ?");
		                    System.out.println("1. Emprunter");
		                    System.out.println("2. Rendre");
		                    selection = in.nextInt();
		                    System.out.println("Dans quelle bibliotheque ?");
		                    bibliotheque = in.next();
		                    System.out.println("Quel est le nom du client ?");
		                    nom = in.next();
		                    System.out.println("Quel est le prenom du client ? ");
		                    prenom = in.next();

		                    // find client

		                    if(selection == 1){
		                        System.out.println("Vous voulez emprunter");
		                        System.out.println("Quel est le document que vous voulez emprunter ?");
		                        System.out.println("1. Recherchez le document par son ISBN");
		                        System.out.println("1. Recherchez le document par son EAN");



		                    }else if(selection == 2){
		                        System.out.println("Quel est le document que vous voulez rendre ?");

		                    }else{


		                    }

		                    break;

		                default:
		                    System.out.println();
		                    System.out.println("Refaite votre choix !");
		                    System.out.println();
		            }
		            System.out.println();
		            System.out.println();

		            }catch (java.util.InputMismatchException e){
		                System.out.println("Mauvaise selection. Recommencez !");
		            }
		        }while(true);
			}
			else
			{
				System.out.println("[Main] No file " + args[0]);
			}
		}
		else
		{
			System.out.println("[Main] You should enter the CSV file path as a parameter.");
		}

        
    }

}
