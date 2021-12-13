package es.dani;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][]matriz;
        matriz=getSize();
        getValues(matriz);
        imprimirMatriz(matriz);

        sumarDiagonales(matriz);

    }

    /**
     * Procedimiento que suma las dos diagonales de una matriz
     * @param matriz matriz que queremos calcular sus diagonales
     */
    public static void sumarDiagonales(int[][] matriz){
        int sum=0;
        int sum1=0;
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if (i == j) sum += matriz[i][j];
                if((i+j)== (matriz.length-1)) sum1 += matriz[i][j];
            }
        }
        System.out.println("La suma de las diagonales son: " + sum + " y " + sum1);
    }
    public static void getValues(int[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                matriz[i][j] = (int)(Math.random()* (matriz.length - 0));
            }
        }
    }
    private static void imprimirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matriz[i].length ; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println("]");
        }
    }
    private static int[][] getSize() {
        int row;
        int column;
        Scanner sc= new Scanner(System.in);
        do {
            System.out.println("Introduce las filas:");
            row= sc.nextInt();
        }while (row<= 0);
        do {
            System.out.println("Introduce las columnas:");
            column= sc.nextInt();
        }while (column<= 0);
        int[][] matriz= new int[row][column];
        return matriz;
    }
}
