package es.drodriguez.com;

/**
 * @author Daniel Rodríguez Fernández
 * @date 09/11/2021
 * @description En este ejercicio realizamos el cálculo del valor maximo, mínimo, medio y más repetido de una matriz
 */
public class Main {

    public static void main(String[] args) {
        int[][] matriz =
                {
                        {3, 3, 4},
                        {5, 6, 7},
                        {8, 9, 19}
                };
        valorMaximo(matriz);
        valorMinimo(matriz);
        valorMedia(matriz);
        valorMasRepetido(matriz);
    }

    /**
     * @param matriz  que vamos a utilizar para realizar las operaciones.
     */

    private static int valorMaximo(int[][] matriz) {
        int maximo = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maximo) {
                    maximo = matriz[i][j];
                }
            }
        }
        System.out.println("El valor maximo es: " + maximo);
        return maximo;
    }

    private static void valorMinimo(int[][] matriz) {
        int minimo = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < minimo) {
                    minimo = matriz[i][j];
                }
            }
        }
        System.out.println("El valor minimo es: " + minimo);
    }
    private static void valorMedia(int[][] matriz){
        float media=0;
        //tenemos que recorrer primero el primer nivel (i -> vector de vectores)
        for (int i = 0; i < matriz.length; i++){
            //aqui el valor máximo de j es el del vector situado en matriz[i]
            for (int j = 0; j < matriz[i].length; j++){
                //aquí no igualamos porque sobreescribiríamos el valor, sino que acumulamos
                media += matriz[i][j];
            }
        }
        //solo dividimos al final cuando ya hemos recorrido toda la matriz
        //y dividimos por el numero total de elementos
        //para una matriz N*M, el numero de elementos es N*M
        media /= (matriz.length * matriz[0].length);
       System.out.println("La media de la matriz es: " +media);
    }


    private static void valorMasRepetido(int[][] matriz) {
        int[] repetidos = new int[valorMaximo(matriz)+1];
        //recorremos el vector
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                repetidos[matriz[i][j]]++;
            }
        }

        int maximo = repetidos[0];
        int masRepetido = 0;
        for (int i = 0; i < repetidos.length; i++) {
            if (repetidos[i] > maximo) {
                maximo = repetidos[i];
                masRepetido = i;
            }
            System.out.println("El valor más repetido es: " +masRepetido);
        }
    }
}