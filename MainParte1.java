import java.util.Scanner;

public class MainParte1 {
    public static void main(String[] args) {
        AppStore tienda = new AppStore();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ APPSTORE ---");
            System.out.println("1. Mostrar información de todos los juegos");
            System.out.println("2. Comprar licencias de un juego");
            System.out.println("3. Vender licencias de un juego");
            System.out.println("4. Mostrar juego más vendido");
            System.out.println("5. Calcular descuentos por volumen");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    mostrarInfoJuego(tienda.darJuego1());
                    mostrarInfoJuego(tienda.darJuego2());
                    mostrarInfoJuego(tienda.darJuego3());
                    mostrarInfoJuego(tienda.darJuego4());
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del juego: ");
                    String juegoCompra = sc.nextLine();
                    System.out.print("¿Cuántas licencias desea comprar?: ");
                    int cantCompra = sc.nextInt();
                    tienda.comprarLicenciasJuego(juegoCompra, cantCompra);
                    System.out.println("Licencias compradas.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del juego: ");
                    String juegoVenta = sc.nextLine();
                    System.out.print("¿Cuántas licencias desea vender?: ");
                    int cantVenta = sc.nextInt();
                    boolean vendido = tienda.venderLicenciasJuego(juegoVenta, cantVenta);
                    System.out.println(vendido ? "Venta realizada con éxito." : "No hay suficientes licencias.");
                    break;
                case 4:
                    System.out.println("Juego más vendido: " + tienda.darJuegoMasVendido());
                    break;
                case 5:
                    System.out.print("Cantidad licencias Candy Crush: ");
                    int cc = sc.nextInt();
                    System.out.print("Cantidad licencias Flow: ");
                    int flow = sc.nextInt();
                    System.out.print("Cantidad licencias FIFA: ");
                    int fifa = sc.nextInt();
                    System.out.print("Cantidad licencias Clash of Clans: ");
                    int coc = sc.nextInt();
                    System.out.println(tienda.calcularVentaPorVolumen(cc, flow, fifa, coc));
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    public static void mostrarInfoJuego(Juego juego) {
        System.out.println("\nNombre: " + juego.darNombre());
        System.out.println("Categoría: " + juego.darCategoria());
        System.out.println("Precio: $" + juego.darPrecio());
        System.out.println("Tamaño: " + juego.darTamanio() + " KB");
        System.out.println("Licencias disponibles: " + juego.darCantidadLicencias());
        System.out.println("Licencias vendidas: " + juego.darCantidadVendidas());
    }
}
