import java.util.Arrays;

public class EnteroEnorme {
    private int[] digitos;

    public EnteroEnorme() {
        digitos = new int[40];
    }

    // Método estático para crear un objeto EnteroEnorme a partir de una cadena numérica
    public static EnteroEnorme parse(String numero) {
        EnteroEnorme entero = new EnteroEnorme();
        int longitud = numero.length();
        int inicio = 40 - longitud;

        // Extraer cada dígito de la cadena y almacenarlo en el arreglo de dígitos del objeto EnteroEnorme
        for (int i = 0; i < longitud; i++) {
            char digitoChar = numero.charAt(i);
            int digito = Character.getNumericValue(digitoChar);
            entero.digitos[inicio + i] = digito;
        }

        return entero;
    }

    // Método toString para convertir el objeto EnteroEnorme en una representación de cadena
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int primerDigito = obtenerPrimerDigitoNoCero();
        if (primerDigito == -1) {
            return "0";
        }

        // Construir la cadena a partir de los dígitos del objeto EnteroEnorme
        for (int i = primerDigito; i < 40; i++) {
            sb.append(digitos[i]);
        }

        return sb.toString();
    }

    // Método para sumar dos objetos EnteroEnorme
    public EnteroEnorme sumar(EnteroEnorme otro) {
        EnteroEnorme resultado = new EnteroEnorme();
        int acarreo = 0;

        // Realizar la suma dígito a dígito, considerando el acarreo
        for (int i = 39; i >= 0; i--) {
            int suma = digitos[i] + otro.digitos[i] + acarreo;
            resultado.digitos[i] = suma % 10;
            acarreo = suma / 10;
        }

        return resultado;
    }

    // Método para restar dos objetos EnteroEnorme
    public EnteroEnorme restar(EnteroEnorme otro) {
        EnteroEnorme resultado = new EnteroEnorme();
        int acarreo = 0;

        // Realizar la resta dígito a dígito, considerando el acarreo
        for (int i = 39; i >= 0; i--) {
            int resta = digitos[i] - otro.digitos[i] - acarreo;
            if (resta < 0) {
                resta += 10;
                acarreo = 1;
            } else {
                acarreo = 0;
            }
            resultado.digitos[i] = resta;
        }

        return resultado;
    }

    // Método para verificar si dos objetos EnteroEnorme son iguales
    public boolean esIgualA(EnteroEnorme otro) {
        return Arrays.equals(digitos, otro.digitos);
    }

    // Método para verificar si dos objetos EnteroEnorme no son iguales
    public boolean noEsIgualA(EnteroEnorme otro) {
        return !esIgualA(otro);
    }

    // Método para verificar si un objeto EnteroEnorme es mayor que otro
    public boolean esMayorQue(EnteroEnorme otro) {
        for (int i = 0; i < 40; i++) {
            if (digitos[i] > otro.digitos[i]) {
                return true;
            } else if (digitos[i] < otro.digitos[i]) {
                return false;
            }
        }

        return false;
    }

    // Método para verificar si un objeto EnteroEnorme es menor que otro
    public boolean esMenorQue(EnteroEnorme otro) {
        return !esMayorQue(otro) && noEsIgualA(otro);
    }

    // Método para verificar si un objeto EnteroEnorme es mayor o igual que otro
    public boolean esMayorOIgualA(EnteroEnorme otro) {
        return esMayorQue(otro) || esIgualA(otro);
    }

    // Método para verificar si un objeto EnteroEnorme es menor o igual que otro
    public boolean esMenorOIgualA(EnteroEnorme otro) {
        return esMenorQue(otro) || esIgualA(otro);
    }

    // Método para verificar si un objeto EnteroEnorme es cero
    public boolean esCero() {
        for (int i = 0; i < 40; i++) {
            if (digitos[i] != 0) {
                return false;
            }
        }
        return true;
    }

    // Método privado para obtener el índice del primer dígito no cero en el objeto EnteroEnorme
    private int obtenerPrimerDigitoNoCero() {
        for (int i = 0; i < 40; i++) {
            if (digitos[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    // Método main para probar la clase EnteroEnorme
    public static void main(String[] args) {
        EnteroEnorme numero1 = EnteroEnorme.parse("1234567890123456789012345678901234567890");
        EnteroEnorme numero2 = EnteroEnorme.parse("9876543210987654321098765432109876543210");

        System.out.println("Número 1: " + numero1.toString());
        System.out.println("Número 2: " + numero2.toString());

        EnteroEnorme suma = numero1.sumar(numero2);
        System.out.println("Suma: " + suma.toString());

        EnteroEnorme resta = numero1.restar(numero2);
        System.out.println("Resta: " + resta.toString());

        boolean igual = numero1.esIgualA(numero2);
        System.out.println("¿Iguales?: " + igual);

        boolean mayor = numero1.esMayorQue(numero2);
        System.out.println("¿Mayor?: " + mayor);

        boolean menor = numero1.esMenorQue(numero2);
        System.out.println("¿Menor?: " + menor);
    }
}
