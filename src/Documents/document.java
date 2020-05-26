package Documents;

import java.util.Date;

public abstract class Document {
    private String titre;
    private int numNotice;
    private String editeur;
    private String nomAuteur;
    private String prenomAuteur;
    private String EAN;
    private Date datePublication;
    private int nbExemplaire;

    public Document(String titre, int numNotice, String editeur, String nomAuteur, String prenomAuteur, Date datePublication, String EAN, int nombreExemplaire){
        this.titre = titre;
        this.numNotice = numNotice;
        this.editeur = editeur;
        this.nomAuteur = nomAuteur;
        this.prenomAuteur = prenomAuteur;
        this.datePublication = datePublication;
        this.EAN = EAN;
        this.nbExemplaire = nombreExemplaire;
    }

    public String getEAN(){
        return this.EAN;
    }

}
