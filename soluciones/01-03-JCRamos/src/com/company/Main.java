/**
 * Autor: Jan Carlos Ramos.
 * GitHub: JanCRM.
 */
package com.company;
import java.util.Arrays;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // write your code here
        System.out.println("Introduce el tamaño de los ventores.");
        int tam = in.nextInt();
        int [] a=new int[tam];
        int [] b=new int[tam];

        //Rellenar vectores
        System.out.println("Rellenar vectores");
        fillVectors(a);
        fillVectors(b);

        //Imprimir vectores.
        System.out.println("Imprimir vectores");
        printVectors(a);
        printVectors(b);

        //producto escalar
        System.out.println("Producto escalar");
        pEscalar(a,b);


        //Suma de vectores
        System.out.println("El resultado de la suma es:");
        sumaArrays(a,b);

        //Resta de vectores
        System.out.println("El resultado de la resta es:");
        restaArrays(a,b);

    }



    //fill vectors
    public static void fillVectors(int [] vector){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i <vector.length ; i++) {
            //generar numero aleatorios para rellenar el vector
            vector[i]= (int) (Math.random()*100)+1;
        }
    }


    //print vectors
    public static void printVectors(int [] printvectors){
        for (int i = 0; i <printvectors.length ; i++) {

        }
        System.out.println(Arrays.toString(printvectors));
    }


    //Producto escalar
    public static int pEscalar(int [] vector1, int [] vestor2){
        int pEscalar=0;
        for (int i = 0; i <vector1.length ; i++) {
            pEscalar=pEscalar+(vector1[i]*vestor2[i]);
            System.out.println("-----------"+pEscalar);
        }
        return pEscalar;
    }


    //Operaciones con vectores.
    //Suma de vectores
    public static void sumaArrays(int [] array1, int [] array2){
        int suma=0;
        for (int i = 0; i <array1.length-1 ; i++) {

            suma=array1[i]+array2[i];
            System.out.println("Resultado "+(i+1)+" : "+suma);
        }
    }

    //Resta de vectores
    public static void restaArrays(int [] array1, int [] array2){
        int resta=0;
        for (int i = 0; i <array1.length-1 ; i++) {
            resta=array1[i]-array2[i];
            System.out.println("Resultado "+(i+1)+" : "+resta);
        }
    }


}

