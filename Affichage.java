
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.*;


public class Affichage extends JPanel{
    public static final int LARG = 600;
    public static final int HAUT = 400;
    private int saut = 10; 

    public Affichage(){
        setPreferredSize(new Dimension(LARG, HAUT));
    }


    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawOval(50,this.saut,20,20);
    }

   

}
