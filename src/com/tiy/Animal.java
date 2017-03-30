package com.tiy;

import java.time.LocalDate;

/**
 * Created by josh on 3/24/17.
 */
public class Animal {

	private String name;
	private String species;
	private String breed;
	private String description;

	public Animal(String name, String species, String breed, String description) {
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getSpecies() {
		return species;
	}

	public String getBreed() {
		return breed;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}




