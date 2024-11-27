import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int MAX_FILAS = 4;
    static final int MAX_COLUMNAS = 4;
    static String [][] tablero = new String[MAX_FILAS][MAX_COLUMNAS];
    static String [][] tableroL = new String[MAX_FILAS][MAX_COLUMNAS];
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static int filaAl;
    static int columnaAl;
    static int intentos = 0;
    static int fila;
    static int columna;
    static int fila2;
    static int columna2;

    public static void inicializarTableros(String[][]Tablero){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j <MAX_COLUMNAS ; j++) {
                Tablero[i][j] = "X";
                }
            }
    }

    public static void rellenarTablero(){
        for (int k = 1; k <9 ; k++) {
            for (int l = 0; l <2 ; l++) {
                do {
                    filaAl = random.nextInt(4);
                    columnaAl = random.nextInt(4);
                }while(tablero[filaAl][columnaAl]!="X");
                tablero[filaAl][columnaAl]= String.valueOf(k);
            }
        }
    }
    public static void printearTablero(String[][]Tablero){
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(Tablero[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean comprobarTerminado(){
        int contadorL = 0;
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j < 4; j++) {
                if (!tableroL[i][j].equals("X")){
                    contadorL++;
                    if (contadorL==16){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        inicializarTableros(tablero);
        inicializarTableros(tableroL);
        rellenarTablero();
        System.out.println("Tablero rellenado: ");
        printearTablero(tablero);
        System.out.println();
        System.out.println("Tablero tapado: ");
        printearTablero(tableroL);
        while (intentos < 10){
            if (comprobarTerminado()){
                System.out.println("Has ganado");
                System.exit(0);
            }
            if (intentos ==10){

            }
            System.out.println();
            System.out.println("Introduce la posición del primer nº de la pareja (fila y columna)");
            fila = scanner.nextInt();
            columna = scanner.nextInt();
            System.out.println("Introduce la posición del segundo nº de la pareja (fila y columna)");
            fila2 = scanner.nextInt();
            columna2 = scanner.nextInt();

            while(fila==fila2 && columna==columna2){
                System.out.println("No puedes introducir dos posiciones iguales, ¡Son el mismo número!");
                System.out.println();
                System.out.println("Introduce la posición del primer nº de la pareja (fila y columna)");
                fila = scanner.nextInt();
                columna = scanner.nextInt();
                System.out.println("Introduce la posición del segundo nº de la pareja (fila y columna)");
                fila2 = scanner.nextInt();
                columna2 = scanner.nextInt();
            }


            if (tablero[fila][columna].equals(tablero[fila2][columna2]) ){
                System.out.println("Has acertado, las parejas coinciden !!");
                tableroL[fila][columna] = tablero[fila][columna];
                tableroL[fila2][columna2] = tablero[fila2][columna2];
                printearTablero(tableroL);
            }
            else{
                intentos++;
                int vidas = 10-intentos;
                System.out.println("No has acertado, tienes una vida menos, es decir " +vidas+ " vidas" );
            }
        }
        System.out.println();
        System.out.println("Has perdido todas las vidas, has perdido el juego :(");
    }
}