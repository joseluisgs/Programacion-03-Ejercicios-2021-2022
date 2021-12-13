package es.jeremyramos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int [][] matriz=new int[3][3];




    generarMatriz(matriz);
        System.out.println("Matriz");
    imprimirMatriz(matriz);
        System.out.println();
        System.out.println();
    sacarElMaximo(matriz);

    }



    private static void sacarElMaximo(int [][] matriz){
        int mayor = 0;
        int media=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                 if(mayor < matriz[i][j]){
                     mayor = matriz[i][j];
                 }




            }
            System.out.println("Este es el mayor de la fila " + (i+1)+ ": " +  mayor);

            media= media + mayor;

            mayor=0;
        }
        media = media / matriz.length;

        System.out.println("Esta es la media total: " +  media) ;
    }



    private static void generarMatriz(int [][] matriz){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                System.out.println("Dime los valores de la matriz");
                matriz[i][j]= sc.nextInt();


            }

        }


    }



    private static void imprimirMatriz(int [][] matriz){

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("{");
            for (int j = 0; j < matriz[i].length; j++) {

                if(j!=matriz[i].length -1 ){

                    System.out.print(matriz[i][j] + ",");
                }else{
                    System.out.print(matriz[i][j]);
                }




            }
            System.out.println("}");

        }


    }
}
