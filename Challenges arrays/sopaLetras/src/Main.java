import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] matriz = new char[5][5];

        // Inicializar la matriz con guiones para que sea más fácil visualizar el tablero vacío
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = '-';
            }
        }

        // Mostrar la sopa de letras inicial (vacía)
        System.out.println("Sopa de letras inicial:");
        mostrarTablero(matriz);

        Scanner scanner = new Scanner(System.in);

        // Permitir al usuario agregar varias palabras
        for (int intentos = 0; intentos < 5; intentos++) {
            System.out.print("Introduce una palabra (solo letras mayúsculas): ");
            String palabra = scanner.nextLine().toUpperCase();

            System.out.print("Introduce la fila de inicio (0 a 4): ");
            int fila = scanner.nextInt();

            System.out.print("Introduce la columna de inicio (0 a 4): ");
            int columna = scanner.nextInt();

            System.out.print("Introduce la dirección (H para horizontal, V para vertical): ");
            char direccion = scanner.next().toUpperCase().charAt(0);

            scanner.nextLine(); // Limpiar el salto de línea

            // Verificar si la palabra cabe en la posición y dirección dadas
            if (cabeEnTablero(matriz, palabra, fila, columna, direccion)) {
                // Colocar la palabra en la matriz
                colocarPalabra(matriz, palabra, fila, columna, direccion);
                System.out.println("Palabra insertada correctamente.");
            } else {
                System.out.println("Error: La palabra no cabe en la posición y dirección indicadas.");
            }

            // Mostrar la sopa de letras después de cada intento
            mostrarTablero(matriz);
        }

        System.out.println("Fin del juego.");
        scanner.close();
    }

    // Función para mostrar el tablero
    public static void mostrarTablero(char[][] matriz) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Función para verificar si la palabra cabe en la posición y dirección dadas
    public static boolean cabeEnTablero(char[][] matriz, String palabra, int fila, int columna, char direccion) {
        if (direccion == 'H') {
            // Verificar si cabe horizontalmente
            return columna + palabra.length() <= 5;
        } else if (direccion == 'V') {
            // Verificar si cabe verticalmente
            return fila + palabra.length() <= 5;
        } else {
            return false; // Dirección no válida
        }
    }

    // Función para colocar la palabra en la matriz
    public static void colocarPalabra(char[][] matriz, String palabra, int fila, int columna, char direccion) {
        if (direccion == 'H') {
            for (int i = 0; i < palabra.length(); i++) {
                matriz[fila][columna + i] = palabra.charAt(i);
            }
        } else if (direccion == 'V') {
            for (int i = 0; i < palabra.length(); i++) {
                matriz[fila + i][columna] = palabra.charAt(i);
            }
        }
    }
}