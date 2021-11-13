package com.company;

import java.util.Scanner;

/**
 * @author Rocío Palao Fernández
 * @date 10/11/2021
 * github: Rochiio
 * Realiza un programa que dada una palabra nos diga si es palíndromo u no.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String palabra;

        //Pedir palabra
        System.out.println("Dime la palabra (no pongas espacios): ");
        palabra=sc.nextLine();

        //Añadirla a un array
        int numeroChart=palabra.length();
        char[] palabraVector= new char[numeroChart];

        //Añadirle los valores
        palabraVector=addVector(palabraVector, palabra);

        //Averiguar si es palíndroma
        boolean palindromo;
        palindromo=esPalindromo(palabraVector);

        if (palindromo) {
            System.out.println("La palabra es palíndroma");
        } else {
            System.out.println("La palabra no es palíndroma");
        }
    }

    public static char[] addVector(char []palabraVector, String palabra){
        for (int i=0; i< palabraVector.length; i++){
            palabraVector[i]=palabra.charAt(i);
        }
        return palabraVector;
    }


    public static boolean esPalindromo(char[] palabraVector){
        boolean palindromo=false;
        int finalVect = palabraVector.length-1;
        for (int i=0 ; i< finalVect ;i++){
            if (palabraVector[i]==palabraVector[finalVect-i]){
                palindromo=true;
            }else{
                palindromo=false;
            }
        }
        return palindromo;
    }
}