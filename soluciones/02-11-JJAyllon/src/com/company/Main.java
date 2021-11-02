package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final char ATTACKED_SLOT = 'X';
	    char[][] board = new char[8][8];
        char piece;
        int[] position = new int[2];
        piece = askForPiece("Select a piece to place in the board: Queen [q] / King [k] / Knight [n] / Bishop [b] / Rook [r]", 'q','k','n','b','r');
        position[0] = tryNextInt(1,8,"Enter the column where you want to place the piece [1/8]")-1;
        position[1] = tryNextInt(1,8,"Enter the row where you want to place the piece [1/8]")-1;
        setPieceInBoard(board, piece, position);
        switch (piece) {
            case 'n' -> attackedSlotsKnght(board, position, ATTACKED_SLOT);
            case 'k' -> attackedSlotsKing(board, position, ATTACKED_SLOT);
            case 'r' -> attackedSlotsRook(board, position, ATTACKED_SLOT);
            case 'b' -> attackedSlotsBishop(board, position, ATTACKED_SLOT);
            case 'q' -> attackedSlotsQueen(board, position, ATTACKED_SLOT);//Could also be called as a rook+bishop movement
        }
        printBoard(board);
    }
    public static char askForPiece(String text, char... piece) {
        boolean isEqual;
        char answer= 0;
        Scanner sc = new Scanner (System.in);
        System.out.println(text);
        do {
            isEqual = false;
            answer = sc.next().charAt(0);
            for (int i = 0; (i < piece.length) && !isEqual; i++){
                if (answer == piece[i]){
                    isEqual = true;
                }
            }
        } while(!isEqual);
        return answer;
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
    public static void setPieceInBoard(char[][] board, char piece, int[] position){
        board[position[0]][position[1]] = piece;
    }
    public static void attackedSlotsKing(char[][] board, int[] position, char ATTACKED_SLOT){
        //Possible movements
        int[]x = {1,0,-1,1,0,-1,1,-1};
        int[]y = {1,1,1,-1,-1,-1,0,0};
        //Attack possible movements
        for (int i = 0; i<x.length; i++){
            boolean checkX = (position[0] + x[i])>0 &&(position[0] + x[i])<7;
            boolean checkY = (position[1] + y[i])>0 && (position[1] + y[i])<7;
            if(checkX && checkY){
                board[position[0] + x[i]][position[1] + y[i]] = ATTACKED_SLOT;
            }
        }
    }
    public static void attackedSlotsQueen(char[][] board, int[] position, char ATTACKED_SLOT){
        //Possible movements
        int xySum = position[0] + position[1];
        int xyDiff = position[0] - position[1];
        boolean checkX, checkY, chechSum, checkDiff;
        //Attack possible movements
        for (int j = 0; j< board[1].length; j++){
            for (int i = 0; i<board[0].length; i++){
                checkX = i == position[0];
                checkY = j == position[1];
                chechSum = (i + j) == xySum;
                checkDiff = (i - j) == xyDiff;
                if((checkX||checkY||chechSum||checkDiff)){
                    board[i][j] = ATTACKED_SLOT;
                }
            }
        }
        board[position[0]][position[1]] = 'q';
    }
    public static void attackedSlotsBishop(char[][] board, int[] position, char ATTACKED_SLOT){
        //Possible movements
        int xySum = position[0] + position[1];
        int xyDiff = position[0] - position[1];
        boolean chechSum, checkDiff;
        //Attack possible movements
        for (int j = 0; j< board[1].length; j++){
            for (int i = 0; i<board[0].length; i++){

                chechSum = (i + j) == xySum;
                checkDiff = (i - j) == xyDiff;
                if(chechSum||checkDiff){
                    board[i][j] = ATTACKED_SLOT;
                }
            }
        }
        board[position[0]][position[1]] = 'b';
    }
    public static void attackedSlotsRook(char[][] board, int[] position, char ATTACKED_SLOT){
        //Possible movements
        boolean checkX, checkY;
        //Attack possible movements
        for (int j = 0; j< board[1].length; j++){
            for (int i = 0; i<board[0].length; i++){
                checkX = i == position[0];
                checkY = j == position[1];
                if(checkX||checkY){
                    board[i][j] = ATTACKED_SLOT;
                }
            }
        }
        board[position[0]][position[1]] = 'r';
    }
    public static void attackedSlotsKnght(char[][] board, int[] position, char ATTACKED_SLOT){
        //Possible movements
        int[]x = {1,1,-1,-1,2,2,-2,-2};
        int[]y = {2,-2,-2,2,1,-1,1,-1};
        //Attack possible movements
        for (int i = 0; i<x.length; i++){
            boolean checkX = (position[0] + x[i])>0 &&(position[0] + x[i])<7;
            boolean checkY = (position[1] + y[i])>0 && (position[1] + y[i])<7;
            if(checkX && checkY){
                board[position[0] + x[i]][position[1] + y[i]] = ATTACKED_SLOT;
            }
        }
    }
    public static void printBoard(char[][] board){
        for (int j = 0; j< board[1].length; j++){
            for (int i = 0; i<board[0].length; i++){
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
    }
}
