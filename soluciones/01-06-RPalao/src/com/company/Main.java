package com.company;

import java.util.Scanner;

/**
 * @author Rocío Palao Fernández
 * @date 10/11/2021
 * github: Rochiio
 * Realizar un programa que le pida al usuario una cadena y le pregunte por otra. Debe
 * comprobar si la segunda cadena está incluida en la primera.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
	    String cadenaUno;

        System.out.println("Dime la primera cadena: ");
        cadenaUno=sc.nextLine();

        //Comprobación
        cadenaIncluida(cadenaUno);

    }

    public static void cadenaIncluida(String cadenaUno){
        Scanner sc= new Scanner(System.in);
        String cadenaDos;

        System.out.println("Dime la segunda cadena: ");
        cadenaDos=sc.nextLine();

        if (cadenaUno.contains(cadenaDos)) {
            System.out.println("La segunda cadena sí que está en la cadena 1");
        } else {
            System.out.println("La segunda cadena no está en la cadena 1");
        }
    }
}
