package com.tiy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static ArrayList<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[\n]");
        MenuService menuService = new MenuService(scanner);
        //Main while loop for program
        while(true){
                int action = menuService.promptForMainMenu();
                //List Animals
                if (action == menuService.LIST_ANIMALS) {
                    menuService.showAnimals(listAnimals());
                    menuService.pause();
                }
                //Creates a New Animal
                else if (action == menuService.CREATE_ANIMAL) {
                    System.out.println("\n-- Create an Animal --\n");
                   //Creates new animal
                    createAnimal(
                            //Prompts for Animal Name
                            menuService.waitForString("Animal Name: ",true),
                            //Prompts for Animal species
                            menuService.waitForString("Species: ",true),
                            //Prompts for Animal breed
                            menuService.waitForString("Breed (Optional): ",false),
                            //Prompts for Animal age
                            menuService.waitForInt("Age: "),
                            //Inserts creation date
                            menuService.getDate(),
                            //Prompts for Animal description
                            menuService.waitForString("Description: ",true));
                }
                //View Animal by Proper ID
                else if (action == menuService.VIEW_ANIMAL_DETAIL) {
                    //Looping around like a loop ninja
                    while(true) {
                        Animal animal;
                        int input = menuService.promptViewAnimalDetailMenu();
                        if(input == menuService.SEARCH_BY_ID){
                            //gets animal from array
                            animal = getAnimal(menuService.waitForInt("%nWhat is the numeric ID of the animal you want to view?: "));
                        }else if(input == menuService.SEARCH_BY_NAME){
                            //gets animal id
                            animal = getAnimal(
                                    //displays animal by name with its id from hashmap
                                    menuService.displayViewByName(
                                            //searches array for name and returns hashmap
                                            findByName(
                                                    //gets proper ID then adds one to make up for list view id
                                                    menuService.waitForString("Please type a name: ",false)
                                            )
                                    ) + 1
                            );
                        }else{
                            System.out.println("Sorry, Invalid.");
                            animal = null;
                        }
                        //prints out animal detail
                        if(animal != null){
                            //shows animal details
                            menuService.animalDetails(animal);
                            //breaks loop
                            break;
                        }
                    }
                    //adds pause so you can read data
                    menuService.pause();
                }
                //edit Animal info
                else if (action == menuService.EDIT_ANIMAL) {
                    //Looping around like a loop ninja
                    while(true){
                        //Gets animal
                        Animal animal = getAnimal(menuService.waitForInt("%nWhat is the numeric ID of the animal you want to edit?: "));
                        //if null re ask questions
                        if(animal == null){
                            System.out.println("Sorry, try again there is no animal with that ID.");
                            continue;
                        }
                        //updates and print out animal details
                        else{
                            //update method that update the animal with specific parameters
                            updateAnimal(animal,
                                    menuService.waitForString(String.format("%nName[%s]: ",animal.getName()),false),
                                    menuService.waitForString(String.format("Species[%s]: ",animal.getSpecies()),false),
                                    menuService.waitForString(String.format("Breed[%s]: ",animal.getBreed()),false),
                                    menuService.waitForString(String.format("Description[%s]:",animal.getDescription()),false)
                                    );
                            //displays animal details
                            menuService.animalDetails(animal);
                            //pauses so you can read details
                            menuService.pause();
                            //breaks loop
                            break;
                        }
                    }
                }
                //deletes animal
                else if (action == menuService.DELETE_ANIMAL) {
                    System.out.println("\n-- Delete an Animal --\n");
                    //Looping around like a loop ninja
                    while(true){
                        //get animal
                        Animal animal = getAnimal(menuService.waitForInt("What is the numeric ID of the animal you want to delete?: "));
                        //if null re ask questions
                        if(animal == null){
                            System.out.println("Sorry, try again there is no animal with that ID.");
                            continue;
                        }
                        //print out animal details
                        else{
                            menuService.animalDetails(animal);
                            //ask user if they are sure they want to delete if yes it returns true and deletes then breaks the loop
                            if(menuService.getYesOrNo("%nAre you sure you would like to delete this Animal(y/n or yes/no): ")){
                                //removes animal from loop
                                removeAnimal(animal);
                                System.out.println("Success: The animal has been deleted!");
                                //breaks loop
                                break;
                            }
                        }
                    }
                }
                //Quits App
                else if (action == menuService.QUIT) {
                    //if returns true break main loop
                    if(menuService.getYesOrNo("%nAre you sure you want to quit? All of your data will be lost!: ")){
                        break;
                    }
                }
                //If invalid number prints out invalid
                else {
                    System.out.println("Error: Sorry, that isn't a valid option.");
                }
        }
    }

//Replacement of animalService
    public static ArrayList<Animal> listAnimals(){
        return animals;
    }
    //todo Figure out some recursion or another loop maybe move the try catch
    public static Animal getAnimal(int index){
        index--;
        if(index < animals.size() && index >= 0){
            return animals.get(index);
        }else{
            //prints out to console that the id does not exist in the array then returns null

            return null;
        }
    }

    public static HashMap<Integer,Animal> findByName(String name){
        HashMap<Integer,Animal> searchAnimalByName = new HashMap<>();

        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                searchAnimalByName.put(i,animals.get(i));
            }
        }

        return searchAnimalByName;
    }

    //create a new animal
    public static void createAnimal(String name, String species, String breed,int age,LocalDate dateReceived, String description){
        animals.add(new Animal(name,species,breed,age,dateReceived,description));
    }
    //Removes Animal by index
    public static void removeAnimal( Animal animal){
       //animals.remove(index);
        animals.remove(animal);

    }
    //Updates the Value of the animal if the value is not null or empty
    public static void updateAnimal(Animal animal,String name,String species, String breed, String description){
        if(!name.equals("")){
            animal.setName(name);
        }
        if(!species.equals("")){
            animal.setSpecies(species);
        }
        if(!breed.equals("")){
            animal.setBreed(breed);
        }
        if(!description.equals("")){
            animal.setDescription(description);
        }
    }
}
