import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int MAX_FILAS = 10;
    static final int MAX_COLUMNAS = 10;
    static String [][] matriz1 = new String[MAX_FILAS][MAX_COLUMNAS];
    static String [][] matriz2 = new String[MAX_FILAS][MAX_COLUMNAS];

    static int filaAl;
    static int columnaAl;

    static int filaYoda;
    static int columnaYoda;
    static int filaVader;
    static int columnaVader;

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    static int vidas1 = 3;
    static int vidas2 = 3;
    public static void rellenarTablero(String matriz[][]){
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                matriz[i][j]= ".";
                if(i == 9 && j==9){
                    matriz[i][j]="F";
                }
            }
        }

    }
    public static void rellenarPersonajes(String matriz[][], String personaje, int numVeces){
        for (int i = 0; i <numVeces ; i++) {
            do {
                filaAl= random.nextInt(10);
                columnaAl= random.nextInt(10);
            }while (matriz[filaAl][columnaAl]!=".");
            matriz[filaAl][columnaAl] = personaje;
        }
        if (personaje.equals("Y")  || personaje.equals("V") )
            if (personaje.equals("Y")){
                filaYoda = filaAl;
                columnaYoda = columnaAl;
            } else if (personaje.equals("V")) {
                filaVader= filaAl;
                columnaVader=columnaAl;
            }
    }
    public static void printearTablero(String matriz[][]){
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j <MAX_COLUMNAS ; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void movimiento(String matriz[][], String personaje, String enemigo, String muro, int salto){
        int fila = 0, columna = 0;
        if (personaje.equals("Y")) {
            fila = filaYoda;
            columna = columnaYoda;
        } else if (personaje.equals("V")) {
            fila = filaVader;
            columna = columnaVader;
        }

        System.out.println("Introduce un movimiento de tu personaje (W,A,S,D)");
        String leerMovimiento = scanner.nextLine();

        int oldFila = fila;
        int oldColumna = columna;

        matriz[fila][columna] = "."; // Eliminar personaje de la posición actual

        switch (leerMovimiento){
            case "W", "w":
                fila = (fila - salto + MAX_FILAS) % MAX_FILAS;
                break;
            case "D", "d":
                columna = (columna + salto) % MAX_COLUMNAS;
                break;
            case "S", "s":
                fila = (fila + salto) % MAX_FILAS;
                break;
            case "A", "a":
                columna = (columna - salto + MAX_COLUMNAS) % MAX_COLUMNAS;
                break;
            default:
                System.out.println("Movimiento no válido");
                fila = oldFila;
                columna = oldColumna;
                matriz[fila][columna] = personaje;
                return;
        }

        if (matriz[fila][columna].equals(muro)){
            System.out.println("No se puede pasar, hay un muro");
            fila = oldFila;
            columna = oldColumna;
        } else if (matriz[fila][columna].equals(enemigo)){
            if (personaje.equals("Y")) {
                vidas1--;
            } else {
                vidas2--;
            }
        }

        matriz[fila][columna] = personaje;

        if (personaje.equals("Y")) {
            filaYoda = fila;
            columnaYoda = columna;
        } else if (personaje.equals("V")) {
            filaVader = fila;
            columnaVader = columna;
        }
    }


    public static void main(String[] args) {
        rellenarTablero(matriz1);
        rellenarTablero(matriz2);
        rellenarPersonajes(matriz1,"Y",1);
        rellenarPersonajes(matriz2,"V",1);
        rellenarPersonajes(matriz1,"D",5);
        rellenarPersonajes(matriz2,"R",5);
        rellenarPersonajes(matriz1,"M",5);
        rellenarPersonajes(matriz2,"M",5);

        do {

            printearTablero(matriz1);
            System.out.println("Introduce el num de saltos que quieres que se mueva el personaje (máximo 3)");
            int salto1 = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea sobrante
            movimiento(matriz1, "Y","D", "M",salto1);

            System.out.println();
            System.out.println();
            System.out.println();

            printearTablero(matriz1);

            System.out.println();
            System.out.println();
            System.out.println();

            printearTablero(matriz2);
            System.out.println("Introduce el num de saltos que quieres que se mueva el personaje (máximo 3)");
            int salto2 = scanner.nextInt();
            movimiento(matriz2,"V","R","M",salto2);

            System.out.println();
            System.out.println();
            System.out.println();

            printearTablero(matriz2);
            System.out.println();
            System.out.println();
            System.out.println();



        }while(vidas1>0 && vidas2>0);
        if (vidas1 > 0) {
            System.out.println("¡Yoda ganó!");
        } else if (vidas2 > 0) {
            System.out.println("¡Vader ganó!");
        } else {
            System.out.println("¡Empate!");
        }
        printearTablero(matriz1);
        System.out.println();
        printearTablero(matriz2);
    }
}