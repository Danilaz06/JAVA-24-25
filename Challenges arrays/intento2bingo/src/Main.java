import java.util.Random;
import java.util.Random;
import java.util.Scanner;


public class Main {
    static String matriz[][] = new String[3][9];
    static final int MAX_FILAS = 3;
    static final int MAX_COLUMNAS = 9;

    static Random aleatorio = new Random();
    static Scanner lector = new Scanner(System.in);

    public static void rellenarCarton(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j <MAX_COLUMNAS ; j++) {
                matriz[i][j] = "XX";
            }
        }
    }
    public static void imprimirTablero(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {

            }
        }
    }
    public static void colocarNumeros(){
        int NumeroContador = 0;

        do{
            for (int i = 0; i <MAX_FILAS ; i++) {
                for (int j = 0; j < MAX_COLUMNAS; j++) {
                    matriz[i][j] =
                }
            }

        }while(NumeroContador<15);

    }


    public static void main(String[] args){




    }
}