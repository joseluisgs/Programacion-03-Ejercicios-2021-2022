package es.dani;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int[][] matriz;
    //Generar matriz y darle valores
    matriz=getSize();
    getValues(matriz);
    //Imprimir
    imprimirMatriz(matriz);
    //Suma de los pares y la media de ellos
    sumaPares(matriz);
    //Suma de los impares y la media de ellos
    sumaImpares(matriz);
    //Suma de las posiciones pares y la media de ellos
    sumaPosicionesPares(matriz);
    //Suma de las posiciones impares y la media de ellos
    sumaPosicionesImpares(matriz);
    }

    /**
     * Procedimiento que suma las posiciones impares y calcula la media
     * @param matriz matriz donde queremos calcular los valores
     */
    public static void sumaPosicionesImpares(int[][] matriz){
        int sumaTotal=0;
        int impares=0;
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if (j % 2 != 0){
                    sumaTotal+= matriz[i][j];
                    impares++;
                }
            }
        }
        System.out.println("La suma de las posiciones impares es: " + sumaTotal);
        System.out.println("La media de las posiciones impares es: " + (sumaTotal/impares));
    }

    /**
     * Procedimiento que suma las posiciones impares y calcula su media
     * @param matriz matriz donde queremos calcular los valores
     */
    public static void sumaPosicionesPares(int[][] matriz){
        int sumaTotal=0;
        int pares=0;
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if (j % 2 == 0){
                    sumaTotal+= matriz[i][j];
                    pares++;
                }
            }
        }
        System.out.println("La suma de las posiciones pares es: " + sumaTotal);
        System.out.println("La media de las posiciones pares es: " + (sumaTotal/pares));
    }

    /**
     * Procedimiento que suma los numeros impares y calcula su media
     * @param matriz matriz donde queremos calcular los valores
     */
    public static void sumaImpares(int[][] matriz){
        int sumaTotal=0;
        int impares=0;
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if (matriz[i][j] % 2 != 0){
                    sumaTotal+= matriz[i][j];
                    impares++;
                }
            }
        }
        System.out.println("La suma de los impares es: " + sumaTotal);
        System.out.println("La media de los impares es: " + (sumaTotal/impares));
    }

    /**
     * Procedimiento que suma los numeros pares y calcula su media
     * @param matriz matriz donde queremos calcular los valores
     */
    public static void sumaPares(int[][] matriz){
        int sumaTotal=0;
        int pares=0;
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if (matriz[i][j] % 2 == 0){
                    sumaTotal+= matriz[i][j];
                    pares++;
                }
            }
        }
        System.out.println("La suma de los pares es: " + sumaTotal);
        System.out.println("La media de los pares es: " + (sumaTotal/pares));
    }

    /**
     * Procedimiento que imprime una matriz
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
     * Procedmiento para crear valores en la matriz
     * @param matriz matriz donde queremos crear los valores
     */
    public static void getValues(int[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                matriz[i][j] = i + j;
            }
        }
    }

    /**
     * Procedimiento para crear el tamaño de la matriz
     * @return devuelve la matriz con su tamaño
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
