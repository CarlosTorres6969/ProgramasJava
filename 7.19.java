import java.util.Scanner;

public class App {
    private static final int CAPACIDAD_AVION = 10;
    private boolean[] asientos;
    private Scanner scanner;

    public App() {
        asientos = new boolean[CAPACIDAD_AVION];
        scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        while (true) {
            mostrarMenu();
            int opcion = obtenerOpcion();

            if (opcion == 1) {
                asignarAsientoPrimeraClase();
            } else if (opcion == 2) {
                asignarAsientoEconomico();
            } else {
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\nPor favor escriba 1 para Primera Clase");
        System.out.println("Por favor escriba 2 para Económico");
    }

    private int obtenerOpcion() {
        return scanner.nextInt();
    }

    private void asignarAsientoPrimeraClase() {
        int asiento = buscarAsientoDisponible(0, 5);

        if (asiento != -1) {
            asignarAsiento(asiento, "Primera Clase");
        } else {
            System.out.println("La sección de Primera Clase está llena. ¿Desea ser colocado en la sección Económica? (Sí/No)");

            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("Sí")) {
                asignarAsientoEconomico();
            } else {
                System.out.println("El próximo vuelo sale en 3 horas.");
            }
        }
    }

    private void asignarAsientoEconomico() {
        int asiento = buscarAsientoDisponible(5, 10);

        if (asiento != -1) {
            asignarAsiento(asiento, "Económico");
        } else {
            System.out.println("La sección Económica está llena. ¿Desea ser colocado en la sección de Primera Clase? (Sí/No)");

            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("Sí")) {
                asignarAsientoPrimeraClase();
            } else {
                System.out.println("El próximo vuelo sale en 3 horas.");
            }
        }
    }

    private int buscarAsientoDisponible(int inicio, int fin) {
        for (int i = inicio; i < fin; i++) {
            if (!asientos[i]) {
                return i;
            }
        }
        return -1; // No se encontró asiento disponible
    }

    private void asignarAsiento(int asiento, String clase) {
        asientos[asiento] = true;
        System.out.println("\nAsiento asignado: " + (asiento + 1));
        System.out.println("Sección: " + clase);
        System.out.println("¡Disfrute de su vuelo!");
    }

    public static void main(String[] args) {
        App sistema = new App ();
        sistema.ejecutar();
    }
}
