public class App {

    public static void main(String[] args) {
        // Inicializar la variable producto en 1
        int producto = 1;

        // Utilizar un bucle for para iterar desde 1 hasta 15
        for (int i = 1; i <= 15; i++) {
            // Verificar si el número i es impar
            if (i % 2 != 0) {
                // Multiplicar el valor actual de producto por el número impar i
                producto *= i;
            }
        }

        // Mostrar en pantalla el resultado del producto
        System.out.println("El producto de los enteros impares del 1 al 15 es: " + producto);
    }
}
