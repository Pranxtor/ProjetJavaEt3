package Reseau;

import Documents.Document;

import java.util.ArrayList;

public class Emprunt {
    private ArrayList<Document> listeEmprunt;
    private int nbLivreMax;

    public Emprunt(int nombreLivreMax){
        this.nbLivreMax = nombreLivreMax;
        listeEmprunt = new ArrayList<>();
    }



}
