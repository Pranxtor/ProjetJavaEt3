package Reseau;

import Documents.Document;
import Documents.Livre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Bibliotheque {

    private String nom;
    private String adresse;
    private HashMap<Document,Integer> collection;//document,nombre d'exemplaire
    private HashMap<String, Livre> searchISBN;
    private HashMap<String, Document> searchEAN;
    private HashSet<Client> clients;

    private static HashSet<Bibliotheque> reseauBibliotheque;

    public Bibliotheque(String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
        collection = new HashMap<>();
        searchISBN = new HashMap<>();
    }
    
   public Document rechercheEAN(String EAN) {
	   if (searchEAN.containsKey(EAN)) {
		   return searchEAN.get(EAN);
	   }
	   else
		   return	null;
    }
   
   public Livre rechercheISBN(String EAN) {
	   if (searchISBN.containsKey(EAN)) {
		   return searchEAN.get(EAN);
	   }
	   else
		   return	null;
    }
    
    public boolean ajouterDocument(Document doc,Integer nbExemplaire) {
    	if(!collection.containsKey(doc)) {//if the Bibliotheque doesn't contain the doc
    		collection.put(doc,nbExemplaire);
        	if(doc instanceof Livre)//if doc is a Livre
        		searchISBN.put(((Livre) doc).getISBN(), (Livre)doc);
        	if(doc.getEAN()!=null)//if doc have an EAN
        		searchEAN.put(doc.getEAN(), doc);
    	}
    	else//if the Bibliotheque contains the doc
    		doc.augmenterQuantite();
    	return true;
    }

    public boolean ajouterClient(Client nouveau){
    	boolean dedans;
    	if(clients.contains(nouveau)){
			clients.add(nouveau);
    		dedans = true;
		}
    	else
			dedans = false;
    	return dedans;
	}

    public boolean emprunter(Document doc) {
    	boolean emprunt ;
    	if(collection.containsKey(doc)) {
    		emprunt = doc.diminuerQuantite();
    		return true;
    	}
    	else
    		return false;
    }
    
    public boolean rendre(Document doc) {
    	boolean retour ;
    	if(collection.containsKey(doc)) {
    		retour = doc.augmenterQuantite();
    	}
    	else
    		retour = false;
    	return retour;
    }
    
    public ArrayList<Document> consulterToutDoc() {
    	ArrayList<Document> docs= new ArrayList<Document>();
    	for(Document doc : collection.keySet()) {
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
