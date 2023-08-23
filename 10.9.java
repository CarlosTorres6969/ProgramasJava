public class Main {
    // Definición de la interfaz Saludable
    public interface Saludable {
        // Método abstracto sin implementación
        void saludar();

        // Método default con una implementación predeterminada
        default void despedirse() {
            System.out.println("¡Hasta luego!");
        }
    }

    // Definición de la clase Persona que implementa la interfaz Saludable
    public static class Persona implements Saludable {
        @Override
        public void saludar() {
            System.out.println("¡Hola!");
        }
    }

    // Método main para ejecutar el programa
    public static void main(String[] args) {
        // Creación de una instancia de la clase Persona
        Persona persona = new Persona();
        
        // Llamada al método saludar() de la instancia de Persona
        persona.saludar();

        // Llamada al método despedirse() de la instancia de Persona
        persona.despedirse(); // Utilizando el nuevo método default
    }
}
