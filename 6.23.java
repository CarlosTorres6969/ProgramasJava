import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble(); // Leemos el primer número ingresado por el usuario
        
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble(); // Leemos el segundo número ingresado por el usuario
        
        System.out.print("Ingrese el tercer número: ");
        double num3 = scanner.nextDouble(); // Leemos el tercer número ingresado por el usuario
        
        double minimo = minimo3(num1, num2, num3); // Utilizamos el método minimo3 para obtener el valor mínimo
        
        System.out.println("El valor mínimo es: " + minimo);
        
        scanner.close(); // Cerramos el objeto Scanner para liberar los recursos
    }
    
    // Método para obtener el valor mínimo de tres números
    public static double minimo3(double num1, double num2, double num3) {
        return Math.min(Math.min(num1, num2), num3); // Utilizamos el método Math.min para obtener el valor mínimo entre los tres números
    }
}
