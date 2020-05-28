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
        String nom;
        String prenom;
        String adresse;
        String ISBN;
        String EAN;
        String bibliotheque;
        String debut;
        String fin;
        boolean fait;

        do{
            java.util.Scanner in = new Scanner(System.in);

            System.out.println("Choisissez parmi ces options");

            System.out.println("1. Ajouter une nouvelle bibliotheque"); // ok
            System.out.println("2. Ajouter un nouveau document dans le reseau"); // TODO
            System.out.println("3. Ajouter un nouvel utilisateur"); // ok
            System.out.println("4. Consulter tous les documents");  // ok
            System.out.println("5. Consulter les documents d'une serie"); //
            System.out.println("6. Consulter les documents d'un auteur"); // ok
            System.out.println("7. Rechercher un livre par son ISBN");    // Creer une methode pour afficher le document
            System.out.println("8. Rechercher un document par son EAN");  // Creer une methode pour afficher le document
            System.out.println("9. Consulter le nombre de documents publies sur une periode");  // TODO DATES !
            System.out.println("10. Emprunter ou rendre un document pour un client"); // TODO

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
                    System.out.println("Quel est le titre du documents ?");
                    //Document doc = new Document();
                    // J'attends d'avoir ton push pour le faire
                    System.out.println("Dans quelle bibliotheque voulez vous ajouter votre document ?");
                    afficheReseau();
                    bibliotheque = in.next();
                    // TODO
                    //rechercheBibliotheque(bibliotheque).ajouterDocument(doc);
                    break;

                case 3:
                    System.out.println("Entrer le nom de l'utilisateur");
                    nom = in.next();
                    System.out.println("Entrer le prenom");
                    prenom = in.next();
                    Client client = new Client(nom, prenom);

                    System.out.println("Dans quel bibliotheque voulez vous l'inscrire parmi cette liste de bibliotheque ? \nEcirvez le nom de la bibliotheque");
                    afficheReseau();
                    bibliotheque = in.next();
                    fait = client.inscrire(rechercheBibliotheque(bibliotheque));
                    if(fait)
                        System.out.println("L'inscription est faite !");
                    else
                        System.out.println("L'inscription n'a pas aboutit");
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
                        rechercheBibliotheque(bibliotheque).consulterToutDoc();
                    }else if(selection == 3){
                        System.out.println("Voici les differents documents");
                        consulterToutDocReseau();
                    }else{
                        System.out.println("Mauvaise selection, retour au menu principal");
                    }
                    break;

                case 5:
                    System.out.println("Entrer le titre de la serie");
                    nom = in.next();

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
                    // Creer une methode pour afficher le document
                    rechercheBibliotheque(bibliotheque).rechercheISBN(ISBN);

                    break;

                case 8:
                    System.out.println("Vous voulez chercher un document par son EAN");
                    System.out.println("Quel est l'EAN de votre document ?");
                    EAN = in.next();
                    System.out.println("Dans quelle bibliotheque voulez-vous chercher votre document ?");
                    bibliotheque = in.next();
                    // Creer une methode pour afficher le document
                    rechercheBibliotheque(bibliotheque).rechercheEAN(EAN);

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
                    System.out.println("Quel est votre nom ?");
                    nom = in.next();
                    System.out.println("Quel est votre prenom ? ");
                    prenom = in.next();


                    if(selection == 1){
                        System.out.println("Vous voulez emprunter");




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

        }while(true);



        /*
        Date a = new Date();
        Livre livreEconomie = new Livre("Economie", 314, "Polytech", "Henriot","Marie Christine", a, "ERF4324", 25,"ER3RFAZ");
        Livre livrePhilosophie = new Livre("Philo", 14, "Polytech", "Aristote","INCONNU", a, "ERF24", 25,"ER3RF");
        CD Orange = new CD("Orange", 3, "TacTac Music", "Oups", "I did it !", a, "ERG", 342);
        Bibliotheque Paris = new Bibliotheque("Cristaline", "Saint-Yorre");
        Paris.ajouterDocument(livreEconomie, 45);
        //Paris.ajouterDocument(livrePhilosophie,23);

        Client Sam = new Client("Sam", "ET3");
        Emprunt entreSam = new Emprunt(23,Sam,Paris);
        entreSam.emprunter(livrePhilosophie);
        System.out.println(Paris.consulterToutDoc());
        //System.out.println(livreEconomie.getClass());

        ArrayList<ArrayList<String>> listTypeDoc = new ArrayList<>();
        ArrayList<String> typeDoc = new ArrayList<>();

        typeDoc.add(livreEconomie.getClass().toString());   // On a ajouté livreEconomie
        typeDoc.add(Integer.toString(1));
        listTypeDoc.add(typeDoc);

        boolean estDedans = false;

        // Collection
        ArrayList<Document> tabDoc = new ArrayList<>();
        tabDoc.add(Orange);
        tabDoc.add(livreEconomie);
        tabDoc.add(livrePhilosophie);
        tabDoc.add(Orange);
        tabDoc.add(livrePhilosophie);
        tabDoc.add(livreEconomie);
        tabDoc.add(livrePhilosophie);


        typeDoc.add(tabDoc.get(0).getClass().toString());
        typeDoc.add(Integer.toString(0));
        listTypeDoc.add(typeDoc);

        for(Document i : tabDoc){
            for(ArrayList<String> dedans : listTypeDoc){
                if(dedans.contains(i.getClass().toString())){  // Si on contient l'élément alors
                    dedans.set(1,Integer.toString(Integer.parseInt(dedans.get(1))+1) );
                    estDedans = true;
                }
            }
            if(estDedans == false){
                System.out.println(typeDoc);
                typeDoc = (ArrayList<String>) typeDoc.clone();
                typeDoc.set(0, i.getClass().toString());
                typeDoc.set(1, Integer.toString(1));
                listTypeDoc.add(typeDoc);
            }
            estDedans = false;
        }

         */
    }

}
