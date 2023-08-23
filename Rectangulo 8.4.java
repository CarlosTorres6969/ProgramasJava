public class Rectangulo {
    private double longitud;
    private double anchura;

    public Rectangulo() {
        this.longitud = 1.0;
        this.anchura = 1.0;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        if (longitud > 0.0 && longitud < 20.0) {
            this.longitud = longitud;
        } else {
            System.out.println("La longitud debe ser un número de punto flotante mayor que 0.0 y menor que 20.0.");
        }
    }

    public double getAnchura() {
        return anchura;
    }

    public void setAnchura(double anchura) {
        if (anchura > 0.0 && anchura < 20.0) {
            this.anchura = anchura;
        } else {
            System.out.println("La anchura debe ser un número de punto flotante mayor que 0.0 y menor que 20.0.");
        }
    }

    public double calcularPerimetro() {
        return 2 * (longitud + anchura);
    }

    public double calcularArea() {
        return longitud * anchura;
    }

    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo();

        System.out.println("Valores predeterminados:");
        System.out.println("Longitud: " + rectangulo.getLongitud());
        System.out.println("Anchura: " + rectangulo.getAnchura());

        rectangulo.setLongitud(5.0);
        rectangulo.setAnchura(3.0);

        System.out.println("\nDespués de establecer los valores:");
        System.out.println("Longitud: " + rectangulo.getLongitud());
        System.out.println("Anchura: " + rectangulo.getAnchura());

        double perimetro = rectangulo.calcularPerimetro();
        double area = rectangulo.calcularArea();

        System.out.println("\nPerímetro: " + perimetro);
        System.out.println("Área: " + area);
    }
}
