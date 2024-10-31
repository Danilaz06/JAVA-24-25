import java.util.Scanner;

public class Main {

    static int numNum;
    static int[] array = new int[numNum];
    static Scanner lector = new Scanner(System.in);

    private static void introducirNumeros(){
        for (int i = 0; i <numNum ; i++) {
            int numUsuario = lector.nextInt();
            array[i] = numUsuario;
        }
    }
    private static void determinarCapasPosibles(){

    }
    public static void main(String[] args) {
        
    }
}