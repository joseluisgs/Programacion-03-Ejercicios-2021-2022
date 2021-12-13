package es.jeremyramos;

public class Main {

    public static void main(String[] args) {
	int [][] matriz1 = new int [3][3];
    int [][] matriz2 = new int [3][3];

    generarValoresMatriz(matriz1);

    imprimirMatriz(matriz1);

        System.out.println();
        invertirOrdenMatriz(matriz1, matriz2);
        System.out.println();
        imprimirMatriz(matriz2);

    }

    private static void invertirOrdenMatriz(int [][] matriz, int[][] matriz2){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {

                matriz2[i][j]= matriz[matriz.length-1-i][matriz[i].length-1-j];

            }
        }
    }


    private static void imprimirMatriz(int [][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("{");
            for (int j = 0; j < matriz[i].length; j++) {
                if(j != matriz[i].length-1){
                    System.out.print(matriz[i][j] + ",");
                }else {
                    System.out.print(matriz[i][j]);
                }
            }
            System.out.println("}");
        }



    }




    private static void generarValoresMatriz(int [][] matriz){

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                matriz[i][j]= (int) (Math.random()*10 +1);

            }

        }

    }


}
