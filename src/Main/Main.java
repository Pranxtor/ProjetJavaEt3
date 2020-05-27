package Main;

import Documents.*;
import Reseau.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args){
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
/*
        typeDoc.add(livreEconomie.getClass().toString());   // On a ajouté livreEconomie
        typeDoc.add(Integer.toString(1));
        listTypeDoc.add(typeDoc);
 */

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


    }



}
