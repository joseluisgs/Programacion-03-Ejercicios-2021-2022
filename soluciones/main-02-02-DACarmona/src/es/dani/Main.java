package es.dani;

import java.util.Scanner;

/**
 * @author Daniel Carmona Rodriguez
 */
public class Main {

    public static void main(String[] args) {
	int[][] matriz;
    matriz=sizeMatriz();
    getMatriz(matriz);
    imprimirMatriz(matriz);
    calcularValorMaximo(matriz);

    }

    /**
     * Funcion para crear el tamaño de la matriz
     * @return devuelve la matriz con su tamaño
     */
    public static int[][] sizeMatriz(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el tamaño de las filas:");
        int row= sc.nextInt();
        System.out.println("Introduce el tamaño de las columnas:");
        int column= sc.nextInt();
        int [][] auxiliar= new int[row][column];
        return auxiliar;
    }

    /**
     * Procedimiento para calcular la suma de las filal y calcular su media
     * @param matriz matriz donde queremos calcular
     */
    public static void calcularValorMaximo(int[][] matriz){
        int numeroMaximo= 0;
        int media=0;
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if(numeroMaximo < matriz[i][j]){
                    numeroMaximo= matriz[i][j];
                }
            }
            System.out.println("El valor máximo de la fila " + (i+1)+" es: " + numeroMaximo);
            media= media + numeroMaximo;
            numeroMaximo=0;
        }
        media= media / matriz.length;
        System.out.println("La media de los máximos es: " + media);
    }

    /**
     * Procedimiento para imprimir una matriz
     * @param matriz matriz que queremos imprimir
     */
    public static void imprimirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            System.out.print("[");
            for (int j = 0; j < matriz[i].length ; j++) {
                if (j < matriz[i].length-1) System.out.print(matriz[i][j] + " ");
                else System.out.print(matriz[i][j]);
            }
            System.out.println("]");
        }
    }

    /**
     * Procedimiento para introducir valores en la matriz
     * @param matriz matriz donde queremos almacenar dichos valores
     */
    public static void getMatriz(int[][] matriz){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println("Introduce el valor de " + (j+1)+ " :");
                matriz[i][j]= sc.nextInt();
            }
        }
    }
}
