/*
Mohamed Asidah Bchiri (loopedMoha)
51496651L   moha.as172@gmail.com

 */
package com.MAsidah;


import java.util.Random;
import java.util.Scanner;

public class Main {

    static final int SIZE = 3;

    /**
     * Inicia aleatoriamente las cadenas de los bots
     * @return
     */
    public static String initCadena() {
        String cadena = "";
        Random r = new Random();
        for (int i = 0; i < SIZE; i++) {
            if (r.nextInt(100) < 50)
                cadena += 0;
            else
                cadena += 1;
        }
        return cadena;
    }

    /**
     * Lee por teclado la cadena de C3PO
     * @return
     */
    public static String leerCadena() {
        Scanner sc = new Scanner(System.in);
        String cadena = "";
        boolean ok;
        do {
            ok = true;
            try {
                System.out.println("Introduce tu cadena de binarios C3PO (longitud 3): ");
                cadena = sc.next();
            } catch (Exception e) {
                System.out.println("ERROR AL LEER LA ENTRADA");
                sc.next();
                ok = false;
            }
            if (cadena.length() != SIZE) {
                System.out.println("Introduce una cadena de 3 binarios");
                ok = false;
            } else {
                for (int i = 0; i < SIZE && ok; i++) {
                    if (cadena.charAt(i) != '0' && cadena.charAt(i) != '1') {
                        System.out.println("La cadena solo puede tener 0 y 1");
                        ok = false;
                    }
                }
            }
        } while (!ok);
        return cadena;
    }

    /**
     * Cuenta cuantos 1 hay en las tres cadenas
     * @param cadenaC3
     * @param cadenaR2
     * @param cadenaBB8
     * @return
     */
    public static int contarUnos(String cadenaC3, String cadenaR2, String cadenaBB8) {
        int unos = 0;
        for (int i = 0; i < SIZE; i++) {
            if (cadenaC3.charAt(i) == '1')
                unos++;
            if (cadenaBB8.charAt(i) == '1')
                unos++;
            if (cadenaR2.charAt(i) == '1')
                unos++;
        }
        return unos;
    }

    /**
     * Elige aleatoriamente la apuesta de los bots
     * @param apuestas
     * @return
     */
    public static int apuestaBot(int[] apuestas) {
        int apuesta = -1;
        Random r = new Random();
        do {
            apuesta = r.nextInt(9);
            for (int i = 0; i < apuestas.length; i++) {
                if (apuestas[i] == apuesta)
                    apuesta = -1;
            }
        } while (apuesta == -1);
        return apuesta;
    }

    /**
     * Lee la apuesta de C3PO por teclado
     * @param apuestas
     * @return
     */
    public static int apuestaJugador(int[] apuestas) {
        Scanner sc = new Scanner(System.in);
        int apuesta = -1;
        do {
            try {
                System.out.println("C3PO haz tu apuesta (entre 0 y 9): ");
                apuesta = sc.nextInt();
                if (apuesta > 9 || apuesta < 0) {
                    System.out.println("La apuesta debe ser un número entre 0 y 9.");
                    apuesta = -1;
                } else {
                    for (int i = 0; i < apuestas.length; i++) {
                        if (apuestas[i] == apuesta) {
                            apuesta = -1;
                            System.out.println("Ya han realizado esa apuesta, elige otro número.");
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("La apuesta debe ser un número entre 0 y 9.");
                sc.next();
                apuesta = -1;
            }
        } while (apuesta == -1);
        return apuesta;
    }

    /**
     * Elige al ganador que haya acertado el numero de unos.
     * 0: R2D2
     * 1: BB8
     * 2: C3PO
     *
     * @param apuestas
     * @return
     */
    public static int elegirGanador(int[] apuestas, int unos) {
        int ganador = -1;
        for (int i = 0; i < apuestas.length; i++) {
            if (apuestas[i] == unos)
                ganador = i;
        }
        return ganador;
    }

    /**
     * Ejecuta el juego de contar unos
     */
    public static void juegoUnos() {
        String cadenaBB8 = "", cadenaR2 = "", cadenaC3 = "";
        int victoriasBB8 = 0, victoriasR2 = 0, victoriasC3 = 0;

        int[] apuestas = new int[3];

        while(victoriasBB8 != 3 && victoriasR2 != 3 && victoriasC3!= 3){
            //se crean las cadenas
            cadenaR2 = initCadena();
            cadenaBB8 = initCadena();
            cadenaC3 = leerCadena();

            //se hacen las apuestas de los bots
            for (int i = 0; i < apuestas.length - 1; i++) {
                apuestas[i] = apuestaBot(apuestas);
            }

            //se coge la apuesta del jugador
            apuestas[2] = apuestaJugador(apuestas);

            //se decide el ganador de la ronda
            int unos = contarUnos(cadenaR2, cadenaBB8, cadenaC3);
            int ganador = elegirGanador(apuestas, unos);
            switch (ganador){
                case(0):
                    System.out.println("Esta ronda ha ganado R2D2");
                    victoriasR2++;
                    break;
                case(1):
                    System.out.println("Esta ronda ha ganado BB8");
                    victoriasBB8++;
                    break;
                case(2):
                    System.out.println("Esta ronda ha ganado C3PO");
                    victoriasC3++;
                    break;
                default:
                    System.out.println("Ninguno ha acertado.");
                    break;
            }
        }

        //se decide el ganador del juego
        if(victoriasBB8 ==3)
            System.out.println("BB8 HA GANADO EL JUEGO!!");
        else if(victoriasR2 == 3)
            System.out.println("R2D2 HA GANADO EL JUEGO!!");
        else
            System.out.println("C3PO HA GANADO EL JUEGO!!");
    }

    public static void main(String[] args) {
        juegoUnos();
    }
}
