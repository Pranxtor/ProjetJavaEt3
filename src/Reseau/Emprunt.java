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




}
