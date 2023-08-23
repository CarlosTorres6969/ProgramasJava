import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese la cantidad de valores
        System.out.print("Ingrese la cantidad de valores: ");
        int cantidadValores = scanner.nextInt();

        // Solicitar al usuario que ingrese el primer valor
        System.out.print("Ingrese el primer valor: ");
        int menor = scanner.nextInt();

        // Utilizar un bucle for para leer los valores restantes
        for (int i = 2; i <= cantidadValores; i++) {
            // Solicitar al usuario que ingrese el valor i
            System.out.print("Ingrese el valor " + i + ": ");
            int valor = scanner.nextInt();
            
            // Comparar el valor ingresado con el valor actual más pequeño
            if (valor < menor) {
                // Si el valor ingresado es menor, actualizar la variable "menor"
                menor = valor;
            }
        }

        // Mostrar en pantalla el valor más pequeño encontrado
        System.out.println("El menor valor ingresado es: " + menor);

        // Cerrar el objeto Scanner para liberar los recursos
        scanner.close();
    }
}
