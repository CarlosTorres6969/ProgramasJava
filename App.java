public class Main {
    public static void main(String[] args) {
        try {
            unMetodo();
        } catch (Exception excepcion) {
            System.out.println("Excepción atrapada en el método main:");
            excepcion.printStackTrace();
        }
    }

    static void unMetodo() throws Exception {
        try {
            unMetodo2();
        } catch (Exception excepcion) {
            System.out.println("Excepción atrapada en el método unMetodo, volviendo a lanzar...");
            throw excepcion; // Volvemos a lanzar la excepción
        }
    }

    static void unMetodo2() throws Exception {
        throw new Exception("Excepción lanzada desde el método unMetodo2");
    }
}
