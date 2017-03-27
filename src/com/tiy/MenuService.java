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
	public static final int VIEW_ANIMAL_DETAIL = 3;
	public static final int EDIT_ANIMAL = 4;
	public static final int DELETE_ANIMAL =5;
	public static final int QUIT = 6;
	//Search by options
	public static final int SEARCH_BY_ID = 1;
	public static final int SEARCH_BY_NAME = 2;
	private Scanner scanner;
	private String textAlign = " %-15s  %-9s %n";

	public MenuService(Scanner scanner) {
		this.scanner = scanner;
	}
	//prompts menu options
	public int promptForMainMenu(){
		System.out.println("\n-- Main Menu --\n" +
				"\n" +
				" 1) List animals\n" +
				" 2) Create an animal\n" +
				" 3) View animal details\n" +
				" 4) Edit an animal\n" +
				" 5) Delete an animal\n" +
				" 6) Quit\n");
		return waitForInt("Please choose an option: ");
	}
	//shoes a list of animals in a array with number
	public void showAnimals(ArrayList<Animal> animals){
		System.out.println("\n-- List Of Animals --\n");
		for(int i = 0; i < animals.size(); i++){
			System.out.format(textAlign,(i+1)+") "+animals.get(i).getName(),
					animals.get(i).getSpecies());
		}
		if(animals.isEmpty()){
			System.out.println("Sorry there are no animals.");
		}
	}
	public int promptViewAnimalDetailMenu(){
		System.out.println("\n-- View Details Menu --\n"+
				"\n1) Lookup by ID" +
				"\n2) Lookup by Name\n");

		return waitForInt("Please choose an option: ");
	}
	//displays names in hashmap with ids
	public int displayViewByName(HashMap<Integer,Animal> animalsWithName){
		Iterator iterator = animalsWithName.entrySet().iterator();
		while(iterator.hasNext()){
			HashMap.Entry entry = (HashMap.Entry) iterator.next();
			System.out.format(textAlign,String.format("%s) %s",entry.getKey(),animalsWithName.get(entry.getKey()).getName()),animalsWithName.get(entry.getKey()).getSpecies());
		}
		return waitForInt("%nPlease choose an the proper ID for the Animal with this Name: ");
	}
	//displays animal details
	public void animalDetails(Animal animal){
		System.out.println();
		System.out.format(textAlign,"Name: " ,animal.getName());
		System.out.format(textAlign,"Specie: " ,animal.getSpecies());
		System.out.format(textAlign,"Breed: " ,animal.getBreed());
		System.out.format(textAlign,"Age: " ,animal.getAge());
		System.out.format(textAlign,"Description: " ,animal.getDescription());
		System.out.format(textAlign,"Date Received: " ,animal.getDayReceived());
	}
	// gets int response from prompt and returns it
	public int waitForInt(String prompt){
		System.out.printf(prompt);
		//if its not a integer than print error and try again
		if(!scanner.hasNextInt()){
			String badInput = scanner.next();
			System.out.printf("%nError: %s is invalid option.%n",badInput);

			return waitForInt(prompt);
		}else{
			return scanner.nextInt();
		}
	}
	//Gets a String response from prompt
	public String waitForString(String prompt, boolean required){
		System.out.printf(prompt);
		String input = scanner.next();
		if(required == true && input.isEmpty()){
			System.out.println("This field must be filled out...");
			return waitForString(prompt,required);
		}else{
			return input;
		}
	}
	//Gets current date
	public LocalDate getDate(){
		return LocalDate.now();
	}
	//Controls Yes or no prompt returns true if yes or y
	public boolean getYesOrNo(String prompt) {
		String input = waitForString(prompt,false);
		if(input.toLowerCase().equals("y")||input.toLowerCase().equals("yes")){
			return true;
		}else if(input.toLowerCase().equals("n")||input.toLowerCase().equals("no")){
			return false;
		} else{
			System.out.println("Needs to be (yes / no) or (y / n)");
			return getYesOrNo(prompt);
		}
	}

	public void pause(){
		waitForString("%nPress ENTER to continue: ",false);
	}
}
