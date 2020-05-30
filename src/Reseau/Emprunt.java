package Reseau;

import Documents.Document;

import java.util.ArrayList;

public class Emprunt {
    private ArrayList<Document> listeEmprunt;
    private int nbLivreMax;
    private Client client;
    private Bibliotheque bibliotheque;

    /**
     * Constructeur
     * @param nombreLivreMax nombre de livre maximum accorde au client
     * @param client le client qui profite de l'emprunt
     * @param bibliotheque bibliotheque qui prete le document
     */
    public Emprunt(int nombreLivreMax, Client client, Bibliotheque bibliotheque){
        if(!client.estInscrit(bibliotheque)){
            System.out.println("Le client a ete inscrit !");
            bibliotheque.ajouterClient(client);
            client.inscrire(bibliotheque);
        }
        this.nbLivreMax = nombreLivreMax;
        listeEmprunt = new ArrayList<>();
        this.client = client;
        this.bibliotheque = bibliotheque;
    }

    /**
     * Methode qui permet d'emprunter un document
     * @param document le document que le client veut emprunter
     * @return true si l'emprunt a ete fait, false sinon
     */
    public boolean emprunter (Document document){
        if(listeEmprunt.size() < nbLivreMax && bibliotheque.emprunter(document)) {
            listeEmprunt.add(document);
            System.out.println("Le document est dans la bibliothèque");
            return true;
        }
        System.out.println("Le document n'est pas dans la bibliothèque");
        return false;
    }

    
    public Client getClient(){
        return client;
    }

    public Bibliotheque getBibliotheque(){
        return bibliotheque;
    }

    /**
     * Methode qui permet de rendre un document
     * @param document le document que le client veut rendre
     * @return true si le rendu a ete fait, false sinon
     */
    public boolean rendre(Document document){
        if(listeEmprunt.contains(document)){
            bibliotheque.rendre(document);
            return true;
        }
        System.out.println("Vous n'avez pas emprunte ce document");
        return false;
    }


}
