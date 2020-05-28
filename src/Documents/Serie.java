package Documents;

import java.util.ArrayList;

public class Serie {
    private String titre;
    private ArrayList<Document> serie;

    /**
     * Constructeur
     * @param titre titre de la serie
     */
    public Serie(String titre){
        this.titre = titre;
        serie = new ArrayList<>();
    }
    
    public String getTitre() {
    	return titre;
    }

}
