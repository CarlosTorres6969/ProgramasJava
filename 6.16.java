import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Ingrese el primer número: ");
            int num1 = scanner.nextInt(); // Leemos el primer número ingresado por el usuario
            
            System.out.print("Ingrese el segundo número: ");
            int num2 = scanner.nextInt(); // Leemos el segundo número ingresado por el usuario
            
            if (esMultiplo(num1, num2)) { // Verificamos si el segundo número es múltiplo del primero
                System.out.println("El segundo número es múltiplo del primero.");
            } else {
                System.out.println("El segundo número no es múltiplo del primero.");
            }
            
            System.out.print("¿Desea ingresar otro par de números? (s/n): ");
            String continuar = scanner.next(); // Leemos la respuesta del usuario
            
            if (!continuar.equalsIgnoreCase("s")) { // Verificamos si el usuario desea ingresar otro par de números
                break; // Salimos del bucle while si la respuesta no es "s" (ignorando mayúsculas y minúsculas)
            }
        }
        
        scanner.close(); // Cerramos el objeto Scanner para liberar los recursos
    }
    
    // Método para verificar si el segundo número es múltiplo del primero
    public static boolean esMultiplo(int num1, int num2) {
        return num2 % num1 == 0; // Devolvemos true si el residuo de num2 dividido por num1 es igual a cero, indicando que num2 es múltiplo de num1
    }
}
