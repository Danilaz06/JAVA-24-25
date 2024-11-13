import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    private static void iniciarJuego(String[] palabras, String[] respuestas) {
        for (int i = 0; i < palabras.length; i++) {
            mostrarPalabra(palabras[i]);
            respuestas[i] = palabras[i];

            String entrada = pedirRespuesta();

            if (!verificarRespuesta(entrada, respuestas, i)) {
                reiniciarJuego(respuestas);
                i = -1; // Reinicia el juego desde la primera palabra
            } else {
                System.out.println("¡Correcto! Sigue a la siguiente palabra.\n");
            }
        }
    }

    private static void mostrarPalabra(String palabra) {
        System.out.println("Palabra a memorizar: " + palabra);
    }

    private static String pedirRespuesta() {
        System.out.print("Escribe todas las palabras memorizadas hasta ahora: ");
        return scanner.nextLine();
    }

    private static boolean verificarRespuesta(String entrada, String[] respuestas, int hasta) {
        StringBuilder correctas = new StringBuilder();
        for (int j = 0; j <= hasta; j++) {
            correctas.append(respuestas[j]).append(" ");
        }

        boolean esCorrecto = entrada.equals(correctas.toString().trim());
        if (!esCorrecto) {
            System.out.println("¡Incorrecto! La secuencia era: " + correctas.toString().trim());
            System.out.println("Intenta de nuevo desde el inicio.");
        }
        return esCorrecto;
    }


    private static void reiniciarJuego(String[] respuestas) {
        for (int i = 0; i < respuestas.length; i++) {
            respuestas[i] = null; // Limpiar las respuestas
        }
    }

    public static void main(String[] args) {

        String[] palabras = {"casa", "perro", "gato", "sol", "luna"}; // Ejemplo de palabras
        String[] respuestas = new String[palabras.length];

        iniciarJuego(palabras, respuestas);
        System.out.println("¡Felicidades! Has memorizado todas las palabras correctamente.");
        scanner.close();
    }
}


