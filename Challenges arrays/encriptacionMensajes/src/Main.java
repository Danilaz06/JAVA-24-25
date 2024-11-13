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
    
}