package EJ5;

import EJ4.ThreadColor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ClaseThreadHiloTres claseThreadHiloTres = new ClaseThreadHiloTres();

        Thread threadLambdaHiloDos = new Thread(() -> {
            try {
                claseThreadHiloTres.join();
                System.out.println(ThreadColor.ANSI_CYAN + "Hilo 2 comenzado");

                System.out.println(ThreadColor.ANSI_CYAN + "Hilo 2 durmiendo 5 segundos");
                TimeUnit.SECONDS.sleep(5);

                System.out.println(ThreadColor.ANSI_CYAN + "Hilo 2 terminado");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Runnable r = () -> {
            try {
                claseThreadHiloTres.join();
                System.out.println(ThreadColor.ANSI_PURPLE + "Hilo 3 comenzado");

                System.out.println(ThreadColor.ANSI_PURPLE + "Hilo 3 durmiendo 8 segundos");
                TimeUnit.SECONDS.sleep(8);

                System.out.println(ThreadColor.ANSI_PURPLE + "Hilo 3 terminado");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread runnableLambdaHiloTres = new Thread(r);

        claseThreadHiloTres.start();
        threadLambdaHiloDos.start();
        runnableLambdaHiloTres.start();
    }
}
