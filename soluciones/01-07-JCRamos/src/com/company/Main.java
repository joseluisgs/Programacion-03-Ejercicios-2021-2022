/**
 * Autor:Jan Carlos Ramos
 * GitHub: JanCRM
 */
package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
	// write your code here

        numeroCapicua();
    }

    /**
     * Comprobar si un numero es capicúa.
     * El numero es capicúa si se lee igual de derecha izquierda.
     */
    public static void numeroCapicua(){
        Scanner in = new Scanner(System.in);
        int n, aux, inverso = 0, cifras=0;
        do {
            System.out.println("Introducir un numero mayor a 10 ");
            n=in.nextInt();
        }while (n<10);
        aux=n;
        while (aux!=0){
            cifras=aux%10;
            inverso=inverso*10+cifras;
            aux=aux/10;
        }

        if (n==inverso){
            System.out.println("El numero es capicúa");
        }else {
            System.out.println("No es capicúa");
        }




    }


}
