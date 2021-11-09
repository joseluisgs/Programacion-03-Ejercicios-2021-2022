package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] vector = {2, -5, 1, 20, 12};
        printVector(vector);
        maxVector(vector);
        minVector(vector);
        mediaVector(vector);

        burbujaVector(vector);
        printVector(vector);
        vector = new int[]{2, -5, 1, 20, 12};

        seleccionVector(vector);
        printVector(vector);
        vector = new int[]{2, -5, 1, 20, 12};

        insercionVector(vector);
        busquedaSecuencial(vector);
        printVector(vector);
        vector = new int[]{2, -5, 1, 20, 12};

        insercionVector(vector);
        busquedaBinaria(vector, 0, vector.length - 1, 0);
        printVector(vector);
        vector = new int[]{2,-5,1,20,12};
    }

    private static void printVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

    private static void maxVector(int[] vector) {
        int maxNumber = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > maxNumber) {
                maxNumber = vector[i];
            }

        }
        System.out.println("El valor Máximo es: " + maxNumber);
    }

    private static void minVector(int[] vector) {
        int minNumber = vector[0];
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < minNumber) {
                minNumber = vector[i];
            }
        }
        System.out.println("El Valor Mínimo es: " + minNumber);
    }

    private static void mediaVector(int[] vector) {
        int sumaVector = 0;
        int media = 0;
        for (int i = 0; i < vector.length; i++) {
            sumaVector = sumaVector + vector[i];
            media = sumaVector / vector.length;
        }
        System.out.println("La Media da: " + media);
    }

    private static void burbujaVector(int[] vector) {
        int tmp;
        for (int i = 0; i < vector.length; i++) {
            for (int j = vector.length - 1; j > i; j--) {
                if (vector[j] < vector[j - 1]) {
                    tmp = vector[j];
                    vector[j] = vector[j - 1];
                    vector[j - 1] = tmp;
                }
            }
        }
    }

    private static void seleccionVector(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            int tmp = vector[i];
            int minPosition = i;
            for (int j = i; j < vector.length; j++) {
                if (vector[j] < tmp) {
                    tmp = vector[j];
                    minPosition = j;
                }
            }
            vector[minPosition] = vector[i];
            vector[i] = tmp;
        }
    }

    private static void insercionVector(int[] vector) {
        int aux = 0;
        int j = 0;
        for (int i = 1; i < vector.length; i++) {
            aux = vector[i];
            j = i - 1;
            while ((j >= 0) && (aux < vector[j])) {
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = aux;
        }
    }

    private static int busquedaSecuencial(int[] vector) {
        int position = -1;
        int dato = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un número del vector:");
        dato = sc.nextInt();
        for (int i = 0; i < vector.length && (position == -1); i++) {

            if (vector[i] == dato)
                position = i;
        }
        System.out.println("El Número: " + dato + " Está en la posición: " + position);
        return position;
    }

    private static int busquedaBinaria(int[] vector, int buscado, int izq, int der) {
        int dato;
        int centro = (izq + der) / 2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero del vector:");
        dato = sc.nextInt();
        if (izq > der)
            return -1;
        else if (buscado == vector[centro]) {
            System.out.println("El número está: " + buscado);
            return centro;
        } else {
            System.out.println("El número está: " + buscado);
            if (buscado < vector[centro]) {
                return busquedaBinaria(vector, izq, centro - 1, buscado);
            } else {
                System.out.println("El número está: " + buscado);
                return busquedaBinaria(vector, centro + 1, der, buscado);
            }
        }
    }
}
