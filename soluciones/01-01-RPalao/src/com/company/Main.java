package com.company;
import java.util.Scanner;

/**
 * @author Rocío Palao Fernández
 * 06/11/21
 * github: Rochiio
 * Ejercicio 1 hoja 1 tema 3
 */


public class Main {

    public static void main(String[] args) {
        int tamano;
        System.out.println("Hola");
        System.out.println("Intentando utilizar java :))");
        Scanner sc = new Scanner(System.in);

        //Array
        System.out.println("De cuanto quieres el array: ");
        tamano = sc.nextInt();
        int[] array = new int[tamano];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Introduzca el valor de la posicion " + (i + 1) + " :");
            array[i] = sc.nextInt();
        }

        //Array e imprimirlo por pantalla
        esImprimir(array);

        //Maximo y minimo del array
        esMaximo(array);

        //Media del array
        esMedia(array);

        //Ordenación por burbuja
        isBubble(array);

        //Ordenación por selección
        isSeleccion(array);

        //Ordenación por inserción
        isInsercion(array);

        //Ordenación por Quicksort
        isQuicksort(array,0, array.length-1);

        //Busqueda lineal
        System.out.print("Dime que número buscas: ");
        int numberLineal = sc.nextInt();
        int resultLineal = esLineal(array,numberLineal);
        if (resultLineal == -1)
            System.out.println("El número no ha sido encontrado en este array");
        else
           System.out.println("El numero " + numberLineal+ " ha sido encontrado en el array en la posición: " +(resultLineal+1));



        //Búsqueda binaria
        System.out.print("Dime que número buscas: ");
        int number = sc.nextInt();
        int result = isBinary(array,0, array.length-1,number);
        if (result == -1)
            System.out.println("El número no ha sido encontrado en este array");
        else
            System.out.println("El numero " + number + " ha sido encontrado en el array en la posición: " +(result+1));

    }



    /**
     *Imprimir el vector
     * @param imprimir array que vamos a imprimir
     */
    public static void esImprimir(int[] imprimir) {
        int size = imprimir.length;
        for (int i = 0; i < size; i++) {
            System.out.println("Imprimir numero : " + (i + 1) + " , el array es: " + imprimir[i]);
        }
    }

    /**
     *
     * @param maxMin array del que vamos a saber su máximo y minimo
     */
    public static void esMaximo(int[] maxMin) {
        //Variables
        int max = maxMin[0];
        int min = maxMin[0];
        int size = maxMin.length;
        for (int i = 0; i < size; i++) {

            if (maxMin[i] < min) {
                min = maxMin[i];
            } else if (maxMin[i] > max) {
                max = maxMin[i];
            }
            System.out.println("Maximo " + max + " minimo " + min);
        }
        System.out.println("El maximo es : " + max + " y el minimo es : " + min);
    }


    /**
     *
     * @param arrayMedia Array del que vamos a hacer la media
     */
    public static void esMedia(int[] arrayMedia) {
        int media;
        int suma = 0;
        int size = arrayMedia.length;

        for (int i = 0; i < size; i++) {
            suma = suma + arrayMedia[i];
        }
        media = suma / size;

        System.out.println("La media es de:" + media);
    }


    /**
     *
     * @param bubble array del que vamos a hacer la ordenación de burbuja
     */
    public static void isBubble(int[] bubble) {
        int size = bubble.length;
        for (int i=1; i<size; i++) {
            for (int j = size - 1; j >= i; j--) {
                if (bubble[j] < bubble[j - 1]) {
                    int tmp = bubble[j];
                    bubble[j] = bubble[j - 1];
                    bubble[j - 1] = tmp;
                }
            }
        }
    }


    /**
     *
     * @param seleccion array del que vamos a hacer la ordenación por selección
     */
    public static void isSeleccion(int[] seleccion){
        int size= seleccion.length;
        for (int i=0; i<size-1; i++){
            int positionMin=i;
            for (int j=i+1; j<size; j++){
                if (seleccion[j]<seleccion[positionMin]){
                    positionMin=j;
                }
            }
            int tmp = seleccion[i];
            seleccion[i] = seleccion[positionMin];
            seleccion[positionMin]=tmp;
        }
    }


    /**
     *
     * @param insercion array del que vamos a hacer la ordenación por insercion
     */
    public static void isInsercion(int[] insercion){
        int size = insercion.length;
        for (int i=1; i<size; i++){
            int position=insercion[i];
            int j= i-1;

            while ((j>=0) && (position<insercion[j])){
                insercion[j+1]=insercion[j];
                j--;
            }
            insercion[j+1]=position;
        }
    }

    /**
     *
     * @param array array del que vamos a hacer la ordenación por quicksort
     * @param izq principio array
     * @param der final array
     */
    public static void isQuicksort(int [] array, int izq, int der){

        int pivote = array[izq];
        int aux;
        int i= izq;
        int j= der;

        //Buscar el pivote
        while (i < j){
            while (array[i]<= pivote && i<j) i++;
            while (array[j]>pivote) j--;
            if (i<j){
                aux = array[i];
                array[i]=array[j];
                array[j]=aux;
            }
        }
        //Colocación pivote
        array[izq]=array[j];
        array[j]=pivote;

        //Orden subarray izq
        if (izq < j) {
            isQuicksort(array,izq,j-1);
        }
        if (der > j+1){
            isQuicksort(array,j+1,der);
        }
    }

    /**
     * Buscar un numero de forma lineal
     * @param lineal array en el que vamos a buscar el número
     */
    public static int esLineal(int[] lineal, int buscado) {
        int pos = -1;
        for (int i=0; (i<lineal.length)&& (pos==-1);i++){
            if (lineal[i]==buscado){
                pos = i;
            }
        }
        return pos;
    }



    /**
     * Búsqueda binaria de un elemento
     * @param array array en el que queremos ver si esta el número buscado
     * @param izq numero de la izquierda
     * @param der numero de la derecha
     * @param numberSearch número que se busca
     */
    public static int isBinary(int [] array,int izq, int der, int numberSearch){
        int centro= (izq+der)/2;

        if (izq>der)
            return -1;
        if (array[centro]==numberSearch)
            return centro;
        if (array[centro]>numberSearch)
            return isBinary(array,izq,centro-1,numberSearch);
        else
            return isBinary(array,centro+1,der,numberSearch);
    }


}

