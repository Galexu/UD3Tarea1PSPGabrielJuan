import java.util.concurrent.TimeUnit;

public class EJ1 {
    public static void main(String[] args) {
        Thread hiloUno = new Thread(() -> {
            System.out.println(ThreadColor.ANSI_CYAN + "Hilo 1 creado, dormire diez segundillos");
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println(ThreadColor.ANSI_CYAN + "Hilo 1, diez segundos pasraon y desperte");
            } catch (InterruptedException e) {
                System.out.println(ThreadColor.ANSI_CYAN + "Hilo 1, he sido interrumpido por otro hilo");
            }
        });


        Thread hiloDos = new Thread(() -> {
            System.out.println(ThreadColor.ANSI_BLUE + "Hilo 2 creado, dormire 3 segundillos");

            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(ThreadColor.ANSI_BLUE + "Hilo 2, tres segundos pasaron y he despertado");
                hiloUno.interrupt();
            } catch (InterruptedException e) {
                System.out.println(ThreadColor.ANSI_BLUE + "Hilo 2, he sido interrumpido por otro hilo");
            }
        });

        hiloUno.start();
        hiloDos.start();
    }
}
