import javax.swing.*;
import java.io.File;
import java.io.IOException;

// classe main avec throw exception pour imageIO
public class Main {
    public static void main(String[] args) throws IOException {

        JFrame fenetre = new JFrame("flappy bird");

        Parcours ligne = new Parcours();

        Etat etat = new Etat(200, ligne);

        Affichage affichage = new Affichage(etat, ligne);

        // thread pour utiliser periodiquement la methode moveDown

        Voler v = new Voler(etat);
        v.start();

        // thread pour la methode de collision et la fenetre d'arret
        (new Thread(new stop(etat))).start();

        // methodes pour la fenetre

        fenetre.add(affichage);

        fenetre.addMouseListener(new Controleur(etat));

        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}