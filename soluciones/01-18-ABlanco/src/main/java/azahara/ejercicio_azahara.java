package azahara;
import java.util.Scanner;

/**
 * @author Azahara Blanco Rodríguez
 * @Date 08-01-2022
 *
 * @description 18. Realizaremos el juego del buscaminas con un vector(intentaremos una matiz). Para aquellos que no hayan
 * jugado nunca (ni siquiera mientras estoy explicando algo) os recuerdo que el juego consiste
 * en destapar todas las casillas de un vector menos las minas; si pisamos una mina el juego
 * acaba y hemos perdido. El juego nos proporcionará pistas, de forma que si destapamos una casilla y no hay una mina, esta casilla nos indicará cuantas minas hay adyacentes a esa posición. Por lo tanto el
 * ordenador debe preparar un panel de 20 casillas para nosotros en el que colocará 6 minas y
 * las pistas correspondientes. Ejemplo: {0,1,*,1,1,*,*,2,*,1,0,0,0}
 * Este panel permanecerá oculto y es el jugador el que debe
 */
public class ejercicio_azahara {
    public static void main(String[] args) {

        //iniciar el tablero y las constantes para ver cuantas minas y casillas queremos
        int LARGO_DE_TABLERO=10;
        int tableroVisible[][] =new int [LARGO_DE_TABLERO][LARGO_DE_TABLERO];
        int tableroEscondido[][]=new int [LARGO_DE_TABLERO][LARGO_DE_TABLERO];
        int MINAS = 10 ;
        int casillasPorDestapar=((LARGO_DE_TABLERO*LARGO_DE_TABLERO)-MINAS);
        boolean muerto = false;

        //colocamos las bombas

        colocarBombas(tableroEscondido,MINAS);
        rellenarTableroDenueves(tableroVisible);

        //iniciamos juego que terminará si selecionamos bomba o si terminamos

        do {

            imprimirMatriz(tableroVisible);


            // pedir elección
            int [] cañon = pedircoordenadas(tableroEscondido);

            //muerto??
             muerto = comprobarSiMuerto(tableroEscondido,cañon);


            if (muerto==false){
                casillasPorDestapar--;
                System.out.println("no has pisado bomba");

                //poner las casillas donde hay bombas
                ponerNumeroDeBombasCercanas(tableroEscondido, cañon, tableroVisible);

                //imprimimos el tablero


                if (casillasPorDestapar==0){
                    muerto=true;
                    System.out.println("!!has ganado, conseguiste averiguar todas las casillas¡¡");
                }


            }else {
                System.out.println("pumm muerto");
                imprimirMatriz(tableroEscondido);
                muerto=true;
            }

        }while (!muerto);

        System.out.println("fin del juego");


    }

    private static void rellenarTableroDenueves(int[][] tableroVisible) {
        for (int i = 0; i < tableroVisible.length; i++) {
            for (int j = 0; j < tableroVisible.length; j++) {
                tableroVisible[i][j]=9;
            }
        }
    }

    private static void ponerNumeroDeBombasCercanas(int[][] tableroEscondido,  int []cañon, int [][] tableroVisible) {
        //contar las bonbas
        int coordenada1=cañon[0];
        int coordenada2=cañon[1];
        int numero= 0;

        for (int i = (coordenada1-1); i <(coordenada1+2); i++) {
            for (int j = (coordenada2-1); j < (coordenada2+2); j++) {
                if(i>=0 && i<tableroEscondido.length && j>=0 && j<tableroEscondido.length){
                    if (tableroEscondido[i][j]==1){
                        numero++;


                    }
                }
            }
        }
        //ponerlo en la casilla
        tableroVisible[coordenada1][coordenada2]=numero;
    }

    private static boolean comprobarSiMuerto(int[][] tableroEscondido, int[] cañon) {
        return tableroEscondido[cañon[0]][cañon[1]]==1;
    }

    private static int [] pedircoordenadas(int[][] tableroEscondido) {
        int [] coordenada = new int[2];
        System.out.println("coordenada 1");
        coordenada[0] = pedircoordenadaIndividual(tableroEscondido);
        System.out.println("coordenada 2");
        coordenada[1] = pedircoordenadaIndividual(tableroEscondido);
        return coordenada;
    }

    private static int pedircoordenadaIndividual(int[][] tableroEscondido) {
        Scanner cs = new Scanner(System.in);
        boolean escorrecto = false;
        int coordenada=0;

        do {
            try {
                System.out.println("dime tu coordenada que este entre 1 y "+ tableroEscondido.length);
                 coordenada = cs.nextInt();
                if ((coordenada< (tableroEscondido.length+1)) && (coordenada>=1)) {escorrecto = true;};
            }catch (Exception e){
                cs.next();
            }
        }while (!escorrecto);
        int coordenadaTraducida=coordenada-1;
        return coordenadaTraducida;
    }

    private static void imprimirMatriz(int[][] v) {
        for (int i = 0; i <v.length ; i++) {
            System.out.print("[");
            for (int j = 0; j < v.length ; j++) {
                System.out.print("["+v[i][j]);
                System.out.print("]");
            }
            System.out.println("]");
        }
    }

    private static void colocarBombas(int[][] tableroEscondido, int minas) {
        //colocamos el  numero de numas en lugar carrespondiente si no hay una mina en su lugar
        int minasPorColocar=minas;
        for (int i = 0; i <minasPorColocar ; i++) {
            int coordenada1;
            int coordenada2;
            do {
                 coordenada1 = (int)(Math.random()*(tableroEscondido.length));
                 coordenada2 =(int)(Math.random()*(tableroEscondido.length));

            }while (tableroEscondido[coordenada1][coordenada2]!=0);
            tableroEscondido[coordenada1][coordenada2]=1;
        }
    }

}

