import java.io.IOException;

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
            // Lanzar una excepción de tipo ExcepcionA
            throw new ExcepcionA("¡Esto es una ExcepcionA!");
        } catch (Exception excepcion) {
            // Capturar la excepción de tipo Exception
            System.out.println("Se capturó una excepción de tipo Exception.");
            System.out.println("Mensaje: " + excepcion.getMessage());
        }

        try {
            // Lanzar una excepción de tipo ExcepcionB
            throw new ExcepcionB("¡Esto es una ExcepcionB!");
        } catch (Exception excepcion) {
            // Capturar la excepción de tipo Exception
            System.out.println("Se capturó una excepción de tipo Exception.");
            System.out.println("Mensaje: " + excepcion.getMessage());
        }

        try {
            // Lanzar una NullPointerException
            String cadena = null;
            cadena.length();
        } catch (Exception excepcion) {
            // Capturar la excepción de tipo Exception
            System.out.println("Se capturó una excepción de tipo Exception.");
            System.out.println("Mensaje: " + excepcion.getMessage());
        }

        try {
            // Lanzar una IOException
            throw new IOException("¡Esto es una IOException!");
        } catch (Exception excepcion) {
            // Capturar la excepción de tipo Exception
            System.out.println("Se capturó una excepción de tipo Exception.");
            System.out.println("Mensaje: " + excepcion.getMessage());
        }
    }
}
