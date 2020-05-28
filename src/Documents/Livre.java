package Documents;

public class Livre extends Document{
    private String ISBN;

    /**
     * Constructeur
     * @param titre titre de la serie
     * @param editeur nom de l'editeur
     * @param nomAuteur nom de l'auteur
     * @param prenomAuteur prenom de l'auteur
     * @param EAN EAN du document
     * @param datePublication date de publication du document
     * @param nombreExemplaire nombre d'exemplaire du document
     * @param numeroSerie numero dans la serie du document
     * @param serie serie du document
     * @param ISBN ISBN du document
     */
    public Livre(String titre, String editeur, String nomAuteur, String prenomAuteur, String EAN, String datePublication, int nombreExemplaire, Integer numeroSerie, Serie  serie, String ISBN){
        super(titre, editeur, nomAuteur, prenomAuteur, EAN, datePublication, nombreExemplaire, numeroSerie, serie);
        this.ISBN = ISBN;
    }

    /**
     * retourne l'ISBN du livre
     * @return l'ISBN du livre
     */
    public String getISBN() {
    	return ISBN;
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
		Livre other = (Livre) obj;
		if (this.getTitre() != other.getTitre())
			return false;
		if(this.getEAN()!=null&&other.getEAN()!=null)
			if(this.getEAN() != other.getEAN())
				return false;
		if(this.getISBN() != other.getISBN())
			return false;
		return true;
	}
}
