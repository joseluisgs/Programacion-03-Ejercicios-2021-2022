package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // write your code here

        //Declaracion de la matriz
        System.out.println("Introduce el numero de filas");
        int filas = in.nextInt();
        System.out.println("Introduce el numero de columnas");
        int columnas = in.nextInt();
        int [][] matrizA = new int[filas][columnas];
        //MatrizB
        int [][] matrizB = new int[filas][columnas];

        //Imprimir e inicializar una matriz
        System.out.println("Imprimir matriz 1");
        pritMatriz(inicializarMatriz(matrizA, filas, columnas));
        System.out.println("Imprimir matriz 2");
        pritMatriz(inicializarMatriz(matrizB, filas, columnas));

        //Suma de una matriz
        System.out.println("Suma de matrices.");
        pritMatriz(sumaMatriz(matrizA, matrizB));


        //resta de una matriz
        System.out.println("Resta de matrices.");
        pritMatriz(restaMatrices(matrizA, matrizB));

        //Multiplicacion de una matriz
        System.out.println("Resta de matrices.");
        pritMatriz(multiplicarMatrices(matrizA, matrizB));


        //Determianates de una matriz.
        System.out.println("Dtermiante de una matriz.");
        pritMatriz(determinante(matrizA,filas,columnas));


    }


    /**
     * crear e Inicializar una matriz, con valores aleatorio.
     * @param matriz
     * @return
     */
    public static int[][] inicializarMatriz(int [][] matriz, int filas, int columnas){
        Random random =new Random();
        for (int i = 0; i <filas ; i++) {
            for (int j = 0; j <columnas ; j++) {
                matriz[i][j]= (int)(Math.random()*100)+1;
            }
        }
        return matriz;
    }


    /**
     * Print matriz
     * @param matriz
     */
    public static void pritMatriz(int [][]matriz){
        Scanner in = new Scanner(System.in);
        for (int i=0; i<matriz.length; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
            }
            System.out.println("Fila " +(i+1)+ ": "+ Arrays.toString(matriz[i]));
        }
    }


    /**
     * Suma de una matriz
     * @param matrizA matrizB
     */
    public static int[][] sumaMatriz(int [][] matrizA, int[][]matrizB){
        int[][] resultadoSuma=new int[matrizA.length][matrizB.length];
        //Aqui comparo las matrices para que sean del mismo tamaño.
        if (matrizA.length== matrizB.length && matrizA[0].length==matrizB[0].length){
            for (int i = 0; i <matrizA.length ; i++) {
                for (int j = 0; j <matrizA[i].length ; j++) {
                    resultadoSuma[i][j]=matrizA[i][j]+matrizB[i][j];
                }
            }
            System.out.println();
        }else {
            System.out.println("Las matrices son de diferente tamaña.");
        }
        return resultadoSuma;
    }


    /**
     * Resta de matrices
     * @param matrizA
     * @param matrizB
     * @return
     */
    public static int[][] restaMatrices(int [][] matrizA, int[][]matrizB){
        int[][] resultadoResta=new int[matrizA.length][matrizB.length];
        //Aqui comparo las matrices para que sean del mismo tamaño.
        if (matrizA.length== matrizB.length && matrizA[0].length==matrizB[0].length){
            for (int i = 0; i <matrizA.length ; i++) {
                for (int j = 0; j <matrizA[i].length ; j++) {
                        resultadoResta[i][j] = matrizA[i][j] - matrizB[i][j];
                }
            }
            System.out.println();
        }else {
            System.out.println("Las matrices son de diferente tamaña.");
        }
        return resultadoResta;
    }


    /**
     * Multiplicar matriz
     * @param matrizA
     * @param matrizB
     * @return
     */
    public static int[][] multiplicarMatrices(int [][] matrizA, int[][]matrizB){
        int[][] resultadoMultiplicacion=new int[matrizA.length][matrizB.length];
        //Aqui comparo las matrices para que sean del mismo tamaño.
        if (matrizA.length== matrizB.length && matrizA[0].length==matrizB[0].length){
            for (int i = 0; i <matrizA.length ; i++) {
                for (int j = 0; j <matrizA[i].length ; j++) {
                    resultadoMultiplicacion[i][j] = matrizA[i][j] * matrizB[i][j];
                }
            }
            System.out.println();
        }else {
            System.out.println("Las matrices son de diferente tamaña.");
        }
        return resultadoMultiplicacion;
    }




    public static int[][] determinante(int [][] matriz, int filas, int columnas){
        int [][] determiante = new int[filas][columnas];;

        // solo se calcula si la matriz es cuadrada
        if(filas == columnas) {
            if (filas == 2) {
                determiante[filas][columnas] = matriz[0][0]*matriz[1][1] - matriz[0][1]*matriz[1][0];
            }else{
                //Solo lo hago así porque sabemos que es 3x3 así que su determinante es facil de sacar
                determiante[filas][columnas] += matriz[0][0]*matriz[1][1]*matriz[2][2] +
                        matriz[0][1]*matriz[1][2]*matriz[2][0] +
                        matriz[0][2]*matriz[1][0]*matriz[2][1];

                determiante[filas][columnas] -= matriz[2][0]*matriz[1][1]*matriz[0][2] +
                        matriz[2][1]*matriz[1][2]*matriz[0][0] +
                        matriz[2][2]*matriz[1][0]*matriz[0][1];
            }
        }else{
            System.out.println("La matriz no es cuadrada");
        }
        return determiante;
    }




}