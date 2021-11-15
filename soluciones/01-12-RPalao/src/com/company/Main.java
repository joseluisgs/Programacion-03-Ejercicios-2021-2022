package com.company;

import java.util.Scanner;

/**
 * @author Rocío Palao Fernández
 * @date 11/11/2021
 * github: Rochiio
 * Realiza un programa que pida un valor entero, lo coloque en la primera posición de un
 * vector e inicie el resto de elementos sumando uno al anterior. Ejemplo, si introducimos un 9
 * en la primera posición el resto de componentes quedaría: 10, 11, 12, 13...
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Dime cuantos numeros quieres que salgan: ");
        int tamano=sc.nextInt();
        System.out.println("Dime cuál quieres que sea el número inicial: ");
        int numInicial=sc.nextInt();

        int[] vectorNum= new int[tamano];

        //Resto de numeros
        vectorNum=introducirNum(vectorNum,numInicial);
        canPrint(vectorNum);
    }
    public static int[] introducirNum(int[]vector, int numInicial){
        vector[0]=numInicial;
        for (int i=1; i< vector.length;i++){
            vector[i]=vector[i-1]+1;
        }
        return vector;
    }

    public static void canPrint(int[]vector){
        System.out.print("{ ");
        for (int i=0; i< vector.length;i++){
            System.out.print(vector[i]+"  ");
        }
        System.out.println(" }");
    }
}
