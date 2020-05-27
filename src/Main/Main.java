package Main;

import Documents.*;
import Reseau.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Reseau.Bibliotheque.afficheReseau;

public class Main {
    public static void main(String[] args){
        int selection;
        String nom;
        String prenom;
        String adresse;

        do{
            java.util.Scanner in = new Scanner(System.in);

        System.out.println("Choisissez parmi ces options");

        System.out.println("1. Ajouter une nouvelle bibliotheque");
        System.out.println("2. Ajouter un nouveau document dans le reseau");
        System.out.println("3. Ajouter un nouvel utilisateur");
        System.out.println("4. Consulter tous les documents");
        System.out.println("5. Consulter les documents d'une serie");
        System.out.println("6. Consulter les documents d'un auteur");
        System.out.println("7. Rechercher un livre par son ISBN");
        System.out.println("8. Rechercher un document par son EAN");
        System.out.println("9. Consulter le nombre de documents publies sur une periode");

        selection = in.nextInt();

        switch (selection) {
            case 1:

                System.out.println("Donner le nom de la bibliotheque");
                nom = in.next();
                System.out.println("Donner l'adresse de la bibliotheque");
                adresse = in.next();
                Bibliotheque biblio = new Bibliotheque(nom,adresse);
                //afficheReseau();
                break;
            case 2:
                //Document doc = new Document();
                // J'attends d'avoir ton push pour le faire
                break;
            case 3:
                System.out.println("Entrer le nom de l'utilisateur");
                nom = in.next();
                System.out.println("Entrer le prenom");
                prenom = in.next();
                Client client = new Client(nom, prenom);
                System.out.println("Dans quel bibliotheque voulez vous l'inscrire ?");
                // TODO

                break;
            case 4:
                System.out.println("1. Retour au menu");
                System.out.println("2. Consulter dans une bibliotheque");
                System.out.println("3. Consulter dans le reseau");
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

                break;
            case 9:
                String date;
                System.out.println("Donner le debut de la periode souhaitee sous la forme : JJ/MM/AA");
                date = in.next();

                break;
            default:
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
