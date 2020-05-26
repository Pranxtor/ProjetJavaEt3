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
            //if(/* fonction pour savoir si le document est présent dans la bibliotheque*/){
                listeEmprunt.add(document);
                // Fonction pour diminuer de 1 la quantité de ce document dans la bibliothèque
                return true;
            //}
        }else{
            return false;
        }
    }

    public boolean rendre(Document document){
        if(listeEmprunt.contains(document)){
            // ajouter le document dans la bibliothèque
            return true;
        }
        System.out.println("Vous n'avez pas emprunté ce document");
        return false;
    }


}
