package simpsonprogfuncional;

import java.util.Random;
import java.util.Scanner;

public class SimpsonProgFuncional {
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static char[][] tablero;
    private static int filaBart;
    private static int columnaBart;

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
    private static void asignarLibreACasilla(char caracter){
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tablero[i][j] = caracter;
            }
        }
    }
    private static void asignarPersonajesACasillaLibre(char caracter, int numRepeteciones){
        Random aleatorio = new Random();
        int filaAleatorio = -1;
        int columnaAleatorio = -1;
        for(int i = 0; i<numRepeteciones; i++){
            do{
                filaAleatorio = aleatorio.nextInt(MAX_FILA_TABLERO);//0-9
                columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_TABLERO);//0-9
            }while (tablero[filaAleatorio][columnaAleatorio]!='L');
            tablero[filaAleatorio][columnaAleatorio] = caracter;
        }
        if(caracter=='B'){
            filaBart = filaAleatorio;
            columnaBart = columnaAleatorio;
        }
    }
    public static void main(String[] args) {
        tablero = new char[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
        asignarLibreACasilla('L');
        imprimirTablero();
        asignarPersonajesACasillaLibre('B', 1);
        imprimirTablero();
        asignarPersonajesACasillaLibre('H',10);
        imprimirTablero();
        asignarPersonajesACasillaLibre('M',10);
        imprimirTablero();
        tablero[MAX_FILA_TABLERO-1][MAX_COLUMNA_TABLERO-1] = 'F';
        imprimirTablero();

        Scanner lector = new Scanner(System.in);
        /*****************************************************************/
        /*****************************************************************/
        int vidas = 10;
        do{
            System.out.println("Dime el desplazamiento que quieres realizar");
            System.out.println("A--> Izquierda, S--> Abajo, D--> Derecha, W--> Arriba");
            String desplazamiento = lector.nextLine();
            System.out.println("Desplazamiento=" + desplazamiento);
            switch(desplazamiento){
                case "A":
                    if((columnaBart - 1) >=0){
                        columnaBart = columnaBart - 1;
                        switch (tablero[filaBart][columnaBart]){
                            case 'H':
                                vidas = vidas-1;
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart+1] = 'L';
                                System.out.println("Has perdido una vida. "
                                        + "Te quedan=" + vidas + " vidas.");
                                break;
                            case 'L':
                                tablero[filaBart][columnaBart] = 'B';
                                tablero[filaBart][columnaBart+1] = 'L';
                                break;
                            case 'M':
                                System.out.println("El muro no te deja desplazarte a esta casilla.");
                                columnaBart = columnaBart + 1;
                                break;
                        }
                    }else{
                        System.out.println("Desplazamiento prohibido. Límite de tablero.");
                    }
                    break;
                case "S":
                    break;
                case "D":
                    break;
                case "W":
                    break;
                default:
                    break;
            }
            imprimirTablero();
        }while(vidas>0);
        /*****************************************************************/

    }

}
