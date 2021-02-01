public class Voler extends Thread {

    // tempsVol qui permet de reguler la retombee de l'ovale

    public static int tempsVol = 320;
    private Etat etat;

    // constructeur

    public Voler(Etat etat) {
        this.etat = etat;
    }

    /** getter/setter classiques */

    public void setEtat(Etat e) {
        this.etat = e;
    }

    // utilisation periodique de la methode de gravite
    @Override
    public void run() {
        while (true) {

            try {
                etat.moveDown();
                Thread.sleep(tempsVol);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
