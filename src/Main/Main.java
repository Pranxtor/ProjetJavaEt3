package Main;

import Documents.*;
import Reseau.*;
import Exception.*;

import javax.print.Doc;
import javax.swing.plaf.basic.BasicTreeUI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import static Reseau.Bibliotheque.*;

public class Main {

    public static void main(String[] args){

        int selection;
        String titre;
        String nom;
        String prenom;
        int numeroSerie;
        int nombreExemplaire;
        String editeur;
        Serie serie = new Serie("ezf");
        String adresse;
        String ISBN;
        String EAN;
        String bibliotheque;
        String date="";
        String debut="";
        String fin="";
        Date dateDebut;
        Date dateFin;



        Livre ZE = new Livre("ZE", "ZEF", "Mario", "MCH", null, "1234", 234, 213, serie , "VDEFEC");
        //Jeux E = new Jeux("ZE", "ZEF", "Mario", "MCH", null, "1234", 234, 213, serie );
/*
		Bibliotheque abc = new Bibliotheque("ABC", "AZE");

		if(true){
			System.out.println("er");
			try{
				rechercheBibliotheque("ABC").ajouterDocument(new Livre("ZE", "ZEF", "Mario", "MCH", null, "1234", 234, 213, serie , "VDEFEC"),32);
				//.ajouterDocument(ZE, 324);
				System.out.println(abc.consulterToutDoc());
				System.out.println(rechercheBibliotheque("ABC").consulterToutDoc());
			}catch (ExceptionBibliothequeDoesNotExist e){
				System.out.println(e.getMessage());
			}
		}


 */


        boolean fait = false;

        Client client = new Client("","");

        ArrayList<Bibliotheque> b = new ArrayList<Bibliotheque>();
        ArrayList<Client> c = new ArrayList<>();
    	ArrayList<Document> d = new ArrayList<Document>();
    	ArrayList<Emprunt> emprunts = new ArrayList<>();
    	int i = 0;
    	int j = 0;
    	
    	//if(args.length > 0)
		//{
			//java.io.File tempFile = new java.io.File(args[0]);
			
			//if(tempFile.exists())
			//{
				//System.out.println("[Main] Reading the file " + args[0] + " ...");
						
				//We start by reading the CSV file
				//FileReader.getDataFromCSVFile(args[0],b,d);
				
				//System.out.println("[Main] End of the file " + args[0] + ".");
				
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
		            System.out.println("9. Consulter le nombre de documents publies sur une periode"); // ok
		            System.out.println("10. Emprunter ou rendre un document pour un client"); // ok

		            try{
		                selection = in.nextInt();
		            switch (selection) {
		                case 1:
		                    System.out.println("Donner le nom de la bibliotheque");
		                    bibliotheque = in.next();
		                    System.out.println("Donner l'adresse de la bibliotheque");
		                    adresse = in.next();

		                    Bibliotheque biblio = new Bibliotheque(bibliotheque,adresse);
		                    //b.add(biblio);
		                    System.out.println("Le reseau est composé de ces bibliotheques");
		                    afficheReseau();
		                    System.out.println("");
		                    break;

		                case 2:

		                    try {
								System.out.println("Si vous ne savez pas, appuyez sur entree directement");

								System.out.println("Dans quelle bibliotheque voulez vous ajouter votre document ?");
								afficheReseau();
								bibliotheque = in.next();

								System.out.println("Est-ce un livre ?");
								System.out.println("1. Oui");
								System.out.println("2. Non");
								selection = in.nextInt();

								System.out.println("Quel est le numero de serie ?");
								numeroSerie = in.nextInt();

								System.out.println("Combien de documents voulez-vous ajouter ?");
								nombreExemplaire = in.nextInt();

								System.out.println("Quel est le titre du documents ?");
								titre = in.next();

								System.out.println("Qui est l'editeur ?");
								editeur = in.next();

								System.out.println("Quel est le nom de l'auteur");
								nom = in.next();

								System.out.println("Quel est le prenom de l'auteur");
								prenom = in.next();

								System.out.println("Quelle est la date de publication. Ecrivez sous la forme AAAA");
								debut = in.next();
								serie = new Serie("AB");


								System.out.println("Quel est son EAN");
								EAN = in.next();
								System.out.println(bibliotheque);
								System.out.println(numeroSerie);
								System.out.println(nombreExemplaire);
								System.out.println(titre);
								System.out.println(editeur);
								System.out.println(nom);
								System.out.println(prenom);
								System.out.println(debut);


								if(selection == 1){
									System.out.println("Quel est son ISBN ?");
									ISBN = in.next();
									if(rechercheBibliotheque(bibliotheque).ajouterDocument(new Livre(titre,editeur,nom,prenom,EAN, date ,nombreExemplaire, numeroSerie, serie, ISBN), nombreExemplaire)){
										System.out.println(rechercheBibliotheque(bibliotheque).consulterToutDoc());
										System.out.println("Le document a ete ajoute");
									}
								}else{
									// Creer un document
								}
							}catch (ExceptionBibliothequeDoesNotExist e){
		                    	System.out.println(e.getMessage());
							}
		                    break;

		                case 3:
		                    System.out.println("Entrer le nom du client");
		                    nom = in.next();

		                    System.out.println("Entrer le prenom");
		                    prenom = in.next();

		                    System.out.println("Dans quel bibliotheque voulez vous l'inscrire parmi cette liste de bibliotheque ? \nEcirvez le nom de la bibliotheque");
		                    afficheReseau();
		                    bibliotheque = in.next();

		                    try {
								Client clients = new Client(nom, prenom);
								fait = clients.inscrire(rechercheBibliotheque(bibliotheque));
								c.add(clients);
								if (fait){
									System.out.println("L'inscription est faite !");
									fait = false;
								}else{
									System.out.println("L'inscription n'a pas aboutit");
								}
		                    }catch (ExceptionBibliothequeDoesNotExist e){
		                        System.out.println(e.getMessage());
		                    }
		                    break;

		                case 4:
		                    System.out.println("1. Consulter dans une bibliotheque");
		                    System.out.println("2. Consulter dans le reseau");
							System.out.println("Autre chiffre. Retour au menu");
		                    selection = in.nextInt();
		                    if(selection == 1){
		                        System.out.println("Quel est le nom de votre bibliotheque parmi cette liste");
		                        afficheReseau();
		                        bibliotheque = in.next();
		                        System.out.println("Voici les differents documents");
		                        try{
		                            rechercheBibliotheque(bibliotheque).consulterToutDoc();
		                        }catch (ExceptionBibliothequeDoesNotExist e){
		                            System.out.println(e.getMessage());
		                        }

		                    }else if(selection == 2){
		                        System.out.println("Voici les differents documents");
		                        consulterToutDocReseau();
		                    }else{
		                        System.out.println("Retour au menu principal");
		                    }
		                    break;

		                case 5:
		                    System.out.println("Vous voulez consulter une serie");
		                    System.out.println("1. Dans une bibliotheque");
		                    System.out.println("2. Dans le resaeu");
							System.out.println("Autre chiffre. Retour au menu");
		                    selection = in.nextInt();

		                    System.out.println("Entrer le titre de la serie");
		                    titre = in.next();

		                    if(selection == 1){
		                        System.out.println("Quel est le nom de la bibliotheque parmi cette liste");
		                        afficheReseau();
		                        bibliotheque = in.next();
		                        try{
									System.out.println(rechercheBibliotheque(bibliotheque).consulterSerie(titre));
		                        }catch (ExceptionBibliothequeDoesNotExist e){
		                            System.out.println(e.getMessage());
		                        }
		                    }else if(selection == 2){
								System.out.println(consulterSerieReseau(titre));
		                    }else{
		                    	// do nothing
							}
		                    break;

		                case 6:
		                    System.out.println("Vous voulez consulter les documents d'un auteur");
		                    System.out.println("1. Dans le reseau");
		                    System.out.println("2. Dans une bibliotheque");
		                    System.out.println("Autre chiffre. Retour au menu");

		                    selection = in.nextInt();
							nom = in.nextLine();
		                    System.out.println("Entrez son nom. Si vous ne le connaissez pas, appuyez sur entree");
							prenom = in.nextLine();
		                    System.out.println("Entrez son prenom. Si vous ne le connaissez pas, appuyez sur entree");

		                    if(selection == 1){
		                        if(nom.isEmpty() && !prenom.isEmpty()){
									System.out.println(consulterPrenomReseau(prenom));
		                        }else if(!nom.isEmpty() && prenom.isEmpty()){
									System.out.println(consulterReseau(nom));
		                        }else if(!nom.isEmpty() && !prenom.isEmpty()){
									System.out.println(consulterReseau(nom, prenom));
		                        }else{
		                            System.out.println("Impossible de mener la recherche");
		                        }
		                    }else if(selection == 2){
		                        try{
		                            System.out.println("Quel est le nom de la bibliotheque parmi cette liste");
		                            afficheReseau();
		                            bibliotheque = in.next();
		                            if(nom.isEmpty() && !prenom.isEmpty()){
										System.out.println(rechercheBibliotheque(bibliotheque).consulterPrenom(prenom));
		                            }else if(!nom.isEmpty() && prenom.isEmpty()){
										System.out.println(rechercheBibliotheque(bibliotheque).consulter(nom));
		                            }else if(!nom.isEmpty() && !prenom.isEmpty()){
										System.out.println(rechercheBibliotheque(bibliotheque).consulter(nom, prenom));
		                            }else{
		                                System.out.println("Impossible de mener la recherche");
		                            }
		                        }catch (ExceptionBibliothequeDoesNotExist e){
		                            System.out.println(e.getMessage());
		                        }
		                    }else{
		                        System.out.println("Retour au menu");
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

		                    System.out.println("Donner la date de debut sous la forme : AAAA");
		                    debut = in.next();
		                    System.out.println("Donner la date de fin sous la forme : AAAA");
		                    fin = in.next();

							dateDebut = new SimpleDateFormat("yyyy").parse(debut);
							dateFin = new SimpleDateFormat("yyyy").parse(fin);

		                    if(selection == 1){
		                        filtreperiodeReseau(dateDebut, dateFin);
		                    }else if(selection == 2){
		                        System.out.println("Parmi la liste des bibliotheques, laquelle choisissez vous ?");
		                        afficheReseau();
		                        bibliotheque = in.next();
								try{
									System.out.println(rechercheBibliotheque(bibliotheque).filtreperiode(dateDebut, dateFin));
								}catch (ExceptionBibliothequeDoesNotExist e){
									System.out.println(e.getMessage());
								}
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

		                    System.out.println("Quel est le nom de votre client ?");
		                    nom = in.next();
		                    System.out.println("Quel est le prenom de votre client ?");
							prenom = in.next();

							try{
								for(Client k : c){
									if(k.getNom().equals(nom) && k.getPrenom().equals(prenom)){
										client = k;
									}
								}
								if(client.equals(null)){
									System.out.println("Le client est introuvable. Il faut d'abord l'inscrire");
								}else{
									for(Emprunt e : emprunts){
										if(e.getClient().equals(client) && e.getBibliotheque().equals(rechercheBibliotheque(bibliotheque))){
											fait = true;
										}
									}
									if(!fait){ // Si l'emprunt n'a pas deja ete effectue auparavant
										Emprunt emprunt = new Emprunt(5, client, rechercheBibliotheque(bibliotheque));
										emprunts.add(emprunt);
										fait = false;
									}
									if(selection == 1){
										System.out.println("Vous voulez emprunter");
										System.out.println("Quel est le document que vous voulez emprunter ?");
										System.out.println("1. Recherchez le document par son ISBN");
										System.out.println("2. Recherchez le document par son EAN");
										selection = in.nextInt();
										if(selection == 1){
											System.out.println("Donner l'ISBN du document");
											ISBN = in.next();
											for(Emprunt k : emprunts){
												if(k.getClient().equals(client) && k.getBibliotheque().equals(rechercheBibliotheque(bibliotheque))){
													k.emprunter(rechercheBibliotheque(bibliotheque).rechercheISBN(ISBN));
												}
											}
										}else if(selection == 2){
											System.out.println("Donner l'EAN du document");
											EAN = in.next();
											for(Emprunt k : emprunts){
												if(k.getClient().equals(client) && k.getBibliotheque().equals(rechercheBibliotheque(bibliotheque))){
													k.emprunter(rechercheBibliotheque(bibliotheque).rechercheEAN(EAN));
												}
											}
										}
									}else if(selection == 2){
										System.out.println("Vous voulez rendre le document");
										System.out.println("Quel est le document que vous voulez rendre ?");
										System.out.println("1. Recherchez le document par son ISBN");
										System.out.println("2. Recherchez le document par son EAN");
										selection = in.nextInt();
										if(selection == 1){
											System.out.println("Donner l'ISBN du document");
											ISBN = in.next();
											for(Emprunt k : emprunts){
												if(k.getClient().equals(client) && k.getBibliotheque().equals(rechercheBibliotheque(bibliotheque))){
													k.rendre(rechercheBibliotheque(bibliotheque).rechercheISBN(ISBN));
												}
											}
										}else if(selection == 2){
											System.out.println("Donner l'EAN du document");
											EAN = in.next();
											for(Emprunt k : emprunts){
												if(k.getClient().equals(client) && k.getBibliotheque().equals(rechercheBibliotheque(bibliotheque))){
													k.rendre(rechercheBibliotheque(bibliotheque).rechercheEAN(EAN));
												}
											}
										}
									}else{
									}
								}
							}catch (ExceptionBibliothequeDoesNotExist e){
								System.out.println(e.getMessage());
							}
		                    break;

		                default:
		                    System.out.println();
		                    System.out.println("Refaite votre choix !");
		                    System.out.println();
		            }
		            System.out.println();
		            System.out.println();

		            }catch (InputMismatchException | ParseException e){
		                System.out.println("Mauvaise selection. Recommencez !");
		            }
		        }while(true);
			//}
			//else
			//{
				//System.out.println("[Main] No file " + args[0]);
			//}
		//}
		//else
		//{
			//System.out.println("[Main] You should enter the CSV file path as a parameter.");
		//}

        
    }


}
