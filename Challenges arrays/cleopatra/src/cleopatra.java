import java.util.Random;
import java.util.Scanner;



public class cleopatra{

    static Scanner lector = new Scanner(System.in);
    static Random aleatorio = new Random();
    static int [] array = new int[3];
    static int numUsuarioIteraciones = 0;

    private static void preguntarNum(int numUsuarioIteraciones){
        for (int i = 0; i < numUsuarioIteraciones; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("Introduce el numero " + (j+1));
                int numUsuario = lector.nextInt();
                array[j] = numUsuario;
            }
            System.out.println();
        }
    }

    private static void printearNums(){
        int i = 0;
        for (int j = 0; j <numUsuarioIteraciones ; j++) {
            do {
                System.out.println(array[i]);
                i++;
            } while (i < array.length);
            System.out.println();
            }
    }

    public static void main(String[] args) {
        System.out.println("Cuantas veces quieres repetir el proceso?");
        numUsuarioIteraciones = lector.nextInt();
        preguntarNum(numUsuarioIteraciones);
        printearNums();
    }
}
