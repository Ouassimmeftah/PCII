public class Etat {
    
    //private Affichage affichage;
    private int hauteur ;
    private Parcours parcours; 
    public static final int tailleSaut = 10;
    public static final int tailleChute = 5;

    // Affichage a
    public Etat(int h){
        this.hauteur = h;
        //this.affichage = a;
        (new Thread(new Voler(this))).start();
        (new Thread(new Avancer(parcours))).start();
    }

    /** getter/setter classiques */

    public int getHauteur() {
        return this.hauteur;
    }

    public void setHauteur(int x){
        this.hauteur = x;
        
    }

    /** jump() qui sert a faire un saut sur l'écran */

    public void jump(){
        if (this.getHauteur() < Affichage.HAUT && this.getHauteur() > 0){
            this.setHauteur(this.hauteur-tailleSaut);
        } else {
            System.out.println("Attention ca monte");
        }
            
    }

    /** Tentative de codage d'une pseudo gravité 

    public void gravite(){
        if(this.getHauteur()< Affichage.HAUT && this.getHauteur() > 0){
            this.setHauteur(this.hauteur+tailleSaut);
        } else{
            System.out.println("Attention ca tombe");
        }

    }
    */

    public void moveDown(){
        int hauteurBas = this.getHauteur() + Affichage.LONGUEUROVAL; 
        if(hauteurBas < Affichage.HAUT){
            this.setHauteur(this.hauteur+tailleChute);
            
        } else{
            System.out.println("Attention ca tombe");
        }
        
    }
    
}
