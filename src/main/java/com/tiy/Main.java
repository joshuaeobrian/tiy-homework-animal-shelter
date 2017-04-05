package com.tiy;


import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String jdbcURL;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[\n]");
        AnimalService service = new AnimalService();
        MenuService menuService = new MenuService(scanner);
        while(true){

            int userChoice = menuService.promptForMainMenu();

            if(userChoice== menuService.LIST_ANIMALS){
                menuService.listAnimals(service.getAnimals());
               // menuService.pause();
            }else if(userChoice == menuService.CREATE_ANIMAL){
                System.out.println("\n-- Create Animal --\n");
                System.out.println("\nPlease answer the following questions.\n");
                Animal animal = new Animal(0,menuService.waitForString("Animal Name: ",true),
                        menuService.waitForString("Species: ",true),
                        menuService.waitForString("Breed (optional): ",false),
                        menuService.waitForInt("Age: "),
                        menuService.waitForString("Gender: ",true),
                        menuService.waitForString("Description: ",true),
                        LocalDate.now()
                        );
                service.addAnimal(animal);
                    System.out.println("\nSuccess: The animal has been created!");

            }else if(userChoice ==menuService.VIEW_ANIMAL){
                Animal animal =  menuService.promptSearchForAnimal("View Details Menu",service.getAnimals());
                menuService.showDetailsOfAnimal(animal);
               // menuService.pause();

            }
            else if(userChoice==menuService.EDIT_ANIMAL){
                Animal animal =  menuService.promptSearchForAnimal("Edit Animal",service.getAnimals());
                menuService.updateAnimal(animal);
                menuService.showDetailsOfAnimal(animal);
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
