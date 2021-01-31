import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;



public class Affichage extends JPanel{

    public static final int LARG = 600;
    public static final int HAUT = 400;
    public static final int X = 20;
    public static final int Y = 100;
    public static final int LARGEUROVAL = 50;
    public static final int LONGUEUROVAL = 80;

    private JFrame fenetre;
    private ImageIcon img;
    private JLabel background;

    private Etat etat;
    private Parcours ligne;

    public Affichage(Etat e, Parcours l){
        
        this.etat = e;
        this.ligne= l; 
        setPreferredSize(new Dimension(LARG, HAUT));
        //image = ImageIO.read(new File("C:\Users\ouass\Downloads\fondXP.jpg"));

        img = new ImageIcon("fondXP.jpg");
        background = new JLabel("",img,JLabel.CENTER);
        background.setSize(LARG,HAUT);;
        fenetre.add(background);
        //initialiser();
    }

    /** getter/setter classiques */

    public Etat getModele(){
        return this.etat;
    }

    public Parcours getLigne(){
        return this.ligne; 
    }

    /** méthode paint pour l'affichage */

    @Override
    public void paint(Graphics g){
        super.paint(g);
        super.revalidate();
        super.repaint();

        paintOval(g);
        paintLigne(g);
    }

    /** affichage de l'ovale */
    public void paintOval(Graphics g){
        g.setColor(Color.red);
        g.drawOval(X,this.etat.getHauteur(),LARGEUROVAL,LONGUEUROVAL);
    }

    /** affichage de la ligne */
    public void paintLigne(Graphics g){
        g.setColor(Color.BLACK);
        for(int i =0; i<this.ligne.getTailleListePoints()-1;i++){
            g.drawLine( (int) this.ligne.getPoint(i).getX(), 
            (int) this.ligne.getPoint(i).getY(),
            (int) this.ligne.getPoint(i+1).getX(), 
            (int) this.ligne.getPoint(i+1).getY() );
        }
    }
   

}
