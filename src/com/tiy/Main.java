package com.tiy;


import java.util.ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static ArrayList<Animal> animals = new ArrayList<>();



    public static void main(String[] args) {
        animals.addAll(Arrays.asList(
                new Animal("Bob","Cat","",""),
                new Animal("Larry","Dog","",""),
                new Animal("Mo","Cat","","")));
       Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[\n]");

        MenuService menuService = new MenuService(scanner);
        while(true){

            int userChoice = menuService.promptForMainMenu();

            if(userChoice== menuService.LIST_ANIMALS){
                menuService.listAnimals(animals);
            }else if(userChoice == menuService.CREATE_ANIMAL){
                System.out.println("\n-- Create Animal --\n");
                System.out.println("\nPlease answer the following questions.\n");
                animals.add(new Animal(menuService.waitForString("Animal Name: ",true),
                        menuService.waitForString("Species: ",true),
                        menuService.waitForString("Breed (optional): ",false),
                        menuService.waitForString("Description: ",true)));
                System.out.println("\n" +
                        "Success: The animal has been created!");
            }else if(userChoice ==menuService.VIEW_ANIMAL){
                int response = menuService.promptSearchMenu("View Details Menu");
                Animal animal = null;
                if(response == menuService.SEARCH_BY_ID) {
                    animal = animals.get(
                            menuService.waitForInt("What is the numeric ID of the animal you want to view?: ") - 1
                    );

                }
                if(response == menuService.SEARCH_BY_NAME){
                    animal = menuService.viewAnimalByName(animals,"Please enter a name you would like to search: ");
                }
                menuService.showDetailsOfAnimal(animal);

            }
            else if(userChoice==menuService.EDIT_ANIMAL){
                System.out.println("\n-- Edit Animal --\n");
                int index = menuService.waitForInt("What is the numeric ID of the animal you want to Edit?: ");
                //get animal
                Animal animal = animals.get(index-1);
                menuService.updateAnimal(animal);
                menuService.showDetailsOfAnimal(animal);

            }
            else if(userChoice==menuService.DELETE_ANIMAL){
                System.out.println("\n-- Delete an Animal --\n");
                //get animal
                Animal animal = animals.get(menuService.waitForInt("What is the numeric ID of the animal you want to delete?: ")-1);
                menuService.showDetailsOfAnimal(animal);
                //ask if you are sure you want to delete the animal
                if(menuService.isYesOrNo("%nAre you sure you want to delete this animal?: ")){
                    animals.remove(animal);
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
