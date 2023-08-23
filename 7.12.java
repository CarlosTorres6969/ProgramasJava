import java.util.Arrays;
import java.util.Scanner;

public class App{

    public static void main(String[] args) {
        int[] numerosUnicos = new int[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese un número entre 10 y 100: ");
            int numero = scanner.nextInt();

            if (numero >= 10 && numero <= 100) {
                boolean encontrado = false;

                // Verificar si el número ya se encuentra en el arreglo
                for (int j = 0; j < i; j++) {
                    if (numerosUnicos[j] == numero) {
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    numerosUnicos[i] = numero;
                    System.out.println("Valores únicos: " + Arrays.toString(Arrays.copyOf(numerosUnicos, i + 1)));
                } else {
                    System.out.println("El número ya ha sido ingresado antes.");
                    i--;
                }
            } else {
                System.out.println("El número ingresado no cumple con los requisitos.");
                i--;
            }
        }

        scanner.close();
    }

}
