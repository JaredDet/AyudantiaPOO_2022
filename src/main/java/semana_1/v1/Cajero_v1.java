package semana_1.v1;

import java.util.ArrayList;
import java.util.Scanner;

public class Cajero_v1 {

    //Un cajero se usa para depositar, sacar y mostrar dinero.
    //También se les solicita mostrar el historial de los movimientos realizados,
    //y la cantidad de veces que se ha realizado dicho movimiento.
    //Para esto, se le ha encomendado la tarea de hacer un cajero automático
    //a los estudiantes de POO de la UFRO.
    //Considere que debe hacer un menú y las validaciones correspondientes.

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Bienvenido al cajero");

        //o representa la opción ingresada.
        int o = -1;
        //d es el dinero que hay en la cuenta.
        int d = 0;

        String[] c = {"[1] Depositar dinero.", "[2] Sacar dinero.", "[3] Mostrar dinero en cuenta.", "[4] Abandonar el cajero."};

        //l representa a la lista que contiene los movimientos realizados.
        ArrayList<String> l = new ArrayList<>();

        //co representa un contador que lleva la cantidad de veces que se ha realizado un movimiento.
        int[] co = {0, 0, 0, 0};


        while (o != 4) { //Mientras no salga del cajero.

            System.out.println("********** MENÚ **********");
            System.out.println();
            System.out.println("Seleccione la opción correspondiente");
            System.out.println(c[0]);
            System.out.println(c[1]);
            System.out.println(c[2]);
            System.out.println(c[3]);

            o = s.nextInt(); //Asignamos la opción.

            if (o == 1) { //Si se ingresa dinero.
                System.out.println("Ingrese la cantidad de dinero a depositar");
                int t = s.nextInt();

                if (t > 0) {
                    d += t;

                } else {
                    System.out.println("No se puede depositar dinero negativo");
                }
                co[0] += 1; //Aumentamos el contador del movimiento.
                l.add(c[0]); //Agregamos el movimiento.
            } else if (o == 2) { //Si se saca dinero.
                System.out.println("Ingrese la cantidad de dinero a sacar");
                int t = s.nextInt();

                if (t >= 0) { //el dinero a sacar es válido.
                    if (d - t >= 0) {
                        d -= t;
                    } else {
                        System.out.println("No se puede tener dinero negativo");
                    }
                } else {
                    System.out.println("No se puede sacar dinero negativo");
                }
                co[1] += 1; //Aumentamos el contador del movimiento.
                l.add(c[1]); //Agregamos el movimiento.
            } else if (o == 3) { //mostrar dinero.
                System.out.println("El dinero de la cuenta es: ");
                System.out.println(d);
                co[2] += 1; //Aumentamos el contador del movimiento.
                l.add(c[2]); //Agregamos el movimiento.
            } else if (o != 4) { //Si la opción es inválida.
                System.out.println("Opción incorrecta");
                System.out.println("Escoja otra.");
            }
        }
        System.out.println("Gracias por usar el cajero automático.");
        l.add(c[3]); //Agregamos el movimiento final.
        co[3] += 1; //Aumentamos el contador del último movimiento.
        System.out.println("Sus acciones realizadas han sido: ");

        for (int i = 0; i < l.size(); i++) { //Mostramos todos los movimientos realizados.
            System.out.println(l.get(i));
        }
        for (int i = 0; i < co.length; i++) { //Mostramos la cantidad de veces realizada por cada movimiento.

            if (co[i] > 0) {
                System.out.println("La cantidad de veces que se ha realizado el movimiento" + c[i].substring(0, c[i].length() - 1) + " es: " + co[i]);
            } else {
                System.out.println("No se han ejecutado acciones de tipo: " + c[i]);
            }
        }
        System.out.println("Que tenga un buen día :D");
    }
}
