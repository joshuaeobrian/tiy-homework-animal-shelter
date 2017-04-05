package com.tiy;

import java.time.LocalDate;

/**
 * Created by josh on 3/24/17.
 */
public class Animal {
	private int id;
	private String name;
	private String species;
	private String breed;
	private int age;
	private String gender;
	private String description;
	private LocalDate dateReceived;
	private LocalDate dateRelease;

	public Animal(int id, String name, String species, String breed, int age, String gender, String description, LocalDate dateReceived) {
		this.id = id;
		this.name = name;
		this.species = species;
		this.breed = breed;
		this.age = age;
		this.gender = gender;
		this.description = description;
		this.dateReceived = dateReceived;
		this.dateRelease = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(LocalDate dateReceived) {
		this.dateReceived = dateReceived;
	}

	public LocalDate getDateRelease() {
		return dateRelease;
	}

	public void setDateRelease(LocalDate dateRelease) {
		this.dateRelease = dateRelease;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}




