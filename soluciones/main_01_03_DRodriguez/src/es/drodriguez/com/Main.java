package es.drodriguez.com;

import java.util.Arrays;

public class Main {
    /**
     * @author Daniel Rodríguez Fernández
     * @date 12-11-2021
     * @use main_01_03 (Suma, resta y producto escalar de vectores).
     */
    public static void main(String[] args) {
        int[] A = new int[]{4,3,2};
        int[] B = new int[]{4,1,6};
        sumaVectores(A, B);
        restaVectores(A, B);
        prodEscalarVectores(A, B);
    }

    /**
     *
     * @param A vector para realizar operaciones de nuestro programa
     * @param B otro vector para realizar operaciones de nuestro programa
     */
    public static void sumaVectores(int[] A, int[] B) {
        //imaginamos que las longitudes de los vectores son iguales
        if (A.length == B.length) {
            int longitud = A.length;
            int sumaAB[] = new int[longitud];
            for (int i = 0; i < longitud; i++) {
                sumaAB[i] = A[i] + B[i];
            }
            System.out.println("El resultado de la suma del vector es:  " + Arrays.toString(sumaAB));
        } else System.out.println("No se puede realizar la operación, la longitud de los vectores es diferente");
    }

    public static void prodEscalarVectores(int[] A, int[] B) {
        //imaginamos que las longitudes de los vectores son iguales
        if (A.length == B.length) {
            int longitud = A.length;
            double productoEscalar = 0;
            for (int i = 0; i < longitud; i++) {
                productoEscalar += A[i]*B[i];
            }
            System.out.println("El producto escalar es:  " + productoEscalar + "\n");
        } else System.out.println("No se puede realizar la operación, la longitud de los vectores es diferente");
    }

    public static void restaVectores(int[] A, int[] B) {
        if (A.length == B.length) {
            int longitud = A.length;
            int restaAB[] = new int[longitud];
            for (int i = 0; i < longitud; i++) {
                restaAB[i] = A[i] - B[i];
            }
            System.out.println("El resultado de la resta del vector es:  " + Arrays.toString(restaAB));
        } else System.out.println("No se puede realizar la operación, la longitud de los vectores es diferente");
    }
}