package Documents;

import java.util.Date;

public abstract class Document{
    private String titre;
    private int numNotice;
    private String editeur;
    private String nomAuteur;
    private String prenomAuteur;
    private String EAN;
    private Date datePublication;
    private int nbExemplaire;
    private Integer numeroSerie;//numero dans la serie
    private Serie serie;

    /**
     * Constructeur qui ne prend en compte ni l'EAN ni le numero de série
     * @param titre titre du document
     * @param numNotice numero de notice
     * @param editeur editeur du document
     * @param nomAuteur nom de l'auteur
     * @param prenomAuteur prenom de l'auteur
     * @param datePublication date de publication de l'oeuvre
     * @param nombreExemplaire nombre d'exemplaire dans la bibliotheque
     */
    public Document(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, int nombreExemplaire){
        this.titre = titre;
        this.numNotice = numNotice;
        this.editeur = editeur;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
        this.datePublication = datePublication;
        this.nbExemplaire = nombreExemplaire;
    }

    // Constructeur qui prend en compte l'EAN mais pas le numero de série

    /**
     * Constructeur qui prend en compte l'EAN mais pas le numero de serie
     * @param titre titre du document
     * @param numNotice numero de notice du document
     * @param editeur editeur du document
     * @param nomAuteur nom de l'auteur
     * @param prenomAuteur prenom de l'auteur
     * @param datePublication date de publication de l'oeuvre
     * @param EAN EAN du document
     * @param nombreExemplaire nombre d'exemplaire dans la bibliotheque
     */
    public Document(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, int nombreExemplaire){
    	this(titre,numNotice,editeur,nomAuteur,prenomAuteur,datePublication,nombreExemplaire);
    	this.EAN = EAN;
    }

    // Constructeur qui prend en compte le numero de série mais pas l'EAN
    public Document(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, Integer numeroSerie, int nombreExemplaire,Serie  serie){
    	this(titre,numNotice,editeur,nomAuteur,prenomAuteur,datePublication,nombreExemplaire);
    	this.numeroSerie = numeroSerie;
    	this.serie=serie;
    }

    // Constructeur qui prend tout en compte
    public Document(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, Integer numeroSerie, int nombreExemplaire,Serie  serie){
    	this(titre,numNotice,editeur,nomAuteur,prenomAuteur,datePublication,nombreExemplaire);
    	this.numeroSerie = numeroSerie;
    	this.serie=serie;
    	this.EAN = EAN;
    }

    public void afficheDoc(){
        System.out.println("Titre : " + titre);
        System.out.println("Numero de notice : " + numNotice);
        System.out.println("Editeur : " + editeur);
        System.out.println("Auteur : " + nomAuteur + " " + prenomAuteur);
        System.out.println("Date de publication : " + datePublication);
        System.out.println("EAN : " + EAN);
    }

    public String getEAN(){
        return this.EAN;
    }

    public String getEditeur(){
        return this.editeur;
    }

    public String getNomAuteur(){
        return this.nomAuteur;
    }

    public String getPrenomAuteur(){
        return this.prenomAuteur;
    }

    public String getTitre(){
        return this.titre;
    }

    public int getNumNotice(){
        return this.numNotice;
    }

    public Date getDatePublication(){
        return this.datePublication;
    }

    public int getNbExemplaire(){
        return this.nbExemplaire;
    }
    
    public Serie getSerie(){
        return this.serie;
    }

    public boolean diminuerQuantite(){
        if(nbExemplaire > 0){
            nbExemplaire = nbExemplaire - 1;
            return true;
        }
        return false;
    }

    public boolean augmenterQuantite(){
        nbExemplaire = nbExemplaire + 1;
        return true;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numNotice;
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
		Document other = (Document) obj;
		if (numNotice != other.numNotice)
			return false;
		return true;
	}
	
	public int compareTo(Document doc) {
		return this.numeroSerie.compareTo(doc.numeroSerie);
	}

    @Override
    public String toString() {
        return titre;
    }
}
