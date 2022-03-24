package semana_2.practica;

import java.util.Scanner;

public class LectorDimension implements Lector<Integer> {

    @Override
    public Integer leer() {
        System.out.println("Ingrese la dimensión");
        var scanner = new Scanner(System.in);

        var dimension = scanner.nextInt();
        if (esNegativa(dimension)) {
            return 0;
        }
        return dimension;
    }

    private static boolean esNegativa(int dimension) {
        return dimension < 0;
    }
}
