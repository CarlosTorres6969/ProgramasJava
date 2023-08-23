class Padre {
    protected double ingresos;

    public Padre(double ingresos) {
        this.ingresos = ingresos;
    }

    public void calcularImpuestos() {
        System.out.println("Cálculo de impuestos en la clase Padre");
        // Aquí iría la lógica real para calcular los impuestos basada en los ingresos
        // ...
        // ...
    }
}

class Hijo extends Padre {
    private double bonificaciones;

    public Hijo(double ingresos, double bonificaciones) {
        super(ingresos); // Llamada al constructor de la clase Padre
        this.bonificaciones = bonificaciones;
    }

    @Override
    public void calcularImpuestos() {
        super.calcularImpuestos(); // Llamada al método calcularImpuestos() de la clase Padre
        System.out.println("Cálculo de impuestos en la clase Hijo");
        // Aquí iría la lógica adicional para calcular impuestos específicos del Hijo
        // ...
        // ...
    }
}

public class Main {
    public static void main(String[] args) {
        Hijo hijo = new Hijo(5000.0, 1000.0);
        hijo.calcularImpuestos();
    }
}

