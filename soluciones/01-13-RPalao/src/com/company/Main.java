package com.company;

import java.util.Scanner;

/**
 * @author Rocío Palao Fernández
 * @date 11/11/2021
 * github: Rochiio
 * Repite el ejercicio en otro módulo de forma que se inicie el primer elemento y el
 * resto de componentes del vector sean el anterior más el índice actual. Ejemplo, si
 * introducimos un 2 el primero el resto quedaría: 2, 3, 5, 8, 12, 17, 23...
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
        vector[1]=numInicial+1;
        for (int i=2; i< vector.length;i++){
            vector[i]=vector[i-1]+vector[i-2];
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

