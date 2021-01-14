import java.awt.desktop.SystemEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control extends Modele implements ActionListener{

   private Etat etat;
   private Affichage vue;
   private Modele modele;

   public Control(Etat e){
       etat = e;
   }
}
