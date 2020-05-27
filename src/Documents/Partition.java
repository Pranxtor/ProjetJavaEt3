package Documents;

import java.util.Date;

public class Partition extends Livre{
    public Partition(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, int nombreExemplaire){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, nombreExemplaire);
    }

    // Constructeur qui prend en compte l'EAN mais pas le numero de série
    public Partition(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, int nombreExemplaire){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, EAN, nombreExemplaire);
    }

    // Constructeur qui prend en compte le numero de série mais pas l'EAN
    public Partition(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, Integer numeroSerie, int nombreExemplaire, Serie serie){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, numeroSerie, nombreExemplaire,serie);
    }

    // Constructeur qui prend tout en compte
    public Partition(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, Integer numeroSerie, int nombreExemplaire, Serie serie){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, EAN, numeroSerie, nombreExemplaire,serie);
    }


    // Constructeur qui prenant en compte l'ISBN
    // Constructeur qui ne prend en compte ni l'EAN ni le numero de série
    public Partition(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, int nombreExemplaire, String ISBN){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, nombreExemplaire,ISBN);
    }

    // Constructeur qui prend en compte l'EAN mais pas le numero de série
    public Partition(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, int nombreExemplaire, String ISBN){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, EAN, nombreExemplaire,ISBN);
    }

    // Constructeur qui prend en compte le numero de série mais pas l'EAN
    public Partition(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, Integer numeroSerie, int nombreExemplaire, String ISBN,Serie serie){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, numeroSerie, nombreExemplaire,ISBN,serie);
    }

    // Constructeur qui prend tout en compte
    public Partition(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, Integer numeroSerie, int nombreExemplaire, String ISBN, Serie serie){
        super(titre, numNotice, editeur, nomAuteur, prenomAuteur, datePublication, EAN, numeroSerie, nombreExemplaire,ISBN,serie);
    }
}
