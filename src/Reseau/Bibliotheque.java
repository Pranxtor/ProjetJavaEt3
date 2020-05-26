package Reseau;

import Documents.Document;
import Documents.Livre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bibliotheque {

    private String nom;
    private String adresse;
    private HashSet<Document> collection;
    private HashMap<String, Livre> searchISBN;
    private HashSet<Client> clients;

    private static HashSet<Bibliotheque> reseauBibliotheque;

    public Bibliotheque(String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
        collection = new HashSet<>();
        searchISBN = new HashMap<>();
    }
    
    public boolean ajouterDocument(Document doc) {
    	collection.add(doc);
    	return true;
    }
    
    public boolean emprunter(Document doc) {
    	boolean emprunt ;
    	if(collection.contains(doc)) {
    		emprunt = doc.diminuerQuantite();
    	}
    	else
    		emprunt = false;
    	return emprunt;
    }
    
    public boolean rendre(Document doc) {
    	boolean retour ;
    	if(collection.contains(doc)) {
    		retour = doc.augmenterQuantite();
    	}
    	else
    		retour = false;
    	return retour;
    }
    
    public ArrayList<Document> consulterToutDoc() {
    	ArrayList<Document> docs= new ArrayList<Document>();
    	for(Document doc : collection) {
    		docs.add(doc);
    	}
    	return docs;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bibliotheque other = (Bibliotheque) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
    
    




}
