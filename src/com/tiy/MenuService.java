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
				" 6) Quit\n");
		return waitForInt("Please choose an option: ");
	}

	public int waitForInt(String prompt) {
		System.out.printf(prompt);
		if(!scanner.hasNextInt()){
			String badInput = scanner.next();
			System.out.printf("%nSorry, %s is a invalid option.",badInput);
			return waitForInt(prompt);
		}else{
			return scanner.nextInt();
		}
	}

	public String waitForString(String prompt) {
		System.out.printf(prompt);
		return scanner.next();
	}

	public boolean isYesOrNo(String prompt) {
		String response = waitForString(prompt);
		if(response.toLowerCase().equals("y")||response.toLowerCase().equals("yes")){
			return true;
		}else if(response.toLowerCase().equals("n")||response.toLowerCase().equals("no")){
			return false;
		}else{
			return isYesOrNo(prompt);
		}
	}

	public void listAnimals(ArrayList<Animal> animals) {
		System.out.println("\n-- List Animals --\n");
		for(int index = 0; index < animals.size();index++){
			System.out.format(textAlign,(index+1)+")"+animals.get(index).getName(),animals.get(index).getSpecies());

		}
	}

	public void showDetailsOfAnimal(Animal animal) {
		System.out.println();
		System.out.format(textAlign,"Name:",animal.getName());
		System.out.format(textAlign,"Species:",animal.getSpecies());
		System.out.format(textAlign,"Breed:",animal.getBreed());
		System.out.format(textAlign,"Description:",animal.getDescription());

	}
}

