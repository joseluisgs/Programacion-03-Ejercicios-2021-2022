package es.drodriguez.com;

public class Main {

    public static void main(String[] args) {
        int [][] matriz =
                {
                        {2,4,4},
                        {6,6,9},
                        {8,10,12}
                };
        int [][] matriz2 =
                {
                        {1,2,4},
                        {4,5,7},
                        {9,10,11}
                };

       sumaMatriz(matriz, matriz2);
       restaMatriz(matriz, matriz2);
       multiplicacionMatriz(matriz, matriz2);
       determinanteMatriz(matriz2);
    }

    /**
     *
     * @param matriz primera matriz para operar.
     * @param matriz2 segunda matriz para operar.
     */
    private static void sumaMatriz(int [][]matriz, int [][]matriz2) {
        if (matriz.length == matriz2.length) {
            int longitud = matriz.length;
            int[][] sumaAB = new int[longitud][longitud];
            for (int i = 0; i < longitud; i++) {
                for (int j = 0; j < longitud; j++) {
                    sumaAB[i][j] = matriz[i][j] + matriz2[i][j];
                    System.out.println("La suma de " +matriz[i][j]+ "con la suma de " + matriz2[i][j] + "es: " + sumaAB[i][j]);
                }
            }
        }
    }
    private static void restaMatriz(int [][]matriz, int [][]matriz2) {
        if (matriz.length == matriz2.length) {
            int longitud = matriz.length;
            int[][] restaAB = new int[longitud][longitud];
            for (int i = 0; i < longitud; i++) {
                for (int j = 0; j < longitud; j++) {
                    restaAB[i][j] = matriz[i][j] - matriz2[i][j];
                    System.out.println("La resta de " +matriz[i][j]+ "con la resta de " + matriz2[i][j] + "es: " + restaAB[i][j]);
                }
            }
        }
    }
    private static void multiplicacionMatriz(int [][]matriz, int [][]matriz2) {
        if (matriz.length == matriz2.length) {
            int longitud = matriz.length;
            int[][] multiplicacionAB = new int[longitud][longitud];
            for (int i = 0; i < longitud; i++) {
                for (int j = 0; j < longitud; j++) {
                    multiplicacionAB[i][j] = matriz[i][j] * matriz2[i][j];
                    System.out.println("La multiplicacion de " +matriz[i][j]+ "con la multiplicacion de " + matriz2[i][j] + "es: " + multiplicacionAB[i][j]);
                }
            }
        }
    }

    private static void determinanteMatriz(int[][] matriz) {
        int determinante = 0;

        if (matriz.length == matriz[0].length) {
            if (matriz.length > 3 || matriz[0].length > 3) {
                determinante = -1;
                System.out.println("No se ha podido calcular el determinante. La matriz debe ser 1X1, 2x2 o 3x3");
            } else {
                //podemos calcular
                if (matriz.length == 1) {
                    determinante = matriz[0][0];
                } else if (matriz.length == 2) {
                    determinante = matriz[0][0]*matriz[1][1] - matriz[1][0]*matriz[0][1];
                } else {
                    //es de 3x3
                    determinante = (matriz[0][2]*matriz[1][1]*matriz[2][0] + matriz[1][2]*matriz[0][0]*matriz[2][1] + matriz[0][1]*matriz[2][2]*matriz[1][0]) - (matriz[0][0]*matriz[1][1]*matriz[2][2] + matriz[1][0]*matriz[2][1]*matriz[0][2] + matriz[2][0]*matriz[0][1]*matriz[1][2]);
                    System.out.println("El determinante es: " + determinante);
                }
            }
        } else {
            determinante = -1;
            System.out.println("No se ha podido calcular el determinante porque la matriz no es cuadrada");
        }
    }
}