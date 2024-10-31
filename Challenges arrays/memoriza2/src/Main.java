import java.util.*;

public class Main {

    static final int MAX_FILAS = 4;
    static final int MAX_COLUMNAS = 4;
    static String[][] tableroTapado = new String[4][4];
    static Random aleatorio = new Random();
    static int[][] tableroBueno = new int[MAX_FILAS][MAX_COLUMNAS];
    static int posx, posy;
    static Scanner sc = new Scanner(System.in);

    private static void inicializarTablero(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                tableroBueno[i][j] = 0;
            }
        }
    }
    private static void generarParejas(){
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j <2 ; j++) {
                do {
                    posx = aleatorio.nextInt(4);
                    posy = aleatorio.nextInt(4);
                } while (tableroBueno[posx][posy] != 0);
                tableroBueno[posx][posy] = i;
            }
        }
    }
    private static void preguntarPosicion(){
        System.out.println("Introduce la posicion del usuario: ");
        int usuariox = sc.nextInt();
        int usuarioy= sc.nextInt();
        int usuario2x = sc.nextInt();
        int usuario2y = sc.nextInt();
        if (tableroBueno[usuariox][usuarioy] == tableroBueno[usuario2x][usuario2y]){
            tableroTapado[usuariox][usuarioy] = String.valueOf(tableroBueno[usuariox][usuarioy]);
            tableroTapado[usuario2x][usuario2y] = String.valueOf(tableroBueno[usuario2x][usuario2y]);
        }else {
            System.out.println("Error, las parejas no coinciden");
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
        generarParejas();
        printearTableroBueno();
        System.out.println();
        System.out.println("Tablero tapado: ");
        rellenarTableroTapado();
        printearTableroTapado();
        int intentos = 0;
        do {
            intentos++;
            preguntarPosicion();
            printearTableroTapado();
        }while (intentos < 10);
        System.out.println("El juego ha terminado");
        System.out.println("Tablero revelado: ");
        printearTableroBueno();
    }
}