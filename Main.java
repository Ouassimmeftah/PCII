import javax.swing.*;

public class Main {
    public static void main(String[] args) {

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