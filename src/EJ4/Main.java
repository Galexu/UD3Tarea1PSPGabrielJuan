package EJ4;

public class Main {
    public static void main(String[] args) {
        HiloUno hiloUno = new HiloUno();

        Runnable r = () -> {
            try {
                hiloUno.join();
                System.out.println(ThreadColor.ANSI_BLUE + "Factorial calculado con exito");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread hiloDos = new Thread(r);

        hiloUno.start();
        hiloDos.start();
    }
}
