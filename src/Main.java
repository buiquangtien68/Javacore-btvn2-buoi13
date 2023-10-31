import entities.Pet;
import service.PetService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        PetService petService = new PetService();
        ArrayList<Pet> pets=new ArrayList<>();
        petService.inputInfo(scanner,pets);
        System.out.println(pets);
        petService.match(scanner,pets);
    }
}
