import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    private static void identificarDistanciaSalto(){

        String linea=sc.nextLine();
        char primeraLetra = linea.charAt(0);
        String mensajeCifrado = linea.substring(1);

        int desplazamiento = primeraLetra - 'p';
        if (mensajeCifrado.equals("FIN")) {
            return;
            
    }
    private static void descifrarMensaje(String mensajeCifrado, int desplazamiento , String linea){
        for (int i = 0; i <mensajeCifrado.length() ; i++) {
            char letra = linea.charAt(i)
        }
    }
    public static void main(String[] args) {

    }
}