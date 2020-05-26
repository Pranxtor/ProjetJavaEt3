package Main;

import Documents.*;
import Reseau.*;

import java.util.Date;

public class Main {
    public static void main(String[] args){
        Date a = new Date();
        Livre livreEconomie = new Livre("Economie", 314, "Polytech", "Henriot","Marie Christine", a, "ERF4324", 25,"ER3RFAZ");
        Livre livrePhilosophie = new Livre("Philo", 14, "Polytech", "Aristote","INCONNU", a, "ERF24", 25,"ER3RF");
        Bibliotheque Paris = new Bibliotheque("Cristaline", "Saint-Yorre");
        //Paris.ajouterDocument(livreEconomie);
        //Paris.ajouterDocument(livrePhilosophie);

        Client Sam = new Client("Sam", "ET3");
        Emprunt entreSam = new Emprunt(23,Sam,Paris);
        entreSam.emprunter(livrePhilosophie);
        System.out.println(Paris.consulterToutDoc());
    }
}
