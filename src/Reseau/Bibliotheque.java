package Reseau;

import Documents.*;
import Exception.*;

import java.net.StandardSocketOptions;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Bibliotheque {

    private String nom;
    private String adresse;
    private HashMap<Document,Integer> collection;// document , nombre d'exemplaire
    private HashMap<String, Livre> searchISBN;
    private HashMap<String, Document> searchEAN;
    private HashSet<Client> clients;

    private static HashSet<Bibliotheque> reseauBibliotheque = new HashSet<>();

	/**
	 * Constructeur
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
        reseauBibliotheque.add(this);
    }

	/**
	 * Methode qui permet d'afficher le nom de l'ensemble des bibliotheques du reseau
	 */
    public static void afficheReseau(){
		for(Bibliotheque bibliotheque : reseauBibliotheque){
			System.out.println(bibliotheque.nom);
		}
	}

	/**
	 * Methode qui permet de retrouver une bibliotheque a partir de son nom
	 * @param nom nom de la bibliotheque
	 * @return retourne la bibliotheque si elle existe, null sinon
	 * @throws ExceptionBibliothequeDoesNotExist
	 */
	public static Bibliotheque rechercheBibliotheque(String nom) throws ExceptionBibliothequeDoesNotExist{
		for(Bibliotheque bibliotheque : reseauBibliotheque){
			if(bibliotheque.nom.equals(nom)){
				return bibliotheque;
			}
		}
		throw new ExceptionBibliothequeDoesNotExist();
		//return null;
	}

	/**
	 * Methode qui permet de rechercher a partir de l'EAN
	 * @param EAN Chaine de caractere representant l'EAN
	 * @return Le document associe a l'EAN
	 * @throws ExceptionDocumentDoesntExist
	 */
	public Document rechercheEAN(String EAN) throws ExceptionDocumentDoesntExist {
	   if (searchEAN.containsKey(EAN)) {
		   return searchEAN.get(EAN);
	   }
	   else{
	   		throw new ExceptionDocumentDoesntExist();
		   //return	null;
	   }

    }

	/**
	 * Methode qui permet de rechercher a partir de l'ISBN
	 * @param ISBN Chaine de caractere representant l'ISBN
	 * @return Le document associe a l'ISBN, null s'il n'est pas associe a un document
	 * @throws ExceptionDocumentDoesntExist
	 */
	public Livre rechercheISBN(String ISBN) throws ExceptionDocumentDoesntExist {
	   if (searchISBN.containsKey(ISBN)) {
		   return searchISBN.get(ISBN);
	   }
	   else {
		   throw new ExceptionDocumentDoesntExist();
		   //return	null;
	   }
    }

	/**
	 * Methode qui permet de chercher a partir du nom d'un auteur dans une bibliotheque
	 * @param nom chaine de caractere representant le nom de l'auteur
	 * @return Liste des documents d'un meme auteur
	 */
	public ArrayList<Document> consulter(String nom){
		ArrayList<Document> listeDoc = new ArrayList<>();
		for(Document doc : collection.keySet()){
			if(doc.getNomAuteur().equals(nom)){
				listeDoc.add(doc);
			}
		}
		return  listeDoc;
	}

	/**
	 * Methode qui permet de chercher a partir du prenom d'un auteur dans une bibliotheque
	 * @param prenom chaine de caractere representant le prenom de l'auteur
	 * @return Liste des documents d'un meme auteur
	 */
	public ArrayList<Document> consulterPrenom(String prenom){
		ArrayList<Document> listeDoc = new ArrayList<>();
		for(Document doc : collection.keySet()){
			if(doc.getPrenomAuteur().equals(prenom)){
				listeDoc.add(doc);
			}
		}
		return  listeDoc;
	}

	/**
	 * Methode qui permet de chercher a partir du nom et du prenom de l'auteur dans une bibliotheque
	 * @param nom chaine de caractere representant le nom de l'auteur
	 * @param prenom chaine de caractere representant le prenom de l'auteur
	 * @return Liste des documents d'un meme auteur
	 */
	public ArrayList<Document> consulter(String nom, String prenom){
		ArrayList<Document> listeDoc = new ArrayList<>();
		for(Document doc : collection.keySet()){
			if(doc.getPrenomAuteur().equals(prenom) && doc.getNomAuteur().equals(nom)){
				listeDoc.add(doc);
			}
		}
		return listeDoc;
	}

	/**
	 * Methode qui permet d'obtenir la liste des documents proventant de la meme liste dans la meme bibliotheque
	 * @param titre chaine de caractere representant le titre de la serie de documents
	 * @return Les documents d'une serie tries par date de publication
	 */
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

	/**
	 * Methode qui permet d'obtenir la liste des documents proventant de la meme liste dans tout le reseau
	 * @param titre chaine de caractere representant le titre de la serie de documents
	 * @return Les documents d'une serie tries par date de publication
	 */
	public static ArrayList<Document> consulterSerieReseau(String titre){
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

	/**
	 * Methode qui permet d'obtenir la liste de document paru entre deux dates dans la bibliotheque
	 * @param debut Debut de la periode qui interresse
	 * @param fin Fin de la periode qui interresse
	 * @return Le nombre de documents de chaque type publies entre deux dates
	 * @throws ParseException 
	 */
	public ArrayList<ArrayList<String>> filtreperiode(Date debut, Date fin) throws ParseException{

		ArrayList<ArrayList<String>> listTypeDoc = new ArrayList<>();
		ArrayList<String> typeDoc = new ArrayList<>();

		boolean estDedans = false;

		if(collection.isEmpty()){                            // Si la collection est vide, ne rien faire
			System.out.println("Votre collection est vide");
		}else{						                         // Si la collection n'est pas vide
			for(Document doc : collection.keySet()){ // On parcourt tous les documents
				doc.getDatePublication();
				Date date = new SimpleDateFormat("yyyy").parse(doc.getDatePublication());
				if(date.after(debut) && date.before(fin)){ // Si on est compris dans la periode
					if(listTypeDoc.isEmpty()){                // Dans le cas ou on itere pour la premiere fois, on initialise a la main
						typeDoc.add(doc.getClass().toString());
						typeDoc.add(Integer.toString(1));
						listTypeDoc.add(typeDoc);
						System.out.println(typeDoc);
					}else{
						for(ArrayList<String> type : listTypeDoc){ // En parcourant la liste de type de documents deja connu
							if(type.contains(doc.getClass().toString())){ // Si le type de documents est deja dans la liste de type de document
								type.set(1, Integer.toString(Integer.parseInt(type.get(1))+1));
								estDedans = true;
								System.out.println(typeDoc);
							}
						}
						if(!estDedans){  // Si on a parcouru toute la liste de types de documents deja connu mais que le type n'est pas connu

							typeDoc =(ArrayList<String>) typeDoc.clone();
							typeDoc.set(0, doc.getClass().toString());
							typeDoc.set(1, Integer.toString(1));
							listTypeDoc.add(typeDoc);
							System.out.println(typeDoc);
						}
					}
					estDedans = false;
				}
			}
		}
		return listTypeDoc;
	}

	/**
	 * Methode qui permet d'obtenir la liste de document paru entre deux dates dans le reseau
	 * @param debut Debut de la periode qui interresse
	 * @param fin Fin de la periode qui interresse
	 * @return Le nombre de documents de chaque type publies entre deux dates
	 * @throws ParseException 
	 */
	public static ArrayList<ArrayList<String>> filtreperiodeReseau(Date debut, Date fin) throws ParseException{
		ArrayList<ArrayList<String>> filtre = new ArrayList<>();
		ArrayList<ArrayList<String>> intermediaire = new ArrayList<>();
		ArrayList<String> inter = new ArrayList<>();
		boolean estDedans = false;

		for(Bibliotheque biblio : reseauBibliotheque){ // Dans tout le reseau
			intermediaire = biblio.filtreperiode(debut, fin);
			for(ArrayList<String> tab : intermediaire){ // Dans chaque bibliotheque
				for(ArrayList<String> final_tab : filtre){
					if(final_tab.contains(tab.get(0))){ // Si le filtre contient deja le type de document
						final_tab.set(filtre.indexOf(tab), Integer.toString(Integer.parseInt(tab.get(1)) + Integer.parseInt(final_tab.get(1))) );
						estDedans = true;
					}
				}
				if(!estDedans){ // Si le filtre ne contient pas le type de document
					filtre.add((ArrayList<String>) tab.clone());
				}
				estDedans = false;
			}
		}
    	return filtre;
	}

	/**
	 * Methode qui permet de chercher a partir du nom d'un auteur dans le reseau
	 * @param nom chaine de caractere representant le nom de l'auteur
	 * @return Liste des documents d'un meme auteur
	 */
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

	/**
	 * Methode qui permet de chercher a partir du nom et du prenom de l'auteur dans une bibliotheque
	 * @param nom chaine de caractere representant le nom de l'auteur
	 * @param prenom chaine de caractere representant le prenom de l'auteur
	 * @return Liste des documents d'un meme auteur
	 */
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

	/**
	 * Methode qui permet de chercher a partir du prenom d'un auteur dans une bibliotheque
	 * @param prenom chaine de caractere representant le prenom de l'auteur
	 * @return Liste des documents d'un meme auteur
	 */
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

	/**
	 * Methode qui permet d'echanger un document entre deux bibliotheques
	 * @param biblio la bibliotheque avec qui on echange
	 * @param doc le document que l'on veut echanger
	 * @return true si l'echange a ete fait, false sinon
	 */
	public boolean echangeDocument(Bibliotheque biblio, Document doc) {
		boolean estFait;
		if(biblio.collection.containsKey(doc) && this.collection.containsKey(doc)){//si les 2 bibliotheque contiaennt le doc
			biblio.collection.replace(doc,biblio.collection.get(doc)+1);
			if(this.collection.get(doc)-1==0) {//si le document etait en un seul exemplaire
				this.searchEAN.remove(doc.getEAN());//on l'enleve de la collection des EAN
				this.collection.remove(doc);//on enleve le doc de la bibliotheque
				if(doc instanceof Livre)//si le doc est un livre
					this.searchISBN.remove(((Livre) doc).getISBN());//on l'enleve de la collection des ISBN
			}
			else
			{
				this.collection.replace(doc, this.collection.get(doc)-1);//on enleve un exemplaire du doc de la bibliotheque
			}
			
			estFait = true;
		}
		else{
			if(this.collection.containsKey(doc)) {//si seulemtn la premiere biblioteque contient le doc
				biblio.ajouterDocument(doc, 1);
				if(this.collection.get(doc)-1==0) {//si le document etait en un seul exemplaire
					this.collection.remove(doc);//on enleve le doc de la bibliotheque
					this.searchEAN.remove(doc.getEAN());//on l'enleve de la collection des EAN
					if(doc instanceof Livre)//si le doc est un livre
						this.searchISBN.remove(((Livre) doc).getISBN());//on l'enleve de la collection des ISBN
				}
				else
				{
					this.collection.replace(doc, this.collection.get(doc)-1);//on enleve un exemplaire du doc de la bibliotheque
				}
				estFait = true;
			}
			else //si la bibliotheque ne contient pas le document
				estFait = false;
			
		}
		return estFait;
	}

	/**
	 * Methode qui permet d'ajouter un document a notre bibliotheque
	 * @param doc document que l'on veut ajouter
	 * @param nbExemplaire le nombre d'exemplaire ajoute
	 * @return true si l'ajout a ete fait, false sinon
	 */
    public boolean ajouterDocument(Document doc,Integer nbExemplaire) {
    	Livre livre = null;
    	if(!collection.containsKey(doc)) {//if the Bibliotheque doesn t contain the doc
    		if(doc.getEAN()==null) {//if doc doesn t have an EAN
    			if(doc instanceof Livre) {//if doc is a Livre
    				livre = (Livre)doc;
            		if(livre.getISBN()==null) {//if doc doesn t have an ISBN
            			collection.put(doc,nbExemplaire);
            		}
            		else {
            			if(!searchISBN.containsKey(livre.getISBN())) {//if this ISBN doesn t exist
                			searchISBN.put(((Livre) doc).getISBN(), (Livre)doc);//bd, carte etc
            				collection.put(livre,nbExemplaire);
            			}
            			else //if this ISBN already exists
            				return false;
            		}
    			}
    			else//if doc isn t a livre
    				collection.put(doc,nbExemplaire);
    		}
    		else {//if doc has an EAN
    			if(!searchEAN.containsKey(doc.getEAN())) {//if this EAN doesn t exist
    				if(doc instanceof Livre) {//if doc is a Livre
        				livre = (Livre)doc;
                		if(livre.getISBN()==null) {//if doc doesn t have an ISBN
                			searchEAN.put(doc.getEAN(), doc);
                			collection.put(doc,nbExemplaire);
                		}
                		else {
                			if(!searchISBN.containsKey(livre.getISBN())) {//if this ISBN doesn t exist
                				collection.put(livre,nbExemplaire);
                				searchISBN.put(((Livre) doc).getISBN(), (Livre)doc);//bd ...
                				searchEAN.put(doc.getEAN(), doc);
                			}
                			else //if this ISBN already exists
                				return false;
                		}
        			}
    				else{//if doc isn t a livre
    					collection.put(doc,nbExemplaire);
    					searchEAN.put(doc.getEAN(), doc);
    				}
    					
    					
    			}
    			else//if this EAN already exists
    				return false;
    		}	
    	}
    	else{//if the Bibliotheque contains the doc
    		for(int i = 0 ; i<nbExemplaire; i++) {
    			doc.augmenterQuantite();
    		}
    		collection.replace(doc,collection.get(doc)+nbExemplaire);
    	}
    	return true;
    }

	/**
	 * Methode qui ajoute un client dans la bibliotheque
	 * @param nouveau le nouveau client
	 * @return true si l'ajout a ete fait, false sinon
	 */
	public boolean ajouterClient(Client nouveau){
    	boolean dedans;
    	if(clients.contains(nouveau)){
			dedans = false;
		}
    	else{
			clients.add(nouveau);
			dedans = true;
    	}
    	return dedans;
	}

	/**
	 * Methode qui permet a un client d'emprunter un document dans la bibliotheque
	 * @param doc le document a emprunter
	 * @return true si l'emprunt a ete fait, false sinon
	 */
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

	/**
	 * Methode qui permet a un client de rendre un document dans la bibliotheque
	 * @param doc le document a rendre
	 * @return true si le rendu a ete fait, false sinon
	 */
	public boolean rendre(Document doc) {
    	if(collection.containsKey(doc)) {//if the Bibliotheque contains the doc
    		collection.replace(doc,collection.get(doc)+1);
    		return true;
    	}
    	else//if the Bibliotheque doesn t contain the doc
    		return false;
    }

	/**
	 * Methode qui permet de consulter tous les documents de la bibliotheque
	 * @return Liste de tous les documents de la bibliotheque
	 */
	public ArrayList<Document> consulterToutDoc() {
    	ArrayList<Document> docs= new ArrayList<Document>();
    	System.out.println(nom);
    	System.out.println(collection);
    	for(Document doc : collection.keySet()) {
    		docs.add(doc);
    	}
    	return docs;
    }

	/**
	 * Methode qui permet de consulter tous les documents du reseau
	 * @return Liste de tous les documents de la bibliotheque
	 */
    public static ArrayList<Document> consulterToutDocReseau(){
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
