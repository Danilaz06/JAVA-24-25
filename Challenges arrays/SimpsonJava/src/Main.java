import java.util.Random;

public class Main {
    private final int MAX_FILA_TABLERO = 10;
    private final int MAX_COLUMNA_TABLERO = 10;
    public static char[][] tablero = new int[10][10];


    //Rellenar tablero

    public static void rellenar_tablero() {
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = ' ';
            }
            System.out.println(" ");
        }
    }
    public static void asignar_pos_bart(){
        Random Aleatorio = new Random(10);
        int fila_bart = Aleatorio.nextInt();
        int columna_bart = Aleatorio.nextInt();

    }

    public static void asignar_5_hommers(){
        for (int i = 0; i < 5; i++) {
            while (tablero)
        }
    }
    public static void main(String[] args) {

    }
}