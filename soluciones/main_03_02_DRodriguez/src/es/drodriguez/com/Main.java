package es.drodriguez.com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la palabra que quieres invertir.");
        String cadena = "";
        cadena = sc.nextLine();
        String reverseStr = invertirRecursiva(cadena, cadena.length()-1);
        System.out.println(reverseStr);
    }

    static String invertirRecursiva(String cadena, int i){
        if(i == 0){
            return cadena.charAt(0) + "";
        }
        char letra = cadena.charAt(i);
        return letra + invertirRecursiva(cadena, i-1);
    }
    }
