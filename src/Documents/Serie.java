package Documents;

import java.util.ArrayList;

public class Serie {
    private String titre;
    private ArrayList<Document> serie;

    // constructeur
    public Serie(String titre){
        this.titre = titre;
    }
    
    public String getTitre() {
    	return titre;
    }

}
