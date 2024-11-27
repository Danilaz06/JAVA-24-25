import java.util.Random;

public class Main {
    static final int MAX_FILAS = 3;
    static final int MAX_COLUMNAS = 9;
    static String[][] matriz = new String[MAX_FILAS][MAX_COLUMNAS];
    static Random random = new Random();
    static int numAle;
    public static void inicializarTablero() {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                matriz[i][j] = "XX";
            }
        }
    }

    public static void rellenarNumAle() {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                numAle = random.nextInt(9); // Números entre 0 y 8
                if (matriz[i][j] != numAle)
                matriz[i][j] = String.valueOf(numAle + (10 * j)); // Ajuste por columnas
            }
        }
    }

    public static void printearMatriz() {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void ordenarTablero() {
        // Ordenar cada columna individualmente
        for (int columna = 0; columna < MAX_COLUMNAS; columna++) {
            for (int i = 0; i < MAX_FILAS - 1; i++) {
                for (int j = 0; j < MAX_FILAS - i - 1; j++) {
                    if (Integer.parseInt(matriz[j][columna]) > Integer.parseInt(matriz[j + 1][columna])) {
                        // Intercambiar valores
                        String aux = matriz[j][columna];
                        matriz[j][columna] = matriz[j + 1][columna];
                        matriz[j + 1][columna] = aux;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Matriz inicial:");
        inicializarTablero();
        rellenarNumAle();
        printearMatriz();

        System.out.println("\nMatriz ordenada por columnas:");
        ordenarTablero();
        printearMatriz();
    }
}
