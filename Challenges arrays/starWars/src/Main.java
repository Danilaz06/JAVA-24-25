import java.util.Random;
import java.util.Scanner;

public class Main {
    static String[][] matriz1 = new String[10][10];
    static String[][] matriz2= new String[10][10];
    static final int MAX_FILAS = 10;
    static final int MAX_COLUMNAS = 10;
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();
    static final String casillaFinal1 = matriz1[9][9];
    static final String casillaFinal2 =matriz2[9][9];

    static int pos1x;
    static int pos1y;
    static int pos2x;
    static int pos2y;

    public static void rellenarTablerosL(){
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                matriz1[i][j] = "L";
            }
        }
        matriz1[9][9]="F";
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                matriz2[i][j] = "L";
            }
        }
        matriz2[9][9]="F";
    }
    public static void meterPersonajesMatriz1(String personaje, int nVeces){
        for (int i = 0; i <nVeces ; i++) {
            int Posx;
            int Posy;
            do {
                Posx =random.nextInt(9);
                Posy =random.nextInt(9);
            }while(matriz1[Posx][Posy]!="L");
            matriz1[Posx][Posy]=personaje;
        }
    }
    public static void meterPersonajesMatriz2(String personaje, int nVeces){
        for (int i = 0; i <nVeces ; i++) {
            int Posx;
            int Posy;
            do {
                Posx =random.nextInt(9);
                Posy =random.nextInt(9);
            }while(matriz1[Posx][Posy]!="L");
            matriz2[Posx][Posy]=personaje;
        }
    }
    public static void printearMatriz1(){
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j <MAX_COLUMNAS ; j++) {
                System.out.print(matriz1[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printearMatriz2(){
        for (int i = 0; i <MAX_FILAS ; i++) {
            for (int j = 0; j <MAX_COLUMNAS ; j++) {
                System.out.print(matriz2[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void identificarPersonajes(String matriz[][],String personaje, int posicion1, int posicion2){
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                if (matriz[i][j]==personaje){
                    posicion1=i;
                    posicion2=j;
                }
            }
        }
    }
    static int vidas=3;
    public static void movimientos1(String matriz[][],int numSaltos,String direccion){
        while(numSaltos>3){
            System.out.println("No puedes saltar mas de tres casillas");
            numSaltos = sc.nextInt();
            sc.nextLine();
        }
        int nuevaPosX = pos1x;
        int nuevaPosY = pos1y;

        switch (direccion.trim().toLowerCase()) {
            case "W":
                nuevaPosX = (pos1x - numSaltos + MAX_FILAS) % MAX_FILAS;
                break;
            case "S":
                nuevaPosX = (pos1x + numSaltos) % MAX_FILAS;
                break;
            case "A":
                nuevaPosY = (pos1y - numSaltos + MAX_COLUMNAS) % MAX_COLUMNAS;
                break;
            case "D":
                nuevaPosY = (pos1y + numSaltos) % MAX_COLUMNAS;
                break;
            case "Q":
                nuevaPosX = (pos1x - numSaltos + MAX_FILAS) % MAX_FILAS;
                nuevaPosY = (pos1y - numSaltos + MAX_COLUMNAS) % MAX_COLUMNAS;
                break;
            case "E":
                nuevaPosX = (pos1x - numSaltos + MAX_FILAS) % MAX_FILAS;
                nuevaPosY = (pos1y + numSaltos) % MAX_COLUMNAS;
                break;
            case "Z":
                nuevaPosX = (pos1x + numSaltos) % MAX_FILAS;
                nuevaPosY = (pos1y - numSaltos + MAX_COLUMNAS) % MAX_COLUMNAS;
                break;
            case "X":
                nuevaPosX = (pos1x + numSaltos) % MAX_FILAS;
                nuevaPosY = (pos1y + numSaltos) % MAX_COLUMNAS;
                break;
            default:
                System.out.println("Dirección no válida.");
                return;
        }
        matriz[pos1x][pos1y] = "L";
        matriz[nuevaPosX][nuevaPosY] = "Y";

        pos1x = nuevaPosX;
        pos1y = nuevaPosY;
    }
    static int vidas2 = 3;
    public static void movimientos2(String matriz[][],int numSaltos,String direccion){
        while(numSaltos>3){
            System.out.println("No puedes saltar mas de tres casillas");
            numSaltos = sc.nextInt();
            sc.nextLine();
        }
        int nuevaPosX = pos2x;
        int nuevaPosY = pos2y;

        switch (direccion.trim().toLowerCase()) {
            case "W":
                nuevaPosX = (pos1x - numSaltos + MAX_FILAS) % MAX_FILAS;
                break;
            case "S":
                nuevaPosX = (pos1x + numSaltos) % MAX_FILAS;
                break;
            case "A":
                nuevaPosY = (pos1y - numSaltos + MAX_COLUMNAS) % MAX_COLUMNAS;
                break;
            case "D":
                nuevaPosY = (pos1y + numSaltos) % MAX_COLUMNAS;
                break;
            case "Q":
                nuevaPosX = (pos1x - numSaltos + MAX_FILAS) % MAX_FILAS;
                nuevaPosY = (pos1y - numSaltos + MAX_COLUMNAS) % MAX_COLUMNAS;
                break;
            case "E":
                nuevaPosX = (pos1x - numSaltos + MAX_FILAS) % MAX_FILAS;
                nuevaPosY = (pos1y + numSaltos) % MAX_COLUMNAS;
                break;
            case "Z":
                nuevaPosX = (pos1x + numSaltos) % MAX_FILAS;
                nuevaPosY = (pos1y - numSaltos + MAX_COLUMNAS) % MAX_COLUMNAS;
                break;
            case "X":
                nuevaPosX = (pos1x + numSaltos) % MAX_FILAS;
                nuevaPosY = (pos1y + numSaltos) % MAX_COLUMNAS;
                break;
            default:
                System.out.println("Dirección no válida.");
                return;
        }

        if (matriz[nuevaPosX][nuevaPosY].equals("D")) {
            vidas2--;
            System.out.println("¡Has caído en una trampa! Pierdes una vida. Vidas restantes: " + vidas);

            // Si las vidas llegan a 0, el jugador pierde
            if (vidas2 <= 0) {
                System.out.println("Has perdido todas tus vidas. ¡Juego terminado!");
                return;
            }
        }

        matriz[pos2x][pos2y] = "L";
        matriz[nuevaPosX][nuevaPosY] = "Y";

        pos2x = nuevaPosX;
        pos2y = nuevaPosY;
    }

    public static void main(String[] args) {
        rellenarTablerosL();
        meterPersonajesMatriz1("Y",1);
        meterPersonajesMatriz2("V",1);
        meterPersonajesMatriz1("D",5);
        meterPersonajesMatriz2("R",5);
        meterPersonajesMatriz1("M",5);
        meterPersonajesMatriz2("M",5);
        identificarPersonajes(matriz1,"Y", pos1x, pos1y);
        identificarPersonajes(matriz2,"V", pos2x, pos2y);

    }
}