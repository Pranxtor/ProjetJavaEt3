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
                return true;
            //}
        }else{
            return false;
        }
    }

    public boolean rendre(Document document){
        if(listeEmprunt.isEmpty()){
            return false;
        }else if(listeEmprunt.contains(document)){
            return true;
        }
        return false;
    }


}
