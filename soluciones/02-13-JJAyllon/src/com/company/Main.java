package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    //Create the table and the pairs
        int pairs = tryNextIntCases("Introduce the number of pairs you want to play with: [8/18/32]" ,8, 18, 32);
        int slots = (int)Math.sqrt(pairs*2);
        int[][] board = new int[slots][slots];
        int[][] publicBoard = new int [slots][slots];
        setSecretBoard(board, pairs);
        System.out.println("Pairs already set in the board");
        int pairsLeft = pairs;
        int flips = 0;
        boolean paired;
        do{
            printBoardRules(slots);
            //Ask for cards to flip
            int card1 = tryNextIntRange("Select the first card to flip: ",1,(slots*slots))-1;
            int card2;
            do{
                card2 = tryNextIntRange("Select the second card to flip: ",1,(slots*slots))-1;
            } while (card1 == card2);
            flips++;
            //Show flipped cards
            printFlip(card1, card2, board, publicBoard);
            //Check if equal
            paired = flipStats(card1, card2, board, publicBoard);
            //Set pairs and pairs left
            if (paired) {
                updateBoard(card1, card2, board, publicBoard);
                pairsLeft--;
            }
            System.out.println("Pairs left: "+ pairsLeft);
        } while (pairsLeft != 0);
        System.out.println("You managed to find all the pairs, you won the game.");
        System.out.println("Number of flips: "+ flips);
    }
    public static void printFlip(int card1, int card2, int[][] board, int[][] publicBoard){
        int card1X = card1%(board[0].length);
        int card1Y = card1/(board[0].length);
        int card2X = card2%(board[0].length);
        int card2Y = card2/(board[0].length);
        System.out.println("Board:");
        for (int i = 0; i< publicBoard.length; i++){
            for (int j = 0; j<publicBoard[i].length; j++){
                if (i == card1X && j == card1Y){
                    System.out.print(board[i][j]+ " ");
                } else if (i == card2X && j == card2Y){
                    System.out.print(board[i][j]+" ");
                } else {
                    System.out.print(publicBoard[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static boolean flipStats(int card1, int card2, int[][] board, int[][] publicBoard){
        int card1X = card1%(board[0].length);
        int card1Y = card1/(board[0].length);
        int card2X = card2%(board[0].length);
        int card2Y = card2/(board[0].length);
        boolean checkCards = board[card1X][card1Y] == board[card2X][card2Y];
        return checkCards;
    }
    public static void updateBoard(int card1, int card2, int[][] board, int[][] publicBoard){
        int card1X = card1%(board[0].length);
        int card1Y = card1/(board[0].length);
        int card2X = card2%(board[0].length);
        int card2Y = card2/(board[0].length);
        publicBoard[card1X][card1Y] = board[card1X][card1Y];
        publicBoard[card2X][card2Y] = board[card2X][card2Y];
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
    public static void setSecretBoard (int[][] board, int pairs){
        ArrayList pool = new ArrayList();
        int randomIndex;
        int randomNum;
        for (int i = 1; i <= pairs; i++){
            pool.add(i);
            pool.add(i);
        }
        for (int i = 0; i< board.length; i++){
            for (int j = 0; j<board[i].length; j++){
                randomIndex = (int) (Math.random() * (pool.size() - 1));
                randomNum = (int) pool.get(randomIndex);
                board[i][j] = randomNum;
                pool.remove(randomIndex);
            }
        }
    }
    public static int tryNextIntCases(String text, int... cases){
        //Function that provides a read next int with its try catch exception already resolved,
        //Start and end used to imitate the range of the number asked for.
        int var = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        boolean isEqual = false;
        do {
            try {
                var = sc.nextInt();
            } catch(Exception e){
                System.out.println("Not allowed answer");
                sc.nextLine();
                isEqual = true;
            }
            for (int aCase : cases) {
                if (var == aCase) {
                    isEqual = true;
                    break;
                }
            }
        } while (!isEqual);
        sc.nextLine();
        return var;
    }
    public static int tryNextIntRange(String text, int start, int end){
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
        } while (var<start || var>end);
        sc.nextLine();
        return var;
    }
}
