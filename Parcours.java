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

    public int getPositionX(){
        return this.positionX;
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

    public ArrayList<Point> getParcours(){
        ArrayList<Point> copie = this.listePoints;
        for (Point point : copie){
            point.move(point.x - taille, point.y );
        }
        return copie;
    }

    public boolean gagner(Point p1, Point p2){
        float pente = (p2.y - p1.y )/ (p2.x - p1.y); 
        float y = p1.y - pente *(p1.x - this.parcours.getPositionX());
        if()
        return false;
    }
    
    /** 
    public void moveRight(){
        int x; 
        int y;
        for (int i = 0; i < this.getTailleListePoints()-1; i++ ){
            x = (int) (this.getPoint(i).getX() -  taille);
            y = (int) (this.getPoint(i).getY());
            this.setPoint(i,new Point(x,y));
        }
    }
    */ 

    public ArrayList<Point> moveRight(){
        ArrayList<Point> tab = this.listePoints; 
        for(Point p : tab){
            p.move(p.x-5, p.y );
        }
        Random r = new Random();
        int x = tab.get(getTailleListePoints()-1).x; 
        while(x < Affichage.LARG + 50){
            x = x+r.nextInt(100);
            Point p = new Point(x,r.nextInt(200) + this.getTailleListePoints());
            tab.add(p);
        }
        return tab; 
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
