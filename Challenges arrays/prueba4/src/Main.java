import java.util.Random;

public class Main {
   static int[][] matriz = new int[3][9];
   static Random random = new Random();
   static final int MAX_FILAS=3;
   static final int MAX_COLUMNAS=9;

   public static void rellenarMatriz(){
       for (int col = 0; col < matriz[0].length; col++) {
           int min = 10 + (col * 10); // valor mínimo para la columna actual
           int max = min + 9;     	// valor máximo para la columna actual

           for (int row = 0; row < matriz.length; row++) {
               matriz[row][col] = random.nextInt(max - min + 1) + min;
           }
       }
   }
   public static void imprimirMatriz(){
       for (int row = 0; row < matriz.length; row++) {
           for (int col = 0; col < matriz[0].length; col++) {
               System.out.print(matriz[row][col] + "\t");
           }
           System.out.println();
       }
   }
    public static void ordenarPorColumnas() {
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            for (int i = 0; i < MAX_FILAS - 1; i++) {
                for (int k = 0; k < MAX_FILAS - 1 - i; k++) {
                    if (matriz[k][j] > matriz[k + 1][j]) {
                        int aux = matriz[k][j];
                        matriz[k][j] = matriz[k + 1][j];
                        matriz[k + 1][j] = aux;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        rellenarMatriz();
        ordenarPorColumnas();
        imprimirMatriz();


    }
}
