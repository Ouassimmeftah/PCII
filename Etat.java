import java.util.ArrayList;
import java.awt.Point;

public class Etat {

    private Affichage affichage;
    private int hauteur;
    private Parcours parcours;
    private int hauteurMAX;
    private int taille;
    public static final int tailleSaut = 15;
    public static final int tailleChute = 5;

    // Constructeur etat
    public Etat(int h, Parcours parcours) {
        this.hauteur = h;
        this.parcours = parcours;
        // this.affichage = a;
        (new Thread(new Voler(this))).start();
        (new Thread(new Avancer(parcours))).start();
    }

    /** getter/setter classiques */

    public int getHauteur() {
        return this.hauteur;
    }

    public void setHauteur(int x) {
        this.hauteur = x;
    }

    public ArrayList<Point> getParcours() {
        return parcours.getParcours();
    }

    /** jump() qui sert a faire un saut sur l'écran */

    public void jump() {
        if (this.getHauteur() < Affichage.HAUT && this.getHauteur() > 0) {
            this.setHauteur(this.hauteur - tailleSaut);
        } else {
            System.out.println("Attention ca monte");
        }

    }

    /**
     * Tentative de codage d'une pseudo gravité
     * 
     * public void gravite(){ if(this.getHauteur()< Affichage.HAUT &&
     * this.getHauteur() > 0){ this.setHauteur(this.hauteur+tailleSaut); } else{
     * System.out.println("Attention ca tombe"); }
     * 
     * }
     * 
     * 
     * public void initialiser(int x, Affichage aff){ hauteurMAX = x; taille = x/5;
     * affichage = aff; Avancer avancer = new Avancer(parcours); avancer.start(); }
     */

    // methode de gravite de l'ovale
    public void moveDown() {
        int hauteurBas = this.getHauteur() + Affichage.LONGUEUROVAL;
        if (hauteurBas < Affichage.HAUT) {
            this.setHauteur(this.hauteur + tailleChute);

        } else {
            System.out.println("Attention ca tombe");
        }

    }

    // methode qui mets en place les collisions et leur detections
    public boolean testPerdu() {
        Point p1 = getParcours().get(0);
        Point p2 = getParcours().get(1);
        float pente = ((p1.y) - (p2.y)) / ((float) (p1.x) - (float) (p2.x));
        float y = p1.y - pente * (p1.x - Affichage.LARGEUROVAL - 20);

        if (y < hauteur || y > hauteur + Affichage.LONGUEUROVAL) {
            return true;
        }

        return false;
    }

}
