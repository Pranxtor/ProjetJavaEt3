package Documents;

import java.util.Date;

public class JeuxVideo extends Jeux {
    public JeuxVideo(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, int nombreExemplaire){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, nombreExemplaire);
    }
    
    public JeuxVideo(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, int nombreExemplaire){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, EAN, nombreExemplaire);
    }
    
    public JeuxVideo(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, Integer numeroSerie, int nombreExemplaire,Serie  serie){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, numeroSerie, nombreExemplaire,serie);
    }
    
    public JeuxVideo(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, Integer numeroSerie, int nombreExemplaire,Serie  serie){
    	super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, numeroSerie, nombreExemplaire,serie);
    }
}
