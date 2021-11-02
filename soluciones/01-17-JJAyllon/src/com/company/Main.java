package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean keepPlaying = true;
        int numberShips = 4;
        int[] playerPublicBoard = new int[20];
        int[] computerPublicBoard = new int[20];
        int[] playerPrivateBoard = new int[20];
        int[] computerPrivateBoard = new int[20];
        int[] boardStatus = new int[2];
        setComputerPrivateBoard(computerPrivateBoard, numberShips);
        printRules();
        setPlayerPrivateBoard(playerPrivateBoard, numberShips);
        System.out.println("Your board is: ");
        printBoard(playerPrivateBoard);
        printBoard(computerPublicBoard);
        do{
            //player attacks
            int attack;
            do {
                attack = tryNextInt(0, 19, "Select an unattacked slot to attack");
            } while (computerPublicBoard[attack] != 0);
            playerAttack(computerPrivateBoard, computerPublicBoard, attack);
            printBoard(computerPublicBoard);
            //computer attacks
            computerAttack(playerPrivateBoard, playerPublicBoard);
            printBoard(playerPublicBoard);
            //read boards
            boardStatus = boardStatus(playerPublicBoard, computerPublicBoard);
            System.out.println("Ships taken down:" );
            System.out.println("player: "+ boardStatus[0]);
            System.out.println("computer: "+ boardStatus[1]);
            if (boardStatus[0] == 4 || boardStatus[1] == 4){
                keepPlaying = false;
            }
        } while(keepPlaying);
        //end game
        if(boardStatus[1]< boardStatus[0]){
            System.out.println("Player wins the game");
        } else if(boardStatus[1]> boardStatus[0]){
            System.out.println("Computer wins the game");
        } else {
            System.out.println("Game draw");
        }
        System.out.println("Player boards");
        printBoard(playerPrivateBoard);
        printBoard(playerPublicBoard);
        System.out.println("Computer boards");
        printBoard(computerPrivateBoard);
        printBoard(computerPublicBoard);
    }
    public static void playerAttack(int[]privateBoard, int[]publicBoard, int slot){
        if (privateBoard[slot] == 1){
            System.out.println("Succeed, your attack landed on an enemy ship");
            publicBoard[slot] = 1;
        } else {
            System.out.println("Miss, your attack landed on water");
            publicBoard[slot] = 8;
        }
    }
    public static void computerAttack(int[]privateBoard, int[]publicBoard){
        int aux;
        ArrayList slots = new ArrayList();
        for (int i = 0; i< publicBoard.length;i++){
            if(publicBoard[i] == 0){
                slots.add(i);
            }
        }
        aux = (int)(Math.random()* slots.size());
        aux = (int)slots.get(aux);
        if(privateBoard[aux] == 1){
            System.out.println("The computer succeeded with its attack");
            publicBoard[aux] = 1;
        } else {
            System.out.println("The computer missed its attack");
            publicBoard[aux] = 8;
        }
    }
    public static void printRules(){
        System.out.println("The board looks like this: ");
        System.out.print("[");
        for (int i = 0; i < 20; i++){
            System.out.print(i+" ");
        }
        System.out.println("]");
        System.out.println("Hitting an enemy shit will show up like a 1, missing a shot will show up like a 8");
        System.out.println("Now you can set your board according to the numbers");
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
    public static void printBoard(int[]board){
        System.out.print("[");
        for (int i = 0; i< board.length; i++){
            System.out.print(board[i]+" ");
        }
        System.out.print("]");
        System.out.println();
    }
    public static void setComputerPrivateBoard(int[]board, int ships){
        ArrayList slots = new ArrayList();
        int aux;
        for (int i = 0; i< board.length; i++){
            slots.add(i);
            board[i] = 0;
        }
        for (int i = 0; i<ships ;i++){
            aux = (int)(Math.random()* slots.size());
            board[(int)slots.get(aux)] = 1;
            slots.remove(aux);
        }
    }
    public static void setPlayerPrivateBoard(int[]board, int ships){
        Scanner sc = new Scanner(System.in);
        int answer;
        boolean isFree = true;
        for (int i = 0; i<ships;i++) {
            isFree = false;
            System.out.println("introduce the desired ship "+ (i+1) + " position: ");
            do {
                answer = sc.nextInt();
                sc.nextLine();
                if (board[answer] == 0) {
                    board[answer] = 1;
                    isFree = true;
                } else {
                    System.out.println("That position is already takes choose another one");
                }
            } while(!isFree);
        }
    }
    public static int[] boardStatus(int[]playerBoard,int[]computerBoard){
        //count[0] for player, count[1] for computer
        int[]count = {0,0};
        for (int i = 0; i < playerBoard.length; i++){
            if (computerBoard[i] == 1){
                count[0]++;
            }
            if (playerBoard[i] == 1){
                count[1]++;
            }
        }
        return count;
    }
}
