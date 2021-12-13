package es.dani;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] matriz;
        int[][] reves;

        // Introducir el tamaño de la matriz
        matriz = getSizeMatriz();

        //Darle valores a la matriz
        getValoresMatriz(matriz);
        imprimirMatriz(matriz);

        //Invertir la matriz
        System.out.println("La matriz invertida es: ");
        reves= invertirMatriz(matriz);
        imprimirMatriz(reves);

    }
    /**
     * Funcion para crear el tamaño de la matriz
     * @return devuelve la matriz con su tamaño
     */
    private static int[][] getSizeMatriz() {
        int[][] matriz;
        System.out.println("Introduce el número de filas:");
        int row=sizeMatriz();
        System.out.println("Introduce el número de columnas:");
        int column= sizeMatriz();
        matriz= new int[row][column];
        return matriz;
    }

    /**
     * Funcion para introducir el tamaño
     * @return devuelve el tamaño introducido
     */
    public static int sizeMatriz(){
        Scanner sc = new Scanner(System.in);
        int size= sc.nextInt();
        return size;
    }
    /**
     * Funcion para invertir una matriz
     * @param matriz matriz que queremos invertir
     * @return devolvemos la nueva matriz invertida
     */
    public static int[][] invertirMatriz(int[][] matriz){
        int row= matriz.length;
        int column= matriz[matriz.length-1].length;
        int[][] reves= new int[row][column];
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                reves[i][j]= matriz[matriz.length-1-i][matriz[i].length - 1-j];
            }
        }
        return reves;
    }
    /**
     * Procedimiento para generar valores aleatorios en las posiciones de la matriz
     * @param matriz matriz donde queremos almacenar los datos
     */
    public static void getValoresMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                matriz[i][j]= (int)(Math.random()* 10);
            }
        }
    }
    /**
     * Procediemto para imprimir una matriz
     * @param matriz matiz que queremos imprimir
     */
    public static void imprimirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matriz[i].length ; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("]");
        }
    }
}
