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

    public String getEditeur(){
        return this.editeur;
    }

    public String getNomAuteur(){
        return this.nomAuteur;
    }

    public String getPrenomAuteur(){
        return this.prenomAuteur;
    }

    public String getTitre(){
        return this.titre;
    }

    public int getNumNotice(){
        return this.numNotice;
    }

    public Date getDatePublication(){
        return this.datePublication;
    }

    public int getNbExemplaire(){
        return this.nbExemplaire;
    }

    public boolean diminuerQuantite(){
        if(nbExemplaire > 0){
            nbExemplaire = nbExemplaire - 1;
            return true;
        }
        return false;
    }

    public boolean augmenterQuantite(){
        nbExemplaire = nbExemplaire + 1;
        return true;
    }
}
