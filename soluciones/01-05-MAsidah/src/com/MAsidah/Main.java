package com.MAsidah;

import java.util.Scanner;

public class Main {

    static void mostrarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print("[" + vector[i] + "]");
        }
        System.out.println();
    }

    /**
     * Dado un vector, lo invierte y devuelve por referencia
     *
     * @param vector
     */
    static int[] invertirVector(int[] vector) {
        int[] invertido = new int[vector.length];
        for (int i = 0, j = vector.length -1; i < vector.length && j >= 0; i++, j--) {
            invertido[i] = vector[j];
        }
        return invertido;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = 0;
        System.out.println("Introduce el tamaño del vector: ");
        size = in.nextInt();
        int[] vector = new int[size];
        System.out.println("Introduce los valores del vector:");
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ":");
            vector[i] = in.nextInt();
        }

        System.out.println("El vector es:");
        mostrarVector(vector);
        vector = invertirVector(vector);
        System.out.println("El vector invertido es:");
        mostrarVector(vector);
    }
}
