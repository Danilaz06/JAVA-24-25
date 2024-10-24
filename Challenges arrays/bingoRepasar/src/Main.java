import java.util.Random;
import java.util.Scanner;

public class Main {
    static String[][] matriz = new String[3][9];
    static String[] ganadores = new String[15];
    static int Num_ganadores = 15;
    static final int MAX_FILAS = 3;
    static final int MAX_COLUMNAS = 9 ;
    static String valorAl;
    static Random aleatorio = new Random();
    static Scanner lector = new Scanner(System.in);

    private static void inicializarMatriz(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                do{
                    valorAl = String.valueOf(aleatorio.nextInt(9)+(j*10));
                } while (existeRepetido(j,valorAl));
                matriz[i][j] = valorAl;
            }
        }
    }

    private static boolean existeRepetido(int j,String valorAl){
        for (int i = 0; i < MAX_FILAS; i++) {
            if (matriz[i][j]!=null && matriz[i][j].equals(valorAl)) {
                return true;
            }
        }
        return false;
    }

    private static void mostrarMatriz(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void ordenarColumnas() {
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            for (int k = 0; k < MAX_FILAS - 1; k++) {
                for (int i = 0; i < MAX_FILAS - 1; i++) {
                    int valorActual = Integer.parseInt(matriz[i][j]);
                    int valorSiguiente = Integer.parseInt(matriz[i + 1][j]);

                    if (valorActual > valorSiguiente) {
                        String aux = matriz[i][j];
                        matriz[i][j] = matriz[i + 1][j];
                        matriz[i + 1][j] = aux;
                    }
                }
            }
        }
    }

    public static void generarGanadores(){
        for (int i = 0; i < Num_ganadores ; i++) {
            do {
                valorAl = String.valueOf(aleatorio.nextInt(90)); // Ahora el rango es de 0 a 89
            } while (comprobarRepetidosGanadores(valorAl));
            ganadores[i] = valorAl;
        }
    }

    public static boolean comprobarRepetidosGanadores(String valorAl){
        for (int i = 0; i < Num_ganadores; i++) {
            if (ganadores[i] != null && ganadores[i].equals(valorAl)) {
                return true;
            }
        }
        return false;
    }

    public static void tacharGanadores(){
        for (int g = 0; g < Num_ganadores; g++) {
            for (int i = 0; i < MAX_FILAS; i++) {
                for (int j = 0; j < MAX_COLUMNAS; j++) {
                    if (ganadores[g].equals(matriz[i][j])) {
                        matriz[i][j] = "XX";
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        inicializarMatriz();
        System.out.println("Matriz inicial:");
        mostrarMatriz();
        ordenarColumnas();
        System.out.println("\nMatriz ordenada:");
        mostrarMatriz();
        generarGanadores();
        System.out.println("\nGanadores generados:");
        for (String ganador : ganadores) {
            System.out.print(ganador + " ");
        }
        System.out.println();
        tacharGanadores();
        System.out.println("\nMatriz después de tachar ganadores:");
        mostrarMatriz();
    }
}