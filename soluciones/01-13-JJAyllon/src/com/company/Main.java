package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[]sequence = new int[10];
        int initialNum = 0;
        initialNum = tryNextInt("write a number here: ");
        sumSequence(sequence, initialNum);
        printArray1D(sequence);
    }
    public static void printArray1D(int[]arrayToPrint){
        for (int i = 0; i< arrayToPrint.length; i++){
            System.out.print(arrayToPrint[i]+" ");
        }
        System.out.println();
    }
    public static void sumSequence(int[]sequence, int initialNumber){
        sequence[0] = initialNumber;
        for (int i = 1; i<sequence.length; i++){
            sequence[i] = sequence[i-1] + i;
        }
    }
    public static int tryNextInt(String text){
        //Function that provides a read next int with its try catch exception already resolved,
        Integer var = null;
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        do {
            try {
                var = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Not allowed answer");
                sc.nextLine();
            }
        }while (var == null);
        sc.nextLine();
        return var;
    }
}
