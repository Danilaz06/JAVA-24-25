// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Simpson {
    //visible a nivel de la clase simpson
    static char[][] tablero = new char[10][10];
    //Software de gestión de venta online
    public static void rellenarTablero(char pers){
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10 ; j++) {
                tablero[i][j] = pers;
            }
        }
    }
    public static void escribirtablero() {
        for (int i = 0; i <10; i++) {
            System.out.println();
            for (int j = 0; j <10 ; j++) {
                System.out.println(tablero[i][j]);
            }

    public static void main(String[] args) {
              char personaje= '#';
              rellenarTablero(personaje);
              escribirtablero();
            }

        }


        //for ()
        }
    }