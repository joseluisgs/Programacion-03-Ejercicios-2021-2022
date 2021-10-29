/*
Autor: Mohamed Asidah Bchiri (loopedmoha)
 */
package com.MAsidah;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int[] sumaVectores(int[] vector1, int[] vector2) {
        int[] resultado = new int[vector1.length];

        for (int i = 0; i < vector1.length; i++) {
            resultado[i] = vector1[i] + vector2[i];
        }
        return resultado;
    }

    static int[] restaVectores(int[] vector1, int[] vector2) {
        int[] resultado = new int[vector1.length];

        for (int i = 0; i < vector1.length; i++) {
            resultado[i] = vector1[i] - vector2[i];
        }
        return resultado;
    }

    static int[] multiplicacionEscalar(int[] vector, int escalar) {
        int[] resultado = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            resultado[i] = vector[i] * escalar;
        }
        return resultado;

    }
static void mostrarVector(int [] vector){
    for (int i = 0; i < vector.length; i++) {
        System.out.print("[ "+vector[i] + " ]");
    }
    System.out.println();
}
    public static void main(String[] args) {
        int tamano = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("Introduce la longitud de los vectores:");
        tamano = in.nextInt();


        int[] vector1 = new int[tamano];
        int[] vector2 = new int[tamano];
        int[] resultado = new int[tamano];
        int escalar = 0;

        System.out.println("Introduce los valores del vector 1: ");
        for (int i = 0; i < tamano; i++) {
            vector1[i] = in.nextInt();
        }

        System.out.println("Introduce los valores del vector 2: ");
        for (int i = 0; i < tamano; i++) {
            vector2[i] = in.nextInt();
        }

        System.out.println("La suma de los vectores es: ");
        resultado = sumaVectores(vector1, vector2);
        mostrarVector(resultado);
        System.out.println("La resta de los vectores es: ");
        resultado = restaVectores(vector1, vector2);
        mostrarVector(resultado);

        System.out.println("Introduce un escalar: ");
        escalar = in.nextInt();

        System.out.println("Vector 1 multiplicado por " +escalar+" es: ");
        resultado = multiplicacionEscalar(vector1, escalar);
        mostrarVector(resultado);

        System.out.println("Vector 2 multiplicado por " +escalar+" es: ");
        resultado = multiplicacionEscalar(vector2, escalar);
        mostrarVector(resultado);
    }
}
