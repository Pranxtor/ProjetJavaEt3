package Documents;

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

    /**
     * retourne l'EAN du livre
     * @return l'EAN du livre
     */
    public String getEAN(){
        return this.EAN;
    }

    /**
     * retourne l'editeur du document
     * @return l'editeur du livre
     */
    public String getEditeur(){
        return this.editeur;
    }

    /**
     * retourne l'editeur du document
     * @return l'editeur du livre
     */
    public String getNomAuteur(){
        return this.nomAuteur;
    }

    /**
     * retourne l'editeur du document
     * @return l'editeur du livre
     */
    public String getPrenomAuteur(){
        return this.prenomAuteur;
    }

    /**
     * retourne l'editeur du document
     * @return l'editeur du livre
     */
    public String getTitre(){
        return this.titre;
    }

    /**
     * retourne l'editeur du document
     * @return l'editeur du livre
     */
    public String getDatePublication(){
        return this.datePublication;
    }

    /**
     * retourne l'editeur du document
     * @return l'editeur du livre
     */
    public int getNbExemplaire(){
        return this.nbExemplaire;
    }
    
    /**
     * retourne l'editeur du document
     * @return l'editeur du livre
     */
    public Serie getSerie(){
        return this.serie;
    }

    /**
     * retourne l'editeur du document
     * @return l'editeur du livre
     */
    public boolean diminuerQuantite(){
        if(nbExemplaire > 0){
            nbExemplaire = nbExemplaire - 1;
            return true;
        }
        return false;
    }

    /**
     * retourne l'editeur du document
     * @return l'editeur du livre
     */
    public boolean augmenterQuantite(){
        nbExemplaire = nbExemplaire + 1;
        return true;
    }

    
    /**
     * @inheritDoc
     */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + titre.hashCode()+((EAN==null)?"":EAN).hashCode() ;
		return result;
	}

	/**
     * @inheritDoc
     */
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

	/**
	 * @inheritDoc
	 */
    @Override
    public String toString() {
        return titre;
    }
}
