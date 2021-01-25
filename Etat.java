
public class Etat {
    
    private Affichage affichage;
    private int hauteur ;
    private Parcours parcours; 
    private int hauteurMAX; 
    private int taille; 
    public static final int tailleSaut = 15;
    public static final int tailleChute = 5;

    // Affichage a
    public Etat(int h, Parcours parcours){
        this.hauteur = h;
        this.parcours = parcours;
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
    

    public void initialiser(int x, Affichage aff){
        hauteurMAX = x; 
        taille = x/5; 
        affichage = aff; 
        Avancer avancer = new Avancer(parcours);
        avancer.start();
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
