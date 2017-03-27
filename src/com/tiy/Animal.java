package com.tiy;

import java.time.LocalDate;

/**
 * Created by josh on 3/24/17.
 */
public class Animal {
	private String name;
	private String species;
	private String breed;
	private int age;
	private LocalDate dayReceived;
	private String description;

	public Animal(String name, String species, String breed,int age, LocalDate dayReceived, String description) {
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.age = age;
		this.dayReceived = dayReceived;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getDayReceived() {
		return dayReceived;
	}

	public void setDayReceived(LocalDate dayReceived) {
		this.dayReceived = dayReceived;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
