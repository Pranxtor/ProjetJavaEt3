package Documents;

import java.util.Date;

public class Carte extends Livre {
	public Carte(String titre, String editeur, String nomAuteur, String prenomAuteur, String EAN, String datePublication, int nombreExemplaire, Integer numeroSerie, Serie  serie, String ISBN){
        super(titre, editeur, nomAuteur, prenomAuteur, EAN, datePublication, nombreExemplaire, numeroSerie, serie, ISBN);
    }
}
