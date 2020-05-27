package Documents;

import java.util.Date;

public class Vinyle extends Document {
    public Vinyle(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, int nombreExemplaire){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, nombreExemplaire);
    }
    
    public Vinyle(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, int nombreExemplaire){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, EAN, nombreExemplaire);
    }
    
    public Vinyle(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, Integer numeroSerie, int nombreExemplaire,Serie  serie){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, numeroSerie, nombreExemplaire,serie);
    }
    
    public Vinyle(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, Integer numeroSerie, int nombreExemplaire,Serie  serie){
    	super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, numeroSerie, nombreExemplaire,serie);
    }
}
