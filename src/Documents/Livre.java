package Documents;

import java.util.Date;

public class Livre extends Document{
    private String ISBN;

    // Constructeur ne prenant pas en compte l'ISBN
    // Constructeur qui ne prend en compte ni l'EAN ni le numero de série
    public Livre(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, int nombreExemplaire){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, nombreExemplaire);
    }

    // Constructeur qui prend en compte l'EAN mais pas le numero de série
    public Livre(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, int nombreExemplaire){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, EAN, nombreExemplaire);
    }

    // Constructeur qui prend en compte le numero de série mais pas l'EAN
    public Livre(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, Integer numeroSerie, int nombreExemplaire){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, numeroSerie, nombreExemplaire);
    }

    // Constructeur qui prend tout en compte
    public Livre(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, Integer numeroSerie, int nombreExemplaire){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, EAN, numeroSerie, nombreExemplaire);
    }


    // Constructeur qui prenant en compte l'ISBN
    // Constructeur qui ne prend en compte ni l'EAN ni le numero de série
    public Livre(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, int nombreExemplaire, String ISBN){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, nombreExemplaire);
        this.ISBN = ISBN;
    }

    // Constructeur qui prend en compte l'EAN mais pas le numero de série
    public Livre(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, int nombreExemplaire, String ISBN){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, EAN, nombreExemplaire);
        this.ISBN = ISBN;
    }

    // Constructeur qui prend en compte le numero de série mais pas l'EAN
    public Livre(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, Integer numeroSerie, int nombreExemplaire, String ISBN){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, numeroSerie, nombreExemplaire);
        this.ISBN = ISBN;
    }

    // Constructeur qui prend tout en compte
    public Livre(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, Integer numeroSerie, int nombreExemplaire, String ISBN){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, EAN, numeroSerie, nombreExemplaire);
        this.ISBN = ISBN;
    }



    public String getISBN(){
        return this.ISBN;
    }
}
