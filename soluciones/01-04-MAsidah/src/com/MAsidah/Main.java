package com.MAsidah;

import java.util.Scanner;

public class Main {

    /**
     * Calcula la suma de dos matrices
     * @param matriz1
     * @param matriz2
     * @param filas
     * @param columnas
     * @return resultado
     */
    static int[][] sumaMatrices(int[][] matriz1, int[][]matriz2, int filas, int columnas){
        int[][] resultado = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return resultado;
    }


    /**
     * Calcula la resta de dos matrices
     * @param matriz1
     * @param matriz2
     * @param filas
     * @param columnas
     * @return resultado
     */
    static int[][] restaMatrices(int[][] matriz1, int[][]matriz2, int filas, int columnas){
        int[][] resultado = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }
        return resultado;
    }

    /**
     * Calcula el producto de dos matrices
     * @param matriz1
     * @param matriz2
     * @param filas
     * @param columnas
     * @return resultado
     */
    static int[][] multiplicacionMatrices(int[][] matriz1, int[][]matriz2, int filas, int columnas){
        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = 0;
                //mantenemos fijo el valor del resultado y iteramos filas y columnas con el bucle for k
                for (int k = 0; k < columnas; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return resultado;
    }

    /**
     * Lee por teclado los valores para inicializar la matriz
     * @param matriz1
     * @param filas
     * @param columnas
     */
    static void iniciarMatriz(int[][] matriz1, int filas, int columnas){
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < filas; i++) {
            System.out.println("Introduce los valores de la fila "+(i+1));
            for (int j = 0; j < columnas; j++) {
                System.out.println((j+1)+":");
                matriz1[i][j] = in.nextInt();
            }
        }
    }
    /**
     * Imprime por pantalla la matriz dada
     * @param matriz
     * @param filas
     * @param columnas
     */
    static void mostrarMatriz(int[][]matriz, int filas, int columnas){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println();
        }
    }

    /**
     * Calcula el determinante de una matriz dada
     * @param matriz1
     * @param filas
     * @param columnas
     * @return
     */
    static int determinanteMatriz(int[][]matriz1, int filas, int columnas){
        int determinante = 0;
        int [][] aux = new int[2][2];
        // solo se calcula si la matriz es cuadrada
        if(filas == columnas) {
            if (filas == 2) {
                determinante = matriz1[0][0]*matriz1[1][1] - matriz1[0][1]*matriz1[1][0];
            }else{
                //Solo lo hago así porque sabemos que es 3x3 así que su determinante es facil de sacar
            determinante += matriz1[0][0]*matriz1[1][1]*matriz1[2][2] +
                                matriz1[0][1]*matriz1[1][2]*matriz1[2][0] +
                                    matriz1[0][2]*matriz1[1][0]*matriz1[2][1];

            determinante -= matriz1[2][0]*matriz1[1][1]*matriz1[0][2] +
                                matriz1[2][1]*matriz1[1][2]*matriz1[0][0] +
                                    matriz1[2][2]*matriz1[1][0]*matriz1[0][1];
            }
        }else{
            System.out.println("La matriz no es cuadrada");
        }
        return determinante;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int filas = 0, columnas = 0;

        do{
            System.out.println("Introduce el numero de filas:");
            filas = in.nextInt();

            System.out.println("Introduce el numero de columnas:");
            columnas = in.nextInt();
        }while(filas > 3 || columnas >3);

        int [][]matriz1 = new int[filas][columnas];
        int [][]matriz2 = new int[filas][columnas];
        int [][] resultado = new int[filas][columnas];
        int determinante = 0;
        System.out.println("Incia la matriz 1: ");
        iniciarMatriz(matriz1, filas, columnas);
        System.out.println("Incia la matriz 2: ");
        iniciarMatriz(matriz2, filas, columnas);
        System.out.println("La matriz 1 es:");
        mostrarMatriz(matriz1, filas, columnas);
        System.out.println("La matriz 2 es:");
        mostrarMatriz(matriz2, filas, columnas);


        System.out.println("El resultado de sumar matriz 1 y matriz 2 es:");
        resultado = sumaMatrices(matriz1, matriz2, filas, columnas);
        mostrarMatriz(resultado, filas, columnas);

        System.out.println("El resultado de restar matriz 1 y matriz 2 es:");
        resultado = restaMatrices(matriz1, matriz2, filas, columnas);
        mostrarMatriz(resultado, filas, columnas);

        System.out.println("El resultado de multiplicar matriz 1 y matriz 2 es:");
        resultado = multiplicacionMatrices(matriz1, matriz2, filas, columnas);
        mostrarMatriz(resultado, filas, columnas);

        determinante = determinanteMatriz(matriz1, filas, columnas);
        System.out.println("El determinante de la matriz1 es: "+determinante);

        determinante = determinanteMatriz(matriz2, filas, columnas);
        System.out.println("El determinante de la matriz2 es: "+determinante);
    }
}
