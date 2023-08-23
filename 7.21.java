public class App {
    private static final int FILAS = 20;
    private static final int COLUMNAS = 20;
    private int[][] piso; // El piso de dibujo
    private int posicionX; // Posición X actual de la tortuga
    private int posicionY; // Posición Y actual de la tortuga
    private boolean boligrafoAbajo; // Indica si el bolígrafo está abajo o arriba

    public App () {
        piso = new int[FILAS][COLUMNAS];
        posicionX = 0;
        posicionY = 0;
        boligrafoAbajo = false;
    }

    public void ejecutarComandos(int[] comandos) {
        for (int comando : comandos) {
            int accion = comando / 100;
            int valor = comando % 100;

            switch (accion) {
                case 1:
                    boligrafoAbajo = false; // Levantar el bolígrafo
                    break;
                case 2:
                    boligrafoAbajo = true; // Bajar el bolígrafo
                    break;
                case 3:
                    girarDerecha(valor); // Girar a la derecha
                    break;
                case 4:
                    girarIzquierda(valor); // Girar a la izquierda
                    break;
                case 5:
                    avanzar(valor); // Avanzar
                    break;
                case 6:
                    imprimirPiso(); // Imprimir el piso de dibujo
                    break;
            }
        }
    }

    private void girarDerecha(int grados) {
        int cantidadGiros = grados / 45;
        int direccionActual = gradosToDireccion(posicionX, posicionY);

        for (int i = 0; i < cantidadGiros; i++) {
            direccionActual = (direccionActual + 1) % 4;
        }

        actualizarPosicion(direccionActual);
    }

    private void girarIzquierda(int grados) {
        int cantidadGiros = grados / 45;
        int direccionActual = gradosToDireccion(posicionX, posicionY);

        for (int i = 0; i < cantidadGiros; i++) {
            direccionActual = (direccionActual + 3) % 4;
        }

        actualizarPosicion(direccionActual);
    }

    private void avanzar(int pasos) {
        int direccionActual = gradosToDireccion(posicionX, posicionY);

        for (int i = 0; i < pasos; i++) {
            switch (direccionActual) {
                case 0: // Arriba
                    if (posicionY > 0) {
                        posicionY--;
                    }
                    break;
                case 1: // Derecha
                    if (posicionX < COLUMNAS - 1) {
                        posicionX++;
                    }
                    break;
                case 2: // Abajo
                    if (posicionY < FILAS - 1) {
                        posicionY++;
                    }
                    break;
                case 3: // Izquierda
                    if (posicionX > 0) {
                        posicionX--;
                    }
                    break;
            }

            if (boligrafoAbajo) {
                piso[posicionY][posicionX] = 1; // Marcar el piso en la posición actual
            }
        }
    }

    private void actualizarPosicion(int nuevaDireccion) {
        int direccionActual = gradosToDireccion(posicionX, posicionY);

        if (nuevaDireccion != direccionActual) {
            avanzar(1);
            actualizarPosicion(nuevaDireccion);
        }
    }

    private int gradosToDireccion(int x, int y) {
        if (y == 0) {
            return 0; // Arriba
        } else if (x == COLUMNAS - 1) {
            return 1; // Derecha
        } else if (y == FILAS - 1) {
            return 2; // Abajo
        } else if (x == 0) {
            return 3; // Izquierda
        }

        return -1;
    }

    private void imprimirPiso() {
        for (int[] fila : piso) {
            for (int valor : fila) {
                if (valor == 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] comandos = {2, 5, 12, 3, 10, 3, 10, 3, 10, 3, 10, 4, 90, 5, 12, 4, 90, 5, 12, 4, 90, 5, 12, 1, 6};
        App simulador = new App();
        simulador.ejecutarComandos(comandos);
    }
}
