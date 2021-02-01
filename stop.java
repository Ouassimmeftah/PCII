import javax.swing.JOptionPane;

public class stop extends Thread {
    private Etat etat;

    public stop(Etat etat) {
        this.etat = etat;
    }

    @Override
    public void run() {
        while (Affichage.boucle) {
            if (etat.testPerdu()) {
                JOptionPane.showMessageDialog(null, "score :", "Game over", JOptionPane.PLAIN_MESSAGE);
                Affichage.boucle = false;
            }
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
