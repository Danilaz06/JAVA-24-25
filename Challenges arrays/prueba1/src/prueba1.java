import java.util.Random;
import java.util.Scanner;

public class prueba1 {
    static String [][] matriz = new String[10][10];
    static String [][] matrizX = new String[10][10];
    static final int MAX_FILAS = 10;
    static final int MAX_COLUMNAS = 10;
    static final int intentos = 10;

    static Random Aleatorio = new Random();
    static Scanner Lector = new Scanner(System.in);

    private static void rellenarMatrizAle() {
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j <MAX_COLUMNAS ; j++) {
                int numAle = Aleatorio.nextInt(89)+10;
                matriz[i][j] = String.valueOf(numAle);
            }
        }
    }
    private static void printearMatrizAle(){
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j <MAX_COLUMNAS ; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void rellenarMatrizX(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                matrizX[i][j] = "X";
            }
        }
    }
    private static void printearMatrizX(){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(matrizX[i][j] + " ");;
            }
            System.out.println();
        }

    }
    private static void comprobarNumUsuario(){
        for (int i = 0; i <intentos ; i++) {
            String numUsuario = Lector.nextLine();
            for (int j = 0; j <MAX_FILAS ; j++) {
                for (int k = 0; k <MAX_COLUMNAS ; k++) {
                    if (matriz[j][k].equals(numUsuario)){
                        matrizX[j][k] = numUsuario;
                    }
                }
            }
            printearMatrizX();
        }
    }

    public static void main(String[] args) {
        rellenarMatrizAle();
        rellenarMatrizX();
        printearMatrizX();
        comprobarNumUsuario();
        printearMatrizX();

    }
}