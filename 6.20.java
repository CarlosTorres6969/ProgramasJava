import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el radio del círculo: ");
        double radio = scanner.nextDouble(); // Leemos el radio ingresado por el usuario
        
        double area = circuloArea(radio); // Calculamos el área utilizando el método circuloArea
        
        System.out.println("El área del círculo es: " + area);
        
        scanner.close(); // Cerramos el objeto Scanner para liberar los recursos
    }
    
    // Método para calcular el área de un círculo
    public static double circuloArea(double radio) {
        return Math.PI * Math.pow(radio, 2); // Utilizamos la fórmula del área de un círculo: π * radio^2
    }
}
