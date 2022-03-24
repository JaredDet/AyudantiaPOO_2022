package semana_2.practica;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TallerPractica {

    public static void main(String[] args) {

        int dimension;
        var primos = 0;

        dimension = leerDimension();
        int[] vector;
        vector = new int[dimension];

        llenarVector(vector);
        System.out.println("Arreglo de números");
        mostrarVector(vector);

        for (int posicion : vector) {
            if (esPrimo(posicion)) primos++;
        }

        var vectorPrimos = new int[primos];

        copiarVector(vector, vectorPrimos);
        System.out.println("Números primos");

        mostrarVector(vectorPrimos);
    }

    private static int leerDimension() {

        System.out.println("Ingrese la dimensión");
        var scanner = new Scanner(System.in);

        try {
            var dimension = scanner.nextInt();
            if (esNegativa(dimension)) {
                return 0;
            }
            return dimension;
        } catch (InputMismatchException ex) {
            System.err.println("No has ingresado un número. Opción por defecto: 0");
            return 0;
        }
    }

    private static boolean esNegativa(int dimension) {
        return dimension < 0;
    }

    private static void llenarVector(int[] vector) {
        var random = new Random();

        for (int valor = 0; valor < vector.length; valor++) {
            vector[valor] = random.nextInt(100);
        }
    }

    private static void mostrarVector(int[] vector) {

        for (var valor : vector ) {
            System.out.println("[ " + valor + " ]");
        }
    }

    private static boolean esPrimo(int valor) {

        if (esUno(valor)) {
            return false;
        }
        if (esDos(valor)) {
            return true;
        }

        if (esPar(valor)) {
            return false;
        }
        return revisarCasoGeneral(valor);
    }

    private static boolean esUno(int valor) {
        return valor == 1;
    }

    private static boolean esDos(int valor) {
        return valor == 2;
    }

    private static boolean esPar(int valor) {
        return valor % 2 == 0;
    }

    private static boolean revisarCasoGeneral(int valor) {
        for (int divisor = 3; divisor <= Math.sqrt(valor); divisor = divisor + 2) {
            if (moduloDaCero(valor, divisor)) {
                return false;
            }
        }
        return true;
    }

    private static boolean moduloDaCero(int valor, int posibleDivisor) {
        return valor % posibleDivisor == 0;
    }

    private static void copiarVector(int[] origen, int[] destino) {

        int posicionDestino = 0;

        for (int posicionOrigen : origen) {
            if (esPrimo(posicionOrigen)) {
                destino[posicionDestino] = posicionOrigen;
                posicionDestino++;
            }
        }
    }
}
