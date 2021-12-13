package es.dani;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] vector = new int[10];
        getVector(vector);
        aumentarNumero(vector);
        System.out.println(Arrays.toString(vector));

    }

    /**
     *  Procedimiento para almacenar un dato dado en el primer puesto del vector
     * @param vector vector donde queremos almacenar el dato
     */
    public static void getVector(int[] vector){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer número:");
        vector[0]= sc.nextInt();
    }

    /**
     * Funcion incrementa el valor y lo almacena en cada posicion
     * @param vector vector donde queremos almacenar
     */
    public static void aumentarNumero(int[] vector){
        vector[1]= vector[0] + 1;
        for (int i = 2; i < vector.length ; i++) {
            vector[i]= vector[i-1]+vector[i-2];
        }
    }
}
