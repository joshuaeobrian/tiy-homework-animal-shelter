package com.tiy;

import com.sun.xml.internal.bind.v2.TODO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Animal> animals = new ArrayList<>();
    private static LocalDate date;



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[\n]");
        MenuService menuService = new MenuService(scanner);
        loadAnimalsForTesting();


        while(true){
            try {
                int action = menuService.promptForMainMenu();
                //List Animals
                if (action == menuService.LIST_ANIMALS) {
                    menuService.showAnimals(listAnimals());
                }
                //Creates a New Animal
                else if (action == menuService.CREATE_ANIMAL) {
                    System.out.println("\n-- Create an Animal --\n");
                    createAnimal(
                            //Prompts for Animal Name
                            menuService.waitForString("%nAnimal Name: ",true),
                            //Prompts for Animal species
                            menuService.waitForString("%nSpecies: ",true),
                            //Prompts for Animal breed
                            menuService.waitForString("%nBreed (Optional): ",false),
                            //Prompts for Animal age
                            menuService.waitForInt("%nAge: "),
                            //Inserts creation date
                            menuService.getDate(),
                            //Prompts for Animal description
                            menuService.waitForString("%nDescription: ",true));

                }
                //View Animal by Proper ID
                else if (action == menuService.VIEW_ANIMAL_DETAIL) {
                    //prints out animal detail
                    menuService.animalDetails(
                            //gets animal from array
                            getAnimal(
                                    //gets a number
                                    menuService.waitForInt("%nWhat is the numeric ID of the animal you want to view?: ")
                            ));

                }
                //TODO: Add the ability to edit a Animal
                else if (action == menuService.EDIT_ANIMAL) {

                }
                //deletes animal
                else if (action == menuService.DELETE_ANIMAL) {
                    System.out.println("\n-- Delete an Animal --\n");
                    //Looping around like a loop ninja
                    while(true){
                        //get index
                        int index  = menuService.waitForInt("%nWhat is the numeric ID of the animal you want to delete?: ");
                        //get animal
                        Animal animal = getAnimal(index);
                        //if null re ask questions
                        if(animal == null){
                            continue;
                        }
                        //print out animal details
                        else{
                            menuService.animalDetails(animal);
                            //ask user if they are sure they want to delete if yes it returns true and deletes then breaks the loop
                            if(menuService.getYesOrNo("%nAre you sure you would like to delete this Animal(y/n or yes/no): ")){
                                removeAnimal(index);
                                break;
                            }
                        }
                    }
                }
                //Quits App
                else if (action == menuService.QUIT) {
                    break;
                }
                //If invalid number prints out invalid
                else {
                    System.out.println("Error: Sorry, that isn't a valid option.");
                }

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
//Replacement of animalService

    private static void loadAnimalsForTesting(){
        animals.add(new Animal("Spot","Dog", "Mut", 3,
                date.now(),"black dog with White spots."));
		animals.add(new Animal("Spot","Dog", "Mut", 3,
				date.now(),"black dog with White spots."));
		animals.add(new Animal("bob","cat", "Mut", 3,
				date.now(),"black dog with White spots."));
		animals.add(new Animal("Spot","Dog", "Mut", 3,
				date.now(),"black dog with White spots."));
		animals.add(new Animal("bob","Dog", "Mut", 3,
				date.now(),"black dog with White spots."));
		animals.add(new Animal("Spot","Dog", "Mut", 3,
				date.now(),"black dog with White spots."));
		animals.add(new Animal("bob","lizard", "Mut", 3,
				date.now(),"black dog with White spots."));

		animals.add(new Animal("Spot","bird", "Mut", 3,
				date.now(),"black dog with White spots."));
    }

    public static ArrayList<Animal> listAnimals(){
        return animals;
    }
    //todo Figure out some recursion or another loop maybe move the try catch
    public static Animal getAnimal(int index){
        if(index < animals.size() && index >= 0){
            return animals.get(index);
        }else{
//            throw new Exception("Sorry, try again there is no animal with that ID.");
            System.out.println("Sorry, try again there is no animal with that ID.");
            return null;
        }

    }

    public static void createAnimal(String name, String species, String breed,int age,LocalDate dateReceived, String description){

        animals.add(new Animal(name,species,breed,age,dateReceived,description));

    }

    public static void removeAnimal(int index){
        animals.remove(index);
    }

}
