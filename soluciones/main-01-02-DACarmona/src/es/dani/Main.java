package es.dani;

import java.util.Scanner;

import static utils.utils.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	    int [][] matriz= new int[5][5];
        int numberMax;
        int numberMin;
        int numberMedia;
        int numberBuscado;
        int[] pos;

        getMatriz(matriz);
        imprimirMatriz(matriz);
        numberMax= giveNumberMax(matriz);
        System.out.println("El número máximo es: " + numberMax);

        numberMin= giveNumberMin(matriz);
        System.out.println("El número minimo es: " + numberMin);

        numberMedia= giveNumberMedia(matriz);
        System.out.println("La media es: " + numberMedia);

        System.out.println("Busqueda de número: ");
        numberBuscado = sc.nextInt();
        pos=busquedadLineal(matriz, numberBuscado);
        if(pos[0] != -1) System.out.println("El número " + numberBuscado + " esta en la posicion " + (pos[0] + 1) + "," + (pos[1] + 1));
        else System.out.println("El número " + numberBuscado +" no se encuentra.");

        buscarNumeroMasRepetido(matriz);

    }
    public static void buscarNumeroMasRepetido(int[][] matriz){
        int numeroVecesRepetido= 0;
        int repetido= 0;
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                int repetidoJ= 0;
                int numeroVecesRepetidoJ= 0;
                for (int x = 0; x < matriz.length ; x++) {
                    for (int y = 0; y < matriz[x].length ; y++) {
                        if(matriz[i][j]== matriz[x][y]){
                            repetidoJ= matriz[i][j];
                            numeroVecesRepetidoJ++;
                        }
                        if(numeroVecesRepetido < numeroVecesRepetidoJ){
                            repetido = repetidoJ;
                            numeroVecesRepetido= numeroVecesRepetidoJ;
                        }
                    }
                }
            }
        }
        System.out.println("El numero que más se repite es: " + repetido);
        System.out.println("Las veces que se repite son: " + numeroVecesRepetido);
    }

    public static int[] busquedadLineal(int[][] matriz, int num){
        boolean encontrado= false;
        int [] pos= {-1, -1};
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length && !encontrado ; j++) {
                if (num == matriz[i][j]){
                    encontrado= true;
                    pos[0]= i;
                    pos[1]= j;
                }
            }
        }
        return pos;
    }
    public static int giveNumberMedia(int[][] matriz){
        int numberMedia= 0;
        int divisor=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                numberMedia += matriz[i][j];
                divisor++;
            }
        }
        numberMedia= numberMedia/divisor;
        return numberMedia;
    }
    public static int giveNumberMin(int[][] matriz){
        int numberMin= matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if (numberMin > matriz[i][j]){
                    numberMin = matriz[i][j];
                }
            }
        }
        return numberMin;
    }
    public static int giveNumberMax(int[][] matriz){
        int numberMax= matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if (numberMax < matriz[i][j]){
                    numberMax = matriz[i][j];
                }
            }
        }
        return numberMax;
    }
}
