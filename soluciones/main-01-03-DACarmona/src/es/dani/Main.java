package es.dani;

import java.util.Scanner;
/**
 * @author Daniel Carmona Rodriguez
 * @version 1.0
 */
public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int [] primerVector = new int[5];
        int [] segundoVector= new int[5];
        int [] hola= new int[5];
        int option =0;
        boolean continuar= false;
        int num=4;

        do {
            System.out.println("Introduce los valores del primer vector: ");
            introducirVectores(primerVector);
            imprimirVector(primerVector);

            System.out.println("Introduce los valores del segundo vector: ");
            introducirVectores(segundoVector);
            imprimirVector(segundoVector);

            System.out.println("Introduce los valores del tercer vector: ");
            introducirVectores(hola);
            imprimirVector(hola);


            do {
                System.out.println("¿Qué quieres hacer? Sumar(1), Restar(2), Producto escalar(3): ");
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        operacionesVectores(option, primerVector, segundoVector, num);
                        break;

                    case 2:
                        operacionesVectores(option, primerVector, segundoVector, num);
                        break;

                    case 3:
                        operacionesVectores(option, primerVector, segundoVector , num);
                        break;
                    default:
                        System.out.println("Se ha equivocado");
                        break;

                }
            } while (option > 3);

            continuar= continuamos();

        } while (continuar);
        System.out.println("Gracias por su tiempo. :)");

    }
    /**
     * Procedimiento que resuelve las operaciones que indiquemos
     * @param option sera el número que introduzcamos y nos de indicara el caso que queremos
     * @param a es el primer vector
     * @param b es el segundo vector
     */
    private static void operacionesVectores(int option, int[] a, int[] b, int num) {
        for (int i = 0; i < a.length ; i++) {
            int [] aux = a;
            if (option == 1) {
                aux[i] = a[i] + b[i];
            }
            if (option == 2) {
                aux[i] = a[i] - b[i];
            }
            if (option == 3) {
                aux[i] = a[i] * num;
            }
            if(i == (a.length - 1)){
                System.out.print("Este es el resultado: ");
                imprimirVector(aux);
            }
        }
    }

    /**
     * Procedimiento para imprimir un vector
     * @param a es el vector que queremos imprimir
     */
    private static void imprimirVector(int[] a) {
        System.out.print("[");
        for (int vector : a){
            System.out.print(vector + ",");
        }
        System.out.println("]");
    }
    /**
     * Procedimiento para agregar valores dentro del vector
     * @param a es el vector donde queremos almacenar los datos
     */
    private static void introducirVectores(int[] a) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < a.length; i++) {
            a[i]= sc.nextInt();
            System.out.println("Introduce los valores: ");
        }
    }
    /**
     * Funcion para comprobar si queremos continuar
     * @return devuelve true, si se quieres continuar, false si no.
     */
    private static boolean continuamos(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quiéres continuar? (s) / (n): ");
        char option = sc.next().charAt(0);
        boolean continuar=false;
        if (option == 's' || option == 'S'){
            continuar= true;
        }
        return continuar;
    }

}
