package Documents;

import java.util.Date;

public class JeuxSociete extends Jeux {
	public JeuxSociete(String titre, String editeur, String nomAuteur, String prenomAuteur, String EAN, String datePublication, int nombreExemplaire, Integer numeroSerie, Serie  serie){
        super(titre, editeur, nomAuteur, prenomAuteur, EAN, datePublication, nombreExemplaire, numeroSerie, serie);
    }
}
