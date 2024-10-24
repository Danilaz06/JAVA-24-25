import java.util.Random;
import java.util.Collection;
import java.util.Scanner;
public class BingoProg {

    static int[][] matriz = new int[3][9];
    static final int MAX_FILAS = 3;
    static final int MAX_COLUMNAS = 9;

    static Random aleatorio = new Random();
    static Scanner lector = new Scanner(System.in);


    // Metodo para rellenar la matriz con valores no repetidos en cada columna
    public static void rellenarMatriz() {
        int valor;
        int decenas = 0;

        // Recorremos las columnas primero
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            for (int i = 0; i < MAX_FILAS; i++) {
                do {
                    // Generamos un valor dentro del rango [0,9] y sumamos decenas para evitar valores fuera de rango
                    valor = aleatorio.nextInt(10) + decenas;
                } while (repetidoNumero(valor, j));  // Si el número ya existe en la columna, volvemos a intentar
                matriz[i][j] = valor;  // Asignamos el valor a la matriz
            }
            decenas += 10;  // Incrementamos las decenas para la siguiente columna
        }
    }
    // Metodo para verificar si el número ya existe en una columna
    public static boolean repetidoNumero(int valor, int j) {
        for (int i = 0; i < MAX_FILAS; i++) {
            if (valor == matriz[i][j]) {
                return true;  // Si el valor ya existe en la columna, retornamos true
            }
        }
        return false;
    }
    // Metodo para mostrar la matriz en consola
    public static void mostrarMatriz() {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(matriz[i][j] + "\t");  // Imprimimos la matriz con tabulaciones
            }
            System.out.println();  // Nueva línea después de cada fila
        }
    }
    public static void ordenarArrays(){
        for (int j = 0; j < 9; j++) {
            Collection ordenar = new Collection() {


            }
        }
    }

    // Metodo principal
    public static void main(String[] args) {
        rellenarMatriz();  // Rellenamos la matriz con valores
        mostrarMatriz();   // Mostramos la matriz en consola
    }
}
