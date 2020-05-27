package Reseau;

import Documents.Document;
import Documents.Livre;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
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
        searchEAN = new HashMap<>();
        clients = new HashSet<>();
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
		   return searchISBN.get(EAN);
	   }
	   else
		   return	null;
    }

    public ArrayList<Document> consulter(String nom){
		ArrayList<Document> listeDoc = new ArrayList<>();
		for(Document doc : collection.keySet()){
			if(doc.getNomAuteur() == nom){
				listeDoc.add(doc);
			}
		}
		return  listeDoc;
	}

	public ArrayList<Document> consulterPrenom(String prenom){
		ArrayList<Document> listeDoc = new ArrayList<>();
		for(Document doc : collection.keySet()){
			if(doc.getPrenomAuteur() == prenom){
				listeDoc.add(doc);
			}
		}
		return  listeDoc;
	}

	public ArrayList<Document> consulter(String nom, String prenom){
		ArrayList<Document> listeDoc = new ArrayList<>();
		for(Document doc : collection.keySet()){
			if(doc.getPrenomAuteur() == prenom && doc.getNomAuteur() == nom){
				listeDoc.add(doc);
			}
		}
		return listeDoc;
	}

/*
	// Renvoie les documents d'une série triés par date de publication
	public ArrayList<Document> consulterSerie(String titre){
		
	}
 */

	// Renvoie le nombre de documents de chaque type publiés entre deux dates
	public ArrayList<ArrayList<String>> filtreperiode(Date debut, Date fin){
		ArrayList<ArrayList<String>> listTypeDoc = new ArrayList<>();
		ArrayList<String> typeDoc = new ArrayList<>();
		boolean estDedans = true;

		for(Document doc : collection.keySet()){ // On parcourt tous les documents
			if(doc.getDatePublication().after(debut) && doc.getDatePublication().before(fin)){ // Si on est compris dans la période

				for(ArrayList<String> type : listTypeDoc){ // En parcourant la liste de type de documents déjà connu
					if(!type.contains(doc.getClass().toString())){ // Si le type de documents n'est pas déjà dans la liste de type de document
						estDedans = false;

					}else{ // Si le type de documents est déjà dans la liste de type de document
						type.set(1,Integer.toString(Integer.parseInt(type.get(1))+1) );
						estDedans = true;
					}
				}

				if(!estDedans){ // Si le type de documents n'est pas déjà dans la liste de type de document
					// TODO ajouter le type dans la liste listTypeDoc avec un nombre de 1 (en string)
				}
			}
		}
		return listTypeDoc;
	}

	public static ArrayList<Document> consulterReseau(String nom){
    	ArrayList<Document> listDoc = new ArrayList<>();
    	ArrayList<Document> listIntermediaire = new ArrayList<>();
    	for(Bibliotheque bibliotheque : reseauBibliotheque){
			listIntermediaire = bibliotheque.consulter(nom);
    		for(Document doc : listIntermediaire){
    			listDoc.add(doc);
			}
		}
    	return listDoc;
	}

	public static ArrayList<Document> consulterReseau(String nom, String prenom){
		ArrayList<Document> listDoc = new ArrayList<>();
		ArrayList<Document> listIntermediaire = new ArrayList<>();
		for(Bibliotheque bibliotheque : reseauBibliotheque){
			listIntermediaire = bibliotheque.consulter(nom,prenom);
			for(Document doc : listIntermediaire){
				listDoc.add(doc);
			}
		}
		return listDoc;
	}

	public static ArrayList<Document> consulterPrenomReseau(String prenom){
		ArrayList<Document> listDoc = new ArrayList<>();
		ArrayList<Document> listIntermediaire = new ArrayList<>();
		for(Bibliotheque bibliotheque : reseauBibliotheque){
			listIntermediaire = bibliotheque.consulterPrenom(prenom);
			for(Document doc : listIntermediaire){
				listDoc.add(doc);
			}
		}
		return listDoc;
	}

	public boolean echangeDocument(Bibliotheque biblio, Document doc){
		boolean estFait;
		if(biblio.collection.containsKey(doc) && this.collection.containsKey(doc)){
			biblio.collection.replace(doc,biblio.collection.get(doc)+1);
			this.collection.replace(doc, this.collection.get(doc)-1);
			estFait = true;
		}
		else
			estFait = false;
		return estFait;
	}

    public boolean ajouterDocument(Document doc,Integer nbExemplaire) {//moi
    	if(!collection.containsKey(doc)) {//if the Bibliotheque doesn t contain the doc
    		collection.put(doc,nbExemplaire);
        	if(doc instanceof Livre)//if doc is a Livre
        		searchISBN.put(((Livre) doc).getISBN(), (Livre)doc);
        	if(doc.getEAN()!=null)//if doc have an EAN
        		searchEAN.put(doc.getEAN(), doc);
    	}
    	else{//if the Bibliotheque contains the doc
    		for(int i = 0 ; i<nbExemplaire; i++) {
    			doc.augmenterQuantite();
    		}
    		collection.replace(doc,collection.get(doc)+nbExemplaire);
    	}
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
    	if(collection.containsKey(doc)) {//if the Bibliotheque contains the doc
    		if(collection.get(doc)>0) {//if there is no doc available in the Bibliotheque
    			collection.replace(doc,collection.get(doc)-1);
    			return true;
    		}
    		else {//if the Bibliotheque doesn t contain the doc
        		return false;
    		}
    	}
    	else
    		return false;
    }
    
    public boolean rendre(Document doc) {
    	if(collection.containsKey(doc)) {//if the Bibliotheque contains the doc
    		collection.replace(doc,collection.get(doc)+1);
    		return true;
    	}
    	else//if the Bibliotheque doesn t contain the doc
    		return false;
    }
    
    public ArrayList<Document> consulterToutDoc() {
    	ArrayList<Document> docs= new ArrayList<Document>();
    	for(Document doc : collection.keySet()) {
    		docs.add(doc);
    	}
    	return docs;
    }

    public ArrayList<Document> consulterToutDocReseau(){
		ArrayList<Document> docs = new ArrayList<>();
		ArrayList<Document> listIntermediaire = new ArrayList<>();
		for(Bibliotheque bibliotheque : reseauBibliotheque){
			listIntermediaire = bibliotheque.consulterToutDoc();
			for(Document document : listIntermediaire){
				docs.add(document);
			}
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
