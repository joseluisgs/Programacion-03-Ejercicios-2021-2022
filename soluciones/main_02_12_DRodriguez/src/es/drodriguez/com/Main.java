package es.drodriguez.com;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Variables del juego:
        final int numeroIntentosMaximo = 3;

        //Creación de Scanner
        Scanner sc = new Scanner(System.in);

        //Indicamos el tamaño que va a tener nuestro tablero
        int tamanoTablero = pedirTamanoTablero(sc);

        //Posición de la mosca cada vez que revolotea
        int posicionMosca[] = new int[2];
        getposicionMosca(tamanoTablero,posicionMosca);

        //Creamos el tablero
        boolean [][]tablero = new boolean[tamanoTablero][tamanoTablero];
        initTablero(tablero,tamanoTablero,posicionMosca);

        //Desarrollo del juego
        inicioJuego(sc, tamanoTablero, posicionMosca, tablero, numeroIntentosMaximo);
    }

    public static void imprimirMatrizBoolean(boolean[][] matriz) {
        for (int i = 0; i < matriz.length; i++)
            System.out.println(Arrays.toString(matriz[i]));
    }

    public static void inicioJuego(Scanner sc, int tamanoTablero, int[] posicionMosca, boolean[][] tablero, int numeroIntentos) {
        boolean continuarJugando = true;
        int intentosActuales = 0;
        boolean moscaCazada = false;
        while (continuarJugando && intentosActuales < numeroIntentos && !moscaCazada) {
            imprimirMatrizBoolean(tablero);
            //pedimos una posición
            int posicionI = pedirPosicionI(tamanoTablero, sc);
            int posicionJ = pedirPosicionJ(tamanoTablero, sc);
            //el resultado será según esta posición (en caso de perder actualizará variables)
            moscaCazada = tablero[posicionI][posicionJ];
            if (!moscaCazada) {
                //ver si ha pegado cerca
                boolean moscaProxima = false;
                for (int i = posicionI - 1; i <= posicionI + 1 && !moscaProxima; i++) {
                    for (int j = posicionJ - 1; j <= posicionJ + 1 && !moscaProxima; j++) {
                        //comprobamos que i y j no se salen del tamaño de la matriz
                        if (i >= 0 && i < tamanoTablero && j >= 0 && j < tamanoTablero) {
                            moscaProxima = tablero[i][j];
                        }
                    }
                }
                if (moscaProxima) {
                    getposicionMosca(tamanoTablero, posicionMosca);
                    initTablero(tablero,tamanoTablero,posicionMosca);
                    System.out.println("La mosca estaba cerca y se ha ido revoloteando");
                } else {
                    System.out.println("La mosca estaba lejos");
                }
                intentosActuales++;
                //pedir si quiere seguir jugando si le quedan intentos
                if (intentosActuales < numeroIntentos) {
                    System.out.println("Te quedan " + (numeroIntentos - intentosActuales) + ". ¿Deseas seguir intentándolo? (y/n)");
                    String respuesta = sc.nextLine();
                    continuarJugando = respuesta.equals("y") || respuesta.equals("Y");
                }
            }
        }
        if (moscaCazada) {
            //la mosca ha sido cazada
            System.out.println("Enhorabuena!, te has cargado la mosca");
        } else if (intentosActuales >= numeroIntentos) {
            //no hay más intentos
            System.out.println("Ooooo, se te han acabado los intentos :(");
        } else {
            //ha salido del juego
            System.out.println("Tu lo has decidido, no quieres cargarte a la mosca");
        }
    }

    public static void getposicionMosca(int tamanoTablero, int[] posicionMosca) {
        int nuevaMoscaI = randomEntre(0, tamanoTablero - 1);
        int nuevaMoscaJ = randomEntre(0, tamanoTablero - 1);
        while (nuevaMoscaI == posicionMosca[0] && nuevaMoscaJ == posicionMosca[1]) {
            nuevaMoscaI = randomEntre(0, tamanoTablero - 1);
            nuevaMoscaJ = randomEntre(0, tamanoTablero - 1);
        }
        posicionMosca[0] = nuevaMoscaI;
        posicionMosca[1] = nuevaMoscaJ;
    }

    public static void initTablero(boolean[][] tablero, int tamanoTablero, int[] posicionMosca) {
        for (int i = 0; i < tamanoTablero; i++) {
            for (int j = 0; j < tamanoTablero; j++) {
                tablero[i][j] = i == posicionMosca[0] && j == posicionMosca[1];
            }
        }
    }

    public static int pedirTamanoTablero(Scanner sc) {
        System.out.println("¿Dime el tamaño del tablero (N x N)?");
        return escaneaNumero(sc);
    }
    public static int pedirPosicionI(int tamanoTablero, Scanner sc){
        System.out.println("Indica la posición I entre 0 y " +(tamanoTablero-1));
        int posicion = escaneaNumero(sc);
        while (posicion < 0 || posicion >= tamanoTablero) {
            System.out.println("Recuerda es un número entre 0 y "+(tamanoTablero-1));
            posicion = escaneaNumero(sc);
        }
        return posicion;
    }
    public static int pedirPosicionJ(int tamanoTablero, Scanner sc){
        System.out.println("Indica la posición J entre 0 y " +(tamanoTablero-1));
        int posicion = escaneaNumero(sc);
        while (posicion < 0 || posicion >= tamanoTablero) {
            System.out.println("Recuerda es un número entre 0 y "+(tamanoTablero-1));
            posicion = escaneaNumero(sc);
        }
        return posicion;
    }

    public static int randomEntre(int min, int max) {
        return (int) Math.round(Math.random()*((double) max)) + min;
    }

    public static int escaneaNumero(Scanner sc) {
        try {
            int tamanoTablero;
            tamanoTablero = sc.nextInt();
            sc.nextLine();
            return tamanoTablero;
        } catch (Exception e) {
            System.out.println("!!NOOOOOOOO!! Recuerda que tienes que poner un número :/");
            sc.nextLine();
            return escaneaNumero(sc);
        }
    }
}
