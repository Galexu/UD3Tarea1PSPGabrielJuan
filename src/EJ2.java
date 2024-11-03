import java.util.concurrent.TimeUnit;

public class EJ2 {
    public static void main(String[] args) {
        Thread hiloUno = new Thread(() -> {
            try {
                System.out.println(ThreadColor.ANSI_CYAN + "Hilo 1 creado.");

                for (int i = 1; i <= 5; i++) {
                    System.out.println(ThreadColor.ANSI_CYAN + "Numero " + i);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread hiloDos = new Thread(() -> {
            try {
                hiloUno.join();
                System.out.println(ThreadColor.ANSI_GREEN + "Hilo 2 creado.");


                for (int i = 6; i <= 10; i++) {
                    System.out.println(ThreadColor.ANSI_GREEN + "Numero " + i);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread hiloTres = new Thread(() -> {
            try {
                hiloDos.join();
                System.out.println(ThreadColor.ANSI_PURPLE + "Hilo 3 creado.");
                for (int i = 11; i <= 15; i++) {
                    System.out.println(ThreadColor.ANSI_PURPLE + "Numero " + i);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        hiloUno.start();
        hiloDos.start();
        hiloTres.start();
    }
}
