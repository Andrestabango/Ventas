import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de productos: ");
        int numProductos = scanner.nextInt();
        Producto[] productos = new Producto[numProductos];

        for (int i = 0; i < numProductos; i++) {
            System.out.println("Ingrese los datos del Producto #" + (i + 1));
            productos[i] = Producto.ingresarProductoDesdeConsola();
        }

        System.out.print("Ingrese la cantidad de clientes: ");
        int numClientes = scanner.nextInt();
        Cliente[] clientes = new Cliente[numClientes];

        for (int i = 0; i < numClientes; i++) {
            System.out.println("Ingrese los datos del Cliente #" + (i + 1));
            clientes[i] = Cliente.ingresarClienteDesdeConsola();
        }

        System.out.print("Ingrese la cantidad de ventas: ");
        int numVentas = scanner.nextInt();
        Venta[] ventas = new Venta[numVentas];

        for (int i = 0; i < numVentas; i++) {
            System.out.println("Ingrese los datos de la Venta #" + (i + 1));
            ventas[i] = Venta.ingresarVentaDesdeConsola(productos, clientes);
        }

        // Imprimir los datos de las ventas
        System.out.println("Registro de Ventas:");
        for (Venta venta : ventas) {
            venta.mostrarInformacion();
            System.out.println("---------------");
        }
    }
}