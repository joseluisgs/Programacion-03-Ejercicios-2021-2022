/*
Autor:Jan Carlos Ramos M.
GitHub: JanCRM
* */
package com.company;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
	    // write your code here

        //Establecer el tamaño de la matriz, introduciendole las filas y las columnas.
        int filas, columnas;
        System.out.println("Introduce el tamaño de las fila");
        filas= in.nextInt();
        System.out.println("Introduce el tamaño de las columnas");
        columnas= in.nextInt();

        //Creacion e inicalizacion de la matriz
        int[][] matriz=new int[filas][columnas];
        inicializarMatriz(matriz);
        //Imprimir matriz
        pritMatriz(matriz);

        //Devuelve el maximo de la matriz.
        maximoMatriz(matriz);

        //Devuele el minimo de la matriz.
        minimoMatriz(matriz);

        //Devuelve la media.
        mediaMatriz(matriz);

        //Devuelve el elemento que buscamos.
        int elemento;
        System.out.println("Introduce el elemento que deseas buscar:");
        elemento=in.nextInt();

        int[][] matrizBusquedaElemento = new int [][]{{89, 22, 91, 47},
                                                      {95, 57, 89, 3},
                                                      {27, 57, 22, 89},
                                                      {67, 99,56,8}};
        int resusltadoBusqueda=linearSearch(matrizBusquedaElemento, elemento);
        print(resusltadoBusqueda, elemento);

            //Numero que mas se repite en una matriz.
        numeroMasRepetido(matriz);

    }




    /*
    * crear e Inicializar una matriz, con valores aleatorio.
    * @param Matriz[i][j].
     * i:filas
     * j:columnas
    * */
    public static  void inicializarMatriz(int [][] matriz){
        Random random =new Random();
        for (int i = 0; i <matriz.length ; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
                matriz[i][j]= (int)(Math.random()*100)+1;
            }
        }
    }

    /*
     * Imprimir matriz
     * @param Matriz[i][j].
     * i:filas
     * j:columnas
     * */
    public static void pritMatriz(int [][]matriz){
        Scanner in = new Scanner(System.in);
        System.out.println("Imprimir la lista de array.");
        for (int i=0; i<matriz.length; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
            }
            System.out.println("Fila " +(i+1)+ ": "+ Arrays.toString(matriz[i]));
        }
    }


    /*
     * Obtener el maximo de la matriz
     * @param Matriz[i][j].
     * */
    public static void maximoMatriz(int [][] matriz){
        int maximo= matriz[0][0];
        for (int i = 0; i <matriz.length ; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
                if (maximo<matriz[i][j]){
                    maximo=matriz[i][j];
                }
            }
        }
        System.out.println("El mayor es: "+maximo);
    }


    /*
     * Obtener el minimo de la matriz
     * @param Matriz[i][j].
     * */
    public static void minimoMatriz(int [][] matriz){
        int minimo= matriz[0][0];
        for (int i = 0; i <matriz.length ; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
                if (minimo>matriz[i][j]){
                    minimo=matriz[i][j];
                }
            }
        }
        System.out.println("El minimo es: "+minimo);
    }


    /*
     * Obtener la media de la matriz
     * @param Matriz[i][j].
     * */
    public static void mediaMatriz(int [][] matriz){
        int media=0;
        int suma=0;
        int contador=0;
        int sumas=0;
        for (int i = 0; i <matriz.length ; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
                suma=matriz[i][j]+matriz[i][j];
                sumas+=suma;
                contador++;

            }
        }
        media=sumas/contador;
        System.out.println("La media es: "+media);
    }


    /*
     * Buscar un elemento en una matriz
     * @param Matriz[i][j].
     * */
    public static int linearSearch(int[][] matriz, int elementToSearch) {
        int res= -1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j <matriz[i].length ; j++) {
                if (elementToSearch == matriz[i][j]){
                    res= matriz[i][j];
                }
            }
        }

        return res;
    }
    /*
     * Imprime el elementor encontrado en la matriz.
     * @param Matriz[i][j].
     * */
    public static void print(int elementToSearch, int index) {
        if (index == -1){
            System.out.println(elementToSearch + " not found.");
        }
        else {
            System.out.println("Elemento encontrado " +index);
        }
    }


    /*
     * Buscar el numero que mas se repite.
     * @param Matriz[i][j].
     * */
    public static void numeroMasRepetido(int[][] matriz) {
        int numeroRepetido = 0;
        int numeroVecesRepetido = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                int numeroRepetidoj = 0;
                int numeroVecesRepetidoj = 0;
                for (int x = 0; x < matriz.length; x++) {
                    for (int y = 0; y < matriz[x].length; y++) {

                        if (matriz[x][y] == matriz[i][j]) {
                            numeroRepetidoj = matriz[i][j];
                            numeroVecesRepetidoj++;
                        }
                        if (numeroVecesRepetidoj>numeroVecesRepetido){
                            numeroRepetido=numeroRepetidoj;
                            numeroVecesRepetido=numeroVecesRepetidoj;
                        }
                    }
                }
            }
        }
            System.out.println("Numero que mas se repite es: " +numeroRepetido+
                    " numero de veces que se repite: " +numeroVecesRepetido);

    }

}
