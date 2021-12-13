package es.jeremyramos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        int [][] matriz= new int [8][8];


        generarValoresMatriz(matriz);
        System.out.println("Matriz Creada :D");
        imprimirMatriz(matriz);

        System.out.println();
        sumaDePares(matriz);
        System.out.println();
        System.out.println();
        sumaDeimPares(matriz);
        System.out.println();
        System.out.println();
        sumaDeParesPosc(matriz);
        System.out.println();
        System.out.println();
        sumaDeImaresPosc(matriz);

    }



    private static void sumaDeimPares(int[][] matriz) {
        int suma=0;
        int media;
        int aux=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length-1; j++) {
                if (matriz[i][j] % 2 != 0) {
                    suma = suma + matriz[i][j];
                    aux++;

                }

            }
        }

        System.out.println("Esta es la suma total de todos los impares: " + suma);

        media = suma / aux;


        System.out.println("Media total de la suma de los impares entre la cantidad de datos de la matriz: " + media);
    }

    private static void sumaDePares(int[][] matriz) {
        int suma=0;
        int aux=0;
        int media;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length-1; j++) {
                if (matriz[i][j] % 2 == 0) {
                    suma = suma + matriz[i][j];
                    aux++;

                }

            }
        }

        System.out.println("Esta es la suma total de todos los pares: " + suma);

        double floor = Math.floor(media = suma / aux);

        System.out.println("Media total de la suma de los pares entre la cantidad de datos de la matriz: " + media);
    }


    private static  void sumaDeParesPosc(int[][] matriz) {
        int suma=0;
        int media;
        int aux=0;


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length-1; j++) {

                if(j%2==0){
                    suma=suma+matriz[i][j];
                    aux++;

                }
            }
        }

        System.out.println("Esta es la suma total de todas las posiciones pares: " + suma);

        double floor = Math.floor(media = suma / aux);

       System.out.println("Media total de la suma de las posiciones pares de la matriz: " + media);
    }
    private static  void sumaDeImaresPosc(int[][] matriz) {
        int suma=0;
        int media;
        int aux=0;


        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length-1; j++) {

                if(j%2!=0){
                    suma=suma+matriz[i][j];
                    aux++;

                }
            }
        }

        System.out.println("Esta es la suma total de todas las posiciones impares: " + suma);

        double floor = Math.floor(media = suma / aux);

        System.out.println("Media total de la suma de las posiciones impares de la matriz: " + media);
    }


    private static void generarValoresMatriz(int [][]matriz){
        Scanner sc = new Scanner(System.in);
        System.out.println("Valores del vector");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j]= (int) (Math.random()*20 + 1);

            }

        }



    }
    private static void imprimirMatriz(int[][] m) {
        for(int i = 0; i < m.length; i++){
            System.out.print("{");
            for(int j = 0; j < m[i].length; j++){
                if(j!= m[i].length -1 ){
                    System.out.print(m[i][j] + ",");
                }else {
                    System.out.print(m[i][j]);
                }
            }
            System.out.println("}");
        }
    }
}

