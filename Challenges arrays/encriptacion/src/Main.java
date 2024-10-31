import java.util.Scanner;
public class Main {
    static int t,g,c,f,d,r,h;
    static int[] array = new int[4];
    static Scanner lector = new Scanner(System.in);
    public static void preguntarNumeros(){
        for (int i = 0; i < 4; i++) {
            int num = lector.nextInt();
            array[i] = num;
            if (i==4){
                array[i] = 0;
            }
        }
    }
    public static void asignarLetras(){
        for (int i = 0; i < 3; i++) {
            t = array[i]/1;
            g = array[i]/10;
            c = array[i]/100;
            f = array[i]/1000;
            d = array[i]/10000;
            r = array[i]/100000;
            h = array[i]/1000000;

        }



    }
    public static void main(String[] args) {

    }
}