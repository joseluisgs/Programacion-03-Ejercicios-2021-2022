package es.drodriguez.com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /**
         * Programa que invierte el orden de una matriz.
         * @author Daniel Rodríguez  Fernández
         */
        //Pedimos el tamaño de la matriz
        int[][] matriz = datosMatriz();
        //Utilizamos el vector para poder invertir la matriz
        int[] vector;
        //Pedimos al usuario los elementos que quiere almacenar en nuestra matriz
        printNumbers(matriz);
        //Devolvemos la matriz impresa por pantalla
        printMatriz(matriz);
            vector = matrizToVector(matriz);
        //Invertimos los elementos de nuestro vector
        invertirVector(vector);
        int[][]aux = vectorToMatriz(vector);
        //Imprimimos matriz invertida
        printMatriz(aux);

    }

    /**
     * @description le pedimos el tamaño de la matriz que quiere generar, primeros pedimos las filas y después las
     * columnas y se genera una martiz según pide el usuario.
     * @return
     */

    public static int[][] datosMatriz() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime los datos para introducir en las filas de la matriz");
        int filas = sc.nextInt();
        System.out.println("Dime los datos para introducir en las columnas de la matriz");
        int columnas = sc.nextInt();
        int matriz[][] = new int[filas][columnas];
        return matriz;
    }

    /**
     *
     * @param matriz imprimimos la matriz
     */
    public static void printMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            System.out.print(" ");
            for (int columna : fila) {
                System.out.print(columna + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     * @param matriz es impresa en pantalla para que el usuario la vea y le pedimos que elementos quiere almacenar en ella.
     * @return
     */

    public static int[][] printNumbers(int[][] matriz) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Dime numeros de la matriz: ");
                matriz[i][j] = sc.nextInt();
            }
        }
        return matriz;
    }

    /**
     *
     * @param matriz la pasamos a vector para después poder invertir el vector
     * @return
     */

    public static int[] matrizToVector(int[][]matriz) {
       int[] vector = new int[matriz.length * matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int posicion = matriz[i].length * i + j;
                vector[posicion] = matriz[i][j];
            }
        }
        return vector;
    }

    /**
     *
     * @param vector que era una martiz y ahora vamos a invertir los elementos almacenados en los indices.
     * @return
     */
    public static int[]invertirVector(int[]vector){
        for (int i = 0; i < vector.length/2; i++) {
            int aux = vector[i];
            vector[i] =vector[vector.length - 1 - i];
            vector[vector.length -1 -i] = aux;
        }
        return vector;
    }

    /**
     *
     * @param vector una vez invertido le devolvemos a matriz.
     * @return
     */
    public static int[][] vectorToMatriz(int[] vector) {
        int filas = (int) Math.sqrt(vector.length);
        int[][] matriz = new int[filas][filas];
        for (int i = 0; i < vector.length; i++) {
            int f = i / filas;
            int c = i % filas;
            matriz[f][c] = vector[i];
        }
        return matriz;
    }
}