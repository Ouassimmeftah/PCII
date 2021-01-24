public class Voler extends Thread{

    public static int tempsVol = 200;
    private Etat etat;

    public Voler(Etat etat){
        this.etat = etat;
    }

    public void setEtat(Etat e){
        this.etat = e; 
    }

    @Override
    public void run(){
        while(true){
            
            try{
                etat.moveDown();
                Thread.sleep(tempsVol);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
