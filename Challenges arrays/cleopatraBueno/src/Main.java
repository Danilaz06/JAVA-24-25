import java.util.Scanner;
import static java.lang.Math.abs;

public class Main {
    static int NumLineas;
    static final int NumAños = 3;
    static int[][] cadenaAños;
    static String entrada;
    static Scanner leer = new Scanner(System.in);

    private static void llenarArrays(int NumLineas) {
        for (int i = 0; i < NumLineas; i++) {
            entrada = leer.nextLine();
            String[] cadena = entrada.split(" ");
            for (int j = 0; j < NumAños; j++) {
                cadenaAños[i][j] = Integer.parseInt(cadena[j]);
            }
        }
    }

    private static int medirAñosSin0(int x, int y) {
        if ((x < 0 && y > 0) || (x > 0 && y < 0)) {
            return Math.abs(x) + Math.abs(y) - 1;
        } else {
            return Math.abs(x - y);
        }
    }

    private static void devolverCercano(int i){
        int a = cadenaAños[i][1];
        int b = cadenaAños[i][2];
        int c = cadenaAños[i][3];

        int difAB = medirAñosSin0(a, b);
        int difBC = medirAñosSin0(b, c);

        if (difAB < difBC) {
            System.out.println(a);
        } else if (difAB > difBC) {
            System.out.println(c);
        } else {
            System.out.println(b);
        }
    }
    public static void main(String[] args) {
        NumLineas = leer.nextInt();
        leer.nextLine();
        cadenaAños = new int[NumLineas][NumAños];
        llenarArrays(NumLineas);
        for (int i = 0; i < NumLineas; i++) {
            devolverCercano(i);
        }
    }
}