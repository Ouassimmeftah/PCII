import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Affichage extends JPanel {

    private static final long serialVersionUID = 1L;
    public static final int LARG = 600;
    public static final int HAUT = 400;
    public static final int X = 20;
    public static final int Y = 100;
    public static final int LARGEUROVAL = 50;
    public static final int LONGUEUROVAL = 80;
    public static boolean boucle = true;
    private BufferedImage img;
    private Etat etat;
    private Parcours ligne;

    public Affichage(Etat e, Parcours l) throws IOException {

        this.etat = e;
        this.ligne = l;
        setPreferredSize(new Dimension(LARG, HAUT));

        img = ImageIO.read(new File("fondXP.jpg"));

        // image = ImageIO.read(new File("C:\Users\ouass\Downloads\fondXP.jpg"));
        /**
         * img = new ImageIcon("fondXP.jpg"); background = new
         * JLabel("",img,JLabel.CENTER); background.setSize(LARG,HAUT);;
         * fenetre.add(background);
         * 
         * initialiser();
         */
    }

    /** getter/setter classiques */

    public Etat getModele() {
        return this.etat;
    }

    public Parcours getLigne() {
        return this.ligne;
    }

    /** méthode paint pour l'affichage */

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        super.revalidate();
        super.repaint();

        Graphics2D g2 = (Graphics2D) g;

        g.drawImage(img, 0, 0, LARG, HAUT, null);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        paintOval(g);
        paintLigne(g);
    }

    /** affichage de l'ovale */
    public void paintOval(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(X, this.etat.getHauteur(), LARGEUROVAL, LONGUEUROVAL);
    }

    /** affichage de la ligne */
    public void paintLigne(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i < this.ligne.getTailleListePoints() - 1; i++) {
            g.drawLine((int) this.ligne.getPoint(i).getX(), (int) this.ligne.getPoint(i).getY(),
                    (int) this.ligne.getPoint(i + 1).getX(), (int) this.ligne.getPoint(i + 1).getY());
        }
    }

}
