package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pairs = 0;
        System.out.println("Set the number of pairs you'll have to match: ");
        pairs = sc.nextInt();
	    int[] secretBoard = new int[pairs*2];
        int[] publicBoard = new int[secretBoard.length];
        setSecretBoard(secretBoard, pairs);
        int card1 = 0;
        int card2 = 0;
        int pairsLeft = pairs;
        int flipNum = 0;
        printRules(pairs);
        printInitialState(pairs);
        do {
            flipNum ++;
            card1 = tryNextInt(0, pairs*2, "Select the first card to flip");
            do {
                card2 = tryNextInt(0, pairs * 2, "Select the second card to flip");
            } while (card2 == card1);
            printRules(pairs);
            flip(secretBoard, publicBoard, card1, card2);
            if (areEqual(secretBoard, card1, card2)){
                setPublicBoard(publicBoard,secretBoard,card1,card2);
            }
            pairsLeft = boardStatus(publicBoard);
            System.out.println("Pairs left: "+ pairsLeft);
        } while (pairsLeft != 0);
        System.out.println("You won, number of flips: "+ flipNum);
    }
    public static void setSecretBoard (int[] board, int pairs){
        ArrayList pool = new ArrayList();
        int randomIndex;
        int randomNum;
        for (int i = 1; i <= pairs; i++){
            pool.add(i);
            pool.add(i);
        }
        for (int i = 0; i< board.length; i++){
            randomIndex = (int)(Math.random()* (pool.size()-1));
            randomNum = (int)pool.get(randomIndex);
            board[i] = randomNum;
            pool.remove(randomIndex);
        }
    }
    public static void printInitialState(int pairs){
        System.out.print("[");
        for (int i = 0; i<(pairs*2); i++){
            System.out.print("0 ");
        }
        System.out.print("]");
        System.out.println();
    }
    public static void printRules(int pairs){
        System.out.print("[");
        for (int i = 0; i<(pairs*2); i++){
            System.out.print(i+" ");
        }
        System.out.print("]");
        System.out.println("Now this is the board:");
    }
    public static void setPublicBoard(int[] publicBoard, int[] secretBoard, int num1, int num2){
        publicBoard[num1] = secretBoard[num1];
        publicBoard[num2] = secretBoard[num2];
    }
    public static void flip(int[] secretBoard, int[]publicBoard, int num1, int num2){
        System.out.print("[");
        for (int i = 0; i < publicBoard.length; i++) {
            if ((i == num1) || i == num2) {
                System.out.print(secretBoard[i] + " ");
            } else {
                System.out.print(publicBoard[i] + " ");
            }
        }
        System.out.print("]");
        System.out.println();
    }
    public static boolean areEqual(int[] secretBoard, int num1, int num2){
        boolean areEqual = (secretBoard[num1] == secretBoard[num2]);
        return areEqual;
    }
    public static int boardStatus(int[] board){
        int pairsLeft = 0;
            for (int i= 0; i< board.length; i++){
                if (board[i] == 0){
                    pairsLeft++;
                }
            }
            pairsLeft /= 2 ;
        return pairsLeft;
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
}
