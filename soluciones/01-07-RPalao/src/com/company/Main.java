package com.company;

import java.util.Scanner;

/**
 * @author Rocío Palao Fernández
 * @date 10/11/2021
 * github: Rochiio
 * Realiza un programa que dado un vector de números, nos diga si es capicúa.
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

        //Averiguar si es capicúa
        boolean capicua;
        capicua=esCapicua(vector);

        if (capicua) {
            System.out.println("El vector es capicúa");
        } else {
            System.out.println("El vector no es capicúa");
        }
    }

    public static int[] pedirValor(int[] vector){
        for (int i=0; i< vector.length;i++){
            Scanner sc= new Scanner(System.in);
            System.out.println("Dime el valor que le quieres dar a la posición " +(i+1));
            vector[i]=sc.nextInt();
        }
        return vector;
    }


    public static boolean esCapicua(int[]vector){
        int finalVec=vector.length-1;
        boolean capicua=false;
        for(int i=0; i< finalVec/2 ;i++){
           if (vector[i]==vector[finalVec-i]){
               capicua=true;
           }else if (vector[i]!=vector[finalVec-i]){
               capicua=false;
           }
        }
        return capicua;
    }
}
