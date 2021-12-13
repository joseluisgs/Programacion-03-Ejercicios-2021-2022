package es.dani;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Daniel Carmona Rodriguez
 */
public class Main {

    public static void main(String[] args) {
	int[] vector= new int [5];

    getVector(vector);
    imprimirVector(vector);

    vectorReves(vector);

    System.out.println("Vector al reves");
    imprimirVector(vector);

    }
    /**
     * Procedimiento que invierte el orden del vector
     * @param vectorA vector que queremos invertir
     */
    public static void vectorReves(int[] vectorA){
        int j= vectorA.length-1;
        for (int i = 0; i < vectorA.length; i++){
            if (i < j) {
                int pos = vectorA[i];
                vectorA[i] = vectorA[j];
                vectorA[j] = pos;
                j--;
            }
        }
    }
    /**
     * Procedimiento que genera numeros aleatorios en las posiciones del vector
     * @param vectorA vector donde queremos almacenar los datos
     */
    public static void getVector(int[] vectorA){
        Scanner sc= new Scanner(System.in);
        for (int i = 0; i < vectorA.length ; i++) {
            vectorA[i]= (int)(Math.random()*10 + 1);

        }
    }
    /**
     * Procedimiento para imprimir el vector por pantalla
     * @param vectorA vector que queremos imprimir
     */
    public static void imprimirVector(int[] vectorA){
        System.out.println("Vector: "+ Arrays.toString(vectorA));
    }
}
