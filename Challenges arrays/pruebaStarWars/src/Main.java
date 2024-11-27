import java.util.Random;
import java.util.Scanner;

public class Main {
    static final int MAX_FILAS = 10;
    static final int MAX_COLUMNAS = 10;
    static String [][] matriz1 = new String[MAX_FILAS][MAX_COLUMNAS];
    static String [][] matriz2 = new String[MAX_FILAS][MAX_COLUMNAS];
    static Random random = new Random();
    static final int filaFinal = 9;
    static final int colFinal = 9;
    static int filaYoda;
    static int columnaYoda;
    static int filaVader;
    static int columnaVader;
    public static void rellenarTableroL(String matriz[][]){
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j <MAX_COLUMNAS ; j++) {
                matriz[i][j] = "L";
            }
        }
        matriz[filaFinal][colFinal] = "F";
    }
    public static void rellenarPersonajes(String matriz[][], char personaje, int numVeces){
        for (int i = 0; i < numVeces; i++) {
            int filaAle = 0;
            int colAle = 0;
            do {
                filaAle = random.nextInt(10);
                colAle = random.nextInt(10);
            }while(matriz[filaAle][colAle] != "L");
            matriz[filaAle][colAle] = String.valueOf(personaje);
        }
    }
    public static void printearTablero(String matriz[][]){
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void encontrarPersonajeY(){
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j <MAX_COLUMNAS ; j++) {
                if (matriz1[i][j] == String.valueOf('Y')){
                    filaYoda = i;
                    columnaYoda = j;
                }
            }
        }
    }
    public static void encontrarPersonajeV(){
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j <MAX_COLUMNAS ; j++) {
                if (matriz2[i][j] == String.valueOf('Y')){
                    filaVader = i;
                    columnaVader = j;
                }
            }
        }
    }
    public static void main(String[] args) {
        rellenarTableroL(matriz1);
        rellenarTableroL(matriz2);
        rellenarPersonajes(matriz1,'Y',1);
        rellenarPersonajes(matriz2,'V',1);
        rellenarPersonajes(matriz1,'D',5);
        rellenarPersonajes(matriz2,'R',5);
        rellenarPersonajes(matriz1,'M',5);
        rellenarPersonajes(matriz2,'M',5);
        printearTablero(matriz1);
        System.out.println();
        printearTablero(matriz2);
        encontrarPersonajeY();
        encontrarPersonajeV();
        Scanner scanner = new Scanner(System.in);
        int vidas1=3;
        int vidas2=3;
        while (vidas1>0 && vidas2>0) {
            System.out.println();
            System.out.println("Introduce el movimiento de tu personaje");
            String movimiento = scanner.nextLine();

            if(movimiento.equals("W")){
                filaYoda = (filaYoda-1) % 10;
                if (matriz1[filaYoda][columnaYoda] == "D"){
                    vidas1--;
                }
                matriz1[filaYoda-1][columnaYoda] = "Y";
                matriz1[filaYoda][columnaYoda] = "L";
            }
            else if(movimiento.equals("A")){
                columnaYoda = (columnaYoda-1) % 10;
                if (matriz1[filaYoda][columnaYoda] == "D"){
                    vidas1--;
                }
                matriz1[filaYoda][columnaYoda-1] = "Y";
                matriz1[filaYoda][columnaYoda] = "L";
            }
            else if(movimiento.equals("D")){
                columnaYoda = (columnaYoda+1) % 10;
                if (matriz1[filaYoda][columnaYoda] == "D"){
                    vidas1--;
                }
                matriz1[filaYoda][columnaYoda+1] = "Y";
                matriz1[filaYoda][columnaYoda] = "L";
            }
            else if(movimiento.equals("W")){
                filaYoda = (filaYoda+1) % 10;
                if (matriz1[filaYoda][columnaYoda] == "D"){
                    vidas1--;
                }
                matriz1[filaYoda+1][columnaYoda] = "Y";
                matriz1[filaYoda][columnaYoda] = "L";
            }
            printearTablero(matriz1);

            System.out.println();
            System.out.println("Introduce el movimiento de tu personaje");
            String movimiento2 = scanner.nextLine();
            System.out.println();

            if(movimiento2.equals("W")){
                filaVader = (filaVader-1) % 10;
                if (matriz2[filaVader][columnaVader] == "R"){
                    vidas2--;
                }
                matriz2[filaVader-1][columnaVader] = "V";
                matriz2[filaVader][columnaVader] = "L";
            }
            else if(movimiento2.equals("A")){
                columnaVader = (columnaVader-1) % 10;
                if (matriz2[filaVader][columnaVader] == "R"){
                    vidas2--;
                }
                matriz2[filaVader][columnaVader-1] = "v";
                matriz2[filaVader][columnaVader] = "L";
            }
            else if(movimiento2.equals("D")){
                columnaVader = (columnaVader+1) % 10;
                if (matriz2[filaVader][columnaVader] == "R"){
                    vidas2--;
                }
                matriz2[filaVader][columnaVader+1] = "V";
                matriz2[filaVader][columnaVader] = "L";
            }
            else if(movimiento2.equals("W")){
                filaVader = (filaVader+1) % 10;
                if (matriz2[filaVader][columnaVader] == "R"){
                    vidas2--;
                }
                matriz2[filaVader+1][columnaVader] = "V";
                matriz2[filaVader][columnaVader] = "L";
            }
            printearTablero(matriz2);
        }

    }
}