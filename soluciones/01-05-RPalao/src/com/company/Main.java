package com.company;

import java.util.Scanner;

/**
 * @author Rocío Palao Fernández
 * @date 10/11/2021
 * github: Rochiio
 * Haz un programa que invierta el orden de un vector
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int tamano;

        //Pedir tamaño del vector
        System.out.println("Dime el tamaño que le quieres dar al vector");
        tamano=sc.nextInt();
        int []vector= new int[tamano];

        //Pedir valores del vector
        vector=pedirValor(vector);

        //Invertir vector
        vector=invertirVector(vector);
        printVector(vector);


    }
    public static void printVector(int[]imprimir){
        System.out.print("{ ");
        for (int i=0;i< imprimir.length;i++){
            System.out.print(" " + imprimir[i]+ " ");
        }
        System.out.print(" }");
    }


    public static int[] pedirValor(int[] vector){
        for (int i=0; i< vector.length;i++){
            Scanner sc= new Scanner(System.in);
            System.out.println("Dime el valor que le quieres dar a la posición " +(i+1));
            vector[i]=sc.nextInt();
        }
        return vector;
    }

    public static int[] invertirVector(int[]vector){
        int fin= vector.length-1;
        for (int i=0; i < fin/2 ;i++){
            int aux = vector[i];
            vector[i] = vector[fin-i];
            vector[fin-i] = aux;
        }
        return vector;
    }
}
