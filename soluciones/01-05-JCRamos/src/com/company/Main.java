package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
	// write your code here

        System.out.println("Introduce el tamaño del vector");
        int tamañoVector= in.nextInt();
        int [] vector=new int[tamañoVector];
        inicializarMatriz(vector);
        System.out.println("Imprimir vector original:");
        pritMatriz(vector);
        System.out.println("Imprimir vector invertido:");
        invertirVector(vector);
        pritMatriz(vector);


    }


    /**
     * inicializacion de un vector.
     * @param vector
     */
    public static  void inicializarMatriz(int [] vector){
        Random random =new Random();
        for (int i = 0; i <vector.length ; i++) {
                vector[i]= (int)(Math.random()*10)+1;
        }
    }

    /**
     * imprimir un vector
     * @param vector
     * @return
     */
    public static void pritMatriz(int []vector){
        Scanner in = new Scanner(System.in);
        for (int i=0; i<vector.length; i++) {
        }
        System.out.println(Arrays.toString(vector));
    }


    //Invertir la posicion de un vector
    public static int[] invertirVector(int [] vector){
        int aux;
        for (int i = 0; i <(vector.length-1)/2 ; i++) {
            aux=vector[i];
            vector[i]=vector[vector.length-1-i];
            vector[vector.length-1-i]=aux;
        }
        return vector;
    }




}
