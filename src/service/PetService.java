package service;

import entities.Pet;
import entities.TYPE;
import utils.Utils;

import java.security.DigestException;
import java.util.ArrayList;
import java.util.Scanner;

public class PetService {
    Utils utils = new Utils();
    public void inputInfo(Scanner scanner, ArrayList<Pet> pets){
        String answer="";
        do {
            Pet pet =new Pet();
            System.out.println("Mời nhập tên:");
            pet.setName(scanner.nextLine());
            System.out.println("Mời nhập giống loài:");
            pet.setSpecies(scanner.nextLine());
            System.out.println("Mời nhập tuổi:");
            pet.setAge(utils.inputInt(scanner));
            System.out.println("Mời nhập giới tính:");
            pet.setSex(scanner.nextLine());
            System.out.println("Mời nhập mô tả:");
            pet.setDescription(scanner.nextLine());
            System.out.println("Mời nhập loại:");
            System.out.println("1 - Chó");
            System.out.println("2 - Mèo");
            int select=utils.inputInt(scanner);
            switch (select){
                case 1:
                    pet.setTYPE(TYPE.DOG);
                    break;
                case 2:
                    pet.setTYPE(TYPE.CAT);
                    break;
            }
            System.out.println("Mời nhập hình ảnh:");
            pet.setImages(scanner.nextLine());
            pets.add(pet);
            System.out.println("Bạn muốn nhập nữa k:");
            answer=scanner.nextLine();
        }while (answer.equalsIgnoreCase("Y"));
    }

    public void match(Scanner scanner, ArrayList<Pet> pets){
        System.out.println("Mời bạn nhập id:");
        int id=utils.inputInt(scanner);
        for (Pet pet:pets){
           if (id==pet.getId()){
               for (Pet pet1:pets){
                   if (pet.getTYPE().equals(pet1.getTYPE()) && !pet.getSex().equalsIgnoreCase(pet1.getSex())){
                       System.out.println(pet1);
                       System.out.println("Bạn có muốn tìm chú pet khác k?(Y/N) ");
                       String select=scanner.nextLine();
                       if (select.equalsIgnoreCase("N")) break;
                   }
               }
               break;
           }
        }
    }
}
