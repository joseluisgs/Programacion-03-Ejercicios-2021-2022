package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        final int FLY = 1;
        int slots = 0;
        slots = (tryNextInt(0, 10,"Set a number of slots to play [0,10]")+2);
        boolean isAlive = true;
        int hits = 0;
        int[] board = new int[slots];
        int smash = 0;
        setFly(board, FLY);
	    do{
            printBoard(slots);
            smash = tryNextInt(0, slots, "Type a number to smash");
            if (board[smash] == FLY){
                isAlive = false;
                System.out.println("You managed to hit the fly congrats");
                System.out.println("Number of false hits: "+hits);
            } else if((board[smash-1] == FLY) || (board[smash+1] == FLY)){
                System.out.println("You hit near the fly, she got scared and changed position");
                hits++;
                setFly(board, FLY);
            } else {
                System.out.println("Nothing moved");
                hits++;
            }
        } while (isAlive);
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
    public static void printBoard(int length){
        System.out.print("[");
        for (int i = 0; i < length -2; i++){
            System.out.print(i+" ");
        }
        System.out.print("]");
        System.out.println();
    }
    public static void setFly(int[] board, int FLY){
        int place = (int)((Math.random()* (board.length - 2)+1));
        for (int i = 1; i< (board.length-1); i++) {
            if (i != place){
                board[i] = 0;
            }
        }
        board[place] = FLY;
    }
}
