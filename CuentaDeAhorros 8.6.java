public class CuentaDeAhorros {
    private static double tasaInteresAnual; // Tasa de interés anual compartida por todos los cuentahabientes
    private double saldoAhorros; // Saldo de ahorros del cuentahabiente

    public CuentaDeAhorros(double saldoInicial) {
        saldoAhorros = saldoInicial;
    }

    public void calcularInteresMensual() {
        double interesMensual = saldoAhorros * (tasaInteresAnual / 12); // Calcula el interés mensual
        saldoAhorros += interesMensual; // Suma el interés al saldo de ahorros
    }

    public static void modificarTasaInteres(double nuevaTasaInteres) {
        tasaInteresAnual = nuevaTasaInteres; // Establece la nueva tasa de interés anual
    }

    public double getSaldoAhorros() {
        return saldoAhorros; // Devuelve el saldo de ahorros del cuentahabiente
    }

    public static void main(String[] args) {
        CuentaDeAhorros ahorrador1 = new CuentaDeAhorros(2000.00); // Crea el objeto CuentaDeAhorros para ahorrador1 con saldo inicial de $2000.00
        CuentaDeAhorros ahorrador2 = new CuentaDeAhorros(3000.00); // Crea el objeto CuentaDeAhorros para ahorrador2 con saldo inicial de $3000.00

        CuentaDeAhorros.modificarTasaInteres(0.04); // Establece la tasa de interés al 4%

        for (int mes = 1; mes <= 12; mes++) {
            ahorrador1.calcularInteresMensual(); // Calcula el interés mensual y actualiza el saldo de ahorros para ahorrador1
            ahorrador2.calcularInteresMensual(); // Calcula el interés mensual y actualiza el saldo de ahorros para ahorrador2

            System.out.printf("Mes %d - Ahorrador 1: $%.2f, Ahorrador 2: $%.2f%n", mes, ahorrador1.getSaldoAhorros(), ahorrador2.getSaldoAhorros());
            // Imprime el número de mes y los saldos de ahorros actualizados para ahorrador1 y ahorrador2
        }

        CuentaDeAhorros.modificarTasaInteres(0.05); // Establece la tasa de interés al 5%

        ahorrador1.calcularInteresMensual(); // Calcula el interés mensual y actualiza el saldo de ahorros para ahorrador1
        ahorrador2.calcularInteresMensual(); // Calcula el interés mensual y actualiza el saldo de ahorros para ahorrador2

        System.out.println("\nDespués de un mes con la nueva tasa de interés:");
        System.out.printf("Ahorrador 1: $%.2f, Ahorrador 2: $%.2f%n", ahorrador1.getSaldoAhorros(), ahorrador2.getSaldoAhorros());
        // Imprime los saldos de ahorros actualizados para ahorrador1 y ahorrador2 después de un mes con la nueva tasa de interés
    }
}
