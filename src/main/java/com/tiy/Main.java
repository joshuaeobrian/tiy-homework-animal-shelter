package com.tiy;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[\n]");
        AnimalService service = new AnimalService();
        MenuService menuService = new MenuService(scanner);
        while(true){

            int userChoice = menuService.promptForMainMenu();

            if(userChoice== menuService.LIST_ANIMALS){
                menuService.listAnimals(service.getAnimals());
                menuService.pause();
            }else if(userChoice == menuService.CREATE_ANIMAL){

                service.addAnimal(menuService.createAnimal());

            }else if(userChoice ==menuService.VIEW_ANIMAL){
                Animal animal =  menuService.promptSearchForAnimal("View Details Menu",service.getAnimals());
                menuService.showDetailsOfAnimal(animal);
                menuService.pause();
            }
            else if(userChoice==menuService.EDIT_ANIMAL){
                Animal animal =  menuService.promptSearchForAnimal("Edit Animal",service.getAnimals());
                menuService.showDetailsOfAnimal(menuService.updateAnimal(animal));
                service.updateAnimal(animal);
                menuService.pause();
            }
            else if(userChoice==menuService.DELETE_ANIMAL){
                Animal animal =  menuService.promptSearchForAnimal("Delete an Animal",service.getAnimals());
                menuService.showDetailsOfAnimal(animal);
                //ask if you are sure you want to delete the animal
                if(menuService.isYesOrNo("%nAre you sure you want to delete this animal?: ")){
                    service.deleteAnimal(animal);
                    System.out.println("\nSuccess: The animal has been deleted!\n");
                }
            }else if(userChoice==menuService.QUIT){
                System.out.println("Exiting Program... No Data will be saved.");
                break;
            }else{
                System.out.println("Sorry, Invalid option. Please try again.");
            }
        }
    }
}
