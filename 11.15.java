class ExcepcionA extends Exception {
    public ExcepcionA(String mensaje) {
        super(mensaje);
    }
}

class ExcepcionB extends ExcepcionA {
    public ExcepcionB(String mensaje) {
        super(mensaje);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Lanzar una excepción de tipo ExcepcionB
            throw new ExcepcionB("¡Esto es una ExcepcionB!");
        } catch (ExcepcionA excepcion) {
            System.out.println("Se capturó una excepción de tipo ExcepcionA.");
            System.out.println("Mensaje: " + excepcion.getMessage());
        } catch (ExcepcionB excepcion) {
            System.out.println("Se capturó una excepción de tipo ExcepcionB.");
            System.out.println("Mensaje: " + excepcion.getMessage());
        }
    }
}
