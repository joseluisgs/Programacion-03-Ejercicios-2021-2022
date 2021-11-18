package com.company;
import java.util.Scanner;

/*
 * Nombre: Rocío Palao Fernández
 * GitHub: Rochiio
 * Fecha: 17/11/2021
 * Descripción: Juego de las siete y media pasado a java
 */

public class Main {

    public static void main(String[] args) {

        //Variables
        int money= 100;
        int bet;
        double result;
        String tryAgain;

        //Scanner
        Scanner sc = new Scanner(System.in);

        //INICIO

        //Presentación
        System.out.println("Juego de las siete y media");

        do {
            //Total del dinero
            System.out.println("Tiene un total de dinero: "+money);

            //Apuesta
            System.out.println("Cuánto dinero quieres apostar en esta partida: ");
            bet = sc.nextInt();

            //Proceso coger cartas
            result = canPlayingCard();

            //Funcion winner or loser
            money = isWinner(result, money, bet);

            System.out.println("Tu dinero restante es: " + money);

            //Seguir jugando
            tryAgain = canTryAgain(money);

        }while((tryAgain.equals("si")||tryAgain.equals("Si")) && money > 0 );
    }

    //Funciones

    /**
     * Funcion que devuelve el resultado de las cartas
     * @returns el resultado
     */

        public static double canPlayingCard() {
            //Scanner
            Scanner sc = new Scanner(System.in);

            //Variables de la funcion
            String playingCard;
            int numberCardFila;
            int numberCardColumna;
            double resultCard = 0;

            //Matriz de la baraja de cartas
            int [][] baraja= new int[4][10];


            //Inicio
        do{
            System.out.println("Quieres carta (si/no): ");
            playingCard = sc.nextLine();
            System.out.println();


            //Carta aleatoria

            if(playingCard.equals("si")||playingCard.equals("Si")){
                numberCardColumna = (int) Math.floor(Math.random()*10);
                numberCardFila= (int) Math.floor(Math.random()*4);

            //Los números --> 8, 9 y 10 cuentan como medio punto y el resto como un punto.
            //Vamos dando la vuelta a las cartas ya levantadas hacemos un if para no volver a levantar las que ya están levantadas.

            if (baraja[numberCardFila][numberCardColumna]==1){
                numberCardColumna = (int) Math.round(Math.random()*10);
                numberCardFila= (int) Math.floor(Math.random()*4);

            }else {
                    //Valor de las cartas
                    switch (numberCardColumna) {
                        case 7:

                        case 8:

                        case 9:
                            resultCard = resultCard + 0.5;
                            break;

                        default:
                            resultCard = resultCard + 1;
                            break;
                    }
                }

                baraja[numberCardFila][numberCardColumna]=1;
                canPrint(baraja);
                System.out.println();

            }

            System.out.println("Llevas un total de: " + resultCard);
        }while(playingCard.equals("si")||playingCard.equals("Si"));
        return resultCard;
    }


    private static void canPrint(int[][] baraja) {
            System.out.println();
            for (int i=0; i< baraja.length; i++){
                System.out.print("{ ");
                for (int j=0; j< baraja[i].length; j++){
                    System.out.print(baraja[i][j] + " ");
                }
                System.out.println(" }");
            }
    }


    /**
     * Funcion que devuelve el dinero dependiendo de si ha ganado o perdido la apuesta.
     * @param resultCard Nos dice si ha ganado el juego o no.
     * @param moneyUser Nos dice el dinero que tiene.
     * @param betUser Nos dice la apuesta.
     * @returns El dinero que hay por haber ganado o perdido.
     */

    public static int isWinner(double resultCard, int moneyUser, int betUser) {
        //Inicio
        if(resultCard<=7.5){
            System.out.println("Has ganado");
            moneyUser = moneyUser + betUser;
        }else {
            System.out.println("Has perdido");
            moneyUser = moneyUser - betUser;
        }
        return moneyUser;
    }


    /**
     * Funcion que devuelve si sigue jugando el jugador
     * @param moneyUser Nos dice el dinero del usuario
     * @returns si puede seguir jugando
     */
    public static String canTryAgain(int moneyUser){
        //Scanner
        Scanner sc = new Scanner(System.in);

        String tryAgainUser;
        System.out.println("Quiere volver a jugar (si/no): ");
        tryAgainUser = sc.nextLine();
        if ((tryAgainUser.equals("si")||tryAgainUser.equals("Si")) && (moneyUser == 0)){
            System.out.println("No puedes volver a jugar ya que tu saldo es 0 :(");
        }
        return tryAgainUser;
    }




}
