package com.company;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int lakeWide = 0;
        int intensityRock = 0;
        int distanceRock = 0;
        lakeWide = tryNextInt(3, 20, "Insert the lake wide: [3/20]");
        intensityRock = tryNextInt(2, 10, "Insert the intensity of the rock: [1/10]:");
        distanceRock = tryNextInt(0, lakeWide, "Insert the distance of the travelling rock [0/"+(lakeWide-1)+"]:");
        int[] lake = new int[lakeWide];
        splash(lake, intensityRock, distanceRock);
        printLake(lake);
        do{
            calmLake(lake);
            printLake(lake);
            TimeUnit.SECONDS.sleep(2);
        } while (!isStable(lake));
    }
    public static void printLake(int[] lake){
        System.out.print("[");
        for (int i = 0; i< lake.length; i++){
            System.out.print(lake[i]+" ");
        }
        System.out.print("]");
        System.out.println();
    }
    public static void splash(int[] lake, int intensity, int distance){
        for (int i= 0; i < (lake.length - distance); i++){
            if (intensity - i >= 0) {
                lake[distance + i] = intensity - i;
            }
        }
        for (int i= 0; i <= distance; i++){
            if(intensity - i >= 0) {
                lake[distance - i] = intensity - i;
            }
        }
    }
    public static void calmLake(int[]lake) {
        for (int i = 0; i < lake.length; i++){
            if (lake[i] > 0) {
                lake[i] -= 1;
            }
        }
    }
    public static boolean isStable(int[]lake){
        //True if calm
        boolean calm = true;
        for (int i = 0; i< lake.length; i++){
            if (lake[i] != 0){
                calm = false;
                break;
            }
        }
        return calm;
    }
    public static int tryNextInt(int start, int end, String text){
        //Function that provides a read next int with its try catch exception already resolved,
        //Start and end used to imitate the range of the number asked for.
        int var = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        do {
            try {
                var = sc.nextInt();
            } catch(Exception e){
                System.out.println("Not allowed answer");
                sc.nextLine();
            }
        } while (var < start || var > end);
        sc.nextLine();
        return var;
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
