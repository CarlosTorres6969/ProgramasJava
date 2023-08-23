public class Main {
    // Definición de la interfaz PorPagar
    public interface PorPagar {
        double obtenerMontoPago();
    }

    // Definición de la clase abstracta Empleado que implementa la interfaz PorPagar
    public static abstract class Empleado implements PorPagar {
        private String nombre;
        private double salario;

        // Constructor de la clase Empleado
        public Empleado(String nombre, double salario) {
            this.nombre = nombre;
            this.salario = salario;
        }

        // Método para obtener el nombre del empleado
        public String getNombre() {
            return nombre;
        }

        // Método para obtener el salario del empleado
        public double getSalario() {
            return salario;
        }

        // Implementación del método obtenerMontoPago de la interfaz PorPagar
        @Override
        public double obtenerMontoPago() {
            return salario;
        }

        // Método abstracto que debe ser implementado por las subclases
        public abstract void trabajar();
    }

    // Definición de la clase EmpleadoAsalariado que hereda de la clase Empleado
    public static class EmpleadoAsalariado extends Empleado {
        // Constructor de la clase EmpleadoAsalariado
        public EmpleadoAsalariado(String nombre, double salario) {
            super(nombre, salario);
        }

        // Implementación del método trabajar de la clase EmpleadoAsalariado
        @Override
        public void trabajar() {
            System.out.println("El empleado asalariado está trabajando.");
        }
    }

    // Método main, punto de entrada del programa
    public static void main(String[] args) {
        // Creación de una instancia de EmpleadoAsalariado llamada "empleado"
        EmpleadoAsalariado empleado = new EmpleadoAsalariado("Juan", 2000.0);

        // Obtención del nombre, salario y monto de pago del empleado
        System.out.println("Nombre: " + empleado.getNombre());
        System.out.println("Salario: " + empleado.getSalario());
        System.out.println("Monto de pago: " + empleado.obtenerMontoPago());

        // Llamada al método trabajar del empleado
        empleado.trabajar();
    }
}
