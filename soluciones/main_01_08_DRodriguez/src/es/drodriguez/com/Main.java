package es.drodriguez.com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int resultadoIncial = 0;

        Scanner sc = new Scanner(System.in);
        String palabra;
        System.out.println("Dime la palabra que quieres comprobar si es palindromo o no: ");
        palabra = sc.next();
        boolean isPalindromo = false;
        int tamano = palabra.length() -1;
        isPalindromo(palabra, isPalindromo, resultadoIncial, tamano);

    }

    public static void isPalindromo(String palabra, boolean isPalindromo, int resultadoIncial, int tamano){
        while ((resultadoIncial< tamano) && (!isPalindromo)){
            if (palabra.charAt(resultadoIncial)==palabra.charAt(tamano)){
                resultadoIncial++;
                tamano--;
            } else {
                isPalindromo = true;
            }
        }
        if (!isPalindromo)
            System.out.println("La palabra" +palabra + " es un palindromo");
        else
            System.out.println("La palabra" +palabra + " no es un palindromo");
    }
}
