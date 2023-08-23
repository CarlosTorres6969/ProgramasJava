// Figura 7.11: RepartirCartas.java
// Programa para repartir una mano de póquer de cinco cartas.

public class App{
    public static void main(String[] args) {
        PaqueteDeCartas miPaqueteDeCartas = new PaqueteDeCartas();
        miPaqueteDeCartas.barajar(); // coloca Cartas en orden aleatorio

        // imprime las 5 cartas principales
        for (int i = 0; i < 5; i++) {
            Carta cartaActual = miPaqueteDeCartas.repartirCarta();
            System.out.printf("%-19s", cartaActual);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

        // verifica el tipo de mano
        if (miPaqueteDeCartas.contienePar()) {
            System.out.println("La mano contiene un par");
        }

        if (miPaqueteDeCartas.contieneDosPares()) {
            System.out.println("La mano contiene dos pares");
        }

        if (miPaqueteDeCartas.contieneTercia()) {
            System.out.println("La mano contiene una tercia");
        }

        if (miPaqueteDeCartas.contienePoker()) {
            System.out.println("La mano contiene un póquer");
        }

        if (miPaqueteDeCartas.contieneCorrida()) {
            System.out.println("La mano contiene una corrida");
        }

        if (miPaqueteDeCartas.contieneEscalera()) {
            System.out.println("La mano contiene una escalera");
        }

        if (miPaqueteDeCartas.contieneFullHouse()) {
            System.out.println("La mano contiene un Full House");
        }
    }
}

// Figura 7.10: PaqueteDeCartas.java
// Clase PaqueteDeCartas representa un paquete de cartas

import java.util.Random;

public class PaqueteDeCartas {
    private Carta[] paquete; // arreglo de objetos Carta
    private int cartaActual; // subíndice de la siguiente Carta a repartir (0-51)
    private static final int NUMERO_DE_CARTAS = 52; // número constante de Cartas
    private static final Random numerosAleatorios = new Random(); // generador de números aleatorios

    // el constructor llena el paquete de Cartas
    public PaqueteDeCartas() {
        String[] caras = {"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Joto", "Reina", "Rey"};
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Espadas"};

        paquete = new Carta[NUMERO_DE_CARTAS]; // crea arreglo de objetos Carta
        cartaActual = 0; // establece cartaActual como la primera Carta

        // llena el paquete con objetos Carta
        for (int cuenta = 0; cuenta < paquete.length; cuenta++) {
            paquete[cuenta] = new Carta(caras[cuenta % 13], palos[cuenta / 13]);
        }
    }

    // baraja las cartas con algoritmo de una pasada
    public void barajar() {
        cartaActual = 0; // establece cartaActual de nuevo en la primera Carta

        // para cada Carta, selecciona otra Carta aleatoria (0-51) y las intercambia
        for (int primera = 0; primera < paquete.length; primera++) {
            int segunda = numerosAleatorios.nextInt(NUMERO_DE_CARTAS);

            // intercambia Carta actual con Carta aleatoria
            Carta temp = paquete[primera];
            paquete[primera] = paquete[segunda];
            paquete[segunda] = temp;
        }
    }

    // reparte una Carta
    public Carta repartirCarta() {
        // determina si quedan cartas por repartir
        if (cartaActual < paquete.length) {
            return paquete[cartaActual++]; // devuelve la siguiente Carta
        } else {
            return null; // devuelve null para indicar que se repartieron todas las cartas
        }
    }

    // Determina si una mano contiene un par
    public boolean contienePar() {
        int[] contadorCaras = new int[13];

        for (Carta carta : paquete) {
            contadorCaras[carta.getValor() - 1]++;
        }

        for (int cuenta : contadorCaras) {
            if (cuenta == 2) {
                return true;
            }
        }

        return false;
    }

    // Determina si una mano contiene dos pares
    public boolean contieneDosPares() {
        int[] contadorCaras = new int[13];
        int contadorPares = 0;

        for (Carta carta : paquete) {
            contadorCaras[carta.getValor() - 1]++;
        }

        for (int cuenta : contadorCaras) {
            if (cuenta == 2) {
                contadorPares++;
            }
        }

        return contadorPares == 2;
    }

    // Determina si una mano contiene una tercia
    public boolean contieneTercia() {
        int[] contadorCaras = new int[13];

        for (Carta carta : paquete) {
            contadorCaras[carta.getValor() - 1]++;
        }

        for (int cuenta : contadorCaras) {
            if (cuenta == 3) {
                return true;
            }
        }

        return false;
    }

    // Determina si una mano contiene un póquer
    public boolean contienePoker() {
        int[] contadorCaras = new int[13];

        for (Carta carta : paquete) {
            contadorCaras[carta.getValor() - 1]++;
        }

        for (int cuenta : contadorCaras) {
            if (cuenta == 4) {
                return true;
            }
        }

        return false;
    }

    // Determina si una mano contiene una corrida
    public boolean contieneCorrida() {
        for (int i = 0; i < NUMERO_DE_CARTAS - 1; i++) {
            if (!paquete[i].getPalo().equals(paquete[i + 1].getPalo())) {
                return false;
            }
        }

        return true;
    }

    // Determina si una mano contiene una escalera
    public boolean contieneEscalera() {
        int[] contadorCaras = new int[13];

        for (Carta carta : paquete) {
            contadorCaras[carta.getValor() - 1]++;
        }

        int contadorConsecutivas = 0;
        for (int cuenta : contadorCaras) {
            if (cuenta > 0) {
                contadorConsecutivas++;
            } else {
                contadorConsecutivas = 0;
            }

            if (contadorConsecutivas == 5) {
                return true;
            }
        }

        return false;
    }

    // Determina si una mano contiene un Full House
    public boolean contieneFullHouse() {
        int[] contadorCaras = new int[13];
        boolean tercia = false;
        boolean par = false;

        for (Carta carta : paquete) {
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

// Figura 7.9: Carta.java
// La clase Carta representa una carta de juego.

public class Carta {
    private final String cara; // cara de la carta ("As", "Dos", ...)
    private final String palo; // palo de la carta ("Corazones", "Diamantes", ...)

    // el constructor de dos argumentos inicializa la cara y el palo de una carta
    public Carta(String cara, String palo) {
        this.cara = cara;
        this.palo = palo;
    }

    // devuelve representación String de Carta
    @Override
    public String toString() {
        return cara + " de " + palo;
    }

    // Obtener el valor de la carta
    public int getValor() {
        switch (cara) {
            case "As":
                return 1;
            case "Dos":
                return 2;
            case "Tres":
                return 3;
            case "Cuatro":
                return 4;
            case "Cinco":
                return 5;
            case "Seis":
                return 6;
            case "Siete":
                return 7;
            case "Ocho":
                return 8;
            case "Nueve":
                return 9;
            case "Diez":
                return 10;
            case "Joto":
                return 11;
            case "Reina":
                return 12;
            case "Rey":
                return 13;
            default:
                return 0;
        }
    }

    // Obtener el palo de la carta
    public String getPalo() {
        return palo;
    }
}
