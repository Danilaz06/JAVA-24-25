import java.util.Arrays;

public class Main {

    public static void rellenarArrayAscendente(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }


    public static void mostrarArrayAscendente(int[] array) {
        System.out.println("Array: " + Arrays.toString(array));
    }


    public static void mostrarArrayInverso(int[] array) {
        System.out.print("Array en orden inverso: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    public static void rellenarArrayNumerosPares(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }
    }



    public static void mostrarElementosDeDosEnDos(int[] array) {
        System.out.print("Elementos de dos en dos: ");
        for (int i = 0; i < array.length; i += 2) {
            System.out.print("[" + array[i] + ", " + (i + 1 < array.length ? array[i + 1] : " ") + "] ");
        }
        System.out.println();
    }

    public static void rellenarArrayNumerosImpares(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2 + 1;
        }
    }


    public static void duplicarElementos(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
    }


    public static int calcularSumaElementos(int[] array) {
        int suma = 0;
        for (int num : array) {
            suma += num;
        }
        return suma;
    }


    public static int encontrarMaximo(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }


    public static int encontrarMinimo(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) min = num;
        }
        return min;
    }
    public static void main(String[] args) {
        int[] array = new int[10];

        rellenarArrayAscendente(array);
        mostrarArrayAscendente(array);

        mostrarArrayInverso(array);

        rellenarArrayNumerosPares(array);
        mostrarArrayAscendente(array);

        mostrarElementosDeDosEnDos(array);

        rellenarArrayNumerosImpares(array);
        mostrarArrayAscendente(array);

        duplicarElementos(array);
        mostrarArrayAscendente(array);

        int suma = calcularSumaElementos(array);
        System.out.println("Suma de todos los elementos: " + suma);

        int max = encontrarMaximo(array);
        int min = encontrarMinimo(array);
        System.out.println("Valor máximo: " + max);
        System.out.println("Valor mínimo: " + min);
    }


}