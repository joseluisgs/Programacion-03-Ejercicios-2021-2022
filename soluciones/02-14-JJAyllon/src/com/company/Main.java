package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Create the lake
        int lakeLength = tryNextIntRange("Insert the lake length [4/10]: ", 4, 10);
        int lakeWidth = tryNextIntRange("Insert the lake width [4/10]: ", 4, 10);
	    int[][] lake = new int[lakeLength][lakeWidth];
        System.out.println("This is your desired lake: ");
        printLakeRules(lake);
        //Create the rock to trow
        int rockPlace = tryNextIntRange("Insert the place where you want to throw your rock: [1/"+(lakeWidth*lakeLength)+"]", 1, (lakeWidth*lakeLength))-1;
        int rockThrow = tryNextIntRange("Insert the strength you want to throw the rock with: [2/6]", 2, 6);
        //Generate the splash
        //without radial
        System.out.println("No radial applied");
        setSplashNonRadial (lake, rockPlace, rockThrow);
        printLake(lake);
        //with radial
        System.out.println("Radial applied");
        lake = new int[lakeLength][lakeWidth];
        setSplashRadial(lake, rockPlace, rockThrow);
        printLake(lake);
    }
    public static void printLake(int[][] lake){
        System.out.println("Lake:");
        for (int j = 0; j< lake.length; j++){
            for (int i = 0; i<lake[j].length; i++){
                System.out.print(lake[j][i]+" ");
            }
            System.out.println();
        }
    }
    public static void setSplashNonRadial(int[][] lake, int place, int radio){
        int placeX = place%(lake[0].length);
        int placeY = place/(lake[0].length);
        System.out.println(placeX);
        System.out.println(placeY);
        System.out.println(lake[0].length);
        lake[placeY][placeX] = radio;
        for(int j = 0; j< lake.length; j++){
            for(int i = 0; i< lake[j].length; i++){
                int diffX = Math.abs(placeX-i);
                int diffY = Math.abs(placeY-j);
                int totalDiff = diffY + diffX;
                if(totalDiff>radio){
                    lake[j][i]= 0;
                } else {
                    lake[j][i]= radio - totalDiff;
                }
            }
        }
    }
    public static void setSplashRadial(int[][] lake, int place, int radio){
        int placeX = place%(lake[0].length);
        int placeY = place/(lake[0].length);
        lake[placeY][placeX] = radio;
        for(int j = 0; j< lake.length; j++){
            for(int i = 0; i< lake[j].length; i++){
                int diffX = Math.abs(placeX-i);
                int diffY = Math.abs(placeY-j);
                int totalDiff = (int)Math.round(Math.sqrt(Math.pow(diffY, 2) + Math.pow(diffX, 2)));
                if(totalDiff>radio){
                    lake[j][i]= 0;
                } else {
                    lake[j][i]= radio - totalDiff;
                }
            }
        }
    }
    public static void printLakeRules(int[][] lake){
        System.out.println("Board:");
        int count = 0;
        for (int j = 0; j< lake.length; j++){
            for (int i = 0; i<lake[j].length; i++){
                count++;
                if (count < 10) {
                    System.out.print("0"+count + " ");
                } else {
                    System.out.print(count + " ");
                }
            }
            System.out.println();
        }
    }
    public static int tryNextIntRange(String text, int start, int end) {
        //Function that provides a read next int with its try catch exception already resolved,
        //Start and end used to imitate the range of the number asked for.
        int var = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        do {
            try {
                var = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Not allowed answer");
                sc.nextLine();
            }
        } while (var < start || var > end);
        sc.nextLine();
        return var;
    }
}
