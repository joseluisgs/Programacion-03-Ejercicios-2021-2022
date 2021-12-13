package es.dani;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int[][] matriz;
    matriz= getSize();
    getValues(matriz);
    imprimirMatriz(matriz);
    System.out.println("Giramos la matriz 90º");
    matriz=girarMatriz(matriz);
    imprimirMatriz(matriz);

    }

    /**
     * Funcion que invierte 90º en el sentido de la aguja del reloj
     * @param matriz matriz donde queremos invertir
     * @return
     */
    public static int[][] girarMatriz(int[][] matriz){
        int row= matriz.length;
        int column= matriz[row-1].length;
        int[][] reves= new int[column][row];
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                reves[j][((matriz.length-1)-i)]= matriz[i][j];
            }
        }
        return reves;
    }
    public static void getValues(int[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                matriz[i][j]= i+j;
//                matriz[i][j] = (int)(Math.random()* 10 );
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
