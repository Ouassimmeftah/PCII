
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;



public class Affichage extends JPanel{

    public static final int LARG = 600;
    public static final int HAUT = 400;
    public static final int X = 20;
    public static final int Y = 60;
    public static final int LARGEUROVAL = 50;
    public static final int LONGUEUROVAL = 80;

    private Etat etat;

    public Affichage(Etat e){
        this.etat = e;
        setPreferredSize(new Dimension(LARG, HAUT));
    }

    /** getter/setter classiques */

    public Etat getModele(){
        return this.etat;
    }

    /** méthode paint pour l'affichage */

    @Override
    public void paint(Graphics g){
        super.paint(g);
        super.revalidate();
        super.repaint();
        g.drawOval(X,this.etat.getHauteur(),LARGEUROVAL,LONGUEUROVAL);
    }

   

}
