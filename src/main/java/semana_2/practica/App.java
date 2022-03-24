package semana_2.practica;

import java.util.InputMismatchException;

public class App {

    public static void main(String[] args) {

        var lector = new LectorDimension();
        var dimension = leerDimension(lector);
        System.out.println(dimension);
    }

    private static int leerDimension(Lector<Integer> lector) {

        try {
            return lector.leer();
        } catch (InputMismatchException ex) {
            System.err.println("No has ingresado un número. Opción por defecto: 0");
            return 0;
        }
    }
}
