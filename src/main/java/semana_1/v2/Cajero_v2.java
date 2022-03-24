package semana_1.v2;

import java.util.ArrayList;
import java.util.Scanner;

public class Cajero_v2 {

    //Un cajero se usa para depositar, sacar y mostrar dinero.
    //También se les solicita mostrar el historial de los movimientos realizados,
    //y la cantidad de veces que se ha realizado dicho movimiento.
    //Para esto, se le ha encomendado la tarea de hacer un cajero automático
    //a los estudiantes de POO de la UFRO.
    //Considere que debe hacer un menú y las validaciones correspondientes.

    static int saldo = 0;
    static ArrayList<String> historial;
    static String[] MOVIMIENTOS = {"[1] Depositar dinero.", "[2] Sacar dinero.", "[3] Mostrar dinero en cuenta.", "[4] Abandonar el cajero."};
    static int[] contadorMovimientos = {0, 0, 0, 0};


    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        historial = new ArrayList<>();
        int opcion = -1;

        System.out.println("Bienvenido al cajero");
        do {

            System.out.println("********** MENÚ **********");
            System.out.println();
            System.out.println("Seleccione la opción correspondiente");
            System.out.println(MOVIMIENTOS[0]);
            System.out.println(MOVIMIENTOS[1]);
            System.out.println(MOVIMIENTOS[2]);
            System.out.println(MOVIMIENTOS[3]);

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1: {
                    System.out.println("Ingrese la cantidad de dinero a depositar");
                    int deposito = teclado.nextInt();
                    saldo = depositar(deposito);
                    contadorMovimientos[0] += 1;
                    historial.add(MOVIMIENTOS[0]);
                    break;
                }
                case 2: {
                    System.out.println("Ingrese la cantidad de dinero a sacar");
                    int retiro = teclado.nextInt();
                    saldo -= sacar(retiro);
                    contadorMovimientos[1] += 1;
                    historial.add(MOVIMIENTOS[1]);
                    break;
                }
                case 3: {
                    System.out.println("El saldo de la cuenta es: ");
                    mostrarSaldo();
                    contadorMovimientos[2] += 1;
                    historial.add(MOVIMIENTOS[2]);
                    break;
                }
                default: {
                    System.out.println("Opción incorrecta");
                    System.out.println("Escoja otra.");
                    break;
                }
            }
        } while (opcion != 4);
        System.out.println("Gracias por usar el cajero automático.");
        historial.add(MOVIMIENTOS[3]); //Agregamos el movimiento final.
        contadorMovimientos[3] += 1; //Aumentamos el contador del último movimiento.
        System.out.println();
        mostrarHistorial();
        System.out.println();
        mostrarNroMovimientos();
        System.out.println("Que tenga un buen día :D");
    }

    public static int depositar(int deposito) {

        int retorno = 0;

        if (deposito > 0) {
            retorno = saldo + deposito;
        } else {
            System.out.println("No se puede depositar dinero negativo");
            retorno = saldo;
        }
        return retorno;
    }

    public static int sacar(int retiro) {

        int retorno = 0;

        if (retiro >= 0) { //el dinero a sacar es válido.
            if (saldo - retiro >= 0) {
                retorno = saldo - retiro;
            } else {
                System.out.println("No se puede tener dinero negativo");
                retorno = saldo;
            }
        } else {
            System.out.println("No se puede sacar dinero negativo");
            retorno = saldo;
        }
        return retorno;
    }

    public static void mostrarSaldo() {
        System.out.println(saldo);
    }

    public static void mostrarHistorial() {

        System.out.println("Sus acciones realizadas han sido: ");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println(historial.get(i));
        }
    }

    public static void mostrarNroMovimientos() {

        for (int i = 0; i < contadorMovimientos.length; i++) { //Mostramos la cantidad de veces realizada por cada movimiento.

            if (contadorMovimientos[i] > 0) {
                System.out.println("La cantidad de veces que se ha realizado el movimiento" + MOVIMIENTOS[i].substring(0, MOVIMIENTOS[i].length() - 1) + " es: " + contadorMovimientos[i]);
            } else {
                System.out.println("No se han ejecutado acciones de tipo: " + MOVIMIENTOS[i]);
            }
        }
    }
}
