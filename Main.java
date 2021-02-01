import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        JFrame fenetre = new JFrame("flappy bird");

        Parcours ligne = new Parcours();

        Etat etat = new Etat(200, ligne);

        Affichage affichage = new Affichage(etat, ligne);

        Voler v = new Voler(etat);
        v.start();

        fenetre.add(affichage);

        fenetre.addMouseListener(new Controleur(etat));

        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}