import java.util.Scanner;

public class Venta {
    private int id;
    private String fecha;
    private Producto[] productosVendidos;
    private int[] cantidadesVendidas;
    private Cliente cliente;

    public Venta(int id, String fecha, Producto[] productosVendidos, int[] cantidadesVendidas, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.productosVendidos = productosVendidos;
        this.cantidadesVendidas = cantidadesVendidas;
        this.cliente = cliente;
    }

    public static Venta ingresarVentaDesdeConsola(Producto[] productos, Cliente[] clientes) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID de la Venta: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Fecha de la Venta: ");
        String fecha = scanner.nextLine();

        // Seleccionar un cliente para esta venta
        Cliente cliente = seleccionarCliente(clientes);

        if (cliente == null) {
            System.out.println("Cliente no válido. La venta se cancelará.");
            return null;
        }

        // Ingresar productos y cantidades vendidas
        Producto[] productosVendidos = new Producto[productos.length];
        int[] cantidadesVendidas = new int[productos.length];
        int numProductosVendidos = 0;

        System.out.println("Ingrese los productos vendidos (introduzca '0' para finalizar):");
        for (int i = 0; i < productos.length; i++) {
            System.out.print("ID del Producto #" + productos[i].getId() + ": ");
            int idProducto = scanner.nextInt();

            if (idProducto == 0) {
                break;
            }

            Producto producto = buscarProductoPorID(productos, idProducto);
            if (producto != null) {
                productosVendidos[numProductosVendidos] = producto;
                System.out.print("Cantidad vendida de " + producto.getId() + ": ");
                cantidadesVendidas[numProductosVendidos] = scanner.nextInt();
                numProductosVendidos++;
            } else {
                System.out.println("Producto no válido. Introduzca '0' para finalizar.");
            }
        }

        return new Venta(id, fecha, productosVendidos, cantidadesVendidas, cliente);
    }

    public void mostrarInformacion() {
        System.out.println("ID de la Venta: " + id);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Productos vendidos:");

        for (int i = 0; i < productosVendidos.length; i++) {
            if (productosVendidos[i] != null) {
                System.out.println(productosVendidos[i].getId() + " - Cantidad: " + cantidadesVendidas[i]);
            }
        }
    }

    private static Cliente seleccionarCliente(Cliente[] clientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione un cliente:");

        for (int i = 0; i < clientes.length; i++) {
            System.out.println((i + 1) + ". " + clientes[i].getNombre());
        }

        int seleccion = scanner.nextInt();
        if (seleccion > 0 && seleccion <= clientes.length) {
            return clientes[seleccion - 1];
        } else {
            return null;
        }
    }

    private static Producto buscarProductoPorID(Producto[] productos, int id) {
        for (Producto producto : productos) {
            if (producto != null && producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Producto[] getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(Producto[] productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public int[] getCantidadesVendidas() {
        return cantidadesVendidas;
    }

    public void setCantidadesVendidas(int[] cantidadesVendidas) {
        this.cantidadesVendidas = cantidadesVendidas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
