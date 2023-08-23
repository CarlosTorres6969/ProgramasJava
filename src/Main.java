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

class ExcepcionC extends ExcepcionB {
    public ExcepcionC(String mensaje) {
        super(mensaje);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Lanzamos una excepción de tipo ExcepcionC
            throw new ExcepcionC("¡Esto es una ExcepcionC!");
        } catch (ExcepcionA e) {
            // Capturamos la excepción de tipo ExcepcionA (que también incluye ExcepcionB y ExcepcionC)
            System.out.println("Se capturó una excepción de tipo ExcepcionA.");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
}
