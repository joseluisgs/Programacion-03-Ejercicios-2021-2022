package com.company;

import java.util.Scanner;

/**
 * @author Rocío Palao Fernández
 * @date 11/11/2021
 * github: Rochiio
 * La Mosca Vector
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
	    int mosca=1;

        System.out.println("Juego de la mosca");
        System.out.println("Dime de que tamaño quieres que sea el vector para jugar: ");
        int tamVector=sc.nextInt();
        int[] vectorTablero=new int[tamVector];
        boolean muerto=false;

        //INICIO DEL JUEGO
        //Poner a 0 el tablero
        vectorTablero=reiniciarTablero(vectorTablero);

        //Colocar la mosca
        vectorTablero=ponerMosca(vectorTablero,mosca);



        do {
            canPrint(vectorTablero);
            //Golpeo
            System.out.println("En qué casilla quieres golpear?: ");
            int golpeo=sc.nextInt();

            //Analizar el golpeo
            muerto=analisisGolpeo(vectorTablero,golpeo,mosca);


        }while (!muerto);

    }
    public static void canPrint (int[]print){
            System.out.print("{ ");
        for (int i=0 ;i< print.length;i++){
            System.out.print(print[i]+ " ");
        }
        System.out.println(" }");
    }


    public static int[] reiniciarTablero(int[]vectorTablero){
        for (int i=0; i<vectorTablero.length; i++){
            vectorTablero[i]=0;
        }
        return vectorTablero;
    }

    public static int[] ponerMosca(int[]vectorTablero,int mosca){
        int posicion= (int) Math.floor(Math.random()* vectorTablero.length);
        vectorTablero[posicion]=mosca;
        return vectorTablero;
    }

    public static boolean analisisGolpeo(int[]vectorTablero,int golpeo, int mosca){
        boolean muerto=false;

            if (vectorTablero[golpeo - 1] == mosca) {
                System.out.println("Has matado a la mosca");
                muerto = true;
            }

            if (vectorTablero[golpeo - 1] != mosca) {
                if (vectorTablero[golpeo - 1] == (mosca - 1) && (mosca - 1 > 0)) {
                } else {
                    System.out.println("Casi la pillas!");
                    reiniciarTablero(vectorTablero);
                    ponerMosca(vectorTablero,mosca);
                    muerto = false;
                }
                if (vectorTablero[golpeo - 1] == (mosca + 1) && (mosca + 1 < vectorTablero.length)) {
                    System.out.println("Casi la pillas!");
                    reiniciarTablero(vectorTablero);
                    ponerMosca(vectorTablero,mosca);
                    muerto = false;
                } else
                    System.out.println("Inténtalo de nuevo");
                    muerto = false;
            }

        return muerto;
    }
}
