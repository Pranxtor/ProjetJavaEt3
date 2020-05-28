package Documents;

import java.util.Date;

public class Livre extends Document{
    private String ISBN;

    public Livre(String titre, String editeur, String nomAuteur, String prenomAuteur, String EAN, String datePublication, int nombreExemplaire, Integer numeroSerie, Serie  serie, String ISBN){
        super(titre, editeur, nomAuteur, prenomAuteur, EAN, datePublication, nombreExemplaire, numeroSerie, serie);
        this.ISBN = ISBN;
    }

    public String getISBN() {
    	return ISBN;
    }
}
