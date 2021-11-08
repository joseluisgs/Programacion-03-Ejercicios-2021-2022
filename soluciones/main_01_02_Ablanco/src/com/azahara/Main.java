package com.azahara;
import java.util.Scanner;

public class Main {
/**
 * . Dada un vector, imprimirla obtener el máximo, el mínimo y la media. Buscar si un
 * elemento existe en dicha matriz. Mostrar el elemento que más se repite
 *
 * @author azahara Blanco rodrigues
 */

    public static void main(String[] args) {
        float []suma={0};

        // iniciar veztor
        float [] veztor={4,5,7,5,1,6,9} ;

        //imprimir veztor
        imprimirVeztor(veztor);

        //obtener el Maximo valor
        //maximoValorVeztor(veztor);

        //numero menor en el veztor
        //ninimoValorVeztor(veztor);

        //sumar todos los numeros de un veztor
        //sumarTodoElVeztor(veztor, suma);

        //media de un veztor pasando la suma y el veztor
        //mediaVeztor(veztor,suma);

        //comparamos numero
        //buscarNumeroEnVeztor(veztor);

        //buscar el numero que más se repite
        numeroMasRepetido(veztor);


    }

    /**
     * @author Azahara
     * @param veztor para imprimirlo necesita un Vector
     * @date 28-10-2021
     * @return no devuleve nada
     */
    public static void imprimirVeztor(float [] veztor){

        System.out.print("{ ");
        for (int i = 0 ; i< veztor.length ; i++){
            System.out.print( veztor[i]);
            System.out.print("  ");
        }
        System.out.print(" }");

    };

    /**
     * @return nada
     * @param veztor da el maximo valor que hay en un veztor
     */
    public static void maximoValorVeztor(float [] veztor){
        int numeroSelecionado=0;
        for (int i = 0; i < veztor.length; i++) {
            if ((veztor[numeroSelecionado])<(veztor[i])){
                numeroSelecionado=i;
            }
        }
        System.out.print("   El numero mayor de tu veztor " +
                "es el numero: "+veztor[numeroSelecionado]+"que está en la posición: "+numeroSelecionado);
    };

    /**
     * @return nada
     * @param veztor da el ninimo valor que hay en un veztor
     */
    public static void ninimoValorVeztor(float[] veztor){
        int numeroSelecionado=0;
        for (int i = 0; i > veztor.length; i++) {
            if ((veztor[numeroSelecionado])<(veztor[i])){
                numeroSelecionado=i;
            }
        }
        System.out.print("   El numero menor de tu veztor " +
                "es el numero: "+veztor[numeroSelecionado]+"que está en la" +
                " posición: "+numeroSelecionado);


    };

    /**
     * pasamos un veztor que quieras sumar
     * @return devuelve un número dentro de un veztor para que pase modificado
     */
    public static float sumarTodoElVeztor(float [] veztor , float  [] suma){

        for (int i = 0; i < veztor.length; i++) {
            System.out.print("la suma se inicializa en : "+suma[0]);

            suma[0]=suma[0]+veztor[i];
            System.out.print("por lo que se queda en  : "+suma[0]);

        }
        System.out.print("la suma total del veztor es : "+suma[0]);
        return suma[0];
    };

    /**
     * @Description con un veztor y la suma de sus numeros te hace la media
     * Needs vezrot y float
     */
    public static void mediaVeztor( float[]veztor, float [] suma){
        float media=0;
        System.out.print("la media de todos los numeros del veztor es : " + suma[0] + " / "+ veztor.length);
        media = suma[0]/veztor.length;
        System.out.print("la media de todos los numeros del veztor es : " + media);

    };

    /**
     * @description busca un numero pedido por teclado dentro de un veztor
     * y te da una solución de si lo ha encontrado
     * @param veztor
     * @return no devuelve nada
     */
    public static void buscarNumeroEnVeztor(float [] veztor){
        //pedimos el numero a buscar
        Scanner sc = new Scanner(System.in);
        float numeroBuscado=0;
        System.out.print("dime el numero que quieres buscar en tu veztor: ");
        numeroBuscado=sc.nextFloat();

        //buscamos ese numero
        boolean siEstaNumero = false;
        int i = 0;
        do {
            siEstaNumero=(numeroBuscado==veztor[i]);
            i++;

        }while ((i < veztor.length) && (siEstaNumero!=true) );

        System.out.print("el resultado es" + siEstaNumero);

    }

    /**
     * @descrip
     * @param veztor
     */
    public static void numeroMasRepetido(float[] veztor){

        //vemos cuantas veces se repite cada numero y lo guardamos en
        // un array con el mismo numero de casillas que el veztor origuinal.
        int numeroDeVecesQueSeRepite [];
        numeroDeVecesQueSeRepite= new int [veztor.length];

        for (int i = 0; i < veztor.length ; i++) {

            for (int j = 0; j <veztor.length; j++) {
                if ((veztor[i])==(veztor[j])){
                    numeroDeVecesQueSeRepite[i]=numeroDeVecesQueSeRepite[i]+1;
                }
            }
            System.out.print("este numero"+ veztor[i] + "se ha repetido "
                    + numeroDeVecesQueSeRepite[i]+"veces");
        }
        /**comparamos cuantas veces se ha repetido cada casilla del
        * veztor para analizar cual se ha reptido mas veces
        *para hacer eso ya tenemos funcion que es maximovalor
        */pero solo nos deja pasar con un float, asi que copiamos el array a un array float

        int numeroSelecionado=0;
        for (int i = 0; i < veztor.length; i++) {
            if ((numeroDeVecesQueSeRepite[numeroSelecionado])<(numeroDeVecesQueSeRepite[i])){
                numeroSelecionado=i;
            }
        }
        System.out.print("   El numero que más veces se repite es  " + veztor[numeroSelecionado]+"y se repite "+numeroDeVecesQueSeRepite[numeroSelecionado]);
    };








}
