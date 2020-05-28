package Documents;

import java.util.Date;

public class Partition extends Livre{
	public Partition(String titre, String editeur, String nomAuteur, String prenomAuteur, String EAN, String datePublication, int nombreExemplaire, Integer numeroSerie, Serie  serie, String ISBN){
        super(titre, editeur, nomAuteur, prenomAuteur, EAN, datePublication, nombreExemplaire, numeroSerie, serie, ISBN);
    }
}
