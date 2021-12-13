package es.dani;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Variables y constantes
        int[] tableroSecreto;
        int[] tableroPublico;
        int primeraCarta=-1;
        int segundaCarta=-1;

        // Tamaño del tablero
        tableroSecreto=sizeJuegoParejas();
        tableroPublico= new int[tableroSecreto.length];

        //Parejas que habra
        int parejas= tableroSecreto.length/2;

        //Genero las parejas
        generarParejas(tableroSecreto);

        //Mezclo las parejas
        shuffle(tableroSecreto);

        //Mostramos el tablero inicial
        mostrarTablero(tableroSecreto, tableroPublico, primeraCarta, segundaCarta);

        //Procedimiento del juego
        comprobacionCartas(tableroSecreto, tableroPublico, parejas);

        System.out.println("Has encontrado todas las parejas.");
    }

    /**
     * Procedimiento para comprobar si las cartas son las mismas
     * @param tableroSecreto vector donde tenemos almacenadas las cartas
     * @param tableroPublico vector donde mostraremos las cartas
     * @param parejas parejas que tenemos q encontrar
     */
    public static void comprobacionCartas(int[] tableroSecreto, int[] tableroPublico, int parejas) {
        int pos;
        int pos1;
        do {
            pos1=-1;
            pos=getCarta(tableroSecreto, tableroPublico);
            mostrarTablero(tableroSecreto, tableroPublico, pos, pos1);

            do {
                pos1=getCarta(tableroSecreto, tableroPublico);
                if (pos==pos1) System.out.println("No puedes ver la misma carta.");
            }while(pos==pos1);
            mostrarTablero(tableroSecreto, tableroPublico, pos, pos1);

            if (tableroSecreto[pos] == tableroSecreto[pos1]) {
                sonPareja(tableroSecreto, tableroPublico, pos, pos1);
                parejas--;
            }
            System.out.println("Parejas restantes: " + parejas);
        }while (parejas > 0);
    }

    /**
     * Funcion para seleecionar la carta que queremos ver
     * @param tableroSecreto vector donde se encuentran las cartas
     * @param tableroPublico vector donde queremos mostrar las cartas
     * @return devuelve la posicion donde queremos levantar la carta
     */
    public static int getCarta(int[] tableroSecreto, int[]tableroPublico) {
        int pos;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("¿Que cartas quieres ver?:");
            pos = sc.nextInt() - 1;
            if (pos < 0 || pos > tableroSecreto.length) System.out.println("Número introducido incorrecto.");
            if(pos> 0 && pos< tableroSecreto.length) if(tableroPublico[pos]!=0) System.out.println("Esta carta ya esta visible.");
        } while ((pos < 0 || pos > tableroSecreto.length) || tableroPublico[pos]!=0);
        return pos;
    }

    /**
     * Procedimiento para mostrar el tablero
     * @param tableroSecreto vector donde se encuentra las cartas
     * @param tableroPublico vector donde queremos que se vean las carta levantadas
     * @param pos primera carta que hemos seleccionado
     * @param pos1 segunda carta que hemos seleccionado
     */
    public static void mostrarTablero(int[] tableroSecreto, int[] tableroPublico, int pos, int pos1) {
        System.out.print("[ ");
        for (int i = 0; i < tableroSecreto.length; i++) {
            if (pos != i && pos1 != i){
                System.out.print(tableroPublico[i] +" ");
            }
            else {
                if (pos == i) System.out.print(tableroSecreto[pos] + " ");
                if (pos1 == i) System.out.print(tableroSecreto[pos1] + " ");
            }
        }
        System.out.println("]");
    }

    /**
     * Procedimiento donde almacenaremos el contenido del vector secreto en el publico
     * @param tableroSecreto vector donde se encuentra las cartas
     * @param tableroPublico vector donde queremos mostrar las cartas
     * @param pos primera carta seleccionada
     * @param pos1 segunda carta seleccionada
     */
    public static void sonPareja(int[] tableroSecreto, int[] tableroPublico, int pos, int pos1) {
        tableroPublico[pos]= tableroSecreto[pos];
        tableroPublico[pos1]= tableroSecreto[pos1];
    }
    /**
     * Funcion para crear el tamaño del tablero
     * @return devuelve el tamaño del tablero
     */
    public static int[] sizeJuegoParejas(){
        Scanner sc = new Scanner(System.in);
        int size;
        int[] auxiliar;
        do {
            System.out.println("Introduce el tamaño del juego (siempre que sea par y mayor de 4):");
            size= sc.nextInt();
            auxiliar = new int[size];
            if (size% 2!= 0 || size <= 4){
                System.out.println("El tamaño no es válido.");
            }
        } while (size % 2 != 0 || size <= 4);
        return auxiliar;
    }

    /**
     * Procedimiento para generar las parejas y almacenarlas en el tablero
     * @param vector vector donde queremos almacenarlo
     */
    public static void generarParejas(int[] vector){
        vector[0]=1;
        vector[1]=1;
        for (int i = 3; i < vector.length ; i= i+2) {
            vector[i]= vector[i-2]+1;
            vector[i-1]= vector[i];
        }
    }

    /**
     * Procedimiento de intercambio de posiciones
     * @param vector vector donde intercambiaremos posiciones
     * @param i primera posicion
     * @param j segunda posicion
     */
    public static void swap(int[] vector, int i, int j) {
        int aux= vector[i];
        vector[i]= vector[j];
        vector[j]= aux;
    }

    /**
     * Procedimiento para mezclar las cartas en un vector
     * @param vector vector donde mezclaremos las cartas
     */
    public static void shuffle(int[] vector){
        Random random = new Random();
        int i=0;
        for (int j : random.ints(vector.length, 0, vector.length).toArray()) {
            swap(vector, i++, j);
        }
    }

    /**
     * Procedimiento que imprime el vector
     * @param vector vector que queremos imprimir
     */
    public static void imprimir(int[] vector){
        System.out.println(Arrays.toString(vector));
    }
}
