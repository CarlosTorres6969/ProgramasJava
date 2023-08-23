import java.util.Arrays;

public class App {
    private static final int TAMANIO_TABLERO = 8;
    private static final int NUM_MOVIMIENTOS = 64;

    private static final int[] MOVIMIENTO_FILA = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] MOVIMIENTO_COLUMNA = {1, 2, 2, 1, -1, -2, -2, -1};

    private static int[][] tablero;
    private static int[][] movimientosPosibles;
    private static int contadorMovimientos;

    public static void main(String[] args) {
        int filaInicial = 0;
        int columnaInicial = 0;

        tablero = new int[TAMANIO_TABLERO][TAMANIO_TABLERO];
        movimientosPosibles = new int[NUM_MOVIMIENTOS][2];
        contadorMovimientos = 0;

        // Realizar el paseo del caballo
        realizarPaseoCaballo(filaInicial, columnaInicial);

        // Mostrar el tablero
        System.out.println("Tablero:");
        mostrarTablero();

        // Comprobar si el paseo fue completo y cerrado
        boolean paseoCompleto = contadorMovimientos == NUM_MOVIMIENTOS;
        boolean paseoCerrado = esPaseoCerrado(filaInicial, columnaInicial);

        // Mostrar los resultados
        System.out.println("Paseo completo: " + paseoCompleto);
        System.out.println("Paseo cerrado: " + paseoCerrado);
    }

    private static void realizarPaseoCaballo(int filaActual, int columnaActual) {
        tablero[filaActual][columnaActual] = contadorMovimientos + 1;
        movimientosPosibles[contadorMovimientos][0] = filaActual;
        movimientosPosibles[contadorMovimientos][1] = columnaActual;

        contadorMovimientos++;

        if (contadorMovimientos == NUM_MOVIMIENTOS) {
            return; // Paseo completo
        }

        for (int i = 0; i < MOVIMIENTO_FILA.length; i++) {
            int nuevaFila = filaActual + MOVIMIENTO_FILA[i];
            int nuevaColumna = columnaActual + MOVIMIENTO_COLUMNA[i];

            if (esMovimientoValido(nuevaFila, nuevaColumna)) {
                realizarPaseoCaballo(nuevaFila, nuevaColumna);
                if (contadorMovimientos == NUM_MOVIMIENTOS) {
                    return; // Paseo completo
                }
            }
        }

        // Si no se completó el paseo, retroceder un movimiento
        contadorMovimientos--;
        tablero[filaActual][columnaActual] = 0;
    }

    private static boolean esMovimientoValido(int fila, int columna) {
        return fila >= 0 && fila < TAMANIO_TABLERO &&
                columna >= 0 && columna < TAMANIO_TABLERO &&
                tablero[fila][columna] == 0;
    }

    private static boolean esPaseoCerrado(int filaInicial, int columnaInicial) {
        for (int i = 0; i < MOVIMIENTO_FILA.length; i++) {
            int nuevaFila = filaInicial + MOVIMIENTO_FILA[i];
            int nuevaColumna = columnaInicial + MOVIMIENTO_COLUMNA[i];

            if (esMovimientoValido(nuevaFila, nuevaColumna)) {
                for (int j = 0; j < MOVIMIENTO_FILA.length; j++) {
                    int filaRegreso = nuevaFila + MOVIMIENTO_FILA[j];
                    int columnaRegreso = nuevaColumna + MOVIMIENTO_COLUMNA[j];
                    if (filaRegreso == filaInicial && columnaRegreso == columnaInicial) {
                        return true; // Se encontró un paseo cerrado
                    }
                }
            }
        }
        return false; // No se encontró un paseo cerrado
    }

    private static void mostrarTablero() {
        for (int[] fila : tablero) {
            System.out.println(Arrays.toString(fila));
        }
    }
}
