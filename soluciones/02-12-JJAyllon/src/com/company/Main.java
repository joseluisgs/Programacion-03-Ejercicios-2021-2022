package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int FLY = 1;
        int swipes=0;
        //initialize board
        int slots = tryNextInt(4, 10,"Set the board size MxM to play with m=[4,10]");
        int[][] board = new int[slots][slots];
        //initialize flies
        int fliesAlive = tryNextInt(1, slots*2,"Set the amount of flies to play with [1,"+ slots*2 +"]");
        //set flies in board
        setFly(board, FLY, 0, fliesAlive);
        //Start of the game
        do{
            int smash;
            printBoardRules(slots);
            smash = (tryNextInt(1,(slots*slots),"Select the place you want to smash")-1);
            boolean smashed = smashInFly(smash, board, FLY);
            int nearFlies = smashNearFly(smash, board, FLY);
            setFly(board, FLY, (fliesAlive-nearFlies), fliesAlive);
            if(smashed){
                System.out.println("Congrats you hit a fly");
                fliesAlive--;
            }
            if(nearFlies != 0){
                System.out.println(nearFlies+ " Flies moved from your smash");
            }
            if((nearFlies == 0)&& !smashed){
                System.out.println("Nothing happened");
            }
            swipes++;
            System.out.println("Flies alive: "+fliesAlive);
        } while(fliesAlive > 0);
        System.out.println("Game ended, you managed to kill all the flies");
        System.out.println("Number of swipes needed: "+swipes);
    }
    public static void printBoard(int[][] board){
        for (int i = 0; i< board.length; i++){
            for (int j = 0; j<board[i].length; j++){
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }
    public static boolean smashInFly(int place, int[][] board, int FLY){
        boolean smashed;
        int placeX = place%(board[0].length);
        int placeY = place/(board[0].length);
        smashed = board[placeX][placeY] == FLY;
        return smashed;
    }
    public static int smashNearFly(int place, int[][] board, int FLY){
        int fliesToMove = 0;
        int slots = board[0].length;
        int placeY = place%(board[0].length);
        int placeX = place/(board[0].length);
        //Possible slots near
        int[]x = {1,0,-1,1,0,-1,1,-1};
        int[]y = {1,1,1,-1,-1,-1,0,0};
        //Read flies near the attacked slot
        for (int i = 0; i<x.length; i++){
            boolean checkX = (placeX + x[i])>0 &&(placeX + x[i])<slots;
            boolean checkY = (placeY + y[i])>0 && (placeY + y[i])<slots;
            if(checkX && checkY){
                if(board[placeX + x[i]][placeY + y[i]] == FLY){
                    fliesToMove++;
                    board[placeX + x[i]][placeY + y[i]] = 0;
                }
            }
        }
        return fliesToMove;
    }
    public static void printBoardRules(int slots){
        System.out.println("Board:");
        int count = 0;
        for (int i = 0; i< slots; i++){
            for (int j = 0; j<slots; j++){
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
    public static int tryNextInt(int start, int end, String text){
        //Function that provides a read next int with its try catch exception already resolved,
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
    public static void setFly(int[][] board, int FLY, int startNumber, int endNumber){
        for (int i = startNumber; i<endNumber; i++) {
            int randomNum = 0;
            int placeX = 0;
            int placeY = 0;
            boolean isEmpty;
            do {
                randomNum = (int) ((Math.random() * ((board[0].length)*(board[1].length))));
                placeX = randomNum%(board[0].length);
                placeY = randomNum/(board[0].length);
                isEmpty = board[placeX][placeY] == 0;
            } while (!isEmpty);
            board[placeX][placeY] = FLY;
        }
    }
}
