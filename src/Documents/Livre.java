package Documents;

import java.util.Date;

public class Livre extends Document{
    private String ISBN;

    public Livre(String titre, String editeur, String nomAuteur, String prenomAuteur, String EAN, String datePublication, int nombreExemplaire, Integer numeroSerie, Serie  serie, String ISBN){
        super(titre, editeur, nomAuteur, prenomAuteur, EAN, datePublication, nombreExemplaire, numeroSerie, serie);
        this.ISBN = ISBN;
    }

    public String getISBN() {
    	return ISBN;
    }
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		if (this.getTitre() != other.getTitre())
			return false;
		if(this.getEAN()!=null&&other.getEAN()!=null)
			if(this.getEAN() != other.getEAN())
				return false;
		if(this.getISBN() != other.getISBN())
			return false;
		return true;
	}
}
