package es.drodriguez.com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int matriz[][] = tamanoMatriz();
        numerosAleatorios(matriz);
        imprimirMatriz(matriz);
        maximoFilas(matriz);

    }

    public static int[][] tamanoMatriz(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el tamaño de las filas de la matriz");
        int filasMatriz = sc.nextInt();
        System.out.println("Dime el tamaño de las columnas de la matriz");
        int columnasMatriz = sc.nextInt();
        int datosMatriz[][] = new int [filasMatriz][columnasMatriz];
        return datosMatriz;
    }

    public static void imprimirMatriz (int [][]matriz){
        for (int []fila : matriz){
            System.out.println(" ");
            for (int columna :fila){
                System.out.print(columna +" ");
            }
        }
    }

    public static void numerosAleatorios (int [][]matriz){
        for(int i = 0; i < matriz.length ; i++){
            for(int j = 0; j < matriz[i].length ; j++){
                matriz[i][j] = (int)(Math.random()*100);
            }
        }
    }

    public static void maximoFilas (int [][]matriz){
        int maximo;
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            maximo = matriz[i][0];
            for (int j = 0; j < matriz[i].length; j++){
                if (matriz[i][j]>maximo){
                    maximo = matriz[i][j];
                }
            }
            suma += maximo;
        }
       int media= suma/matriz.length;
        System.out.println("La media de los valores maximo de la matriz es: " + media);
    }

}
