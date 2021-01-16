import javax.sound.sampled.Control;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;


public class Main {
    public static void main(String[] args) {

        JFrame fenetre = new JFrame("flappy bird");
        
        Etat etat = new Etat(200);

        Affichage affichage = new Affichage(etat);
    
        fenetre.add(affichage);

        fenetre.addMouseListener(new Controleur(etat));

        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}