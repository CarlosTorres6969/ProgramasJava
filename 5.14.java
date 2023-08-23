public class App {

    public static void main(String[] args) {
        double montoPrincipal = 1000.0; // Monto principal
        int años = 5; // Número de años
        
        // Utilizar un bucle for para variar la tasa de interés del 5% al 10%
        for (double tasaInteres = 5.0; tasaInteres <= 10.0; tasaInteres++) {
            // Calcular el monto con interés compuesto para la tasa de interés actual
            double montoFinal = montoPrincipal * Math.pow(1 + (tasaInteres / 100), años);
            
            // Mostrar el resultado
            System.out.println("Monto con una tasa de interés del " + tasaInteres + "%: " + montoFinal);
        }
    }
}
