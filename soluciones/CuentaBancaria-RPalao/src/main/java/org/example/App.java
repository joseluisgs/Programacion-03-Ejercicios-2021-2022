package org.example;

import java.util.Scanner;

/**
 * @author Rocio Palao
 * @version v1.0 04/12/2021
 * Comprobar está bien el D.C de la cuenta bancaria.
 */

public class App {

    public static void main( String[] args ) {

        Scanner sc = new Scanner (System.in);

        String account;
        boolean length;
        boolean number;
        int digit1;
        int digit2;

            do {

                System.out.println("Dime tu número bancario");
                account= sc.nextLine();

                length = isLenght(account);
                number=isNumber(account);

            }while(!length || !number);

            digit1 =firstControlCorrect(account);
            digit2 =secondControlCorrect(account);

            System.out.println("La cuenta es: " +account);
            System.out.println("El primer dígito de control es: " + digit1);
            System.out.println("El segundo dígito de control es:" + digit2);
            isCorrect(account, digit1, digit2);




    }

    /**
     *
     * @param account la cuenta bancaria.
     * @param digit1 el primer dígito que hemos calculado.
     * @param digit2 el segundo dígito que hemos calculado.
     * Para ver si los números de control de la cuenta son los correctos con los calculados por el programa.
     */
    public static void isCorrect(String account, int digit1, int digit2){
        if (digit1 ==(Character.getNumericValue(account.charAt(8))) && digit2 ==(Character.getNumericValue(account.charAt(9)))){
            System.out.println("Los dígitos de control son correctos");
        }
        else {
            System.err.println("Los dígitos de control no son correctos");
        }
    }


    /**
     *
     * @param account la cuenta bancaria.
     * @return verdadero o falso dependiendo de si tiene la longitud especificada o no.
     */
    public static boolean isLenght(String account) {
        return account.length()== 20;
    }


    /**
     *
     * @param account la cuenta bancaria.
     * @return verdadero o falso dependiendo de si son numeros.
     */
    public static boolean isNumber(String account) {
        for (int i = 0; i < account.length(); i++) {
            if (Character.isDigit(account.charAt(i))) {
                return true;
            }
        }
        return false;
    }


    /**
     *
     * @param account la cuenta bancaria.
     * @return el primer digito calculado con su switch ya hecho.
     */
    public static int firstControlCorrect(String account) {
        int banc1 = Character.getNumericValue(account.charAt(0));
        int banc2 = Character.getNumericValue(account.charAt(1));
        int banc3 = Character.getNumericValue(account.charAt(2));
        int banc4 = Character.getNumericValue(account.charAt(3));
        int entity1 = Character.getNumericValue(account.charAt(4));
        int entity2= Character.getNumericValue(account.charAt(5));
        int entity3 = Character.getNumericValue(account.charAt(6));
        int entity4 = Character.getNumericValue(account.charAt(7));

        int digit = getFirstDigit(banc1, banc2, banc3, banc4, entity1, entity2, entity3, entity4);

        return isSwitch(digit);
    }


    /**
     *
     * @param banc1 numeros necesarios para calcular el primer digito de control.
     * @param banc2 numeros necesarios para calcular el primer digito de control.
     * @param banc3 numeros necesarios para calcular el primer digito de control.
     * @param banc4 numeros necesarios para calcular el primer digito de control.
     * @param entity1 numeros necesarios para calcular el primer digito de control.
     * @param entity2 numeros necesarios para calcular el primer digito de control.
     * @param entity3 numeros necesarios para calcular el primer digito de control.
     * @param entity4 numeros necesarios para calcular el primer digito de control.
     * @return el digito calculado.
     */
    public static int getFirstDigit(int banc1, int banc2, int banc3, int banc4,
                                    int entity1, int entity2, int entity3, int entity4) {
        int digit;

        digit =((banc1 *4)+(banc2 *8)+(banc3 *5)+(banc4 *10)+(entity1 *9)+(entity2 *7)+(entity3 *3)+(entity4 *6));
        digit = digit %11;
        digit = 11- digit;

        return digit;
    }


    /**
     *
     * @param account cuenta bancaria.
     * @return el segundo digito calculado con su switch ya hecho.
     */
    public static int secondControlCorrect(String account) {
        int account1 = Character.getNumericValue(account.charAt(10));
        int account2 = Character.getNumericValue(account.charAt(11));
        int account3 = Character.getNumericValue(account.charAt(12));
        int account4 = Character.getNumericValue(account.charAt(13));
        int account5 = Character.getNumericValue(account.charAt(14));
        int account6 = Character.getNumericValue(account.charAt(15));
        int account7 = Character.getNumericValue(account.charAt(16));
        int account8 = Character.getNumericValue(account.charAt(17));
        int account9 = Character.getNumericValue(account.charAt(18));
        int account10 = Character.getNumericValue(account.charAt(19));

        int digit = getSecondDigit(account1, account2, account3, account4, account5, account6, account7, account8, account9, account10);

        return isSwitch(digit);
    }


    /**
     *
     * @param account1 numeros necesarios para calcular el segundo digito de control.
     * @param account2 numeros necesarios para calcular el segundo digito de control.
     * @param account3 numeros necesarios para calcular el segundo digito de control.
     * @param account4 numeros necesarios para calcular el segundo digito de control.
     * @param account5 numeros necesarios para calcular el segundo digito de control.
     * @param account6 numeros necesarios para calcular el segundo digito de control.
     * @param account7 numeros necesarios para calcular el segundo digito de control.
     * @param account8 numeros necesarios para calcular el segundo digito de control.
     * @param account9 numeros necesarios para calcular el segundo digito de control.
     * @param account10 numeros necesarios para calcular el segundo digito de control.
     * @return el digito calculado.
     */
    public static int getSecondDigit(int account1, int account2, int account3, int account4, int account5, int account6, int account7, int account8, int account9, int account10) {
        int digit;

        digit =(account1 +(account2 *2)+(account3 *4)+(account4 *8)+(account5 *5)+(account6 *10)
                +(account7 *9)+(account8 *7)+(account9 *3)+(account10 *6));

        digit = digit %11;
        digit = 11- digit;
        return digit;
    }


    /**
     *
     * @param digit digito para calcular lo que pasa si es 10 o 11.
     * @return el digito con el cambio hecho.
     */
    public static int isSwitch(int digit) {
        switch (digit) {
            case 10:
                digit =1;
                break;

            case 11:
                digit =0;
                break;
        }
        return digit;
    }
}
