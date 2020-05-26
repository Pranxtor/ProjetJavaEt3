package Documents;

import java.util.Date;

public class Livre extends Document{
    private String ISBN;

    public Livre(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, int nombreExemplaire, String ISBN){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, EAN, nombreExemplaire);
    }

    public String getISBN(){
        return this.ISBN;
    }
}
