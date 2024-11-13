import java.util.Random;
import java.util.Scanner;

public class Main {
    static String[][] matriz1 = new String[10][10];
    static String[][] matriz2 = new String[10][10];
    static final int MAX_FILAS = 10;
    static final int MAX_COLUMNAS = 10;
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static int pos1x, pos1y;
    static int pos2x, pos2y;
    static int vidas1 = 3;
    static int vidas2 = 3;
    static boolean puedeElegirPosicion1 = false; // Habilitar para jugador 1 si toma una pócima
    static boolean puedeElegirPosicion2 = false; // Habilitar para jugador 2 si toma una pócima

    public static void rellenarTablerosL() {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                matriz1[i][j] = "L";
                matriz2[i][j] = "L";
            }
        }
        matriz1[9][9] = "F";
        matriz2[9][9] = "F";
    }

    public static void meterPersonajesMatriz1(String personaje, int nVeces) {
        for (int i = 0; i < nVeces; i++) {
            int Posx, Posy;
            do {
                Posx = random.nextInt(9);
                Posy = random.nextInt(9);
            } while (!matriz1[Posx][Posy].equals("L"));
            matriz1[Posx][Posy] = personaje;
        }
    }

    public static void meterPersonajesMatriz2(String personaje, int nVeces) {
        for (int i = 0; i < nVeces; i++) {
            int Posx, Posy;
            do {
                Posx = random.nextInt(9);
                Posy = random.nextInt(9);
            } while (!matriz2[Posx][Posy].equals("L"));
            matriz2[Posx][Posy] = personaje;
        }
    }

    public static void printearMatriz(String[][] matriz) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void identificarPersonajes(String[][] matriz, String personaje, int[] posicion) {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                if (matriz[i][j].equals(personaje)) {
                    posicion[0] = i;
                    posicion[1] = j;
                }
            }
        }
    }

    public static void movimientos(String[][] matriz, int[] pos, int numSaltos, String direccion, boolean puedeElegirPosicion) {
        if (puedeElegirPosicion) {
            System.out.println("Puedes elegir una nueva posición en el tablero. Introduce las coordenadas (x, y):");
            int nuevaPosX = sc.nextInt();
            int nuevaPosY = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            if (nuevaPosX >= 0 && nuevaPosX < MAX_FILAS && nuevaPosY >= 0 && nuevaPosY < MAX_COLUMNAS && matriz[nuevaPosX][nuevaPosY].equals("L")) {
                matriz[pos[0]][pos[1]] = "L"; // Deja la casilla actual
                pos[0] = nuevaPosX;
                pos[1] = nuevaPosY;
                matriz[pos[0]][pos[1]] = (matriz == matriz1) ? "Y" : "V"; // Actualiza la nueva posición
            } else {
                System.out.println("La casilla no es válida para moverse.");
            }
            return; // Termina el turno
        }

        if (numSaltos > 3) {
            System.out.println("No puedes saltar más de tres casillas");
            return;
        }

        int nuevaPosX = pos[0];
        int nuevaPosY = pos[1];

        switch (direccion.trim().toUpperCase()) {
            case "W":
                nuevaPosX = Math.floorMod(pos[0] - numSaltos, MAX_FILAS);
                break;
            case "S":
                nuevaPosX = Math.floorMod(pos[0] + numSaltos, MAX_FILAS);
                break;
            case "A":
                nuevaPosY = Math.floorMod(pos[1] - numSaltos, MAX_COLUMNAS);
                break;
            case "D":
                nuevaPosY = Math.floorMod(pos[1] + numSaltos, MAX_COLUMNAS);
                break;
            default:
                System.out.println("Dirección no válida.");
                return;
        }

        matriz[pos[0]][pos[1]] = "L"; // Limpia la casilla anterior

        if (matriz[nuevaPosX][nuevaPosY].equals("D")) {
            if (matriz == matriz1) vidas1--; else vidas2--;
            System.out.println("¡Has caído en una trampa! Pierdes una vida. Vidas restantes: " + (matriz == matriz1 ? vidas1 : vidas2));
            if ((matriz == matriz1 && vidas1 <= 0) || (matriz == matriz2 && vidas2 <= 0)) {
                System.out.println("Has perdido todas tus vidas. ¡Juego terminado!");
                return;
            }
        } else if (matriz[nuevaPosX][nuevaPosY].equals("P")) {
            if (matriz == matriz1) puedeElegirPosicion1 = true; else puedeElegirPosicion2 = true;
            System.out.println("¡Has recogido una pócima! Puedes elegir tu posición en el siguiente turno.");
        }

        // Actualiza la posición y marca el personaje en la nueva ubicación
        pos[0] = nuevaPosX;
        pos[1] = nuevaPosY;
        matriz[pos[0]][pos[1]] = (matriz == matriz1) ? "Y" : "V";
    }

    public static void main(String[] args) {
        rellenarTablerosL();
        meterPersonajesMatriz1("Y", 1);
        meterPersonajesMatriz2("V", 1);
        meterPersonajesMatriz1("D", 5);
        meterPersonajesMatriz2("D", 5);
        meterPersonajesMatriz1("P", 5);
        meterPersonajesMatriz2("P", 5);

        int[] posicion1 = {pos1x, pos1y};
        int[] posicion2 = {pos2x, pos2y};
        identificarPersonajes(matriz1, "Y", posicion1);
        identificarPersonajes(matriz2, "V", posicion2);

        while (vidas1 > 0 && vidas2 > 0) {
            printearMatriz(matriz1);
            System.out.println("Jugador 1, introduce saltos y dirección (W, A, S, D):");
            int saltos = sc.nextInt();
            String direccion = sc.next();
            movimientos(matriz1, posicion1, saltos, direccion, puedeElegirPosicion1);
            puedeElegirPosicion1 = false; // Desactiva la elección de posición tras usarla

            printearMatriz(matriz2);
            System.out.println("Jugador 2, introduce saltos y dirección (W, A, S, D):");
            saltos = sc.nextInt();
            direccion = sc.next();
            movimientos(matriz2, posicion2, saltos, direccion, puedeElegirPosicion2);
            puedeElegirPosicion2 = false; // Desactiva la elección de posición tras usarla
        }
    }
}
