import javax.swing.JOptionPane;

public class stop extends Thread {
    private Etat etat;

    public stop() {
        this.etat = etat;
    }

    @Override
    public void run() {
        while (true) {
            if (etat.testPerdu()) {
                JOptionPane.showMessageDialog(null, "score :", "Game over", JOptionPane.PLAIN_MESSAGE);
            }
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
