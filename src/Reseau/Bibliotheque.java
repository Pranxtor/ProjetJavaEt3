package Reseau;

import Documents.Document;
import Documents.Livre;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Comparator;
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

	/** Constructeur
	 *
	 * @param nom Nom de la bibliotheque
	 * @param adresse Adresse de la bibliotheque
	 */
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


	// Renvoie les documents d'une série triés par date de publication
	public ArrayList<Document> consulterSerie(String titre){
		ArrayList<Document> serie = new ArrayList<>();
		for(Document doc : collection.keySet()){
			if(doc.getSerie().getTitre().contentEquals(titre) ){
				serie.add(doc);
			}
		}
		
		Comparator<Document> comp = new Comparator<Document>(){ 
		  public int compare(Document a, Document b) 
		    { 
			  return a.compareTo(b);
		    } 
		 };
		java.util.Collections.sort(serie, comp);
		
		return serie;
	}

	public ArrayList<Document> consulterSerieReseau(String titre){
    	ArrayList<Document> serie = new ArrayList<>();
		ArrayList<Document> intermediaire = new ArrayList<>();

    	for(Bibliotheque biblio : reseauBibliotheque){
    		intermediaire = biblio.consulterSerie(titre);
    		for(Document i : intermediaire){
    			if(!serie.contains(i)){
    				serie.add(i);
				}
			}
		}
    	return serie;
	}

	// Renvoie le nombre de documents de chaque type publiés entre deux dates
	public ArrayList<ArrayList<String>> filtreperiode(Date debut, Date fin){

		ArrayList<ArrayList<String>> listTypeDoc = new ArrayList<>();
		ArrayList<String> typeDoc = new ArrayList<>();

		boolean estDedans = false;

		if(collection.isEmpty()){   // Si la collection est vide, ne rien faire
			System.out.println("Votre collection est vide");
		}else{						// Si la collection n'est pas vide
			typeDoc.add(collection.get(0).getClass().toString());  // On inplémente une partie
			typeDoc.add(Integer.toString(0));
			listTypeDoc.add(typeDoc);

			for(Document doc : collection.keySet()){ // On parcourt tous les documents
				if(doc.getDatePublication().after(debut) && doc.getDatePublication().before(fin)){ // Si on est compris dans la période

					for(ArrayList<String> type : listTypeDoc){ // En parcourant la liste de type de documents déjà connu
						if(type.contains(doc.getClass().toString())){ // Si le type de documents est déjà dans la liste de type de document
							type.set(1, Integer.toString(Integer.parseInt(type.get(1))+1));
							estDedans = true;
						}
					}
					if(!estDedans){  // Si on a parcouru toute la liste de types de documents déjà connu mais que le type n'est pas connu
						typeDoc =(ArrayList<String>) typeDoc.clone();
						typeDoc.set(0, doc.getClass().toString());
						typeDoc.set(1, Integer.toString(1));
						listTypeDoc.add(typeDoc);
					}
					estDedans = false;
				}
			}
		}
		return listTypeDoc;
	}

	public static ArrayList<ArrayList<String>> filtreperiodeReseau(Date debut, Date fin){
		ArrayList<ArrayList<String>> filtre = new ArrayList<>();
		ArrayList<ArrayList<String>> intermediaire = new ArrayList<>();
		ArrayList<String> inter = new ArrayList<>();
		boolean estDedans = false;

		for(Bibliotheque biblio : reseauBibliotheque){ // Dans tout le réseau
			intermediaire = biblio.filtreperiode(debut, fin);
			for(ArrayList<String> tab : intermediaire){ // Dans chaque bibliothèque
				for(ArrayList<String> final_tab : filtre){
					if(final_tab.contains(tab.get(0))){ // Si le filtre contient déjà le type de document
						final_tab.set(filtre.indexOf(tab), Integer.toString(Integer.parseInt(tab.get(1)) + Integer.parseInt(final_tab.get(1))) );
						estDedans = true;
					}
				}
				if(!estDedans){  // Sinon
					filtre.add((ArrayList<String>) tab.clone());
				}
				estDedans = false;
			}
		}
    	return filtre;
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
