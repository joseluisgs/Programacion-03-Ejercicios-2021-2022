package com.company;

import java.util.Scanner;

/**
 * @author Rocío Palao Fernández
 * @date 15/11/2021
 * github: Rochiio
 * Escribir un programa que lea una matriz de enteros de dimensión NxN. Posteriormente,
 * calcular el valor máximo de cada fila y la media de los máximos.
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Dime de cuánto quieres la matriz");
        int tam= sc.nextInt();

        int[][]matriz = new int[tam][tam];
        matriz=numerosAleatorios(matriz);

        int media= valorMaximoFila(matriz,tam);
        System.out.println("La media de los números más grandes de cada fila es: " +media);
    }

    public static int[][] numerosAleatorios(int [][]matriz){
        for (int i=0; i<matriz.length; i++){
            System.out.print("{ ");
            for (int j=0; j<matriz[i].length; j++){
                matriz[i][j]= (int) Math.floor(Math.random()*10+1);
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println(" }");
        }
        return matriz;
    }

    public static int valorMaximoFila (int[][]matriz, int tam){
        int suma=0;
        int max;
        for (int i=0; i<matriz.length; i++){
            max=matriz[i][0];
            for (int j=0; j<matriz[i].length; j++){

                if (matriz[i][j]>max){
                    max=matriz[i][j];
                }
            }
         suma += max;
        }
        int media = suma/tam;
        return media;
    }
}
