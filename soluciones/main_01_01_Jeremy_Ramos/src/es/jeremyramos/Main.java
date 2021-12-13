package es.jeremyramos;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int[] numerosVarios = {1, 3, 4, 5, 6, 7, 3, 4, 6};
        int opción;
        int izq = 0;
        int der = numerosVarios.length - 1;
        do {
            System.out.print(" \n Que quieres hacer: \n 1) Imprimir el vector \n 2) máximo del vector \n 3) mínimo del vector \n 4) media del vector \n 5) ordenación por burbuja" +
                    "  \n 6) ordenación por selección \n 7) ordenación por inserción \n 8) ordenación por quicksort \n 9) búsqueda de un elemento lineal \n 10) búsqueda de un elemento de manera binaria recursiva \n 11) Salir \n Opción:  ");

            opción = sc.nextInt();
            switch (opción) {

                case 1:
                    imprimirVector(numerosVarios);
                    break;

                case 2:
                    mayorElementoVector(numerosVarios);

                    break;
                case 3:
                    mínimoElementoVector(numerosVarios);
                    break;
                case 4:
                    mediaElementoVector(numerosVarios);
                    break;
                case 5:
                    ordenarBurbuja(numerosVarios);
                    break;
                case 6:
                    ordenarPorSelección(numerosVarios);
                    break;
                case 7:
                    ordenarPorInserción(numerosVarios);
                    break;

                case 8:
                    ordenarPorQuickShort(numerosVarios,izq,der);
                    System.out.println(" \n Este es el vector ordenado con el algoritmo de quicksort" + Arrays.toString(numerosVarios));
                    break;


            }

        } while (opción != 11);
        System.out.println("Gracias por jugar :D");
    }

    private static void ordenarPorQuickShort(int[] numerosVarios, int izq, int der) {
        int pivote = numerosVarios[izq];
        int i = izq;
        int j = der;
        int aux;

        while (i < j) {
            while (numerosVarios[i] <= pivote && i < j) i++;
            while (numerosVarios[j] > pivote) j--;
            if (i < j) {
                aux = numerosVarios[i];
                numerosVarios[i] = numerosVarios[j];
                numerosVarios[j] = aux;
            }
        }


        numerosVarios[izq] = numerosVarios[j];
        numerosVarios[j] = pivote;

        if (izq < j - 1) {
            ordenarPorQuickShort(numerosVarios, izq, j - 1);
        }
        if (j + 1 < der) {
            ordenarPorQuickShort(numerosVarios, j + 1, der);
        }


        System.out.println(" \n Este es el vector ordenado con el algoritmo de quicksort" + Arrays.toString(numerosVarios));

    }



    private static void imprimirVector(int[] vector) {
        System.out.println(" \n Estos son los elementos del vector: " + Arrays.toString(vector));
    }

    private static void mayorElementoVector(int[] vector) {
        int numMayor = 0;
        for (int j : vector) {

            if (j > numMayor) {
                numMayor = j;
            }
        }
        System.out.println(" \n Este es el mayor de los elementos incluidos en el vector: " + numMayor);
    }

    private static void mínimoElementoVector(int[] vector) {
        int numMenor = 0;
        for (int j : vector) {

            if (j < numMenor) {
                numMenor = j;
            }
        }
        System.out.println(" \n Este es el menor de los elementos incluidos en el vector: " + numMenor);

    }

    private static void mediaElementoVector(int[] vector) {
        int media = 0;
        int resultado = 0;
        for (int j : vector) {

            media = j + media;
            resultado = media / vector.length;

        }
        System.out.println(" \n Esta es la media del vector " + resultado);
    }


    private static void ordenarBurbuja(int[] vector) {
        int numeroTemporal;
        int i, j;
        int longitud = vector.length;
        for (i = 1; i < longitud; i++) {
            for (j = longitud - 1; j >= i; j--) {
                if (vector[j] < vector[j - 1]) {
                    numeroTemporal = vector[j];
                    vector[j] = vector[j - 1];
                    vector[j - 1] = numeroTemporal;
                }
            }
        }

        System.out.println(" \n Este es el vector ordenado con el algoritmo de burbuja" + Arrays.toString(vector));
    }

    private static void ordenarPorSelección(int[] vector) {
        int numeroTemporal;
        int i, j;
        int longitud = vector.length;

        for (i = 0; i < longitud; i++) {
            int pos_min = i;
            for (j = i + 1; j < vector.length; j++) {
                if (vector[i] < vector[pos_min]) {
                    pos_min = j;

                }
            }
            numeroTemporal = vector[i];
            vector[i] = vector[pos_min];
            vector[pos_min] = numeroTemporal;

        }
        System.out.println(" \n Este es el vector ordenado mediante el método por selección" + Arrays.toString(vector));
    }


    private static void ordenarPorInserción(int[] vector) {
        int i;
        int longitud = vector.length;
        for (i = 0; i < longitud; i++) {
            int posiciónInicial = vector[i];
            int j = i - 1;
            while ((j >= 0) && (posiciónInicial < vector[j])) {

                vector[j + 1] = vector[j];
                j--;

            }

            vector[j + 1] = posiciónInicial;


        }
        System.out.println(" \n Este es el vector ordenado mediante el método por inserción" + Arrays.toString(vector));
    }

}


