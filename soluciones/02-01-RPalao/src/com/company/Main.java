package com.company;

import java.util.Scanner;

/**
 * @author Rocío Palao Fernández
 * @date 15/11/2021
 * github: Rochiio
 * Dada una matriz de dimensión NxN de números enteros, escribir un programa que calcule:
 * • La suma de los números pares y su media.
 * • La suma de los números impares y su media.
 * • La suma de los números en posiciones pares y su media.
 * • La suma de los números en posiciones impares y su media.
 */

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);


        System.out.println("Dime de que tamaño quieres la matriz");
        int tam = sc.nextInt();

        int [][] matriz= new int[tam][tam];

        //Poner números aleatorios
        matriz = numerosAleatorios(matriz);
        for (int i=0 ; i < matriz.length ; i++){
            System.out.print("{ ");
            for (int j=0; j<matriz[i].length ; j++){
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println(" }");
        }


        //SUMA NUMEROS PARES Y SU MEDIA
        System.out.println("Suma de los números pares y su media");

            int mediaSumaPares=mediaSumaNumerosPares(matriz);
            System.out.println("La media de la suma de los numeros pares es: " +mediaSumaPares);

        //SUMA NUMEROS IMPARES Y SU MEDIA
        System.out.println("Suma de los números impares y su media");

           int mediaSumaImpares=mediaSumaNumerosImpares(matriz);
           System.out.println("La media de la suma de los numeros pares es: " +mediaSumaImpares);

        //SUMA DE LOS NUMEROS EN POSICIONES PARES Y SU MEDIA
        System.out.println("Suma de los números en posiciones pares y su media");

            int mediaSumaPosicionPar= mediaNumerosPosicionesPares(matriz);
            System.out.println("La media de la suma de los numeros en posiciones pares es: " +mediaSumaPosicionPar);

        //SUMA DE LOS NUMEROS EN POSICIONES IMPARES Y SU MEDIA
        System.out.println("Suma de los números en posiciones pares y su media");

        int mediaSumaPosicionImpar= mediaNumerosPosicionesImpares(matriz);
        System.out.println("La media de la suma de los numeros en posiciones pares es: " +mediaSumaPosicionImpar);


    }

    public static int[][] numerosAleatorios (int[][]matriz){
        for (int i=0 ; i < matriz.length ; i++){
            for (int j = 0; j<matriz[i].length ; j++){
                matriz[i][j]= (int) Math.floor(Math.random()*10);
            }
        }
        return matriz;
    }



    public static int mediaSumaNumerosPares (int[][]matriz){
            int suma=0;
            int aux=0;
            int media;

        for (int i=0 ; i < matriz.length ; i++){
            for (int j=0; j<matriz[i].length ; j++){
                if (matriz[i][j]%2 == 0){
                    suma += matriz[i][j];
                    aux ++;
                }
            }
        }
        media= suma/aux;
        return media;
    }

    public static int mediaSumaNumerosImpares (int[][]matriz){
        int suma=0;
        int aux=0;
        int media;

        for (int i=0 ; i < matriz.length ; i++){
            for (int j=0; j<matriz[i].length ; j++){
                if (matriz[i][j]%2 != 0){
                    suma += matriz[i][j];
                    aux ++;
                }
            }
        }
        media= suma/aux;
        return media;
    }

    public static int mediaNumerosPosicionesPares(int[][]matriz){
        int suma=0;
        int media=0;
        int div=0;

        for (int i=0 ; i < matriz.length ; i++){
            for (int j=0; j<matriz[i].length ; j++){

                    if (j%2==0){
                        suma += matriz[i][j];
                        div++;
                    }
            }
        }
        media= suma/div;
        System.out.println("suma posiciones pares"+suma);
        return media;
    }

    public static int mediaNumerosPosicionesImpares(int[][]matriz){
        int suma=0;
        int media=0;
        int div=0;

        for (int i=0 ; i < matriz.length ; i++){
            for (int j=0; j<matriz[i].length ; j++){

                if (j%2!=0){
                    suma += matriz[i][j];
                    div++;
                }
            }
        }
        media= suma/div;
        System.out.println("suma posiciones impares"+suma);
        return media;
    }



}
