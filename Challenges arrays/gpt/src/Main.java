import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos de prueba
        int numCasos = scanner.nextInt();

        // Procesar cada caso de prueba
        for (int i = 0; i < numCasos; i++) {
            // Leer los tres años A, B, C
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();

            // Calcular distancias absolutas
            int distanciaA = Math.abs(A - B);
            int distanciaC = Math.abs(C - B);

            // Determinar cuál año está más cerca de B o si hay un empate
            if (distanciaA < distanciaC) {
                System.out.println(A);
            } else if (distanciaC < distanciaA) {
                System.out.println(C);
            } else {
                System.out.println("EMPATE");
            }
        }
    }
}