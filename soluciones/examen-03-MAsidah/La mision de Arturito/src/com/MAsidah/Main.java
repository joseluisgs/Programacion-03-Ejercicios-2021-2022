/*
Mohamed Asidah Bchiri (loopedMoha)
51496651L   moha.as172@gmail.com
 */
package com.MAsidah;

import java.util.Random;

public class Main {

    static final int N_SECTORES = 50;
    static final int TIEMPO_MAX = 180000;
    static final int TIEMPO_RECOGIDA = 4000;
    static final int TIEMPO_DECISION = 2000;

    /**
     * Inicia los sectores con un tipo de material y una cantidad aleatorias
     * @param tipos
     * @param cantidades
     */
    public static void initSectores(char[] tipos, int[] cantidades) {
        Random r = new Random();

        for (int i = 0; i < N_SECTORES; i++) {
            int prob = r.nextInt(100);
            if (prob < 25) {
                tipos[i] = 't';
                cantidades[i] = r.nextInt(20) + 10;
            } else if (prob < 50) {
                tipos[i] = 'r';
                cantidades[i] = r.nextInt(20) + 10;
            } else if (prob < 75) {
                tipos[i] = 'm';
                cantidades[i] = r.nextInt(20) + 10;
            } else {
                tipos[i] = 'o';
                cantidades[i] = r.nextInt(20) + 10;
            }

        }
    }

    /**
     * Recoge del sector una muestra siempre que sea posible.
     * @param sector
     * @param cantidades
     * @return
     */
    public static int recogerMuestra(int sector, int[] cantidades) {
        Random r = new Random();

        int muestra = 0;
        if (!isSectorVacio(cantidades, sector)) {
            while (muestra == 0) {
                muestra = r.nextInt(3) + 2;
                if (muestra > cantidades[sector])
                    muestra = cantidades[sector];
            }
        }else{
            System.out.println("Este sector esta vacio.");
        }

        cantidades[sector] -= muestra;
        return muestra;
    }

    /**
     * Decide si lleva acabo un cambio de sentido
     * @return
     */
    public static int cambioSentido() {
        Random r = new Random();
        int sentido = r.nextInt(100) < 25 ? -1 : 1;
        return sentido;
    }

    /**
     * Actualiza la tabla de datos de las muestras recogidas
     * 0: tierra
     * 1: roca
     * 2: mineral
     * 3: otros
     *
     * @param muestra
     * @param datos
     * @param sector
     * @param tipos
     */
    public static void actualizarDatos(int muestra, int[] datos, int sector, char[] tipos) {
        switch (tipos[sector]) {
            case ('t'):
                datos[0] += muestra;
                System.out.println("Recogida muestra de tierra. Cantidad: " + muestra);
                break;
            case ('r'):
                datos[1] += muestra;
                System.out.println("Recogida muestra de roca. Cantidad: " + muestra);
                break;
            case ('m'):
                datos[2] += muestra;
                System.out.println("Recogida muestra de mineral. Cantidad: " + muestra);
                break;
            case ('o'):
                datos[3] += muestra;
                System.out.println("Recogida muestra de otros productos. Cantidad: " + muestra);
                break;
            default:
                break;
        }
    }


    /**
     * Informa de si un sector ha quedado vacío.
     * @param cantidad
     * @param sector
     * @return
     */
    public static boolean isSectorVacio(int[] cantidad, int sector){
        return cantidad[sector] <= 0;
    }


    /**
     * Muestra los datos de recogida totales al final de la simulación.
     * @param datos
     */
    public static void mostrarDatos(int[] datos){
        System.out.println("Cantidad de tierra recolectada: " + datos[0]);
        System.out.println("Cantidad de roca recolectada: " + datos[1]);
        System.out.println("Cantidad de mineral recolectado: " + datos[2]);
        System.out.println("Cantidad de otras materias recolectadas: " + datos[3]);
    }

    /**
     * Elabora un mapa de los sectores en los que ha encontrado mineral
     * @param mineral
     * @param cantidad
     */
    public static void mapaMineral(boolean[] mineral, int[] cantidad){
        System.out.println("Cantidad de mineral recolectada en cada sector:");
        for (int i = 0; i < mineral.length; i++) {
            if(mineral[i])
                System.out.println("Sector "+i+"["+cantidad[i]+"] ");
        }
    }

    /**
     * Ejecuta la misión de R2
     */
    public static void ejecutarMision() {
        char[] tipos = new char[N_SECTORES];
        int[] cantidades = new int[N_SECTORES];
        int[] datos = new int[4];

        //si hay mineral marcará la posicion con un true
        boolean[] mineral = new boolean[N_SECTORES];
        int[] mineralExtraido = new int[N_SECTORES];

        int muestra = 0;
        int sentido = 1;
        //inicializacion de sectores
        initSectores(tipos, cantidades);

        //comienza recorrido
        int tiempo = TIEMPO_MAX;
        int pos = 0;
        while (tiempo > 0) {
            try {


                while (pos < N_SECTORES && sentido > 0 && tiempo > 0) {
                    //recoge muestra
                    System.out.println("Llegando al sector: " + pos);
                    muestra = recogerMuestra(pos, cantidades);
                    actualizarDatos(muestra, datos, pos, tipos);
                    if (tipos[pos] == 'm') {
                        mineral[pos] = true;
                        mineralExtraido[pos] += muestra;
                    }
                    Thread.sleep(TIEMPO_RECOGIDA);
                    tiempo -= TIEMPO_RECOGIDA;

                    //cambio de direccion
                    if (pos == 49) {
                        sentido = -1;
                        Thread.sleep(TIEMPO_DECISION);
                        tiempo -= TIEMPO_DECISION;
                    } else {
                        sentido = cambioSentido();
                        Thread.sleep(TIEMPO_DECISION);
                        tiempo -= TIEMPO_DECISION;
                        pos++;
                    }
                }
                while (pos > 0 && sentido < 0 && tiempo > 0) {
                    //recoge muestra
                    System.out.println("Llegando al sector: " + pos);
                    muestra = recogerMuestra(pos, cantidades);
                    actualizarDatos(muestra, datos, pos, tipos);
                    if (tipos[pos] == 'm') {
                        mineral[pos] = true;
                        mineralExtraido[pos] += muestra;
                    }
                    Thread.sleep(TIEMPO_RECOGIDA);
                    tiempo -= TIEMPO_RECOGIDA;

                    //cambio de direccion
                    if (pos == 0) {
                        sentido = 1;
                        Thread.sleep(TIEMPO_DECISION);
                        tiempo -= TIEMPO_DECISION;
                    } else {
                        sentido = cambioSentido();
                        Thread.sleep(TIEMPO_DECISION);
                        tiempo -= TIEMPO_DECISION;
                        pos--;
                    }

                }

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

        mostrarDatos(datos);
        mapaMineral(mineral, mineralExtraido);
    }


    public static void main(String[] args) {
        ejecutarMision();
    }
}
