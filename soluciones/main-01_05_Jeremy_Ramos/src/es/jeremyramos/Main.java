package es.jeremyramos;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //INVERTIR EL ORDEN DEL VECTOR
        int[] vector = new int[7];


        generarVector(vector);
        invertirOrdenVector(vector);



    }

    private static void invertirOrdenVector(int[] vector) {
        int j = vector.length-1;
        int cambio=0;
        for (int i = 0; i < vector.length; i++) {

            if (i < j){

                cambio=vector[i];
                vector[i]=vector[j];
                vector[j]=cambio;
                j--;
            }
        }
        System.out.println(Arrays.toString(vector));
    }

    private static void generarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++){

            vector[i]= (int) (Math.random() * 20) + 1;



        }
        System.out.println(Arrays.toString(vector));
    }

}