package Documents;

public class Revue extends Document {/**
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
     */
	public Revue(String titre, String editeur, String nomAuteur, String prenomAuteur, String EAN, String datePublication, int nombreExemplaire, Integer numeroSerie, Serie  serie){
        super(titre, editeur, nomAuteur, prenomAuteur, EAN, datePublication, nombreExemplaire, numeroSerie, serie);
    }
}
