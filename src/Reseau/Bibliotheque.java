package Reseau;

import Documents.Document;
import Documents.Livre;

import java.util.HashMap;
import java.util.HashSet;

public class Bibliotheque {

    private String nom;
    private String adresse;
    private HashSet<Document> collection;
    private HashMap<String, Livre> searchISBN;

    private static HashSet<Bibliotheque> reseauBibliotheque;

    public Bibliotheque(String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
        collection = new HashSet<>();
        searchISBN = new HashMap<>();
    }




}
