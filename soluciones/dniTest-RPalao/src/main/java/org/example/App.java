package org.example;


import java.util.Scanner;

public class App {

    public static void main( String[] args ) {

        //Var & helps
        Scanner sc= new Scanner(System.in);
        String dni;
        String letter;

        System.out.println("Dime tu dni para averiguar cuál es tu letra: ");

        dni=nextDni(sc);

        letter = hasLetter(dni);

            System.out.println("La letra de tu DNI es: " +letter);

            String concad= dni.concat(letter);
            
            System.out.println("Tu DNI completo es: " +concad);


    }

    private static String nextDni(Scanner sc) {
        String dni;
        boolean correctLength;
        boolean allAreNumbers;
        do {

            dni = sc.nextLine();
            correctLength = dniLongitud(dni);
            allAreNumbers = isANumber(dni);

            if (!correctLength ||!allAreNumbers)
                System.out.println("El DNI es incorrecto, vuelva a intentarlo :( ");

        }while(!correctLength ||!allAreNumbers);

        return dni;
    }

    public static boolean dniLongitud(String dni) {
        return dni.length()==8;
    }

    public static boolean isANumber(String dni) {
        for (int i = 0; i < dni.length() ; i++) {
            if (!Character.isDigit(dni.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String hasLetter(String dni) {
        String letters="TRWAGMYFPDXBNJZSQVHLCKE";
        return String.valueOf(letters.charAt(Integer.parseInt(dni) % letters.length()));
    }
}
