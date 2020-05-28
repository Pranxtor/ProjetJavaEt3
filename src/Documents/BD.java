package Documents;

public class BD extends Livre {
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
	public BD(String titre, String editeur, String nomAuteur, String prenomAuteur, String EAN, String datePublication, int nombreExemplaire, Integer numeroSerie, Serie  serie, String ISBN){
        super(titre, editeur, nomAuteur, prenomAuteur, EAN, datePublication, nombreExemplaire, numeroSerie, serie, ISBN);
    }
}
