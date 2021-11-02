package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final char MINE = '*';
        //Initialize the boards
        int boardLength = tryNextIntRange("Type the length you want the board to have [4/10]: ",4,10);
        int boardWidth = tryNextIntRange("Type the width you want the board to have [4/10]: ",4,10);
	    char[][] publicBoard = new char[boardWidth][boardLength];
        char[][] privateBoard = new char[boardWidth][boardLength];
        int mineNumber = tryNextIntRange("Type the amount of mines you want the board to have [1/"+(boardLength + boardWidth)+"]: ",1,(boardLength + boardWidth));
        setMines(privateBoard, MINE, mineNumber);
        printBoardRules(publicBoard);
        //Start game
        boolean keepPlaying = true;
        do{
            //Place to reveal
            int mineGuess = tryNextIntRange("Type the slot you want to discover: ",1,(boardLength * boardWidth))-1;
            int[] place = positionToComputer(mineGuess, publicBoard);
            boolean isEmpty = isEmpty(privateBoard, place, MINE);
            if (!isEmpty){
                // Lost Game
                keepPlaying = false;
                printBoard(privateBoard);
                System.out.println("You lost");
            } else {
                // Numbering
                checkForNearMines(publicBoard, privateBoard, place, MINE);
                printBoard(publicBoard);
            }
        } while ((mineNumber!=0)&&(keepPlaying));
    }
    public static int[] positionToComputer(int mineGuess, char[][] board){
        int[] place = new int[2];
        place[1] = mineGuess%(board[0].length);
        place[0] = mineGuess/(board[0].length);
        return place;
    }
    public static void checkForNearMines(char[][] publicBoard,char[][] privateBoard, int[] place, char MINE){
        int nearMines = 0;
        //Possible mines combination of x&y
        int[]x = {1,0,-1,1,0,-1,1,-1};
        int[]y = {1,1,1,-1,-1,-1,0,0};

        for (int i = 0; i<x.length; i++){
            int finalX = place[1] + x[i];
            int finalY = place[0] + y[i];
            boolean checkX = finalX>0 && finalX< publicBoard[0].length;
            boolean checkY = finalY>0 && finalY< publicBoard.length;

            if(checkX && checkY){
                if(privateBoard[finalY][finalX] == MINE){
                    nearMines++;
                }
            }
        }
        if (nearMines != 0) {
            publicBoard[place[0]][place[1]] = (char)(nearMines+'0');
        }else{
            publicBoard[place[0]][place[1]] = '0';
            for (int i = 0; i<x.length; i++){
                int[] newPlace = new int[2];
                newPlace[1] = place[1] + x[i];
                newPlace[0] = place[0] + y[i];
                boolean checkX = newPlace[1]>0 && newPlace[1]< publicBoard[0].length;
                boolean checkY = newPlace[0]>0 && newPlace[0]< publicBoard.length;

                if(checkX && checkY){
                    boolean checkNull = publicBoard[newPlace[0]][newPlace[1]] ==  (char)0;
                    if(checkNull) {
                        checkForNearMines(publicBoard, privateBoard, newPlace, MINE);
                    }
                }
            }
        }
    }
    public static void printBoard(char[][] board){
        System.out.println("Board:");
        for (int j = 0; j< board.length; j++){
            for (int i = 0; i<board[j].length; i++){
                System.out.print(board[j][i]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isEmpty(char[][] board, int[] place, char MINE){
        return !(board[place[0]][place[1]] == MINE);
    }
    public static void setMines(char[][] board, char MINE, int mineNum){
        for (int i = 0; i<mineNum; i++) {
            int baordLength = board.length;
            int baordWidth = board[0].length;
            boolean isEmpty;
            int placeX, placeY, randomNum;
            do {
                randomNum = (int)(Math.random()*baordLength*baordWidth);
                placeX = randomNum%(board[0].length);
                placeY = randomNum/(board[0].length);
                isEmpty = board[placeY][placeX] == 0;
            } while (!isEmpty);
            board[placeY][placeX] = MINE;
        }
        for (int i = 0; i< board.length; i++){
            for (int j = 0; j<board[i].length; j++){
                if (board[i][j] != MINE){
                    board[i][j] = '·';
                }
            }
        }
    }
    public static void printBoardRules(char[][] board){
        System.out.println("Board:");
        int count = 0;
        for (int j = 0; j< board.length; j++){
            for (int i = 0; i<board[j].length; i++){
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
