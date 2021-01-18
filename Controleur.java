import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class Controleur implements MouseListener{

   private Etat etat;

   public Controleur(Etat e){
       this.etat = e;
   }

   public Etat getEtat(){
       return this.etat;
   }

   /** Bug sur mouse released qui ne fait pas correctement tomber l'ovale quand on relache le bouton souris  */

   @Override
   public void mouseClicked(MouseEvent e){
        this.etat.jump();
   }
   @Override
   public void mousePressed(MouseEvent e){
       
   }

   @Override
   public void mouseEntered(MouseEvent e){

   }

   @Override
   public void mouseExited(MouseEvent e){

   }
   @Override
   public void mouseReleased(MouseEvent e){
        
   }

}
