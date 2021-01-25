public class Avancer extends Thread {
    public static final int tempsAvancer = 200;

    private Parcours parcours; 
    
    public Avancer(Parcours p ){
        this.parcours = p;
    }

    public void setParcours(Parcours p){
        this.parcours = p;
    }
    
    public Parcours getParcours(){
        return this.parcours;
    }

    @Override
    public void run(){
        while(true){
            
            try{
                parcours.getParcours();
                parcours.removePointInvisible();
                parcours.addPointInvisible();
                Thread.sleep(tempsAvancer);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
