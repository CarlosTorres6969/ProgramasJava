import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Ingrese un número entero (0 para salir): ");
            int numero = scanner.nextInt(); // Leemos el número ingresado por el usuario
            
            if (numero == 0) {
                break; // Si el número es 0, salimos del bucle while y terminamos la aplicación
            }
            
            if (esPar(numero)) { // Verificamos si el número es par
                System.out.println("El número es par.");
            } else {
                System.out.println("El número es impar.");
            }
        }
        
        scanner.close(); // Cerramos el objeto Scanner para liberar los recursos
    }
    
    // Método para verificar si un número es par
    public static boolean esPar(int numero) {
        return numero % 2 == 0; // Devolvemos true si el residuo de dividir el número por 2 es igual a cero, indicando que el número es par
    }
}
