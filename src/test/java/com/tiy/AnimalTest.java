package com.tiy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by josh on 3/28/17.
 */
public class AnimalTest {

	@Test
	public void creationOfAnimalConstructor() throws Exception {

		Animal animal = new Animal(0,"Bob", "Cat", "",2,"","",null);
	}

	@Test
	public void creationOfAnimalName() throws Exception {

		Animal animal = new Animal(0,"Bob", "Cat", "",2,"","",null);
		assertThat(animal.getName().toLowerCase(), equalTo("bob"));
	}

	@Test
	public void creationOfAnimalSpecies() throws Exception {

		Animal animal = new Animal(0,"Bob", "Cat", "",2,"","",null);
		assertThat(animal.getSpecies().toLowerCase(), equalTo("cat"));
	}

	@Test
	public void creationOfAnimalBreed() throws Exception {

		Animal animal = new Animal(0,"Bob", "Cat", "",2,"","exceptional breed",null);
		assertThat(animal.getBreed().toLowerCase(), equalTo("exceptional breed"));
	}

	@Test
	public void creationOfAnimalDescription() throws Exception {

		Animal animal = new Animal(0,"Bob", "Cat", "",12, "","fat and fluffy",null);
		assertThat(animal.getDescription().toLowerCase(), equalTo("fat and fluffy"));
	}

	@Test
	public void settingValueToName(){
		Animal animal = new Animal(0,"", "", "",0,"","",null);
		animal.setName("bob");
		assertThat(animal.getName(),equalTo("bob"));
	}

	@Test
	public void settingValueToSpecies(){
		Animal animal = new Animal(0,"", "", "",0,"","",null);
		animal.setSpecies("cat");
		assertThat(animal.getSpecies(),equalTo("cat"));
	}

	@Test
	public void settingValueToBreed(){
		Animal animal = new Animal(0,"", "", "",0,"","",null);
		animal.setBreed("Mut");
		assertThat(animal.getBreed(),equalTo("Mut"));

	}

	@Test
	public void settingValueToDescription(){
		Animal animal = new Animal(0,"", "", "",0,"","",null);
		animal.setDescription("Likes to drink water");
		assertThat(animal.getDescription(),equalTo("Likes to drink water"));
	}
}
