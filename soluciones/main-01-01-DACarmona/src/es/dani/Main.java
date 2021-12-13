package es.dani;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int [] vector= new int[getLimit()];
        boolean continuar=  true;
        getVector(vector);
        int option;
        do {
            option = getOption();
            switch (option){
                case 1:
                    imprimirVector(vector);
                    break;
                case 2:
                    giveNumberMax(vector);
                    break;
                case 3:
                    giveNumberMin(vector);
                    break;
                case 4:
                    giveNumberMedia(vector);
                    break;
                case 5:
                    ordenarBurbuja(vector);
                    System.out.println("El vector ordenado por burbuja es: " + Arrays.toString(vector)) ;
                    break;
                case 6:
                    ordenarSeleccion(vector);
                    System.out.println("El vector ordenado por selección es: " + Arrays.toString(vector)) ;
                    break;
                case 7:
                    ordenarInsercion(vector);
                    System.out.println("El vector ordenado por insercción es: " + Arrays.toString(vector)) ;
                    break;
                case 8:
                    ordenarQuicksort(vector, 0, vector.length-1);
                    System.out.println("El vector ordenado por quicksort es: " + Arrays.toString(vector)) ;
                    break;
                case 9:
                    int num = getNum();
                    num=busquedadLineal(vector, num);
                    if (num!=-1){
                        System.out.println("El número se encuentre en la posición: " + (num + 1));
                    } else System.out.println("No se ha encontrado.");
                    break;

                case 10:
                    num = getNum();
                    num=busquedadBinaria(vector, num,0, vector.length);
                    if (num!=-1){
                        System.out.println("El número se encuentre en la posición: " + (num+1));
                    } else System.out.println("No se ha encontrado.");
                    break;
                case 11:
                    continuar= false;
                    break;
            }

        }while (option <=10 && continuar);

        System.out.println("Gracias por su colaboración.");

    }
    /**
     * Funcion para indicar que numero quieres buscar
     * @return devuelve el numero que quiere buscar
     */
    private static int getNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué numero quieres buscar?: ");
        return sc.nextInt();
    }
    /**
     * Funcion de busquedad binaria en un vector
     * @param vectorA vector donde queremos buscar
     * @param num numero que queremos buscar
     * @param izq primera posicion numero del vector
     * @param der ultima posicion del vector
     * @return devuelve la posicion donde se encuentra
     */
    private static int busquedadBinaria(int[]vectorA, int num, int izq, int der){
        int pos= -1;
        int centro= (izq+der)/2;
        if (izq>der){
            return -1;
        } else if(num==vectorA[centro]){
            pos= centro;
        } else if (num <vectorA[centro]){
            return busquedadBinaria(vectorA,num,izq,centro-1);
        } else{
            return busquedadBinaria(vectorA,num, centro+1, der);
        }
        return pos;
    }
    /**
     * Funcion de busquedad lineal de un numero en un vector
     * @param vectorA vector donde queremos buscar
     * @param num numero que queremos buscar
     * @return devuelve la posicion donde se encuentra el numero
     */
    private static int busquedadLineal(int[] vectorA, int num){
        boolean encontrado= false;
        int i;
        int pos= -1;
        for (i = 0; i < vectorA.length && !encontrado ; i++) {
            if(num== vectorA[i]) {
                encontrado = true;
                pos=i;
            }
        }
        return pos;
    }
    /**
     * Procedimiento para ordenar por seleccion un vector
     * @param vectorA vector que queremos ordenar
     * @param izq el numero que se encuentra a la izquierda
     * @param der el numero que se encuentra a la derecha
     */
    private static void ordenarQuicksort(int [] vectorA, int izq, int der){
        int pivote= vectorA[izq];
        int i= izq;
        int j= der;
        int aux;
        while (i<j){
            while (vectorA[i]<= pivote && i<j) i++;
            while (vectorA[j]>pivote) j--;
            if (i<j){
                aux= vectorA[i];
                vectorA[i]= vectorA[j];
                vectorA[j]= aux;
            }
        }
        vectorA[izq]= vectorA[j];
        vectorA[j]= pivote;
        if (izq < j-1) ordenarQuicksort(vectorA,izq,j-1);
        if (j+1< der) ordenarQuicksort(vectorA, j+1, der);

    }
    /**
     * Procedimiento para ordenar por inserción un vector
     * @param vectorA vector que queremos ordenar
     */
    private static void ordenarInsercion(int[] vectorA){
        int limit= vectorA.length;
        for (int i = 1; i < limit; i++) {
            int pos= vectorA[i];
            int j= i-1;
            while ((j>=0) && (pos<vectorA[j])){
                vectorA[j+1]=vectorA[j];
                j--;
            }
            vectorA[j+1]=pos;
        }
    }
    /**
     * Procedimiento para ordenar por seleccion un vector
     * @param vectorA vector que queremos ordenar
     */
    private static void ordenarSeleccion(int[] vectorA){
        int limit= vectorA.length;
        for (int i = 0; i < limit-1 ; i++) {
            int posMin= i;
            for (int j = i+ 1; j < limit ; j++) {
                if (vectorA[j]< vectorA[posMin]){
                    posMin=j;
                }
            }
            int numberAux= vectorA[i];
            vectorA[i]= vectorA[posMin];
            vectorA[posMin]= numberAux;

        }
    }
    /**
     * Procedimiento burbuja para ordenar un vector
     * @param vectorA vector que queremos ordenar
     */
    private static void ordenarBurbuja(int [] vectorA){
        int limit= vectorA.length;
        for (int i = 1; i < limit; i++) {
            for (int j = limit - 1; j >= i ; j--) {
                if (vectorA[j] < vectorA[j -1]){
                    int aux = vectorA[j];
                    vectorA[j]= vectorA[j - 1];
                    vectorA[j - 1]= aux;
                }
            }
        }
    }

    /**
     * Procedimiento para descubrir la media del conjunto de datos
     * @param vectorA es donde queremos comprobar los datos almacenados en él
     */
    private static void giveNumberMedia(int[] vectorA){
        int limit= vectorA.length;
        int sumaNumber = 0;
        for (int i = 0; i < limit ; i++) {
            sumaNumber = sumaNumber + vectorA[i];
        }
        int mediaNumber = sumaNumber / limit;
        System.out.println("La media es: " + mediaNumber);
    }
    /**
     * Procedimiento para descubrir cual es el numero minimo
     * @param vectorA es donde queremos comprobar los datos almacenados en él
     */
    private static void giveNumberMin(int [] vectorA){
        int numberMin = vectorA[0];
        int limit= vectorA.length;
        for (int i= 0; i < limit ; i++) {
            if(numberMin > vectorA[i]){
                numberMin = vectorA[i];
            }
        }
        System.out.println("El número minimo es: " + numberMin);
    }
    /**
     * Procedimiento para descubrir cual es el numero máximo
     * @param vectorA es donde queremos comprobar los datos almacenados en él
     */
    private static void giveNumberMax(int [] vectorA){
        int limit= vectorA.length;
        int numberMax = vectorA[0];
        for (int i = 0; i < limit ; i++) {
            if (numberMax < vectorA[i]){
                numberMax = vectorA[i];
            }
        }
        System.out.println("El número máximo es: " + numberMax);
    }
    /**
     * Funcion que se utiliza como menu y permite seleccionar una de las opciones
     * @return devuelve la opcion elegida por el usuario
     */
    private static int getOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué quieres hacer?");
        System.out.println("(1) Imprimir el vector  \n" +
                "(2) Máximo del vector \n" +
                "(3) Minimo del vector \n" +
                "(4) Media del vector \n" +
                "(5) Ordenación por burbuja \n" +
                "(6) Ordenación por selección \n" +
                "(7) Ordenación por insercción \n" +
                "(8) Ordenación por quicksort \n" +
                "(9) Búsquedad lineal \n" +
                "(10) Búsquedad binaria \n" +
                "(11) Salir \n");

        int option = sc.nextInt();
        return option;
    }
    /**
     * Funcion que permite crear el tamaño del vector.
     * @return devuelve el tamaño establecido del vector
     */
    private static int getLimit(){
        Scanner sc = new Scanner(System.in);
        int limit;
        do{
            System.out.println("Introduce el tamaño del vector:");
            limit = sc.nextInt();

        }while (limit < 0);

        return limit;
    }
    /**
     * Procedimiento que genera numeros aleatoreos en cada sector del vector
     * @param vectorA el vector donde queremos almacenar los numeros
     */
    private static void getVector(int [] vectorA){
        int limit= vectorA.length;
        for (int i = 0; i < limit; i++) {
            vectorA[i] = (int)(Math.random() * 101 );
        }
    }

    /** Procedimiento que imprime un vector
     * @param vectorA el vector que queremos imprimir
     */
    private static void imprimirVector(int [] vectorA){
        System.out.print("El vector es: ");
        System.out.println(Arrays.toString(vectorA));
    }
}
