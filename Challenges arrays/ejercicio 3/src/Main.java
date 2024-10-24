import java.util.Random;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        Random aleatorio = new Random();
        Scanner lector = new Scanner(System.in);

        String arrayPrimitiva[] = new String[6];

        //Rellenar Array
        
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            int NumAle = aleatorio.nextInt(100);
            arrayPrimitiva[i] = String.valueOf(NumAle);
        }

        //Imprimirlo

        for (int i = 0; i < arrayPrimitiva.length; i++) {
            System.out.println(arrayPrimitiva[i]);
        }

        //Leer números y poner XX si coincide en la pos del array

        System.out.println("Dame un número");
        String cad1usuario = lector.next();
        for (int i = 0; i < arrayPrimitiva.length; i++){
            if (cad1usuario.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX";}
        }

        System.out.println("Dame un número");
        String cad2usuario = lector.next();
        for (int i = 0; i < arrayPrimitiva.length; i++){
            if (cad2usuario.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX";}
        }
        System.out.println("Dame un número");
        String cad3usuario = lector.next();
        System.out.println(' ');
        for (int i = 0; i < arrayPrimitiva.length; i++){
            if (cad3usuario.equals(arrayPrimitiva[i])){
                arrayPrimitiva[i] = "XX";}
        }


        for (int i = 0; i < arrayPrimitiva.length; i++) {
            System.out.println(arrayPrimitiva[i]);
        }
    }
}