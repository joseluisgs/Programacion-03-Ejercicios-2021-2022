package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
/**
 * Programa con el que invertimos el orden de un Array.
 * @author HXMarin 1DAM
 */
int[][]matrix = arrayData();
int[]vector = matrixToVector(matrix);
printNumbers (matrix);
printMatrix(matrix);
  vector= matrixToVector(matrix);
invertVector(vector);
        System.out.println();
int[][]aux = vectorToMatrix(vector);
printMatrix(aux);
    }
    public static int[][]arrayData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Filas de la Matriz Por favor: ");
        int filas = sc.nextInt();
        System.out.println("Columnas de la Matriz Por Favor: ");
        int columnas = sc.nextInt();
        int matrix[][]= new int[filas][columnas];
        return matrix;
    }
    public static void printMatrix(int[][]matriz){
        for (int[]fila:matriz) {
            System.out.print(" ");
            for (int columna:fila) {
                System.out.print(columna+" ");
            }
            System.out.println();
        }
    }
    public static int[][]printNumbers(int[][]matriz){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                System.out.println("Dame números para la Matriz: ");
                matriz[i][j] = sc.nextInt();
            }
        }
        return matriz;
    }
    public static int[]matrixToVector(int[][]matriz){
        int[] vector = new int[matriz.length * matriz.length];
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                int pos = matriz[i].length * i + j;
                vector[pos] = matriz[i][j];
            }
        }
        return vector;
    }
    public static int[]invertVector(int[]vector){
        for (int i = 0; i<vector.length/2; i++) {
            int aux = vector[i];
            vector[i] = vector[vector.length -1-i];
            vector[vector.length-1 -i] = aux;
        }
        return vector;
    }
    public static int[][]vectorToMatrix(int[]vector){
        int filas = (int) Math.sqrt(vector.length);
        int[][]matriz = new int[filas][filas];
        for (int i = 0; i < vector.length ; i++) {
            int f = i/filas;
            int c = i %filas;
            matriz[f][c] = vector[i];
        }
        return matriz;
    }
}

