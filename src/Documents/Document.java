package Documents;

import java.util.Date;

public abstract class Document {
    private String titre;
    private int numNotice;
    private String editeur;
    private String nomAuteur;
    private String prenomAuteur;
    private String EAN;
    private Date datePublication;
    private int nbExemplaire;
    private Integer numeroSerie;//numero dans la serie

    // Constructeur qui ne prend en compte ni l'EAN ni le numero de série
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
    public Document(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, int nombreExemplaire){
    	this(titre,numNotice,editeur,nomAuteur,prenomAuteur,datePublication,nombreExemplaire);
    	this.EAN = EAN;
    }

    // Constructeur qui prend en compte le numero de série mais pas l'EAN
    public Document(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, Integer numeroSerie, int nombreExemplaire){
    	this(titre,numNotice,editeur,nomAuteur,prenomAuteur,datePublication,nombreExemplaire);
    	this.numeroSerie =numeroSerie;
    }

    // Constructeur qui prend tout en compte
    public Document(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, Integer numeroSerie, int nombreExemplaire){
    	this(titre,numNotice,editeur,nomAuteur,prenomAuteur,datePublication,nombreExemplaire);
    	this.numeroSerie = numeroSerie;
    	this.EAN = EAN;
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

    @Override
    public String toString() {
        return titre;
    }
}
