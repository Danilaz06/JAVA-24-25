
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        List<String> blockOptions  = List.of(
                "IRON",   "BED" , "BED_BLOCK" ,"CACTUS" , "BRICK_STAIRS" , "BIRCH_WOOD_STAIRS" ,"BREWING_STAND", "CAKE", "CAKE_BLOCK" ,"CAULDRON", "CHEST" ,"CLAY" ,"SAND" ,"BURNING_FURNACE"
                ,"COBBLESTONE_STAIRS" , "FENCE" , "FENCE_GATE" , "FIRE" , "GRAVEL" , "IRON_DOOR_BLOCK" , "IRON_FENCE" , "IRON_DOOR" , "LADDER" , "MELON" , "LEAVES" , "LOCKED_CHEST",  "SANDSTONE_STAIRS"

        );
        Scanner lector = new Scanner(System.in);
        for (int i = 0; i < 3 ; i++) {
            String usuario = lector.nextLine();
            if (blockOptions.contains(usuario)){
                int index = (blockOptions.indexOf(usuario));
                System.out.println("La palabra que ha introducido existe dentro de la lista y su procedimiento es PROCEDIMIENTO PARA " + (index+1));
            }else {
                System.out.println("La palabra que ha introducido no existe dentro de la lista, y por ello no tiene procedimiento");
            }
        }



    }
}


