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
        String debut;
        String fin;
        boolean fait;

        do{
            java.util.Scanner in = new Scanner(System.in);

            System.out.println("Choisissez parmi ces options");

            System.out.println("1. Ajouter une nouvelle bibliotheque");
            System.out.println("2. Ajouter un nouveau document dans le reseau"); // TODO
            System.out.println("3. Ajouter un nouvel utilisateur"); // Ok
            System.out.println("4. Consulter tous les documents");
            System.out.println("5. Consulter les documents d'une serie");
            System.out.println("6. Consulter les documents d'un auteur");
            System.out.println("7. Rechercher un livre par son ISBN");
            System.out.println("8. Rechercher un document par son EAN");
            System.out.println("9. Consulter le nombre de documents publies sur une periode");  // TODO DATES !
            // TODO ajouter des fonctionnalités pour emprunter ou rendre un document
            System.out.println("10. Emprunter ou rendre un document pour un client");

            selection = in.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Donner le nom de la bibliotheque");
                    nom = in.next();
                    System.out.println("Donner l'adresse de la bibliotheque");
                    adresse = in.next();

                    Bibliotheque biblio = new Bibliotheque(nom,adresse);
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
                    nom = in.next();
                    //rechercheBibliotheque(nom).ajouterDocument(doc);
                    break;

                case 3:
                    System.out.println("Entrer le nom de l'utilisateur");
                    nom = in.next();
                    System.out.println("Entrer le prenom");
                    prenom = in.next();
                    Client client = new Client(nom, prenom);

                    System.out.println("Dans quel bibliotheque voulez vous l'inscrire parmi cette liste de bibliotheque ? \nEcirvez le nom de la bibliotheque");
                    afficheReseau();
                    nom = in.next();
                    fait = client.inscrire(rechercheBibliotheque(nom));
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

                    }else if(selection == 2){

                    }else if(selection == 3){

                    }
                    break;

                case 5:
                    System.out.println("Entrer le titre de la serie");
                    nom = in.next();

                    break;

                case 6:

                    break;

                case 7:
                    break;

                case 8:
                    System.out.println("8. Rechercher un document par son EAN");


                    break;

                case 9:
                    System.out.println("Voulez vous le faire une bibliotheque particuliere ou dans le reseau ?");
                    System.out.println("1. Reseau");
                    System.out.println("2. Bibliotheque");
                    selection = in.nextInt();

                    if(selection == 1){
                        System.out.println("Donner la date de debut sous la forme : JJ/MM/AA");
                        debut = in.next();
                        System.out.println("Donner la date de fin sous la forme : JJ/MM/AA");
                        fin = in.next();
                        // TODO trouver un moyen pour les dates
                        //filtreperiodeReseau(debut, fin);
                    }else if(selection == 2){
                        System.out.println("Parmi la liste des bibliotheques, laquelle choisissez vous ?");
                        afficheReseau();
                        nom = in.next();

                        System.out.println("Donner la date de debut sous la forme : JJ/MM/AA");
                        debut = in.next();
                        System.out.println("Donner la date de fin sous la forme : JJ/MM/AA");
                        fin = in.next();
                        // TODO trouver un moyen pour les dates
                        //rechercheBibliotheque(nom).filtreperiode(debut, fin);
                    }else{
                        System.out.println("Mauvaise selection, retour au menu principal");
                    }


                    break;
                case 10 :
                    System.out.println("Quel est le nom de votre client ?");

                    System.out.println("Quel est le document que vous voulez rendre ?");

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
