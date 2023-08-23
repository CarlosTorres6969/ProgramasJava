import java.util.Random;

public class App {
    public static void main(String[] args) {
        int[] sumas = new int[13]; // El índice 0 no se utiliza

        Random random = new Random();

        // Realizar 36,000,000 de tiradas de los dados
        for (int i = 0; i < 36000000; i++) {
            int dado1 = random.nextInt(6) + 1; // Generar un número aleatorio entre 1 y 6
            int dado2 = random.nextInt(6) + 1;

            int suma = dado1 + dado2;
            sumas[suma]++;
        }

        System.out.println("Suma\tFrecuencia");

        // Mostrar los resultados en formato tabular
        for (int i = 2; i <= 12; i++) {
            System.out.println(i + "\t" + sumas[i]);
        }
    }
}
