package es.dani;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int[] vector= new int[10];
    getVector(vector);
    aumentarNumero(vector);
    System.out.println(Arrays.toString(vector));

    }
    /**
     * Procedimiento que permite introducir un numero en el primer puesto del vector
     * @param vector vector donde queremos almacenar
     */
    public static void getVector(int[] vector){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer número:");
        vector[0]= sc.nextInt();
    }

    /**
     * Procedimiento que aumenta el numero y lo almacena en el resto
     * @param vector vector donde almacenamos los datos
     */
    public static void aumentarNumero(int[] vector){
        for (int i = 1; i < vector.length ; i++) {
            vector[i]= vector[i-1] + 1;
        }
    }
}
