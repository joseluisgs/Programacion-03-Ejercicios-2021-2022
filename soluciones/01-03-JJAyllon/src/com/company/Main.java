package com.company;

public class Main {

    public static void main(String[] args) {
        int[] v = {2,4,3};
        int[] u = {1,2,1};
        int scalar = 2;
        System.out.println("print sum");
        printArray1D(sum(u,v));
        System.out.println("print rest");
        printArray1D(rest(u,v));
        System.out.println("Product MxM = m");
        System.out.println(productShort(u,v));
        System.out.println("Product MxM = M2");
        printArray2D(productLong(u,v));
        System.out.println("Product kM");
        printArray1D(scalarProduct(v, scalar));

    }
    public static void printArray1D(int[]arrayToPrint){
        for (int i = 0; i< arrayToPrint.length; i++){
            System.out.print(arrayToPrint[i]+" ");
        }
        System.out.println();
    }
    public static void printArray2D(int[][]arrayToPrint){
        for (int i = 0; i< arrayToPrint[0].length; i++){
            for (int j = 0; j< arrayToPrint[1].length; j++) {
                System.out.print(arrayToPrint[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int[]sum(int[]u, int[]v){
        int[] sum = new int[u.length];
        if (u.length != v.length){
            System.out.println("is not possible to sum this two vectors");
            sum[0] = 0;
        } else {
            for (int i = 0; i<u.length;i++){
                sum[i] =u[i]+v[i];
            }
        }
        return sum;
    }
    public static int[]rest(int[]u, int[]v){
        int[] rest = new int[u.length];
        if (u.length != v.length){
            System.out.println("is not possible to rest this two vectors");
            rest[0] = 0;
        } else {
            for (int i = 0; i<u.length;i++){
                rest[i] =u[i]-v[i];
            }
        }
        return rest;
    }
    public static int productShort(int[] u, int[] v){
        int multiply =0;
        if (u.length != v.length){
            System.out.println("is not possible to multiply this two vectors");
            multiply = 0;
        } else {
            for (int i = 0; i<u.length;i++){
                multiply +=u[i]*v[i];
            }
        }
        return multiply;
    }
    public static int[][] productLong(int[] u, int[] v) {
        int multiply[][] = new int[u.length][v.length];
        for (int i = 0; i < u.length; i++) {
            for (int j = 0; j< v.length; j++){
                multiply[i][j] = v[j]*u[i];
            }
        }
        return multiply;
    }
    public static int[] scalarProduct(int[] vector, int number){
        int result[] = new int[vector.length];
        for (int i = 0; i< vector.length; i++){
            result[i]= vector[i]*number;
        }
        return result;
    }
}
