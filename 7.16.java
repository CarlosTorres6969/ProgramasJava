public class App {
    public static void main(String[] args) {
        double suma = 0.0;
        
        // Recorremos los argumentos de línea de comandos
        for (String arg : args) {
            try {
                // Convertimos el argumento a double y lo sumamos a la variable "suma"
                suma += Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                // Si el argumento no puede ser convertido a double, ignoramos el valor
                System.out.println("El argumento '" + arg + "' no es un número válido.");
            }
        }
        
        System.out.println("La suma total es: " + suma);
    }
}
