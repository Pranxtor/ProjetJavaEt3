package Documents;

public abstract class Document{
    private String titre;
    private String editeur;
    private String nomAuteur;
    private String prenomAuteur;
    private String EAN;
    private String datePublication;
    private int nbExemplaire;
    private Integer numeroSerie;
    private Serie serie;

    /**
     * Constructeur qui ne prend en compte ni l'EAN ni le numero de serie
     * @param titre titre du document
     * @param editeur editeur du document
     * @param nomAuteur nom de l'auteur du document
     * @param prenomAuteur prenom de l'auteur du docuemnt
     * @param EAN EAN du document
     * @param datePublication date de publication du document
     * @param nombreExemplaire nombre d'exemplaire du document
     * @param numeroSerie numero dans la serie du document
     * @param serie serie du document
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

    /**
     * retourne l'EAN du document
     * @return l'EAN du document
     */
    public String getEAN(){
        return this.EAN;
    }

    /**
     * retourne l'editeur du document
     * @return l'editeur du document
     */
    public String getEditeur(){
        return this.editeur;
    }

    /**
     * retourne le nom du document
     * @return le nom du document
     */
    public String getNomAuteur(){
        return this.nomAuteur;
    }

    /**
     * retourne prenom du document
     * @return prenom du document
     */
    public String getPrenomAuteur(){
        return this.prenomAuteur;
    }

    /**
     * retourne le titre du document
     * @return le titre du document
     */
    public String getTitre(){
        return this.titre;
    }

    /**
     * retourne date de publication du document
     * @return date de publication  du document
     */
    public String getDatePublication(){
        return this.datePublication;
    }

    /**
     * retourne le nombre d'exemplaire du document
     * @return le nombre d'exemplaire du document
     */
    public int getNbExemplaire(){
        return this.nbExemplaire;
    }
    
    /**
     * retourne la serie du document
     * @return la serie du document
     */
    public Serie getSerie(){
        return this.serie;
    }

    /**
     * diminue la quantite du document
     * @return vrai si l'operation s'est bien passe
     */
    public boolean diminuerQuantite(){
        if(nbExemplaire > 0){
            nbExemplaire = nbExemplaire - 1;
            return true;
        }
        return false;
    }

    /**
     * augmente la quantite du document
     * @return vrai si l'operation s'est bien passe
     */
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

	/**
     * @deprecated inutile depuis le toString
     */
    public void afficheDoc(){
        System.out.println("Titre : " + titre);
        System.out.println("Editeur : " + editeur);
        System.out.println("Auteur : " + nomAuteur + " " + prenomAuteur);
        System.out.println("Date de publication : " + datePublication);
        System.out.println("EAN : " + EAN);
        System.out.println("type : " + this.getClass());
    }

    @Override
	public String toString() {
		return "Document [titre=" + titre + ", editeur=" + editeur + ", nomAuteur=" + nomAuteur + ", prenomAuteur="
				+ prenomAuteur + ", EAN=" + EAN + ", datePublication=" + datePublication + ", nbExemplaire="
				+ nbExemplaire + ", numeroSerie=" + numeroSerie + ", serie=" + serie.getTitre() + "]";
	}

	/**
     * compare le document avec un autre document
     * @param doc le document avec lequel on compare
     * @return un entier negatif, zero, ou un entier positif si le document
     * est inferieur, egale ou supereur que le document passe en parametre
     */
	public int compareTo(Document doc) {
		return this.numeroSerie.compareTo(doc.numeroSerie);
	}


}
