package es.drodriguez.com;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("HOlA! Introduce los 5 elementos que quieres almacenar e invertir, debes introducirlos en orden");
        Scanner Sc = new Scanner(System.in);
        int[]vector = new int [5];
        introduceNumeros(vector);
        ordenInvertido(vector);
    }

    public static int[] introduceNumeros(int[] vector){
        for (int i = 0; i < vector.length; i++){
            Scanner sc= new Scanner(System.in);
            System.out.println("Introduce el valor para almacenar: ");
            vector[i]=sc.nextInt();
        }
        return vector;
    }

    private static void ordenInvertido(int[]vector) {
        int longitud = vector.length-1;
        for (int i = 0; i < longitud/2; i++) {
            int temporal = vector[i];
            vector[i] = vector[longitud - i];
            vector[longitud - i] = temporal;
            System.out.println("El vector invertido es: " +Arrays.toString(vector));
        }
    }
}