
import java.util.Random;

public class Array10dimNumAl {

    static Random ale = new Random();

    public static int generarNumAle(){
        int numAle = ale.nextInt(10)+1;
        return numAle;
    }

        public static void main(String[] args) {
        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = generarNumAle();
            System.out.println(array[i]);
        }
    }





}