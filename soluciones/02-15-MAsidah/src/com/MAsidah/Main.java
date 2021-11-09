package com.MAsidah;

import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        int[][] tablero;
        Scanner in = new Scanner(System.in);
        int casillasRestantes = 0;
        int[] datos = new int[2];
        datosIniciales(in, datos);

        casillasRestantes = (datos[0] * datos[0]) - datos[1];
        tablero = new int[datos[0]][datos[0]];
        iniciarTablero(tablero, datos[0]);
        colocarMinas(tablero, datos[1], datos[0]);

        mostrarTablero(tablero, datos[1], casillasRestantes);
        gameLoop(tablero, datos[1], casillasRestantes);


    }

    private static void mostrarEstadoFinal(int[][] tablero, boolean muerte) {
        if (muerte) System.out.println("Has muerto");
        else System.out.println("Has ganado");
        imprimirFinal(tablero);
    }

    private static void gameLoop(int[][] tablero, int numMinas, int casillasRestantes) {
        int[] posicion;
        boolean muerte = false, victoria = false;
        do {

            posicion = seleccionarCasilla(tablero);
            if (comprobarCasilla(tablero, posicion))
                muerte = true;
            else {
                colocarPistas(tablero, posicion);
                casillasRestantes--;
            }
            mostrarTablero(tablero, numMinas, casillasRestantes);
        } while (!muerte && casillasRestantes > 0);
        mostrarEstadoFinal(tablero, muerte);
    }

    private static void datosIniciales(Scanner in, int[]datos) {
        int numCasillas = datos[0];
        int numMinas = datos[1];
        do {
            System.out.println("Numero de casillas: ");
            datos[0] = in.nextInt();

            System.out.println("Numero de minas: ");
            datos[1] = in.nextInt();
        } while (numCasillas < 2 || numMinas > (numCasillas * numCasillas));
    }

    private static void mostrarTablero(int[][] tablero, int numMinas, int casillasRestantes) {

            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[0].length; j++) {
                    if (tablero[i][j] != -1)
                        System.out.print("[" + tablero[i][j] + "]");
                    else
                        System.out.print("[0]");
                }
                System.out.println();
            }
            System.out.println("Minas restantes: " + numMinas);
            System.out.println("Casillas restantes: " + casillasRestantes);
    }

private static void imprimirFinal(int[][] tablero){
    for (int i = 0; i < tablero.length; i++) {
        for (int j = 0; j < tablero.length; j++) {
            System.out.print("[" + tablero[i][j] + "]");
        }
    System.out.println();
    }
}
    private static void iniciarTablero(int[][] tablero, int numCasillas) {
        for (int i = 0; i < numCasillas; i++)
            for (int j = 0; j < numCasillas; j++)
                tablero[i][j] = 0;
    }

    private static void colocarMinas(int[][] tablero, int numMinas, int numCasillas) {
        Random r = new Random();
        for (int i = 0; i < numCasillas && numMinas != 0; i++)
            for (int j = 0; j < numCasillas && numMinas != 0; j++)
                if (r.nextBoolean()) {
                    tablero[i][j] = -1;
                    numMinas--;
                }
    }

    private static void colocarPistas(int[][] tablero, int[] posicion) {
        tablero[posicion[0]][posicion[1]] = minasAlrededor(tablero, posicion[0], posicion[1]);
    }

    private static int minasAlrededor(int[][] tablero, int x, int y) {
        int minas = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i >= 0 && x + i < tablero.length && y + j >= 0 && y + j < tablero.length)
                    if (tablero[i + x][j + y] < 0)
                        minas++;
            }

        }
        return minas;
    }

    private static int[] seleccionarCasilla(int[][] tablero) {
        Scanner in = new Scanner(System.in);

        int[] casilla = new int[2];

        System.out.println("Selecciona la fila:");
        casilla[0] = in.nextInt() - 1;

        System.out.println("Selecciona la columna:");
        casilla[1] = in.nextInt() - 1;

        return casilla;
    }


    private static boolean comprobarCasilla(int[][] tablero, int[] posicion) {
        return (tablero[posicion[0]][posicion[1]] < 0);
    }
}
