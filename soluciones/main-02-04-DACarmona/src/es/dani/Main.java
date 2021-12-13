package es.dani;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float[][] matriz;
        matriz=getSize();
        getValues(matriz);
        imprimirMatriz(matriz);
        System.out.println("Suma de las filas y columas:");
        matriz=sumaFilas(matriz);
        imprimirMatriz(matriz);
    }

    /**
     * Funcion que suma las filas y columnas. Las almacena en un nuevo columna y una nueva fila
     * @param matriz matriz donde queremos realizar los calculos
     * @return devuelve una matriz nueva con la nueva columna y fila con los resultados
     */
    public static float[][] sumaFilas(float[][] matriz){
        int row= matriz.length;
        int column= matriz[matriz.length-1].length;
        float[][] sumas= new float[(row +1)][(column + 1)];
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                sumas[i][j]= matriz[i][j];
                sumas[i][matriz[i].length]+= matriz[i][j];
                sumas[matriz.length][j]+= matriz[i][j];
            }
        }
        return sumas;
    }
    public static void getValues(float[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                matriz[i][j] = (float)(Math.random()* 10);
            }
        }
    }
    private static void imprimirMatriz(float [][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matriz[i].length ; j++) {
                float v= matriz[i][j];
                System.out.printf("%.2f", v);
                System.out.print(" ");
            }
            System.out.println("]");
        }
    }
    private static float[][] getSize() {
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
        float[][] matriz= new float[row][column];
        return matriz;
    }
}
