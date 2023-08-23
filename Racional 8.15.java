public class Racional {
    private int numerador;
    private int denominador;

    public Racional() {
        this(1, 2); // Valor predeterminado: 1/2
    }

    public Racional(int numerador, int denominador) {
        int divisorComun = obtenerDivisorComun(numerador, denominador);
        this.numerador = numerador / divisorComun;
        this.denominador = denominador / divisorComun;
    }

    public static Racional sumar(Racional racional1, Racional racional2) {
        int numeradorSuma = racional1.numerador * racional2.denominador + racional2.numerador * racional1.denominador;
        int denominadorSuma = racional1.denominador * racional2.denominador;
        return new Racional(numeradorSuma, denominadorSuma);
    }

    public static Racional restar(Racional racional1, Racional racional2) {
        int numeradorResta = racional1.numerador * racional2.denominador - racional2.numerador * racional1.denominador;
        int denominadorResta = racional1.denominador * racional2.denominador;
        return new Racional(numeradorResta, denominadorResta);
    }

    public static Racional multiplicar(Racional racional1, Racional racional2) {
        int numeradorProducto = racional1.numerador * racional2.numerador;
        int denominadorProducto = racional1.denominador * racional2.denominador;
        return new Racional(numeradorProducto, denominadorProducto);
    }

    public static Racional dividir(Racional racional1, Racional racional2) {
        int numeradorDivision = racional1.numerador * racional2.denominador;
        int denominadorDivision = racional1.denominador * racional2.numerador;
        return new Racional(numeradorDivision, denominadorDivision);
    }

    public String toString() {
        return numerador + "/" + denominador;
    }

    public String toFloatString(int precision) {
        double valorDecimal = (double) numerador / denominador;
        String formato = "%." + precision + "f";
        return String.format(formato, valorDecimal);
    }

    private int obtenerDivisorComun(int a, int b) {
        if (b == 0)
            return a;
        else
            return obtenerDivisorComun(b, a % b);
    }

    public static void main(String[] args) {
        Racional racional1 = new Racional(1, 2);
        Racional racional2 = new Racional(3, 4);

        Racional suma = Racional.sumar(racional1, racional2);
        Racional resta = Racional.restar(racional1, racional2);
        Racional producto = Racional.multiplicar(racional1, racional2);
        Racional division = Racional.dividir(racional1, racional2);

        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Producto: " + producto);
        System.out.println("División: " + division);

        System.out.println("Valor decimal de racional1: " + racional1.toFloatString(2));
        System.out.println("Valor decimal de racional2: " + racional2.toFloatString(2));
    }
}
