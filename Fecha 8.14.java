public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    // Constructor con tres valores enteros (MM/DD/AAAA)
    public Fecha(int mes, int dia, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Constructor con un objeto String y dos valores enteros ("Junio 14, 1992")
    public Fecha(String fechaString, int dia, int anio) {
        String[] partes = fechaString.split(" ");
        String mesString = partes[0];
        this.dia = dia;
        this.mes = convertirMesANumero(mesString);
        this.anio = anio;
    }

    // Constructor con dos valores enteros (DDD AAAA)
    public Fecha(int diaDelAnio, int anio) {
        this.anio = anio;
        // Aquí se asume que el día del año debe estar en el rango válido
        // Se omite la validación para simplificar el ejemplo
        this.mes = obtenerMesDelDiaDelAnio(diaDelAnio);
        this.dia = obtenerDiaDelMesDelDiaDelAnio(diaDelAnio);
    }

    // Método para obtener el nombre del mes según su número
    private String obtenerNombreMes() {
        switch (mes) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Septiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "";
        }
    }

    // Método para convertir el nombre del mes en su número correspondiente
    private int convertirMesANumero(String mesString) {
        switch (mesString) {
            case "Enero":
                return 1;
            case "Febrero":
                return 2;
            case "Marzo":
                return 3;
            case "Abril":
                return 4;
            case "Mayo":
                return 5;
            case "Junio":
                return 6;
            case "Julio":
                return 7;
            case "Agosto":
                return 8;
            case "Septiembre":
                return 9;
            case "Octubre":
                return 10;
            case "Noviembre":
                return 11;
            case "Diciembre":
                return 12;
            default:
                return 0;
        }
    }

    // Método para obtener el número del mes a partir del día del año
    private int obtenerMesDelDiaDelAnio(int diaDelAnio) {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int mes = 1;
        int acumulador = diasPorMes[0];

        while (diaDelAnio > acumulador) {
            mes++;
            acumulador += diasPorMes[mes - 1];
        }

        return mes;
    }

    // Método para obtener el día del mes a partir del día del año
    private int obtenerDiaDelMesDelDiaDelAnio(int diaDelAnio) {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int mes = obtenerMesDelDiaDelAnio(diaDelAnio);
        int acumulador = 0;

        for (int i = 0; i < mes - 1; i++) {
            acumulador += diasPorMes[i];
        }

        return diaDelAnio - acumulador;
    }

    // Método para imprimir la fecha en el formato MM/DD/AAAA
    public void imprimirFormato1() {
        System.out.printf("%02d/%02d/%04d%n", mes, dia, anio);
    }

    // Método para imprimir la fecha en el formato "Junio 14, 1992"
    public void imprimirFormato2() {
        String nombreMes = obtenerNombreMes();
        System.out.printf("%s %02d, %04d%n", nombreMes, dia, anio);
    }

    // Método para imprimir la fecha en el formato DDD AAAA
    public void imprimirFormato3() {
        int diaDelAnio = obtenerDiaDelAnio();
        System.out.printf("%03d %04d%n", diaDelAnio, anio);
    }

    // Método para obtener el día del año correspondiente a la fecha
    private int obtenerDiaDelAnio() {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int diaDelAnio = dia;

        for (int i = 0; i < mes - 1; i++) {
            diaDelAnio += diasPorMes[i];
        }

        return diaDelAnio;
    }

    public static void main(String[] args) {
        // Crear objeto Fecha utilizando el primer constructor
        Fecha fecha1 = new Fecha(6, 14, 1992);
        System.out.print("Formato 1: ");
        fecha1.imprimirFormato1();
        System.out.print("Formato 2: ");
        fecha1.imprimirFormato2();
        System.out.print("Formato 3: ");
        fecha1.imprimirFormato3();

        System.out.println();

        // Crear objeto Fecha utilizando el segundo constructor
        Fecha fecha2 = new Fecha("Junio", 14, 1992);
        System.out.print("Formato 1: ");
        fecha2.imprimirFormato1();
        System.out.print("Formato 2: ");
        fecha2.imprimirFormato2();
        System.out.print("Formato 3: ");
        fecha2.imprimirFormato3();

        System.out.println();

        // Crear objeto Fecha utilizando el tercer constructor
        Fecha fecha3 = new Fecha(166, 1992);
        System.out.print("Formato 1: ");
        fecha3.imprimirFormato1();
        System.out.print("Formato 2: ");
        fecha3.imprimirFormato2();
        System.out.print("Formato 3: ");
        fecha3.imprimirFormato3();
    }
}
