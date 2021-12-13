package es.dani;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author Daniel Carmona Rodriguez
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabra;

        System.out.print("Introduce una palabra: ");
        palabra= sc.next();
        System.out.println(palabra);
        isPalindromo(palabra);
    }

    /**
     * Procedimiento que compreba si una cadena es palindromo
     * @param palabra cadena que queremos comprobar si es palindromo
     */
    public static void isPalindromo(String palabra){
        String invertida;
        invertida = new StringBuilder(palabra).reverse().toString();
        System.out.println(palabra.equals(invertida) ? "Es palindromo."  : "No es palindromo.");
    }
}
