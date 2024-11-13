public class Main {

    static int[] numeros = {4, 2, 9, 1, 5, 3};
    static int objetivo = 5;
    static boolean encontrado = false;

    public static boolean recorrer(){
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == objetivo) {
                encontrado = true;
            }
        }
    }

    public static void respuesta() {
        if (encontrado) {
            System.out.println("Número encontrado");
        }
        else {
            System.out.println("Número no encontrado");
        }
    }


    public static void main(String[] args) {
        recorrer();
        respuesta();
    }

