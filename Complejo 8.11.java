public class Complejo {
    private float parteReal;
    private float parteImaginaria;

    // Constructor con valores iniciales
    public Complejo(float parteReal, float parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    // Constructor sin argumentos (valores predeterminados)
    public Complejo() {
        this.parteReal = 0.0f;
        this.parteImaginaria = 0.0f;
    }

    // Método para sumar dos números complejos
    public Complejo sumar(Complejo otro) {
        float nuevaParteReal = this.parteReal + otro.parteReal;
        float nuevaParteImaginaria = this.parteImaginaria + otro.parteImaginaria;
        return new Complejo(nuevaParteReal, nuevaParteImaginaria);
    }

    // Método para restar dos números complejos
    public Complejo restar(Complejo otro) {
        float nuevaParteReal = this.parteReal - otro.parteReal;
        float nuevaParteImaginaria = this.parteImaginaria - otro.parteImaginaria;
        return new Complejo(nuevaParteReal, nuevaParteImaginaria);
    }

    // Método para imprimir el número complejo
    public void imprimir() {
        System.out.println("(" + parteReal + ", " + parteImaginaria + ")");
    }

    public static void main(String[] args) {
        // Crear dos objetos Complejo
        Complejo complejo1 = new Complejo(2.5f, 1.8f);
        Complejo complejo2 = new Complejo(1.3f, 0.7f);

        // Realizar la suma y mostrar el resultado
        Complejo suma = complejo1.sumar(complejo2);
        System.out.print("Suma: ");
        suma.imprimir();

        // Realizar la resta y mostrar el resultado
        Complejo resta = complejo1.restar(complejo2);
        System.out.print("Resta: ");
        resta.imprimir();
    }
}
