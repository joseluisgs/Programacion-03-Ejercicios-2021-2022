package com.company;

import java.util.Scanner;

public class Main {

    /**
     * @author Rocío Palao Fernández
     * @date 15/11/2021
     * github: Rochiio
     * Escribir un programa que lea una matriz de números reales, calcule la suma de cada fila y
     * de cada columna y muestre por pantalla la nueva tabla, incluyendo las sumas.
     */

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("De cuánto quieres la matriz");
        int tam= sc.nextInt();

            float[][]matriz1=new float[tam][tam];
            matriz1=numerosAleatorios(matriz1);
           float[][]matriz2=new float[tam+1][tam+1];
            matriz2=numerosMatriz1(matriz1,matriz2);

        //SUMA FILAS
        System.out.println("SUMA FILAS");
            matriz2=sumaFilas(matriz1,matriz2);
            canPrint(matriz2);

        //SUMA COLUMNAS
        System.out.println("SUMA COLUMNAS");
            matriz2=sumaColumnas(matriz1,matriz2,tam);
            canPrint(matriz2);
    }
    public static void canPrint (float [][]matriz){
        for (int i=0; i< matriz.length;i++){
            System.out.print("{ ");
            for (int j=0; j<matriz[i].length; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println("  }");
        }
    }


    private static float[][] sumaFilas(float[][] matriz1, float[][] matriz2) {
        int suma;
        for (int i=0; i< matriz1.length;i++){
            suma=0;
            for (int j=0; j<matriz1[i].length; j++) {
                suma += matriz1[i][j];
            }
            matriz2[i][matriz2.length - 1]=suma;
        }
        return matriz2;
    }

    private static float[][] sumaColumnas(float[][] matriz1, float[][] matriz2, int tam){
        int suma;
        for (int i=0; i< matriz1.length;i++){
            suma=0;
            for (int j=0; j<matriz1[i].length; j++) {
                suma += matriz1[j][i];
            }
            matriz2[matriz2.length-1][i]=suma;
        }
        return matriz2;
    }

    private static float[][] numerosMatriz1(float[][] matriz1, float[][]matriz2) {
        for (int i=0; i< matriz1.length;i++){
            for (int j=0; j<matriz1[i].length; j++){
                matriz2[i][j]=matriz1[i][j];
            }
        }
        return matriz2;
    }

    public static float[][] numerosAleatorios(float [][]matriz){
        for (int i=0; i<matriz.length; i++){
            System.out.print("{ ");
            for (int j=0; j<matriz[i].length; j++){
                matriz[i][j]= (int) (Math.random()*10+1);
                System.out.print(matriz[i][j]+ "  ");
            }
            System.out.println(" }");
        }
        return matriz;
    }
}
