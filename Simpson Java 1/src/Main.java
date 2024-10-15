package simpsonprogfuncional;

import java.util.Random;

public class SimpsonProgFuncional {
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static char[][] tablero;

    public static void main(String[] args) {
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tablero[i][j] = 'L';
            }
        }
        imprimirTablero();
        Random aleatorio = new Random();
        int filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
        int columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9

        tablero[filaAleatorio][columnaAleatorio] = 'B';

        imprimirTablero();
        int filaAleatorioHomer;
        int columnaAleatorioHomer;
        for (int i = 0; i < 10; i++) {
            do{
                filaAleatorioHomer = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
                columnaAleatorioHomer = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9
            }while (tablero[filaAleatorioHomer][columnaAleatorioHomer]!='L');
            tablero[filaAleatorioHomer][columnaAleatorioHomer] = 'H';
        }
        imprimirTablero();
        int filaAleatorioMuro;
        int columnaAleatorioMuro;
        for (int i = 0; i < 10; i++) {
            do{
                filaAleatorioMuro = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
                columnaAleatorioMuro = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9
            }while (tablero[filaAleatorioMuro][columnaAleatorioMuro]!='L');
            tablero[filaAleatorioMuro][columnaAleatorioMuro] = 'M';
        }
        imprimirTablero();
        tablero[MAX_FILA_TABLERO-1][MAX_COLUMNA_TABLERO-1] = 'F';
        imprimirTablero();
    }

    private static void imprimirTablero(){
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}
