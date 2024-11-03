package EJ4;

import java.util.Scanner;

public class HiloUno extends Thread{
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print(ThreadColor.ANSI_CYAN + "Por favor ingrese un numero: ");
        long numero = sc.nextLong();
        long  resultado = 1;

        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }

        System.out.println(ThreadColor.ANSI_CYAN + "El resultado es: " + resultado);
    }
}
