package utils;

public class utils {
    public static void getMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                matriz[i][j]= (int)(Math.random() * 10+1);
            }
        }
    }
    public static void imprimirMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length ; i++) {
            System.out.print("{");
            for (int j = 0; j < matriz[i].length ; j++) {
                if (j!= matriz[i].length-1) System.out.print(matriz[i][j] + ",");
                else System.out.print(matriz[i][j]);
            }
            System.out.println("}");
        }
    }
}
