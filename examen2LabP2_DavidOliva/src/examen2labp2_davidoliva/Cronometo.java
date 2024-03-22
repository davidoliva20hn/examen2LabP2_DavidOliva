/*
 */
package examen2labp2_davidoliva;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author DAVIDANDRESOLIVAHERN
 */
public class Cronometo extends Thread {

    JLabel Tiempo;
    Carro carro1;
    Carro carro2;
    JProgressBar JPcarro1;
    JProgressBar JPcarro2;

    public Cronometo() {
    }

    public Cronometo(JLabel Tiempo, Carro carro1, Carro carro2, JProgressBar JPcarro1, JProgressBar JPcarro2) {
        this.Tiempo = Tiempo;
        this.carro1 = carro1;
        this.carro2 = carro2;
        this.JPcarro1 = JPcarro1;
        this.JPcarro2 = JPcarro2;
    }
 
    @Override
    public void run() {
        boolean iniciar=true;
        int Sgundos = 0;
        int minutos=0;
        String segun="00";
        String minut="00";
        boolean unavez=true;
        while (iniciar)
        {
            if (unavez == true)
            {
                HiloCarro1 Carro1 = new HiloCarro1(carro1, JPcarro1, JPcarro2);
                HiloCarro2 Carro2 = new HiloCarro2(carro2, JPcarro1, JPcarro2);
                Carro1.start();
                Carro2.start();
                unavez = false;
            }


            if (JPcarro1.getValue() >= 100)
            {
                JOptionPane.showMessageDialog(null, "El carro 1 ha ganado, con un tiempo de:"+minut+" minutos y "+segun+ " segundos");
                iniciar = false;
            } else if (JPcarro2.getValue() >= 100)
            {
                 JOptionPane.showMessageDialog(null, "El carro 2 ha ganado, con un tiempo de:"+minut+" minutos y "+segun+ " segundos");
                iniciar = false;
            }
                        
            if (Sgundos < 10)
            {
                segun = "0" + Sgundos;
            }else{
                segun =String.valueOf(Sgundos); 
            }
            
            if (Sgundos == 60)
            {
                minutos++;
                if (minutos<10)
                {
                  minut="0"+minutos;
                }else{
                   minut=String.valueOf(minutos); 
                }
                Sgundos=0;
            }
            Tiempo.setText(minut+":"+segun);
            Sgundos++;
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException ex)
            {
            }
        }
    }
}
