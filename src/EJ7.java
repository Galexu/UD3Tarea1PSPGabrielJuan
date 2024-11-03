import java.util.concurrent.TimeUnit;

public class EJ7 {
    public static void main(String[] args) {
        Thread hiloUno = new Thread(() -> {
            try {
                System.out.println(ThreadColor.ANSI_CYAN + "Hilo 1 creado.");

                while (true) {
                    System.out.println(ThreadColor.ANSI_CYAN + "Hilo 1 ∞.");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println(ThreadColor.ANSI_CYAN + "Hilo 1 ha sido interrumpido de su bucle infinito.");
            }
        });

        Thread hiloDos = new Thread(() -> {
            try {
                hiloUno.join();
                System.out.println(ThreadColor.ANSI_GREEN + "Hilo 2 creado despues del Hilo 1 infinito.");
                System.out.println("Hilo 2, adios");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread hiloTres = new Thread(() -> {
            try {
                System.out.println(ThreadColor.ANSI_PURPLE + "Hilo 3 creado.");
                System.out.println(ThreadColor.ANSI_PURPLE + "Hilo 3, demos unos segundos hasta la interrumpcion del Hilo 1.");
                hiloUno.join(6000);

                hiloUno.interrupt();
                System.out.println(ThreadColor.ANSI_PURPLE + "Hilo 1 interrumpido desde el Hilo 3.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        hiloUno.start();
        hiloDos.start();
        hiloTres.start();
    }
}
