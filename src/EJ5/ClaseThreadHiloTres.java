package EJ5;

import EJ4.ThreadColor;
import java.util.concurrent.TimeUnit;

public class ClaseThreadHiloTres extends Thread{
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_BLUE + "Hilo 1 comenzado, hasta que no termine este el Hilo 2 e Hilo 3 no empezaran.");

        try {
            System.out.println(ThreadColor.ANSI_BLUE + "Hilo 1 durmiendo 3 segundos.");
            TimeUnit.SECONDS.sleep(3);

            System.out.println(ThreadColor.ANSI_BLUE + "Hilo 1 terminado.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
