package com.tiy;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Arrays;

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

		int searchByID = menuService.SEARCH_BY_ID;
		int searchByName = menuService.SEARCH_BY_NAME;

		assertThat(list,equalTo(1));
		assertThat(create,equalTo(2));
		assertThat(view,equalTo(3));
		assertThat(edit,equalTo(4));
		assertThat(del,equalTo(5));
		assertThat(quit,equalTo(6));
		assertThat(searchByID,equalTo(1));
		assertThat(searchByName,equalTo(2));
	}

	@Test
	public void testMenuServiceConstructor(){
		String input = "1";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
	}

	@Test
	public void testWaitForIntReturnOne(){
		String input = "1";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);

		int response = menuService.waitForInt("Prompt For Option: ");

		assertThat(outputStream.toString(), containsString("Prompt For Option: "));
		assertThat(response, equalTo(1));

	}

	@Test
	public void testWaitForIntReturnTwo(){
		String input = "2";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);

		int response = menuService.waitForInt("Prompt For Option: ");

		assertThat(outputStream.toString(), containsString("Prompt For Option: "));
		assertThat(response, equalTo(2));

	}

	@Test
	public void testWaitForIntReturnThree(){
		String input = "3";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);

		int response = menuService.waitForInt("Prompt For Option: ");

		assertThat(outputStream.toString(), containsString("Prompt For Option: "));
		assertThat(response, equalTo(3));

	}

	@Test
	public void testWaitForIntReturnFour(){
		String input = "4";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);

		int response = menuService.waitForInt("Prompt For Option: ");

		assertThat(outputStream.toString(), containsString("Prompt For Option: "));
		assertThat(response, equalTo(4));

	}

	@Test
	public void testWaitForIntReturnFive(){
		String input = "5";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);

		int response = menuService.waitForInt("Prompt For Option: ");

		assertThat(outputStream.toString(), containsString("Prompt For Option: "));
		assertThat(response, equalTo(5));

	}

	@Test
	public void testWaitForIntReturnSix(){
		String input = "6";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);

		int response = menuService.waitForInt("Prompt For Option: ");

		assertThat(outputStream.toString(), containsString("Prompt For Option: "));
		assertThat(response, equalTo(6));

	}

	@Test
	public void testWaitForStringOutputAndReturn(){
		String input = "Bob";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);

		String response = menuService.waitForString("%nPlease type a name: ",false);

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
	public void testSearchMenuOptionOne(){
		ArrayList<Animal> animals = new ArrayList<>();

		animals.addAll(Arrays.asList(
				new Animal(1,"Bob","Cat","",12,"","",null),
				new Animal(2,"Larry","Dog","",12,"","",null),
				new Animal(3,"Mo","Cat","",12,"","",null)));

		ByteArrayInputStream inputStream = new ByteArrayInputStream((
				"1\n" +
						"1\n" +
						"1\n"


		).getBytes());
		System.setIn(inputStream);
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("[\n]");
		MenuService menuService = new MenuService(scanner);

		Animal animal = menuService.promptSearchForAnimal("View Details Menu",animals);
		assertThat(outputStream.toString(),containsString("View Details Menu"));
		assertThat(outputStream.toString(),containsString("Lookup by ID"));
		assertThat(outputStream.toString(),containsString("Lookup by Name"));
		assertThat(animal, equalTo(animals.get(0)));
	}

	@Test
	public void testSearchMenuOptionTwo(){
		ArrayList<Animal> animals = new ArrayList<>();

		animals.addAll(Arrays.asList(
				new Animal(1,"Bob","Cat","",12,"","",null),
				new Animal(2,"Larry","Dog","",12,"","",null),
				new Animal(3,"Mo","Cat","",12,"","",null)));

		ByteArrayInputStream inputStream = new ByteArrayInputStream((
				"2\n" +

						"Bob\n" +
						"1\n"


		).getBytes());
		System.setIn(inputStream);
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("[\n]");
		MenuService menuService = new MenuService(scanner);

		Animal animal = menuService.promptSearchForAnimal("View Details Menu",animals);
//
		assertThat(outputStream.toString(),containsString("View Details Menu"));
		assertThat(outputStream.toString(),containsString("Lookup by ID"));
		assertThat(outputStream.toString(),containsString("Lookup by Name"));
		assertThat(outputStream.toString(),containsString("Please enter a name you would"));
		assertThat(animal, equalTo(animals.get(0)));
	}

	@Test
	public void testSearchByName(){
		ArrayList<Animal> animals = new ArrayList<>();

		animals.addAll(Arrays.asList(
				new Animal(0,"Bob","Cat","",12,"","",null),
				new Animal(0,"Larry","Dog","",12,"","",null),
				new Animal(0,"Mo","Cat","",12,"","",null)));

		ByteArrayInputStream inputStream = new ByteArrayInputStream((
					"Larry\n" +
						"2\n"

		).getBytes());

		System.setIn(inputStream);
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("[\n]");
		MenuService menuService = new MenuService(scanner);
		Animal animal = menuService.viewAnimalByName(animals,"Please Type a name of an animal: ");

		assertThat(animal.getName(), equalTo("Larry"));


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
		animals.add(new Animal(0,"", "", "",0,"","",null));
		menuService.listAnimals(animals);

		assertThat(outputStream.toString(),containsString("-- List Animals --"));
	}

	@Test
	public void testShowListOfAnimals(){
		String input = "";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Animal(1,"Bob",
				"Cat",
				"na",2,
				"","Just really fat",null));

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
		Animal animal = new Animal(0,"Bob",
									"Cat",
									"N/A",12,
				"","Fat and likes to Eat.",null);
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

	@Test
	public void testUpdateOfAnimal(){
		Animal animal = new Animal(0,"Bob","Cat","",12,"","Likes to eat.",null);
		ByteArrayInputStream inputStream = new ByteArrayInputStream((
				"Larry\n" +
						"Dog\n" +
						"Mut\n" +
						"Likes to lick.\n"
		).getBytes());

		System.setIn(inputStream);
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("[\n]");

		MenuService menuService = new MenuService(scanner);

		menuService.updateAnimal(animal);


		assertThat(outputStream.toString(),containsString("Name [Bob]:"));
		assertThat(outputStream.toString(),containsString("Species [Cat]:"));
		assertThat(outputStream.toString(),containsString("Breed []:"));
		assertThat(outputStream.toString(),containsString("Description [Likes to eat.]:"));
		assertThat(animal.getName(),equalTo("Larry"));
		assertThat(animal.getSpecies(),equalTo("Dog"));
		assertThat(animal.getBreed(),equalTo("Mut"));
		assertThat(animal.getDescription(),equalTo("Likes to lick."));
	}
	@Test
	public void testCreatingAnimal(){
		ByteArrayInputStream inputStream = new ByteArrayInputStream((
				"Larry\n" +
						"Dog\n" +
						"Mut\n" +
						"1\n" +
						"male\n" +
						"Likes to lick.\n"
		).getBytes());

		System.setIn(inputStream);
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("[\n]");

		MenuService menuService = new MenuService(scanner);

		Animal animal = menuService.createAnimal();


		assertThat(outputStream.toString(),containsString("Name"));
		assertThat(outputStream.toString(),containsString("Species"));
		assertThat(outputStream.toString(),containsString("Breed"));
		assertThat(outputStream.toString(),containsString("Age"));
		assertThat(outputStream.toString(),containsString("Gender"));
		assertThat(outputStream.toString(),containsString("Description"));
		assertThat(animal.getName(),equalTo("Larry"));
		assertThat(animal.getSpecies(),equalTo("Dog"));
		assertThat(animal.getBreed(),equalTo("Mut"));
		assertThat(animal.getDescription(),equalTo("Likes to lick."));

	}

	@Test
	public void testPause(){
		String input = "1";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);

		menuService.pause();

		assertThat(outputStream.toString(), containsString("Press ENTER when ready to continue..."));

	}

}
