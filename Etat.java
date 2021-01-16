public class Etat {
    
    private int hauteur ;
    public static final int tailleSaut = 10;
    
    public Etat(int h){
        this.hauteur = h;
    }

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

    /** Tentative de codage d'une pseudo gravité */

    public void gravite(){
        if(this.getHauteur()< Affichage.HAUT && this.getHauteur() > 0){
            this.setHauteur(this.hauteur+tailleSaut);
        } else{
            System.out.println("Attention ca tombe");
        }

    }
    
}
