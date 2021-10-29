/*
Autor: Mohamed Asidah Bchiri (loopedmoha)
 */

package com.MAsidah;

import java.util.Random;
import java.util.Scanner;

public class Main {




    /**
     * Devuelve por referencia la matriz inicializada con numeros aleatorios
     * @param filas
     * @param columnas
     * */
    static void iniciarMatriz(int[][] matriz, int filas, int columnas){
        Random random = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //numero aleatorio entre 1 y 100
                matriz[i][j] = random.nextInt(100) +1;
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
     * Devuelve el valor máximo de la matriz
     * @param matriz
     * @param filas
     * @param columnas
     * @return
     */
    static int maximoMatriz(int[][] matriz, int filas, int columnas){
        int maximo = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if(matriz[i][j] > maximo)
                    maximo = matriz[i][j];
            }
        }
        return maximo;
    }

    /**
     * Devuelve el valor minimo de la matriz
     * @param matriz
     * @param filas
     * @param columnas
     * @return
     */
    static int minimoMatriz(int[][] matriz, int filas, int columnas){
        int minimo = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if(matriz[i][j] < minimo)
                    minimo = matriz[i][j];
            }
        }
        return minimo;
    }

    /**
     * Calcula la media aritmetica de la matriz
     * @param matriz
     * @param filas
     * @param columnas
     * @return
     */
    static float mediaMatriz(int[][] matriz, int filas, int columnas){
        float media = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                media += matriz[i][j];
            }
        }
        return media / (filas*columnas);
    }

    public static void main(String[] args) {
	// write your code here
        int filas, columnas;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el numero de filas de la matriz:");
        filas = scanner.nextInt();
        System.out.println("Indica el numero de columnas de la matriz:");
        columnas = scanner.nextInt();
        int [][] matriz = new int[filas][columnas];
        iniciarMatriz(matriz,filas, columnas);

        System.out.println("La matriz creada es:");
        mostrarMatriz(matriz, filas, columnas);

        System.out.println("El valor máximo de la matriz es: " + maximoMatriz(matriz, filas, columnas));
        System.out.println("El valor mínimo de la matriz es: " + minimoMatriz(matriz, filas, columnas));
        System.out.println("El valor medio de la matriz es: " + mediaMatriz(matriz, filas, columnas));
    }
}
