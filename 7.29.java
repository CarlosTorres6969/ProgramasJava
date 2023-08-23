import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el valor de n para calcular el número de Fibonacci: ");
        int n = scanner.nextInt();
        
        // a) Calcular el enésimo número de Fibonacci
        long fibonacci = calcularFibonacci(n);
        System.out.println("El número de Fibonacci en la posición " + n + " es: " + fibonacci);
        
        // b) Determinar el número de Fibonacci más grande que puede imprimirse en el sistema
        long maxFibonacci = encontrarMaxFibonacci();
        System.out.println("El número de Fibonacci más grande que puede imprimirse en el sistema es: " + maxFibonacci);
        
        // c) Calcular el enésimo número de Fibonacci utilizando double
        double doubleFibonacci = calcularDoubleFibonacci(n);
        System.out.println("El número de Fibonacci (utilizando double) en la posición " + n + " es: " + doubleFibonacci);
    }
    
    public static long calcularFibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long fibNMinus2 = 0;
            long fibNMinus1 = 1;
            long fibonacci = 0;
            
            for (int i = 2; i <= n; i++) {
                fibonacci = fibNMinus2 + fibNMinus1;
                fibNMinus2 = fibNMinus1;
                fibNMinus1 = fibonacci;
            }
            
            return fibonacci;
        }
    }
    
    public static long encontrarMaxFibonacci() {
        long fibNMinus2 = 0;
        long fibNMinus1 = 1;
        long fibonacci = 0;
        long maxFibonacci = 0;
        
        while (fibonacci >= 0) {
            maxFibonacci = fibonacci;
            fibonacci = fibNMinus2 + fibNMinus1;
            fibNMinus2 = fibNMinus1;
            fibNMinus1 = fibonacci;
        }
        
        return maxFibonacci;
    }
    
    public static double calcularDoubleFibonacci(int n) {
        if (n <= 0) {
            return 0.0;
        } else if (n == 1) {
            return 1.0;
        } else {
            double fibNMinus2 = 0.0;
            double fibNMinus1 = 1.0;
            double fibonacci = 0.0;
            
            for (int i = 2; i <= n; i++) {
                fibonacci = fibNMinus2 + fibNMinus1;
                fibNMinus2 = fibNMinus1;
                fibNMinus1 = fibonacci;
            }
            
            return fibonacci;
        }
    }
}
