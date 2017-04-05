package com.tiy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.*;

/**
 * Created by josh on 4/3/17.
 */
public class AnimalRepositoryTest {
	private String jdbcURL = "jdbc:h2:mem:animalshelter";
	private Connection conn;
	private AnimalRepository repository;

	@Before
	public void before(){
		try{
			conn = DriverManager.getConnection(jdbcURL+";INIT=RUNSCRIPT FROM 'classpath:./animalshelter.sql'");
			repository = new AnimalRepository(jdbcURL);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	@Test
	public void listSpeciesTest() throws SQLException {

		assertThat(repository.getListOfSpecies().get(0), equalTo("Cat"));
		assertThat(repository.getListOfSpecies().get(1), equalTo("Dog"));

	}

	@Test
	public void checkCreationOfAnimal(){
		Animal animal = new Animal(0,
				"Bob",
				"Cat",
				"c",
				3,
				"Male",
				"oye",
				LocalDate.now()

		);
		repository.addAnimal(animal);
		assertThat(repository.getAnimalByName("bob").getName(),equalTo("Bob"));
		assertThat(repository.getAnimalByName("bob").getId(),equalTo(3));

	}
	@Test
	public void checkBreedExists(){
		boolean r = repository.checkForBreed("WildCat","cat");
		assertThat(r,equalTo(false));
		r = repository.checkForBreed("Maine coon","cat");
		assertThat(r,equalTo(true));
	}
	@Test
	public void checkSpeciesExists(){
		boolean r = repository.checkForSpecies("Monkey");
		assertThat(r,equalTo(false));

		r = repository.checkForSpecies("Cat");
		assertThat(r,equalTo(true));
	}

	@Test
	public void testShowAllAnimals(){
		Animal animal = new Animal(0,
				"Bob",
				"Cat",
				"Maine Coon",
				3,
				"Male",
				"oye",
				LocalDate.now()

		);
		repository.addAnimal(animal);

		assertThat(repository.listAnimals().get(2).getName(),equalTo("Bob"));
	}

	@Test
	public void testGetAnimalByName(){
		assertThat(repository.getAnimalByName("leo").getName(),equalTo("Leo"));
	}

	@Test
	public void testDeletionOfAnimal(){
		Animal animal = new Animal(0,
				"Bob",
				"Cat",
				"Maine Coon",
				3,
				"Male",
				"oye",
				LocalDate.now()
		);
		repository.addAnimal(animal);
		assertThat(repository.getAnimalByName("bob").getName(),equalTo("Bob"));
		assertThat(repository.getAnimalByName("bob").getId(),equalTo(3));
		animal = repository.getAnimalByName("bob");
		repository.deleteAnimal(animal);

	}

	@Test
	public void testUpdatingAnimal(){
		Animal animal = new Animal(0,
				"Bob",
				"Cat",
				"Maine Coon",
				3,
				"Male",
				"oye",
				LocalDate.now()
		);
		repository.addAnimal(animal);
		assertThat(repository.getAnimalByName("bob").getId(),equalTo(3));
		assertThat(repository.getAnimalByName("bob").getName(),equalTo("Bob"));
		assertThat(repository.getAnimalByName("bob").getSpecies(),equalTo("Cat"));
//		assertThat(repository.getAnimalByName("bob").getBreed(),equalTo("Maine Coon"));

		animal.setName("Larry");
		animal.setSpecies("Dog");
		animal.setBreed("Wolfing kind");
		animal.setAge(6);
		animal.setGender("Female");
		animal.setDescription("Loves to run");
		repository.updateAnimal(animal);
		assertThat(repository.getAnimalByName("Larry").getId(),equalTo(3));
		assertThat(repository.getAnimalByName("Larry").getName(),equalTo("Larry"));
		assertThat(repository.getAnimalByName("Larry").getSpecies(),equalTo("Dog"));
		assertThat(repository.getAnimalByName("Larry").getBreed(),equalTo("Wolfing kind"));
		assertThat(repository.getAnimalByName("Larry").getAge(),equalTo(6));
//		assertThat(repository.getAnimalByName("Larry").getDescription(),equalTo("Loves to run"));

	}

	@After
	public void after(){

		try {
			Statement stmt = conn.createStatement();
			stmt.execute("shutdown");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
