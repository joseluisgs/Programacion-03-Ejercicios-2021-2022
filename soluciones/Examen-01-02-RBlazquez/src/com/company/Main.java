package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import com.company.Utils.Constantes;

public class Main {
    public static void main(String[] args) {
        boolean isAcabado = false;
        int jugadorCanicas = Constantes.MAXCANICAS;
        int computadorCanicas = Constantes.MAXCANICAS;
        do {
            printCanicasActuales(jugadorCanicas);
            int jugadorCanicasApostadas = getNumeroCanicas("Introduce numero canicas a apostar ", jugadorCanicas);
            //QUITA LAS CANICAS APOSTADADAS A JUGADOR
            jugadorCanicas -= jugadorCanicasApostadas;
            int computadoraCanicasApostadas = getNumeroCanicas(computadorCanicas);
            //QUITA LAS CANICAS APOSTADADAS A COMPUTADDORA
            computadorCanicas -= computadoraCanicasApostadas;
            boolean isParJugador = getEleccion("Introduce 'par' si crees su numero de canicas apostadas es par, si no introduce 'impar'");
            boolean isParComputador = getEleccion();
            int resultado = getResult(isParJugador, isParComputador, computadoraCanicasApostadas, jugadorCanicasApostadas);
            printResult(resultado,isParComputador,computadoraCanicasApostadas);
            //DEVUELVE LAS CANICAS SEGUN EL RESULTADO
            switch (resultado) {
                case Constantes.JUGADOR:{
                    jugadorCanicas += jugadorCanicasApostadas;
                    jugadorCanicas += computadoraCanicasApostadas;
                    break;
                }
                case Constantes.COMPUTADORA:{
                    computadorCanicas += computadoraCanicasApostadas;
                    computadorCanicas += jugadorCanicasApostadas;
                    break;
                }
                case Constantes.EMPATE: {
                    computadorCanicas += computadoraCanicasApostadas;
                    jugadorCanicas += jugadorCanicasApostadas;
                    break;
                }
            }
            isAcabado = jugadorCanicas <= 0 || computadorCanicas <= 0;

        }while (!isAcabado);

        printWinner(jugadorCanicas,computadorCanicas);


    }

    /**
     * imprime cuantas canicas tienes
     * @param canicas
     */
    private static void printCanicasActuales(int canicas) {
        System.out.println("Tienes " + canicas + " canicas");
    }

    /**
     * imprime quiena gana
     * @param jugadorCanicas
     * @param computadorCanicas
     */
    private static void printWinner(int jugadorCanicas,int computadorCanicas) {
        if (jugadorCanicas > computadorCanicas) {
            System.out.println("Gana el jugador");
        }
        else if(computadorCanicas > jugadorCanicas) {
            System.out.println("Gana la computadora");
        }
    }
    /**
     * Imprime el resultado y las 'estadisticas' de la ronda
     * @param resultado
     */
    private static void printResult(int resultado,boolean isParComputadora,int canicasApostadasComputadora) {
        System.out.println("La computadora ha apostado: " + canicasApostadasComputadora + " canicas");
        System.out.println("La computadora ha elegido: " + (isParComputadora ? "par" : "impar"));
        switch (resultado) {
            case Constantes.EMPATE:{
                System.out.println("Empate");
                break;
            }
            case Constantes.JUGADOR:{
                System.out.println("Jugador gana ronda");
                break;
            }
            case Constantes.COMPUTADORA: {
                System.out.println("Computadora gana ronda");
                break;
            }
        }
    }
    /**
     * Calcula quien gana
     * @param isParJugador
     * @param isParComputador
     * @param computadorCanicasApostadas
     * @param jugadorCanicasApostadas
     * @return
     * 1 si jugador, 2 si computadora, 0 si empate
     */
    private static int getResult(boolean isParJugador, boolean isParComputador, int computadorCanicasApostadas, int jugadorCanicasApostadas) {
        int result = 0;
        boolean jugadorGana = (isParJugador && computadorCanicasApostadas % 2 == 0) || !(isParJugador || computadorCanicasApostadas % 2 == 0);
        boolean computadorGana = (isParComputador && jugadorCanicasApostadas % 2 == 0) || !(isParComputador || jugadorCanicasApostadas % 2 == 0);
        if(computadorGana && jugadorGana)
            result = Constantes.EMPATE;
        else if(jugadorGana)
            result = Constantes.JUGADOR;
        else if (computadorGana)
            result = Constantes.COMPUTADORA;

        return result;

    }

    /**
     * Eleccion par o inpar desde random
     * @return
     * true si par, false si impar
     */
    private static boolean getEleccion() {
        Random random = new Random();
        return random.nextBoolean();
    }
    /**
     * Eleccion par o inpar desde teclado
     * @param message
     * @return
     * true si par, false si impar
     */
    private static boolean getEleccion(String message) {
        boolean isOk = false;
        boolean isPar = false;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                isOk = true;
                System.out.println(message);
                String input = scanner.next().toLowerCase(Locale.ROOT);
                if(input.equals("par")) {
                    isPar = true;
                }
                else if(input.equals("impar")) {
                    isPar = false;
                }
                else {
                    isOk = false;
                }
            }
            catch (Exception ex) {
                isOk = false;
            }
        }while (!isOk);
        return isPar;
    }

    /**
     * Apuesta numero Canicas desde teclado
     * @param message
     * @return
     */
    private static int getNumeroCanicas(String message,int maxDisponible) {
        boolean isOk = false;
        int numero = 0;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println(message);
                numero = scanner.nextInt();
                isOk = numero <= maxDisponible && numero > 0;
            }
            catch (Exception ex) {
                isOk = false;
            }
        }while (!isOk);
        return numero;
    }

    /**
     * Apuesta numero canicas desde random
     * @return
     */
    private static int getNumeroCanicas(int maxDisponible) {
        Random random = new Random();
        return random.nextInt(maxDisponible)+1;
    }
}
