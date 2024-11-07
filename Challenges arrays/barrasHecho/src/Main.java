import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true){
            String codigo = sc.nextLine().trim();
            if (codigo.equals("0")) break;
            int longitud = codigo.length();
            boolean ean8 = longitud<=8;
            boolean ean13 = longitud<=13 && longitud>8;
            while (ean8){
                codigo = "0" + codigo;
            }
            while(ean13){
                codigo = "0" + codigo;
            }
            int contadorPar = 0;
            int contadorImpar = 0;
            int contadorPos = 0;
            for (int i = longitud-2; i <0; i--) {
                int digito = Integer.parseInt(String.valueOf(codigo.charAt(i)));
                contadorPos++;
                if (contadorPos%2 ==0 ){
                    contadorPar = contadorPar + (digito*1);
                }
                else{
                    contadorImpar =  contadorImpar + (digito*3);
                }

                int suma = contadorPar + contadorImpar;

                int resto = suma%10;
                int numControl;
                numControl = (resto==0) ? 0 : (10-resto);
                int numControlReal = Integer.parseInt(String.valueOf(codigo.charAt(codigo.length()-1)));
                boolean controlValido = (numControlReal == numControl);
                if (controlValido){
                    System.out.println("SI");
                }
                else{
                    System.out.println("NO");
                }

                if (controlValido && ean13){
                    String nombrePais = "Desconocido";
                    int prefijoPais = 0;

                    int[] prefijos = {380, 50, 560, 70, 590, 850, 890};
                    String[] paises = {"Bulgaria", "Inglaterra", "Portugal", "Noruega", "Polonia", "Cuba", "India"};
                    for (int j = 0; j < prefijos.length ; j++) {
                        prefijoPais = Integer.parseInt(codigo.substring(0, (String.valueOf( prefijos[j] )).length()) );
                        if (prefijos[i] == prefijoPais){
                            nombrePais = paises[j];
                        }
                        System.out.println(paises[j]);
                    }

                }





            }
        }
    }
}