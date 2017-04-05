package com.tiy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by josh on 3/24/17.
 */
public class MenuService {


	public static final int LIST_ANIMALS = 1;
	public static final int CREATE_ANIMAL = 2;
	public static final int VIEW_ANIMAL = 3;
	public static final int EDIT_ANIMAL = 4;
	public static final int DELETE_ANIMAL = 5;
	public static final int QUIT = 6;
	public static final int SEARCH_BY_ID = 1;
	public static final int SEARCH_BY_NAME = 2;
	private String textAlign = " %-15s  %-9s %n";

	private Scanner scanner;

	public MenuService(Scanner scanner) {
		this.scanner = scanner;
	}

	public int promptForMainMenu(){
		System.out.println("\n-- Main Menu --\n" +
				"\n" +
				" 1) List animals\n" +
				" 2) Create an animal\n" +
				" 3) View animal details\n" +
				" 4) Edit an animal\n" +
				" 5) Delete an animal\n" +
				" 6) Quit");
		return waitForInt("Please choose an option: ");
	}

	public int waitForInt(String prompt) {
		System.out.printf("%n%s",prompt);
		if(!scanner.hasNextInt()){
			String badInput = scanner.next();
			System.out.printf("%nSorry, %s is a invalid option.",badInput);
			return waitForInt(prompt);
		}else{
			return scanner.nextInt();
		}
	}
	public Animal promptSearchForAnimal(String menuHeader,ArrayList<Animal> animals){
		System.out.printf("%n%n-- %s --%n"+
				"%n1) Lookup by ID" +
				"%n2) Lookup by Name%n",menuHeader);
		Animal animal = null;
		int response  = waitForInt("Please choose an option: ");
		if(response == SEARCH_BY_ID){
			animal = animals.get(waitForInt("What is the numeric ID of the animal you want to view?: "));
		}else if(response == SEARCH_BY_NAME){
			animal = viewAnimalByName(animals,"%nPlease enter a name you would like to search: ");
		}else{
			System.out.println("Sorry, invalid option. Try again...");
			return promptSearchForAnimal(menuHeader, animals);
		}
		return animal;
	}

	public Animal viewAnimalByName(ArrayList<Animal>animals,String prompt){

		int animalCount=0;
		String name = waitForString(prompt,false);
		for(int i = 0; i < animals.size();i++){
			Animal animal = animals.get(i);
			if(name.toLowerCase().equals(animal.getName().toLowerCase())){
				animalCount++;
				System.out.format(textAlign,animal.getId()+") "+animal.getName(),animal.getSpecies());
			}
		}

		if(animalCount == 0){
			System.out.println("Sorry, there are no animals with that name.\nPlease try again...");
			return viewAnimalByName(animals,waitForString(prompt,true));
		}else{

			return animals.get(waitForInt("What is the numeric ID of the animal you want to view?: ")-1);
		}
	}

	public String waitForString(String prompt, boolean required) {
		System.out.printf(prompt);
		String input = scanner.next();
		if(required && input.isEmpty()){
			System.out.println("This field must be filled out...");
			return waitForString(prompt,required);
		}else{
			return input;
		}
	}

	public boolean isYesOrNo(String prompt) {
		String response = waitForString(prompt,false);
		if(response.toLowerCase().equals("y")||response.toLowerCase().equals("yes")){
			return true;
		}else if(response.toLowerCase().equals("n")||response.toLowerCase().equals("no")){
			return false;
		}else{
			System.out.printf("%n is a invalid option please type (yes/no or y/n).");
			return isYesOrNo(prompt);
		}
	}

	public void listAnimals(ArrayList<Animal> animals) {
		System.out.println("\n-- List Animals --\n");
		for(int index = 0; index < animals.size();index++){
			Animal animal = animals.get(index);
			System.out.format(textAlign,animal.getId()+") "+animal.getName(), animal.getSpecies());

		}
	}

	public void showDetailsOfAnimal(Animal animal) {
		System.out.println();
		System.out.format(textAlign,"Name:",animal.getName());
		System.out.format(textAlign,"Species:",animal.getSpecies());
		System.out.format(textAlign,"Breed:",animal.getBreed());
		System.out.format(textAlign,"Description:",animal.getDescription());

	}
	public Animal updateAnimal(Animal animal){

		String input = "";
		input = waitForString(String.format("Name [%s]: ",animal.getName()),false);
		if(!input.isEmpty()){
			animal.setName(input);
		}
		input = waitForString(String.format("Species [%s]: ",animal.getSpecies()),false);
		if(!input.isEmpty()){
			animal.setSpecies(input);
		}
		input = waitForString(String.format("Breed [%s]: ",animal.getBreed()),false);
		if(!input.isEmpty()){
			animal.setBreed(input);
		}
		input = waitForString(String.format("Description [%s]: ",animal.getDescription()),false);
		if(!input.isEmpty()){
			animal.setDescription(input);
		}
		return animal;
	}
	public void pause(){
		waitForString("Press ENTER when ready to continue...",false);
	}
}
