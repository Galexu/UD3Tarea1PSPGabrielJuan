import java.util.concurrent.TimeUnit;

public class EJ3 {
    public static void main(String[] args) {
        Thread hiloSe = new Thread(() -> {
            try {
                System.out.println(ThreadColor.ANSI_CYAN + "Hilo 1 creado.");

                for (int i = 0; i < 10; i++) {
                    System.out.println(ThreadColor.ANSI_CYAN + "Hilo 1, mensaje impreso");
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        hiloSe.start();

        try {
            while (hiloSe.isAlive()) {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(ThreadColor.ANSI_RED + "Hilo 1 estado: " + hiloSe.getState());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
