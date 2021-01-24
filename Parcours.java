import java.awt.Point;
import java.util.ArrayList;
import java.util.Random; 

public class Parcours{

        public static final int longueurMinLigne= 70;
        public static final int longueurMaxLigne = 200;
        public static final int bordureMinLigne = 100;
        public static final int bordureMaxLigne = Affichage.HAUT - 100;
        public static final int plage = bordureMaxLigne - bordureMinLigne;
        public static final int taille = 5;

        private ArrayList<Point> listePoints;
        private Point positionDepart;
        private int positionX; 

    public int getTailleListePoints(){
        return this.listePoints.size();
    }

    public ArrayList<Point> getListePoints(){
        return this.listePoints;
    }

    public Point getPoint(int i){
        return this.listePoints.get(i);
    }

    public void setPositionX(int i){
        this.positionX = this.positionX + i;
    }

    public void addPointInvisible(){
        if((int) this.getPoint(this.getTailleListePoints()-1).getX() < Affichage.LARG+30){
            int x = (int) this.getPoint(this.getTailleListePoints()-1).getX();
            Random r = new Random();
            x = x + r.nextInt(longueurMaxLigne - longueurMinLigne) + 20; 
            int y = (r.nextInt(plage) + bordureMinLigne);
            this.listePoints.add(new Point(x,y));
        }
    }

    public void removePointInvisible(){
        if(this.getPoint(0).getX() <0 && this.getPoint(1).getX() < 0){
            this.getListePoints().remove(0);
        }
    }

    public Parcours(){

    
        this.positionX = Affichage.X;
        this.listePoints = new ArrayList<Point>();
        this.positionDepart = new Point(Affichage.X /**+ Affichage.LARGEUROVAL/2 */ , Affichage.Y /**+ Affichage.LONGUEUROVAL/2 */);
        this.listePoints.add(positionDepart);

        int x = (int) (positionDepart.getX());
        int y = (int) (positionDepart.getY());
        Random r = new Random();

        while(x < Affichage.LARG + 50){
            x = x + r.nextInt(longueurMaxLigne - longueurMinLigne) + 20;
            y = (r.nextInt(plage) + bordureMinLigne); 
            Point newPoint = new Point(x,y);
            listePoints.add(newPoint);
        }

    }
}
    /**
   
     
    public ArrayList<Point> getParcours() {
        ArrayList<Point> copie = listePoints ;
        for (Point point:
             copie) {
            point.move(point.x-positionDepart, point.y);
        }
        return copie;
    }

    public setParcours(){

    }
    */

