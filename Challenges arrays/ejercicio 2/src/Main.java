import java.util.Random;

public class Main {

    static Random ale = new Random();

    public static int generarNumAle(){
        int numAle = ale.nextInt(10)+1;
        return numAle;
    }
    public static void main(String[] args) {
        int[][] array = new int[10][10];

        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <10; j++) {
                array[i][j] = generarNumAle();
                System.out.print(array[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
}