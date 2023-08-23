public class App {
    public static int producto(int... numeros) {
        int resultado = 1;
        for (int numero : numeros) {
            resultado *= numero;
        }
        return resultado;
    }

    public static void main(String[] args) {
        // Pruebas del método producto con diferentes números de argumentos
        System.out.println("Producto de 2, 3, 4: " + producto(2, 3, 4));
        System.out.println("Producto de 5, 6: " + producto(5, 6));
        System.out.println("Producto de 7: " + producto(7));
        System.out.println("Producto de 1, 2, 3, 4, 5, 6, 7, 8, 9, 10: " + producto(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}
