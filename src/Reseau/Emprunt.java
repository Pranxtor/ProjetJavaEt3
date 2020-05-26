package Reseau;

import Documents.Document;

import java.util.ArrayList;

public class Emprunt {
    private ArrayList<Document> listeEmprunt;
    private int nbLivreMax;
    private Client client;
    private Bibliotheque bibliotheque;

    public Emprunt(int nombreLivreMax, Client client, Bibliotheque bibliotheque){
        this.nbLivreMax = nombreLivreMax;
        listeEmprunt = new ArrayList<>();
        this.client = client;
        this.bibliotheque = bibliotheque;
    }

    public boolean emprunter(Document document){
        if(listeEmprunt.size() < nbLivreMax) {
            //if(/*Si le document se trouve dans la bibliothèque*/){
                listeEmprunt.add(document);
                bibliotheque.emprunter(document);
                return true;
            //}
        }else{
            return false;
        }
    }

    public boolean rendre(Document document){
        if(listeEmprunt.contains(document)){
            bibliotheque.rendre(document);
            return true;
        }
        System.out.println("Vous n'avez pas emprunté ce document");
        return false;
    }


}
