package es.drodriguez.com;

public class Main {
    public static void main(String[] args) {
        String cadena = "Esto es una prueba de cuantas veces se repite una letra.";
        char letra = 'a';
        reppitLetter(cadena, letra);

    }

    public static void reppitLetter(String cadena, char letra) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == letra) {
                contador++;
            }
        }
        System.out.println("La letra " + letra + " se repite " + contador + " veces.");
    }
}


