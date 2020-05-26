package Reseau;

import java.util.ArrayList;

public class Client {
    private String nom;
    private String prenom;
    private ArrayList<Bibliotheque> bibliotheque;

    // Consutructeur
    public Client(String surname, String name){
        nom = surname;
        prenom = name;
        bibliotheque = new ArrayList<>();
    }

    public boolean inscrire(Bibliotheque nom){
        return nom.ajouterClient(this);
    }

    public boolean estInscrit(Bibliotheque bibliotheque){
        return this.bibliotheque.contains(bibliotheque);
    }

}
