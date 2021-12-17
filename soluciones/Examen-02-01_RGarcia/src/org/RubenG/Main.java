package org.RubenG;

import java.util.Scanner;

/**
 * Juego para adivinar cuantos "1" hay en las cadenas elegidas, una por ti, y otras 2 por los Androides.
 * Los androides elegirán las cadenas automáticamente y en la elección por adivinar la cantidad de "1" no se podrá repetir
 * entre los participantes.
 *
 * @author: Rubén Garcia-Redondo Marín
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        String binarioJugador = "";
        String binarioAndroide1 = "";
        String binarioAndroide2 = "";
        int eleccionJugador;
        int eleccionAndroide1;
        int eleccionAndroide2 = 0;
        int victoriasJugador = 0;
        int victoriasAndroide1 = 0;
        int victoriasAndroide2 = 0;
        int cantidadDe1;
        String ganadorRonda = "";

        System.out.println("Empecemos el juego");
        do {
            binarioJugador = leerBinarioJugador();
            binarioAndroide1 = leerBinarioAndroide();
            binarioAndroide2 = leerBinarioAndroide();

            eleccionJugador = leerEleccionJugador();
            eleccionAndroide1 = leerEleccionAndroide(eleccionJugador, eleccionAndroide2);
            System.out.println("El R2-D2 dice: " + eleccionAndroide1);
            eleccionAndroide2 = leerEleccionAndroide(eleccionJugador, eleccionAndroide1);
            System.out.println("El BB-8 dice:" + eleccionAndroide2);

            cantidadDe1 = comprobarNumeroDe1(binarioJugador, binarioAndroide1, binarioAndroide2);
            ganadorRonda = comprobarGanador(cantidadDe1, eleccionJugador, eleccionAndroide1, eleccionAndroide2);
            switch (ganadorRonda) {
                case "Androide1":
                    System.out.println("La cantidad de 1 era de " + cantidadDe1 + ", gana R2-D2");
                    victoriasAndroide1 = victoriasAndroide1 + 1;
                    break;
                case "Androide2":
                    System.out.println("La cantidad de 1 era de " + cantidadDe1 + ", gana BB-8");
                    victoriasAndroide2 = victoriasAndroide2 + 1;
                    break;
                case "Jugador":
                    System.out.println("La cantidad de 1 era de " + cantidadDe1 + ", gana C-3PO");
                    victoriasJugador = victoriasJugador + 1;
                    break;
                case "Empate":
                    System.out.println("La ronda acabó en empate");
                    break;

            }
            mostrarRondasGanadas(victoriasJugador, victoriasAndroide1, victoriasAndroide2);
        }while(victoriasJugador != 3 && victoriasAndroide1 != 3 && victoriasAndroide2 != 3);

        ganadorPartida(victoriasJugador, victoriasAndroide1, victoriasAndroide2);
    }

    /**
     *
     * @param victorias1 número de victorias del Jugador
     * @param victorias2 número de victorias del Androide 1
     * @param victorias3 número de victorias del Androide 2
     */
    public static void mostrarRondasGanadas(int victorias1, int victorias2, int victorias3) {
        System.out.println("C-3PO lleva " + victorias1 + " rondas ganadas.");
        System.out.println("R2-D2 lleva " + victorias2 + " rondas ganadas.");
        System.out.println("BB-8 lleva " + victorias3 + " rondas ganadas.");
    }

    /**
     *
     * @param victorias1 número de victorias del Jugador
     * @param victorias2 número de victorias del Androide 1
     * @param victorias3 número de victorias del Androide 2
     */
    public static void ganadorPartida(int victorias1, int victorias2, int victorias3) {
        if(victorias1 > victorias2 && victorias1 > victorias3){
            if(victorias2 > victorias3){
                System.out.println("1º lugar: C-3PO con " + victorias1 + " rondas ganadas");
                System.out.println("2º lugar: R2-D2 con " + victorias2 + " rondas ganadas");
                System.out.println("3º lugar: BB-8 con " + victorias3 + " rondas ganadas");
            }else{
                System.out.println("1º lugar: C-3PO con " + victorias1 + " rondas ganadas");
                System.out.println("2º lugar: BB-8 con " + victorias3 + " rondas ganadas");
                System.out.println("3º lugar: R2-D2 con " + victorias2 + " rondas ganadas");
            }
        }
        if(victorias3 > victorias2 && victorias3 > victorias1){
            if(victorias2 > victorias1){
                System.out.println("1º lugar: BB-8 con " + victorias3 + " rondas ganadas");
                System.out.println("2º lugar: R2-D2 con " + victorias2 + " rondas ganadas");
                System.out.println("3º lugar: C-3PO con " + victorias1 + " rondas ganadas");
            } else{
                System.out.println("1º lugar: BB-8 con " + victorias3 + " rondas ganadas");
                System.out.println("2º lugar: C-3PO con " + victorias1 + " rondas ganadas");
                System.out.println("3º lugar: R2-D2 con " + victorias2 + " rondas ganadas");
            }

        }
        if(victorias2 > victorias1 && victorias2 > victorias3){
            if(victorias1 > victorias3){
                System.out.println("1º lugar: R2-D2 con " + victorias2 + " rondas ganadas");
                System.out.println("2º lugar: C-3PO con " + victorias1 + " rondas ganadas");
                System.out.println("3º lugar: BB-8 con " + victorias3 + " rondas ganadas");
            } else{
                System.out.println("1º lugar: R2-D2 con " + victorias2 + " rondas ganadas");
                System.out.println("2º lugar: BB-8 con " + victorias3 + " rondas ganadas");
                System.out.println("3º lugar: C-3PO con " + victorias1 + " rondas ganadas");
            }

        }
    }

    /**
     *
     * @param numeroDe1 Cantidad de "1" que hay en las cadenas
     * @param eleccion1 Elección del Jugador
     * @param eleccion2 Elección del Androide 1
     * @param eleccion3 Elección del Androide 2
     * @return El ganador de esa ronda
     */
    public static String comprobarGanador(int numeroDe1, int eleccion1, int eleccion2, int eleccion3) {
        String ganador = "";
        if(eleccion1 == numeroDe1){
            ganador = "Jugador";
        }else if(eleccion2 == numeroDe1){
            ganador = "Androide1";
        }else if(eleccion3 == numeroDe1){
            ganador = "Androide2";
        }else{
            ganador = "Empate";
        }
        return ganador;
    }

    /**
     *
     * @param binario1 Cadena del Jugador
     * @param binario2 Cadena del Androide 1
     * @param binario3 Cadena del Androide 2
     * @return La cantidad de "1" que hay en las cadenas
     */
    public static int comprobarNumeroDe1(String binario1, String binario2, String binario3) {
        int numero = 0;
        String cad = binario1 + binario2 + binario3;
        char[] c = cad.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if(c[i] == '1'){
                numero = numero + 1;
            }
        }

        return numero;
    }

    /**
     *
     * @param eleccion1 la elección anterior del Jugador
     * @param eleccion2 la elección del Androide 1
     * @return La elección generada aleatoriamente sin que se repita con ninguna elección anterior
     */
    public static int leerEleccionAndroide(int eleccion1, int eleccion2) {
        int aux = 0;
        do {
            aux = (int) (Math.random() * 9);
        }while(eleccion1 == aux || eleccion2 == aux );
        return aux;
    }

    /**
     *
     * @return La elección del Jugador
     */
    public static int leerEleccionJugador() {
        int eleccion = 0;
        System.out.println("¿Cuántos 1 hay?:");
        boolean correcto = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                eleccion = sc.nextInt();
                correcto = true;
            } catch (Exception e) {
                System.out.println("Debes introducir un valor válido.");
            }
        }while(!correcto);
        return eleccion;
    }

    /**
     *
     * @return La cadena de binarios del Androide generada aleatoriamente
     */
    public static String leerBinarioAndroide() {
        String cadenaDevolver = "";
        char[] cad = new char[3];
        int numero;
            for (int i = 0; i < 3; i++) {
                numero = (int) (Math.random() * 2);
                if(numero == 0){
                    cad[i] = '0';
                }else{
                    cad[i] = '1';
                }

            }

        return String.valueOf(cad);
    }

    /**
     *
     * @return La cadena del Jugador
     */
    public static String leerBinarioJugador() {
        String cadena = "";
        boolean correcto = false;
        System.out.println("C-3PO dime tu elección:");
        do{
            Scanner sc = new Scanner(System.in);
            cadena = sc.nextLine();
            char[] c = cadena.toCharArray();
            if(isCorrecta(c) && cadena.length() == 3){
                correcto = true;
            }else{
                System.out.println("Error: solo puedes coger entre 0 y 1");
            }
        }while(!correcto);
        return cadena;
    }

    /**
     *
     * @param cad Cadena para comprobar si es correcta
     * @return Verdadero si la cadena es correcta
     */
    public static boolean isCorrecta(char[] cad) {
        boolean correcto = true;
        for (int i = 0; i < cad.length; i++) {
            if (cad[i] == '1' || cad[i] == '0') {
                correcto = true;
            }else{
                correcto = false;
            }


        }
        return correcto;
    }


}
