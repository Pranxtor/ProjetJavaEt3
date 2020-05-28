package Documents;

import java.util.Date;

public abstract class Document{
    private String titre;
    private String editeur;
    private String nomAuteur;
    private String prenomAuteur;
    private String EAN;
    private String datePublication;
    private int nbExemplaire;
    private Integer numeroSerie;//numero dans la serie
    private Serie serie;

    /**
     * Constructeur qui ne prend en compte ni l'EAN ni le numero de serie
     * @param titre titre du document
     * @param editeur
     * @param nomAuteur
     * @param prenomAuteur
     * @param EAN
     * @param datePublication
     * @param nombreExemplaire
     * @param numeroSerie
     * @param serie
     */
    public Document(String titre, String editeur, String nomAuteur, String prenomAuteur, String EAN, String datePublication, int nombreExemplaire, Integer numeroSerie, Serie  serie){
        this.titre = titre;
        this.editeur = editeur;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
        if(EAN != null)
        	this.EAN = EAN;
        this.datePublication = datePublication;
        this.nbExemplaire = nombreExemplaire;
        if(numeroSerie != null)
        	this.numeroSerie = numeroSerie;
        if(serie != null)
        	this.serie=serie;
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

    public String getDatePublication(){
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
		result = prime * result + titre.hashCode()+((EAN==null)?"":EAN).hashCode() ;
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
		if (titre != other.titre)
			return false;
		if(EAN!=null&&other.EAN!=null)
			if(EAN != other.EAN)
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
