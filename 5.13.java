public class App {

    public static void main(String[] args) {
        // Calcular y mostrar los factoriales del 1 al 20
        for (int i = 1; i <= 20; i++) {
            // Calcular el factorial del número actual
            long factorial = calcularFactorial(i);
            
            // Mostrar el resultado en formato tabular
            System.out.println(i + "! = " + factorial);
        }
    }

    // Método para calcular el factorial de un número dado
    public static long calcularFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            long factorial = 1;
            
            // Utilizar un bucle for para multiplicar los enteros desde 2 hasta n
            for (int i = 2; i <= n; i++) {
                factorial *= i;
            }
            
            // Devolver el resultado del factorial
            return factorial;
        }
    }
}
