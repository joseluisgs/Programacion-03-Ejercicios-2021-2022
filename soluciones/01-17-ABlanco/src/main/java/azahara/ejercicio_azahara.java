package azahara;
import java.util.Scanner;

/**
 * @author Azahara Blanco Rodríguez
 * @date 03-01-2022
 *
 * @description Realiza el juego de los barquitos pero con una matriz. Sólo se pondrán submarinos
 * (barcos de una casilla). El juego consiste en lo siguiente:
 * - Los paneles serán de 20 posiciones.
 * - Se pondrán 4 barcos: el ordenador coloca los suyos al azar y el jugador humano es
 * preguntado. Los barcos no pueden estar colocados de forma adyacente.
 * - El juego termina cuando acaba con la flota del ordenador.
 * Al final del juego se muestran todos los
 * paneles.
 *
 */
public class ejercicio_azahara {
    public static void main(String[] args) {

        int NUMEO_DE_BARCOS = 4;
        int TAMAÑO_DEL_VECTOR =20;
        int barcosHundidos=0;

        //iniciar un vector con 5 casillas para jugar y otro para guardar los varcos


        int tableroVisible[][] = new int [TAMAÑO_DEL_VECTOR][TAMAÑO_DEL_VECTOR];
        int tableroNoVisible[][] = new int [TAMAÑO_DEL_VECTOR][TAMAÑO_DEL_VECTOR];


        //poner aleatoriamente los barcos

        ponerLosVarcos(NUMEO_DE_BARCOS,tableroNoVisible);

        //do mientras juegas
        do {
            //pedir casilla  y ver si le has dado

             boolean hundido=pedirGolpe(tableroVisible, tableroNoVisible);

             if (hundido==true){
                 barcosHundidos++;
             }

            imprimirVector(tableroVisible);

        }while(barcosHundidos!=4);

        System.out.println("el juego ha acabado");

    }

    private static void imprimirVector(int[][] tableroVisible) {

        for (int i = 0; i < tableroVisible.length; i++) {
            for (int j = 0; j < tableroVisible.length; j++) {
                System.out.print("/"+ tableroVisible[i][j]);
            }
            System.out.println("/");
        }
    }

    private static boolean pedirGolpe( int[][] tableroVisible, int[][] tableroNoVisible) {


            //pedimos el golpe
             System.out.println("coordenada 1");
            int coordenada1 = pedirCoordenada(tableroVisible);
              System.out.println("coordenada 1");
            int coordenada2 = pedirCoordenada(tableroVisible);

            //comprobamos si le he mos dado

            if (tableroNoVisible[coordenada1][coordenada2]==1){
                tableroVisible [coordenada1][coordenada2]=1;
                System.out.println("has hundido un barco");
                return true;
            }else{
                tableroVisible [coordenada1][coordenada2]=-1;
                System.out.println("agua");
                return false;
            }


    }

    private static int pedirCoordenada(int[][] tableroVisible) {
        boolean ok = false;
        Scanner sc = new Scanner(System.in);
        int coordenada=0;
        do {
            try {
                System.out.println("Dime la corrdenadoa dande quieres golpear entre 0 y 5");
                coordenada = sc.nextInt();
                if ((coordenada<=tableroVisible.length)&&(coordenada>=0)){ok = true;}

            }catch (Exception e){
                sc.next();
            }
        }while(!ok);
        return coordenada;
    }

    private static void ponerLosVarcos(int numeo_de_barcos, int [][] tableroNoVisible) {
        //colocamos 4 barcos si no hay ya en esa casilla
        for (int i = 0; i < 4; i++) {
            boolean casillaCorrecta =false;
            int h =-1;
            int j =-1;

            do {
                //selecionamos la casilla aleatoriamente

                j = (int)(Math.random()*(tableroNoVisible.length));
                System.out.println(j);
                h = (int)(Math.random()*(tableroNoVisible.length));
                System.out.println(h);
                //comprobamos que en esa casilla o en otras no hay barcos

                casillaCorrecta=comprobarCasillaCorrecta(tableroNoVisible,j,h);

            }while (!casillaCorrecta);

            tableroNoVisible[j][h]=1;
        }
    }

    private static boolean comprobarCasillaCorrecta(int[][] tableroNoVisible, int j, int h) {
        boolean casillaCorrecta = false;
        for (int i = j-1; i< j+1 ; i++) {
            for (int a = h-1; a< h+1 ; a++) {
                if (tableroNoVisible[i][a]==1){
                    return false;
                }
            }
        }
        return true;

    }
}

