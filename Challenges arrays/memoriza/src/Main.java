import java.util.*;

public class Main {

    static final int MAX_FILAS = 4;
    static final int MAX_COLUMNAS = 4;
    static String[][] tableroTapado = new String[4][4];
    static Random aleatorio = new Random();
    static int aleatorio16 = aleatorio.nextInt(16);
    static ArrayList<Integer> numeros = new ArrayList<>();
    static int[][] tableroBueno = new int[MAX_FILAS][MAX_COLUMNAS];

    private static void inicializarTablero(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tableroBueno[i][j] = 0;
            }
        }
    }
    private static void generarParejas(ArrayList<Integer> numeros){
        for (int i = 1; i < 9; i++) {
            numeros.add(i);
            numeros.add(i);
        }
        Collections.shuffle(numeros , new Random());
        int t=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tableroBueno[i][j] = numeros.get(t);
                t++;
            }
        }
    }
    private static void printearTableroBueno(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j <MAX_COLUMNAS ; j++) {
                System.out.print(tableroBueno[i][j]+ " ");
            }
            System.out.println();
        }
    }
    private static void rellenarTableroTapado(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <4 ; j++) {
                tableroTapado[i][j] = "X";
            }
        }
    }
    private static void printearTableroTapado(){
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tableroTapado[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
       inicializarTablero();
       System.out.println("Tablero revelado: ");
       generarParejas(numeros);
       printearTableroBueno();
        System.out.println();
        System.out.println("Tablero tapado: ");
       rellenarTableroTapado();
       printearTableroTapado();

    }
}