/*
 */
package examen2labp2_davidoliva;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author DAVIDANDRESOLIVAHERN
 */
public class HiloCarro2 extends Thread{
        Carro carro;
    JProgressBar carro1;
    JProgressBar carro2;

    public HiloCarro2() {
    }

    public HiloCarro2(Carro carro, JProgressBar carro1, JProgressBar carro2) {
        this.carro = carro;
        this.carro1 = carro1;
        this.carro2 = carro2;
    }
    
    @Override
    public void run() {
        boolean iniciar=true;
        int Anvansar = 0;
        while (iniciar)
        {
            if (carro1.getValue() >= 100)
            {
                iniciar = false;
            } else if (carro2.getValue() >= 100)
            {
                JOptionPane.showMessageDialog(null, "Gano el carro 2");
                iniciar = false;
            }
            Anvansar++;
            carro2.setValue(Anvansar);
            try
            {
                Thread.sleep(carro.getVelocidad());
            } catch (InterruptedException ex)
            {
            }
        }
    }
}
