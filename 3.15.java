class Cuenta {
    private String nombre; // variable de instancia
    private double saldo; // variable de instancia

    // constructor de Cuenta que recibe dos parámetros
    public Cuenta(String nombre, double saldo) {
        this.nombre = nombre; // asigna nombre a la variable de instancia nombre

        // valida que el saldo sea mayor que 0.0; de lo contrario,
        // la variable de instancia saldo mantiene su valor inicial predeterminado de 0.0
        if (saldo > 0.0) { // si el saldo es válido
            this.saldo = saldo; // lo asigna a la variable de instancia saldo
        }
    }

    // método que deposita (suma) solo una cantidad válida al saldo
    public void depositar(double montoDeposito) {
        if (montoDeposito > 0.0) { // si el montoDeposito es válido
            saldo = saldo + montoDeposito; // lo suma al saldo
        }
    }

    // método devuelve el saldo de la cuenta
    public double obtenerSaldo() {
        return saldo;
    }

    // método que establece el nombre
    public void establecerNombre(String nombre) {
        this.nombre = nombre;
    }

    // método que devuelve el nombre
    public String obtenerNombre() {
        return nombre;
    }
}

public class App {
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta("Jane Green", 50.00);
        Cuenta cuenta2 = new Cuenta("John Blue", -7.53);

        mostrarCuenta(cuenta1);
        mostrarCuenta(cuenta2);

        System.out.printf("%nIngrese el monto a depositar para cuenta1: ");
        double montoDeposito = 100.00;
        System.out.printf("%nsumando %.2f al saldo de cuenta1%n%n", montoDeposito);
        cuenta1.depositar(montoDeposito); // suma al saldo de cuenta1

        mostrarCuenta(cuenta1);
        mostrarCuenta(cuenta2);

        System.out.printf("%nIngrese el monto a depositar para cuenta2: ");
        montoDeposito = 500.00;
        System.out.printf("%nsumando %.2f al saldo de cuenta2%n%n", montoDeposito);
        cuenta2.depositar(montoDeposito); // suma al saldo de cuenta2

        mostrarCuenta(cuenta1);
        mostrarCuenta(cuenta2);
    }

    public static void mostrarCuenta(Cuenta cuentaAMostrar) {
        System.out.printf("El nombre del titular de la cuenta es: %s%n", cuentaAMostrar.obtenerNombre());
        System.out.printf("El saldo de la cuenta es: $%.2f%n", cuentaAMostrar.obtenerSaldo());
    }
}
