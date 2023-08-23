public class App {
    public static void main(String[] args) {
        int limiteSuperior = 1000; // Definimos el límite superior
        
        for (int numero = 1; numero <= limiteSuperior; numero++) {
            if (esPerfecto(numero)) { // Verificamos si el número es perfecto
                System.out.print(numero + ": "); // Imprimimos el número
                
                // Mostramos los factores del número perfecto
                for (int factor = 1; factor < numero; factor++) {
                    if (numero % factor == 0) {
                        System.out.print(factor + " ");
                    }
                }
                
                System.out.println(); // Agregamos un salto de línea después de mostrar los factores
            }
        }
    }
    
    // Método para verificar si un número es perfecto
    public static boolean esPerfecto(int numero) {
        int sumaFactores = 0;
        
        // Calculamos la suma de los factores del número
        for (int factor = 1; factor < numero; factor++) {
            if (numero % factor == 0) {
                sumaFactores += factor;
            }
        }
        
        return sumaFactores == numero; // Devolvemos true si la suma de los factores es igual al número, indicando que el número es perfecto
    }
}
