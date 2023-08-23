// Definición del tipo enum LuzSemaforo
enum LuzSemaforo {
    ROJO(30), // Duración del semáforo en rojo: 30 segundos
    VERDE(60), // Duración del semáforo en verde: 60 segundos
    AMARILLO(5); // Duración del semáforo en amarillo: 5 segundos

    private int duracion; // Duración de la luz

    // Constructor de la constante enum con parámetro de duración
    LuzSemaforo(int duracion) {
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }
}

public class PruebaLuzSemaforo {
    public static void main(String[] args) {
        // Iterar sobre las constantes de la enum LuzSemaforo
        for (LuzSemaforo luz : LuzSemaforo.values()) {
            System.out.println(luz + " - Duración: " + luz.getDuracion() + " segundos");
        }
    }
}
