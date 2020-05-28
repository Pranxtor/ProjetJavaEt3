package Reseau;

import java.util.ArrayList;

public class Client {
    private String nom;
    private String prenom;
    private ArrayList<Bibliotheque> bibliotheque;


    /**
     * Constructeur
     * @param surname prenom du client
     * @param name nom du client
     */
    public Client(String surname, String name){
        nom = surname;
        prenom = name;
        bibliotheque = new ArrayList<>();
    }

    /**
     * Methode qui permet d'inscrire le client a une bibliotheque
     * @param nom nom de la bibliotheque
     * @return true si l'inscription est faite, false sinon
     */
    public boolean inscrire(Bibliotheque nom){
        return nom.ajouterClient(this);
    }

    /**
     * Methode qui permet de verifier si le client est inscrit a une bibliotheque
     * @param bibliotheque la bibliotheque que l'on veut verifier
     * @return true si le client est inscrit a la bibliotheque, false sinon
     */
    public boolean estInscrit(Bibliotheque bibliotheque){
        return this.bibliotheque.contains(bibliotheque);
    }

}
