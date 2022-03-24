package semana_1.v3;

import java.util.ArrayList;
import java.util.Scanner;

public class Cajero_v3 {

    //Un cajero se usa para depositar, sacar y mostrar dinero.
    //También se les solicita mostrar el historial de los movimientos realizados,
    //y la cantidad de veces que se ha realizado dicho movimiento.
    //Para esto, se le ha encomendado la tarea de hacer un cajero automático
    //a los estudiantes de POO de la UFRO.
    //Considere que debe hacer un menú y las validaciones correspondientes.

    static int saldo = 0;
    static ArrayList<String> historial;
    static String[] MOVIMIENTOS = {"[1] Depositar dinero.", "[2] Sacar dinero.", "[3] Mostrar dinero en cuenta.", "[4] Abandonar el cajero."};
    static int[] registroMovimientos = {0, 0, 0, 0};

    public static void main(String[] args) {

        historial = new ArrayList<>();
        int opcion = -1;

        System.out.println("Bienvenido al cajero");

        do {
            desplegarMenu();
            opcion = ingresar();
            ejecutar(opcion);
        } while (!haFinalizado(opcion));
        mostrarHistorial();
        mostrarRegistro();
    }

    public static void desplegarMenu() {

        System.out.println("********** MENÚ **********");
        System.out.println();
        System.out.println("Seleccione la opción correspondiente");
        System.out.println(MOVIMIENTOS[0]);
        System.out.println(MOVIMIENTOS[1]);
        System.out.println(MOVIMIENTOS[2]);
        System.out.println(MOVIMIENTOS[3]);
    }

    public static int ingresar() {
        return new Scanner(System.in).nextInt();
    }

    public static void ejecutar(int opcion) {

        if (esValida(opcion)) {
            actualizarHistorial(MOVIMIENTOS[opcion - 1]);
            actualizarRegistro(opcion - 1);
        }

        switch (opcion) {
            case 1 -> ingresarDeposito();
            case 2 -> ingresarRetiro();
            case 3 -> mostrarSaldo();
            case 4 -> despedirse();
            default -> mostrarError();
        }
    }

    public static void ingresarDeposito() {
        System.out.println("Ingrese la cantidad de dinero a depositar");
        int deposito = ingresar();
        saldo = depositar(deposito);
    }

    public static int depositar(int deposito) {

        if (esNegativo(deposito)) {
            System.err.println("No se puede realizar un deposito negativo.");
            return saldo;
        }
        return saldo + deposito;
    }

    public static void ingresarRetiro() {
        System.out.println("Ingrese la cantidad de dinero a retirar");
        int retiro = ingresar();
        saldo = retirar(retiro);
    }

    public static int retirar(int retiro) {

        int nuevoSaldo = saldo - retiro;

        if (esNegativo(retiro)) {
            System.err.println("No se puede realizar un retiro negativo");
            return saldo;
        }

        if (esNegativo(nuevoSaldo)) {
            System.err.println("No se puede tener saldo negativo");
            return saldo;
        }

        return nuevoSaldo;
    }

    public static void mostrarSaldo() {
        System.out.println("El saldo de la cuenta es: " + saldo);
    }

    public static void despedirse() {
        System.out.println("Gracias por usar el cajero automático.");
    }

    public static void mostrarError() {
        System.err.println("Opción incorrecta");
        System.err.println("Escoja otra.");
    }

    public static void mostrarHistorial() {

        System.out.println("Sus acciones realizadas han sido: ");
        for (String registro : historial) {
            System.out.println(registro);
        }
    }

    public static void mostrarRegistro() {

        for (int indice = 0; indice < registroMovimientos.length; indice++) {

            if (estaVacio(registroMovimientos[indice])) {
                System.out.println("No se han realizado movimientos de tipo: " + MOVIMIENTOS[indice]);
                continue;
            }
            System.out.println("Se ha realizado el movimiento " + MOVIMIENTOS[indice].substring(0, MOVIMIENTOS[indice].length() - 1) + " " + registroMovimientos[indice] + " veces.");
        }
    }

    public static void actualizarHistorial(String movimiento) {
        historial.add(movimiento);
    }

    public static void actualizarRegistro(int indice) {
        registroMovimientos[indice]++;
    }

    public static boolean esNegativo(int entrada) {
        return entrada < 0;
    }

    public static boolean esValida(int opcion) {
        return opcion < 5 && opcion > 0;
    }

    public static boolean estaVacio(int indice) {
        return indice == 0;
    }

    public static boolean haFinalizado(int opcion) {
        return opcion == 4;
    }
}
