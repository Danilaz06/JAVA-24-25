import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int suma = 0;

    public static void sumarPares(int n){
        for (int i = 1; i <= n; i+=2) {
            suma += i;
        }
        System.out.println("La suma de los números pares de 1 a " + n + " es: " + suma);
        scanner.close();
    }
    public static void main(String[] args) {
        System.out.print("Introduce un número entero positivo: ");
        int n = scanner.nextInt();
        sumarPares(n);

    }
}

