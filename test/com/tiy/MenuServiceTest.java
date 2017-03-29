package com.tiy;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by josh on 3/28/17.
 */
public class MenuServiceTest {
	private ByteArrayOutputStream outputStream;
	@Before
	public void before(){
		this.outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
	}
	@Test
	public void testForPublicStaticFinalProperties(){
		String input = "";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);

		int list = menuService.LIST_ANIMALS;
		int create = menuService.CREATE_ANIMAL;
		int view = menuService.VIEW_ANIMAL;
		int edit = menuService.EDIT_ANIMAL;
		int del = menuService.DELETE_ANIMAL;
		int quit = menuService.QUIT;

		assertThat(list,equalTo(1));
		assertThat(create,equalTo(2));
		assertThat(view,equalTo(3));
		assertThat(edit,equalTo(4));
		assertThat(del,equalTo(5));
		assertThat(quit,equalTo(6));
	}

	@Test
	public void testMenuServiceConstructor(){
		String input = "1";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
	}

	@Test
	public void testWaitForIntReturn(){
		String input = "1";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
		int response = menuService.waitForInt("Prompt For Option: ");

		assertThat(outputStream.toString(), containsString("Prompt For Option: "));
		assertThat(response, equalTo(1));

	}
	@Test
	public void testWaitForStringOutputAndReturn(){
		String input = "Bob";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
		String response = menuService.waitForString("%nPlease type a name: ");

		assertThat(outputStream.toString(),containsString("Please type a name:"));
		assertThat(response,equalTo("Bob"));

	}

	@Test
	public void checkYesOrNoReturnTrue(){
		String input = "yes";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
		boolean response = menuService.isYesOrNo("Would you like to exit(yes/no): ");
		assertThat(outputStream.toString(),containsString("Would you like to exit(yes/no):"));
		assertThat(response,equalTo(true));
	}

	@Test
	public void checkYesOrNoReturnFalse(){
		String input = "no";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
		boolean response = menuService.isYesOrNo("Would you like to exit(yes/no): ");
		assertThat(outputStream.toString(),containsString("Would you like to exit(yes/no):"));
		assertThat(response,equalTo(false));
	}
	@Test
	public void testPromptForMenu(){
		String input = "3";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);

		int response = menuService.promptForMainMenu();

		assertThat(outputStream.toString(), containsString("-- Main Menu --"));
		assertThat(outputStream.toString(), containsString("1) List animals"));
		assertThat(outputStream.toString(), containsString("2) Create an animal"));
		assertThat(outputStream.toString(), containsString("3) View animal details"));
		assertThat(outputStream.toString(), containsString("4) Edit an animal"));
		assertThat(outputStream.toString(), containsString("5) Delete an animal"));
		assertThat(outputStream.toString(), containsString("6) Quit"));
		assertThat(response, equalTo(3));
	}

	@Test
	public void testShowListOfAnimalsCheckHeader(){
		String input = "";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Animal("",
				"",
				"",
				""));

		menuService.listAnimals(animals);

		assertThat(outputStream.toString(),containsString("-- List Animals --"));
	}
	@Test
	public void testShowListOfAnimals(){
		String input = "";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Bob",
				"Cat",
				"na",
				"Just really fat"));

		menuService.listAnimals(animals);

		assertThat(outputStream.toString(),containsString("-- List Animals --"));
		assertThat(outputStream.toString(),containsString("1)"));
		assertThat(outputStream.toString(),containsString("Bob"));
		assertThat(outputStream.toString(),containsString("Cat"));
	}

	@Test
	public void testShowingOfAnimalDetails(){
		String input = "" ;
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
		Animal animal = new Animal("Bob",
									"Cat",
									"N/A",
									"Fat and likes to Eat.");
		menuService.showDetailsOfAnimal(animal);

		assertThat(outputStream.toString(),containsString("Name:"));
		assertThat(outputStream.toString(),containsString(animal.getName()));
		assertThat(outputStream.toString(),containsString("Species:"));
		assertThat(outputStream.toString(),containsString(animal.getSpecies()));
		assertThat(outputStream.toString(),containsString("Breed:"));
		assertThat(outputStream.toString(),containsString(animal.getBreed()));
		assertThat(outputStream.toString(),containsString("Description"));
		assertThat(outputStream.toString(),containsString(animal.getDescription()));

	}





}
