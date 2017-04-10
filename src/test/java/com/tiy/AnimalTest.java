package com.tiy;

import org.junit.Test;

import java.time.LocalDate;

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

		Animal animal = new Animal(0,"Bob", "Cat", "exceptional breed",2,"Male","", LocalDate.now());
		assertThat(animal.getBreed(), equalTo("exceptional breed"));
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
	@Test
	public void getValueOfID(){
		Animal animal = new Animal(3,"Bob", "cat", "mut",0,"male","likes to eat",LocalDate.now());

		assertThat(animal.getId(),equalTo(3));
		assertThat(animal.getDateReceived(),equalTo(LocalDate.now()));
	}
	@Test
	public void getValueOfAge(){
		Animal animal = new Animal(3,"Bob", "cat", "mut",1,"male","likes to eat",LocalDate.now());

		assertThat(animal.getAge(),equalTo(1));
		assertThat(animal.getDateReceived(),equalTo(LocalDate.now()));
	}
	@Test
	public void getValueOfGender(){
		Animal animal = new Animal(3,"Bob", "cat", "mut",0,"male","likes to eat",LocalDate.now());

		assertThat(animal.getGender(),equalTo("male"));
		assertThat(animal.getDateReceived(),equalTo(LocalDate.now()));
	}
	@Test
	public void getValueOfDateReceived(){
		Animal animal = new Animal(3,"Bob", "cat", "mut",0,"male","likes to eat",LocalDate.now());


		assertThat(animal.getDateReceived(),equalTo(LocalDate.now()));
	}

	@Test
	public void setValueOfID(){
		Animal animal = new Animal(3,"Bob", "cat", "mut",0,"male","likes to eat",LocalDate.now());
		animal.setId(4);
		assertThat(animal.getId(),equalTo(4));
		assertThat(animal.getDateReceived(),equalTo(LocalDate.now()));
	}
	@Test
	public void setValueOfAge(){
		Animal animal = new Animal(3,"Bob", "cat", "mut",1,"male","likes to eat",LocalDate.now());
		animal.setAge(5);
		assertThat(animal.getAge(),equalTo(5));
		assertThat(animal.getDateReceived(),equalTo(LocalDate.now()));
	}
	@Test
	public void setValueOfGender(){
		Animal animal = new Animal(3,"Bob", "cat", "mut",0,"male","likes to eat",LocalDate.now());
		animal.setGender("Female");
		assertThat(animal.getGender(),equalTo("Female"));
		assertThat(animal.getDateReceived(),equalTo(LocalDate.now()));
	}
	@Test
	public void setValueOfDateReceived(){
		Animal animal = new Animal(3,"Bob", "cat", "mut",0,"male","likes to eat",LocalDate.now());

		animal.setDateReceived(LocalDate.parse("2017-01-01"));

		assertThat(animal.getDateReceived(),equalTo(LocalDate.parse("2017-01-01")));
	}

	@Test
	public void setValueOfDateRelease(){
		Animal animal = new Animal(3,"Bob", "cat", "mut",0,"male","likes to eat",LocalDate.now());

		animal.setDateRelease(LocalDate.parse("2017-01-01"));

		assertThat(animal.getDateRelease(),equalTo(LocalDate.parse("2017-01-01")));
	}
}
