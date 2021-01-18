public class Voler extends Thread{

    private Etat etat;

    public Voler(Etat etat){
        this.etat = etat;
    }

    @Override
    public void run(){
        while(true){
            etat.moveDown();
            try{
                Thread.sleep(30);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
