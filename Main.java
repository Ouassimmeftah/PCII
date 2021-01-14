import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;


public class Main {
    public static void main(String[] args) {

        JFrame fenetre = new JFrame("flappy bird");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setPreferredSize(new Dimension(600,400));

        Affichage affichage = new Affichage();
    
        fenetre.add(new Affichage());

        fenetre.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                affichage.Saut();
            }
        });

        

        fenetre.pack();
        fenetre.setVisible(true);
        
    }
}