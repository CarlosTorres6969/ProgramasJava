public class Tiempo2 {
    private int segundosDesdeMedianoche; // Representa el número de segundos transcurridos desde medianoche

    public Tiempo2() {
        this(0, 0, 0); // Invoca al constructor con tres argumentos pasando valores predeterminados
    }

    public Tiempo2(int horas, int minutos, int segundos) {
        establecerTiempo(horas, minutos, segundos); // Establece el tiempo utilizando los valores proporcionados
    }

    public void establecerTiempo(int horas, int minutos, int segundos) {
        segundosDesdeMedianoche = horas * 3600 + minutos * 60 + segundos; // Calcula el total de segundos desde medianoche
    }

    public String obtenerTiempoUniversal() {
        int horas = segundosDesdeMedianoche / 3600; // Calcula las horas
        int minutos = (segundosDesdeMedianoche % 3600) / 60; // Calcula los minutos
        int segundos = segundosDesdeMedianoche % 60; // Calcula los segundos

        // Retorna el tiempo en formato de cadena HH:MM:SS
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public String toString() {
        return obtenerTiempoUniversal(); // Retorna el tiempo en formato HH:MM:SS llamando al método obtenerTiempoUniversal()
    }

    public static void main(String[] args) {
        Tiempo2 tiempo = new Tiempo2(); // Crea un objeto Tiempo2

        System.out.println("Tiempo Universal: " + tiempo.obtenerTiempoUniversal()); // Muestra el tiempo universal
        System.out.println("Tiempo: " + tiempo); // Muestra el tiempo utilizando el método toString()
    }
}
