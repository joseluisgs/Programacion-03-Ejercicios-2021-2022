package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        int num = 0;
        int highestNum = 0;
        String stack = "";
        boolean keepGoing = true;
        String awnser;
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        while(keepGoing){
            System.out.println("Introduce un número: ");
            num = sc.nextInt();
            stack = stack + ", " + num;
            if (num > highestNum){
                highestNum = num;
            }
            System.out.println("Si queires salir escribe y: ");
            awnser = sc2.nextLine().trim().toLowerCase();
            keepGoing = !awnser.equals("y");
        }
        System.out.println("Tus numeros eran"+ stack);
        System.out.println("El más alto es: "+ highestNum);
    }
}
