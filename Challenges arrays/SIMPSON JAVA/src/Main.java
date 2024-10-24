
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static char tablero[][] = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
    private static int filabart;
    private static int columnabart;


    private static void imprimir_tablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }
    }
    private static void rellenar_tablero() {
        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10 ; j++) {
                tablero[i][j] = 'L';
            }
        }
        tablero[9][9] = 'F';

    }
    private static void asignar_bart(){
        Random Aleatorio = new Random();
        int filabart = Aleatorio.nextInt(10);
        int columnabart = Aleatorio.nextInt(10);
        tablero[filabart][columnabart] = 'B';
    }
    private static void asignar_5_hommers(){
        int filahommer;
        int columnahommer;
        for (int i = 0; i < 5; i++) {
            do {Random Aleatorio = new Random();
               filahommer = Aleatorio.nextInt(10);
               columnahommer = Aleatorio.nextInt(10);
            }while(tablero[filahommer][columnahommer]!='L');
            tablero[filahommer][columnahommer] = 'H';
        }



    }
    private static void asignar_10_muros(){
        int filamuro;
        int columnamuro;
        for (int i = 0; i < 10; i++) {
            do {Random Aleatorio = new Random();
                filamuro = Aleatorio.nextInt(10);
                columnamuro = Aleatorio.nextInt(10);
            }while(tablero[filamuro][columnamuro]!='L');
            tablero[filamuro][columnamuro] = 'M';
        }
    }



    public static void main(String[] args) {
        rellenar_tablero();
        imprimir_tablero();
        asignar_bart();
        imprimir_tablero();
        asignar_5_hommers();
        imprimir_tablero();
        asignar_10_muros();
        imprimir_tablero();

        int vidas = 10;
        System.out.println("Introduce la tecla para el movimiento");
        Scanner lector = new Scanner(System.in);
        String letra = lector.nextLine();
        switch(letra){
            case "A":
                if((columnabart-1)>=0){
                    columnabart--;
                    switch (tablero[filabart][columnabart]){
                        case 'H':
                            vidas --;
                            tablero[filabart][columnabart] = 'B';
                            tablero[filabart][columnabart+1] = 'L';
                            vidas--;
                            System.out.println("Has perdido una vida, te quedan " + vidas + "vidas");

                            break;
                        case 'L':
                            tablero[filabart][columnabart] = 'B';
                            tablero[filabart][columnabart+1] = 'L';
                            break;
                        case 'M':
                            System.out.println("No puedes pasar por ahí, hay un muro");
                        case 'F':
                            System.out.println("Has ganado");
                            System.exit(0);
                            break;

                    }
                }
            case "D":
                if((columnabart+1)<=0){
                    columnabart--;
                    switch (tablero[filabart][columnabart]){
                        case 'H':
                            vidas --;
                            tablero[filabart][columnabart] = 'B';
                            tablero[filabart][columnabart+1] = 'L';
                            vidas--;
                            System.out.println("Has perdido una vida, te quedan " + vidas + "vidas");

                            break;
                        case 'L':
                            tablero[filabart][columnabart] = 'B';
                            tablero[filabart][columnabart+1] = 'L';
                            break;
                        case 'M':
                            System.out.println("No puedes pasar por ahí, hay un muro");
                        case 'F':
                            System.out.println("Has ganado");
                            System.exit(0);
                            break;

                    }
                }

        }
    }


}