package es.drodriguez.com;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Preguntamos al usuario el tamaño de la matriz que quiere generar
        System.out.println("Indica el tamaño de la matriz");
        int tamano = sc.nextInt();
        //Declaramos la matriz original
        int matriz[][] = new int[tamano][tamano];
        matriz = numerosAleatorios(matriz);
        //Declaramos la matriz que vamos a redimensionar para almacenar el resultado de las sumas
        int matriz2[][] = new int[tamano+1][tamano+1];
        matriz2 = volcarMatriz(matriz, matriz2);

        //OPERACIONES:
        System.out.println("Suma resultante de filas");
        matriz2 = sumaFilas(matriz, matriz2);
        imprimirMatriz(matriz2);

        System.out.println("Suma resultante de columnas");
        matriz2 = sumaColumnas(matriz, matriz2);
        imprimirMatriz(matriz2);

    }

    //Función que se encarga de devolver las matrices impresas
    public static void imprimirMatriz (int [][]matriz){
        for (int i=0; i< matriz.length;i++){
            System.out.print("");
            for (int j=0; j<matriz[i].length; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println();
        }
    }

    //Genera números aleatorios que alamacena en la matriz
    public static int[][] numerosAleatorios (int [][]matriz){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length ; j++){
                matriz[i][j] = (int) (Math.random()*100);
            }
        }
        return matriz;
    }

    //Realiza la suma de las filas
    public static int[][] sumaFilas (int [][]matriz, int [][]matriz2){
        int sumaFilas;
        for (int i = 0; i < matriz.length; i++){
            sumaFilas = 0;
            for (int j = 0; j < matriz[i].length ; j++){
                sumaFilas += matriz[i][j];
            }
            matriz2[i][matriz2.length-1] = sumaFilas ;
        }
        return matriz2;
    }

    //Realiza la suma de las columnas
    public static int[][] sumaColumnas (int [][]matriz, int [][]matriz2){
        int sumaColumnas;
        for (int i = 0; i < matriz.length; i++){
            sumaColumnas = 0;
            for (int j = 0; j < matriz[i].length ; j++){
                sumaColumnas += matriz[j][i];
            }
            matriz2[matriz2.length-1][i]=sumaColumnas;
        }
        return matriz2;
    }

    //Se encarga de redimensionar una matriz
    public static int [][]volcarMatriz (int [][]matriz, int [][]matriz2){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length ; j++){
                matriz2[i][j] = matriz[i][j];
            }
        }
        return matriz2;
    }
}
