package es.dani;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String cadena;
        String segundaCadena;
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una cadena: ");
        cadena= sc.next();
        System.out.println("Introduce otra cadena: ");
        segundaCadena= sc.next();

        System.out.println("La primera cadena es: " + cadena);
        System.out.println("La segunda cadena es: " + segundaCadena);

        System.out.println(cadena.contains(segundaCadena));


    }
}
