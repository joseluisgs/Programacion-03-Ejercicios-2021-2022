package es.dani;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Daniel Carmona Rodriguez
 */
public class Main {

    public static void main(String[] args) {
        int[] number= new int[4];
        int[] reves= new int[number.length];
        boolean esCapicua;

        introducirDatos(number);

        System.out.print("Vector: ");
        imprimirVector(number);

        reves=reves(number);
        /**
         * Esta seria otra forma de mostrar el reverso.
         */
//        sustituir(number, reves);
//        vectorReves(reves);
//        System.out.print("Vector inverso: ");
//        imprimirVector(reves);
//
        esCapicua= esCapicua(number, reves);
        System.out.println (esCapicua ? "Es capicúa.": "No es capicúa.");


    }
    /**
     * Funcion que invierte un vector
     * @param vector vector que queremos invertir
     * @return devuelve un vector invertido
     */
    public static int[] reves(int[] vector){
        int[] reves= new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            reves[i]= vector[vector.length-1-i];
        }
        return reves;
    }

    /**
     * Procedimiento para introducir datos en cada posicion del vector
     * @param vector vector donde queremos almacenar los datos
     */
    public static void introducirDatos(int[] vector){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < vector.length ; i++) {
            System.out.println("Introduce el vector " + (i + 1) + " : ");
            vector[i]= sc.nextInt();

        }
    }

    /**
     *  Procedimiento para sustituir un vector por otro
     * @param vector vector que queremos sustituir
     * @param vectorA vector donde almacenaremos los datos del anterior
     */
    public static void sustituir(int[]vector, int[] vectorA){
        for (int i = 0; i < vector.length; i++) {
            vectorA[i]= vector[i];
        }
    }
    /**
     * Funcion que nos dice si un vector invertido es capicua o no
     * @param vector Vector original
     * @param vectorB vector del reves
     * @return devuelve true si es capicua, false si no lo es
     */
    public static boolean esCapicua(int[] vector, int[] vectorB){
         boolean esCapicua= true;
         if(vector.length != vectorB.length) esCapicua= false;
         for (int i = 0; i < vector.length ; i++) {
             if (vector[i] != vectorB[i]) esCapicua= false;
         }
         return esCapicua;
    }

    /**
     * Procedimiento para imprimir un vector por pantalla
     * @param vector
     */
    public static void imprimirVector(int[] vector){
        System.out.println(Arrays.toString(vector));
    }

    /**
     * Procemiento para invertir el orden de un vector
     * @param vector vector que queremos invertir
     */
    public static void vectorReves(int[] vector){
        int j= vector.length-1;
        for (int i = 0; i < vector.length ; i++) {
            if (i < j ){
                int pos= vector[i];
                vector[i]= vector[j];
                vector[j]= pos;
                j--;
            }
        }
    }
}
