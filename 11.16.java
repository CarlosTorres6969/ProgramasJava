class UnaClase {
    public UnaClase() throws Exception {
        // Simulamos una condición que resulta en una falla en el constructor
        throw new Exception("Fallo en el constructor de UnaClase");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Intentamos crear un objeto de tipo UnaClase
            UnaClase objeto = new UnaClase();
        } catch (Exception excepcion) {
            // Capturamos la excepción lanzada desde el constructor
            System.out.println("Se capturó una excepción:");
            System.out.println("Mensaje: " + excepcion.getMessage());
        }
    }
}
