package semana_2.taller;

import java.util.Random;

public class Taller {

    public static void main(String[] args) {
        var carrito = generarCarritoCompra();
        darCantidadProductos(carrito);
        mostrarNroProductos(carrito);
        mostrarDetalleCompra(carrito);
    }

    public static int[] generarCarritoCompra() {
        var nroProductos = getNumeroAleatorio(20) + 1;
        return new int[nroProductos];
    }

    public static void darCantidadProductos(int[] carrito) {
        for (int i = 0; i < carrito.length; i++) {
            carrito[i] = getNumeroAleatorio(16);
        }
    }

    public static int[] generarPrecios(int cantidad) {

        var precios = new int[cantidad];
        var valor = 500;

        for (var indice = 0; indice < precios.length; indice++) {
            precios[indice] = valor;
            valor += 150;
        }
        return precios;
    }

    private static int getNumeroAleatorio(int tope) { //se excluye el tope
        var random = new Random();
        return random.nextInt(tope);
    }

    public static void mostrarDetalleCompra(int[] carrito) {
        var precios = generarPrecios(carrito.length);
        mostrarSubtotal(carrito, precios);
        mostrarTotal(carrito, precios);
    }

    private static void mostrarSubtotal(int[] carrito, int[] precio) {

        for (int posicion = 0; posicion < carrito.length; posicion++) {
            mostrarDetalleProducto(posicion, carrito[posicion], precio[posicion]);
        }
    }

    private static void mostrarDetalleProducto(int indice, int producto, int precio) {
        System.out.println("Cantidad de producto [" + indice + "]: "
                + producto + ", Subtotal: "
                + calcularSubtotal(producto, precio));
    }

    private static int calcularSubtotal(int producto, int precio) {
        return producto * precio;
    }

    private static void mostrarTotal(int[] carrito, int[] precios) {
        System.out.println("Total de compra: " + calcularTotal(carrito, precios));
    }

    private static int calcularTotal(int[] carrito, int[] precios) {
        var total = 0;

        for (int posicion = 0; posicion < carrito.length; posicion++) {
            total += carrito[posicion] * precios[posicion];
        }
        return total;
    }

    public static void mostrarNroProductos(int[] carrito) {
        var numeroProductos = getNroProductos(carrito);
        System.out.println("El carrito contiene " + numeroProductos + " productos");
    }

    private static int getNroProductos(int[] carrito) {

        var numeroProductos = 0;

        for (int numeroProducto : carrito) {
            numeroProductos += numeroProducto;
        }
        return numeroProductos;
    }
}

