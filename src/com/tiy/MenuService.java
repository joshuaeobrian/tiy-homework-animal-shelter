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
	private Scanner scanner;
	private String textAlign = " %-15s  %-9s %n";

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
				" 6) Quit\n");
		return waitForInt("Please choose an option: ");
	}
	public void showAnimals(ArrayList<Animal> animals){
		System.out.println("\n-- List Of Animals --\n");
		for(int i = 0; i < animals.size(); i++){
			System.out.format(textAlign,(i+1)+") "+animals.get(i).getName(),
					animals.get(i).getSpecies());
		}
	}
	public int promptViewAnimalDetailMenu(){
		System.out.println("\n-- View Details Menu --\n"+
				"\n1) Lookup by ID" +
				"\n2) Lookup by Name\n");

		return waitForInt("Please choose an option: ");
	}

	public int DisplayViewByName(HashMap<Integer,Animal> animalsWithName){
		Iterator iterator = animalsWithName.entrySet().iterator();
		while(iterator.hasNext()){
			HashMap.Entry entry = (HashMap.Entry) iterator.next();
			System.out.format(textAlign,String.format("%s) %s",entry.getKey(),animalsWithName.get(entry.getKey()).getName()),animalsWithName.get(entry.getKey()).getSpecies());
		}

		return waitForInt("%nPlease choose an the proper ID for the Animal with this Name: ");
	}

	public void animalDetails(Animal animal){
		System.out.println();
		System.out.format(textAlign,"Name: " ,animal.getName());
		System.out.format(textAlign,"Specie: " ,animal.getSpecies());
		System.out.format(textAlign,"Breed: " ,animal.getBreed());
		System.out.format(textAlign,"Age: " ,animal.getAge());
		System.out.format(textAlign,"Description: " ,animal.getDescription());
		System.out.format(textAlign,"Date Received: " ,animal.getDayReceived());

	}

	public int waitForInt(String prompt){
		System.out.printf(prompt);

		if(!scanner.hasNextInt()){
			String badInput = scanner.next();
			System.out.printf("%nError: %s is invalid option.%n",badInput);

			return waitForInt(prompt);
		}else{
			return scanner.nextInt();
		}
	}

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
	public LocalDate getDate(){
		return LocalDate.now();
	}

	public boolean getYesOrNo(String prompt) {
		String input = waitForString(prompt,false);
		if(input.toLowerCase().equals("y")||input.toLowerCase().equals("yes")){
			return true;
		}else if(input.toLowerCase().equals("n")||input.toLowerCase().equals("no")){
			return false;
		} else{
			return getYesOrNo(prompt);
		}
	}
}
