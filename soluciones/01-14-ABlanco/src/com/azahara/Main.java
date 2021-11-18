package com.azahara;
import java.util.Scanner;

public class Main {
    /**
     * 14. ¿Dónde está la mosca? Vamos a intentar cazar una mosca. La mosca será un valor que
     * se introduce en una posición de un vector; el jugador no ve el panel pero si ve las casillas a
     * las que puede golpear. Si la mosca está en esa posición se acaba el juego, mosca cazada. Si
     * la mosca no está en esa posición pueden ocurrir dos cosas: que la mosca esté en casillas
     * adyacentes en cuyo caso la mosca revolotea y se sitúa en otra casilla o que la mosca no esté
     * en casillas adyacentes, en este caso la mosca permanece donde está.
     * @param args
     *
     * he tardado 2 horas
     */
    public static void main(String[] args) {

        mensajeDeInicioDeJuego();

        //do while para repetir todo hasta que la mosca ha sido cazada (moscaEstaMuerta=true)
        boolean moscaEstaMuerta = false;

        //hacer vector que vea el jugador
        int [] tablero={1,2,3,4,5,6,7,8,9,10};

        imprimirVector(tablero);


        //selecionamos aleatoriamente donde esta la mosca
        int posicionMosoca=elegirPosicionDeMosca();


        do {

            System.out.println("la posicion de la mosca es "+ (posicionMosoca+1));

            //pedir golpe
            int posicionElegidaDeGolpe = getPosicionElegidaDeGolpe();

            //comprobar si la mataste
            moscaEstaMuerta = comprobarSiMoscaEstaMuerta( posicionMosoca , posicionElegidaDeGolpe);

            //comprobar si casi la das
            boolean casiLaDas = comprobarSiCasiLaMatas(posicionMosoca,posicionElegidaDeGolpe);

            //si casi la das elegir otrea posicion para la mosca

            posicionMosoca=elegirPosicionDeMosca();


        }while(moscaEstaMuerta==false);

        System.out.println("¡¡enhorabuena!! has cazado a la mosca");
    }

    private static void mensajeDeInicioDeJuego() {
        System.out.println("¿Dónde está la mosca?");
        System.out.println("Vamos a intentar cazar una mosca. Tu no ves donde esta, solo las casillas"+
                        "a las que puede golpear");
        System.out.println("si la mosca esta el la casilla de al lado esta revolotea y se sitúa en otra casilla ");
        System.out.println("¡¡suerte!!");
    }

    private static boolean comprobarSiCasiLaMatas( int posicionMosa, int posicionGolpeo){
        boolean casiLaDas =false;
        if (posicionGolpeo!=0){
            if (posicionMosa==posicionGolpeo-1){
                casiLaDas=true;
            }
        }
        if(posicionGolpeo!=(10)){
            if (posicionMosa==posicionGolpeo+1){
                casiLaDas=true;
            }
        }
        if (casiLaDas==true){
            System.out.println("¡¡ ha salido volando, casi la das!!");
        }
        return casiLaDas;
    }

    private static boolean comprobarSiMoscaEstaMuerta(int posicionDeMOsca, int posicionElegidaDeGolpe){
        boolean moscaEstaMuerta;

        if (posicionDeMOsca==posicionElegidaDeGolpe){
            moscaEstaMuerta = true;
        } else {
            moscaEstaMuerta = false;
            System.out.println("no has acertado, la mosca sigue dando por c***");
        }
        return moscaEstaMuerta;
    }

    private static int getPosicionElegidaDeGolpe() {
        int posicionElegidaDeGolpe = -1;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("dime la posicion a la que quieres dar el golpe del 1 al 10");
            //guardamos -1 para que sea la posicion real en el vector y no la del jugador
            posicionElegidaDeGolpe = ((sc.nextInt())-1);
        }while (posicionElegidaDeGolpe<0 || posicionElegidaDeGolpe>9);

        return posicionElegidaDeGolpe;
    }

    private static void PosicionamosLaMosca(int[] vMosca, int posicionMosoca) {
        //como todo el vector esta a 0 solo ponemos un 1 en la posicion de mosca
        vMosca[posicionMosoca]=1;
    }

    public static void imprimirVector(int v []){
        System.out.print(" <[");
        for (int i = 0; i < v.length ; i++) {
            System.out.print(" [ ");
            System.out.print(v[i]);
            System.out.print(" ]");
        }
        System.out.println(" ]>");
    }

    public static int elegirPosicionDeMosca(){
        //elegimos al azar una posicion del vecto (0-9)
        int posicionMosca=(int)(Math.random()*10);
        return posicionMosca;
    }

}
