import java.util.Random;

public class JuegoPoker {
    public static void main(String[] args) {
        PaqueteDeCartas paquete = new PaqueteDeCartas();
        paquete.barajar(); // baraja el paquete de cartas

        // reparte dos manos de póquer
        ManoPoker mano1 = new ManoPoker();
        ManoPoker mano2 = new ManoPoker();

        for (int i = 0; i < 5; i++) {
            mano1.agregarCarta(paquete.repartirCarta());
            mano2.agregarCarta(paquete.repartirCarta());
        }

        // evalúa las manos y muestra los resultados
        System.out.println("Mano 1: ");
        mano1.mostrarMano();
        System.out.println("Evaluación: " + mano1.evaluarMano());

        System.out.println("\nMano 2: ");
        mano2.mostrarMano();
        System.out.println("Evaluación: " + mano2.evaluarMano());

        // determina cuál de las dos manos es mejor
        if (mano1.evaluarMano() > mano2.evaluarMano()) {
            System.out.println("\nMano 1 es mejor que Mano 2");
        } else if (mano1.evaluarMano() < mano2.evaluarMano()) {
            System.out.println("\nMano 2 es mejor que Mano 1");
        } else {
            System.out.println("\nEmpate");
        }
    }
}

class ManoPoker {
    private Carta[] mano; // arreglo de objetos Carta
    private static final int NUMERO_DE_CARTAS = 5; // número constante de Cartas en una mano

    // el constructor llena la mano con Cartas
    public ManoPoker() {
        mano = new Carta[NUMERO_DE_CARTAS];
    }

    // agrega una Carta a la Mano
    public void agregarCarta(Carta carta) {
        for (int i = 0; i < NUMERO_DE_CARTAS; i++) {
            if (mano[i] == null) {
                mano[i] = carta;
                break;
            }
        }
    }

    // muestra la mano de póquer
    public void mostrarMano() {
        for (int i = 0; i < NUMERO_DE_CARTAS; i++) {
            System.out.println(mano[i]);
        }
    }

    // evalúa la mano de póquer y devuelve el valor de evaluación
    public int evaluarMano() {
        if (contienePoker()) {
            return 7;
        } else if (contieneFullHouse()) {
            return 6;
        } else if (contieneEscalera()) {
            return 5;
        } else if (contieneTercia()) {
            return 4;
        } else if (contieneDosPares()) {
            return 3;
        } else if (contienePar()) {
            return 2;
        } else {
            return 1; // mano sin combinaciones especiales
        }
    }

    // Métodos para determinar las combinaciones de mano

    // ...

    // Determina si una mano contiene un par
    public boolean contienePar() {
        int[] contadorCaras = new int[13];

        for (Carta carta : mano) {
            contadorCaras[carta.getValor() - 1]++;
        }

        for (int cuenta : contadorCaras) {
            if (cuenta == 2) {
                return true;
            }
        }

        return false;
    }

    // ...

    // Determina si una mano contiene una escalera
    public boolean contieneEscalera() {
        int[] contadorCaras = new int[13];

        for (Carta carta : mano) {
            contadorCaras[carta.getValor() - 1]++;
        }

        int contadorConsecutivas = 0;
        int contadorConsecutivasMax = 0;

        for (int cuenta : contadorCaras) {
            if (cuenta > 0) {
                contadorConsecutivas++;
                contadorConsecutivasMax = Math.max(contadorConsecutivasMax, contadorConsecutivas);
            } else {
                contadorConsecutivas = 0;
            }
        }

        return contadorConsecutivasMax >= 5;
    }

    // ...

    // Determina si una mano contiene un Full House
    public boolean contieneFullHouse() {
        int[] contadorCaras = new int[13];
        boolean tercia = false;
        boolean par = false;

        for (Carta carta : mano) {
            contadorCaras[carta.getValor() - 1]++;
        }

        for (int cuenta : contadorCaras) {
            if (cuenta == 3) {
                tercia = true;
            } else if (cuenta == 2) {
                par = true;
            }
        }

        return tercia && par;
    }
}

class PaqueteDeCartas {
    private Carta[] paquete; // arreglo de objetos Carta
    private int cartaActual; // subíndice de la siguiente Carta a repartir (0-51)
    private static final int NUMERO_DE_CARTAS = 52; // número constante de cartas

    // generador de números aleatorios
    private static final Random numerosAleatorios = new Random();

    // el constructor llena el paquete de cartas
    public PaqueteDeCartas() {
        String[] caras = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis",
                "Siete", "Ocho", "Nueve", "Diez", "Joker", "Reina", "Rey"};
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Espadas"};

        paquete = new Carta[NUMERO_DE_CARTAS]; // crea arreglo de objetos Carta
        cartaActual = 0; // establece cartaActual para que sea la primera Carta

        // llena el paquete con objetos Carta
        for (int cuenta = 0; cuenta < paquete.length; cuenta++) {
            paquete[cuenta] = new Carta(caras[cuenta % 13], palos[cuenta / 13]);
        }
    }

    // baraja el paquete de Cartas con un algoritmo de una pasada
    public void barajar() {
        cartaActual = 0; // reinicia cartaActual

        // para cada Carta, selecciona otra Carta aleatoria y las intercambia
        for (int primera = 0; primera < paquete.length; primera++) {
            // selecciona un número aleatorio entre 0 y 51
            int segunda = numerosAleatorios.nextInt(NUMERO_DE_CARTAS);

            // intercambia la Carta actual con la Carta seleccionada al azar
            Carta temp = paquete[primera];
            paquete[primera] = paquete[segunda];
            paquete[segunda] = temp;
        }
    }

    // reparte una Carta
    public Carta repartirCarta() {
        // determina si quedan cartas por repartir
        if (cartaActual < paquete.length) {
            return paquete[cartaActual++]; // devuelve la Carta actual en el arreglo
        } else {
            return null; // devuelve nulo para indicar que se repartieron todas las cartas
        }
    }
}

class Carta {
    private final String cara; // cara de la carta
    private final String palo; // palo de la carta

    // el constructor de dos argumentos inicializa cara y palo de la carta
    public Carta(String caraCarta, String paloCarta) {
        this.cara = caraCarta; // inicializa cara de la carta
        this.palo = paloCarta; // inicializa palo de la carta
    }

    // devuelve representación String de Carta
    @Override
    public String toString() {
        return cara + " de " + palo;
    }
}
