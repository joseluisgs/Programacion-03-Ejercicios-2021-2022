package es.dani;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] matriz;
        int[] vector;
        matriz=getSize();
        getValues(matriz);
        imprimirMatriz(matriz);
        vector=numberMax(matriz);
        System.out.println(Arrays.toString(vector));

    }

    /**
     * Funcion que comprueba el numero maximo de cada fila
     * @param matriz matriz que queremos comprobar
     * @return devuelve un vector con los numeros máximos
     */
    public static int[] numberMax(int[][] matriz){
        int numberMax=0;
        int[] vector= new int[matriz.length];
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if (numberMax < matriz[i][j]){
                    numberMax= matriz[i][j];
                }
            }
            System.out.println("El número máximo es: " + numberMax);
            vector[i]= numberMax;
            numberMax=0;
        }
        return vector;
    }

    /**
     * Procedimiento que genera numero aleatorios dentro de la matriz
     * @param matriz matriz donde se almacena los datos
     */
    public static void getValues(int[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                matriz[i][j] = (int)(Math.random()* 10);
            }
        }
    }

    /**
     * Procedimiento para imprimir una matriz
     * @param matriz matriz que queremos imprimir
     */
    private static void imprimirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matriz[i].length ; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println("]");
        }
    }

    /**
     * Funcion para darle tamaño a una matriz
     * @return devuelve la matriz con su respectivo tamaño
     */
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
