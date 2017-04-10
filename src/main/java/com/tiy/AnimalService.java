package com.tiy;

import java.util.ArrayList;

/**
 * Created by josh on 4/5/17.
 */
public class AnimalService {
	private AnimalRepository repository;

	public AnimalService(){
		 this.repository  = new AnimalRepository("jdbc:postgresql://localhost:5432/animalshelter");
	}
	public AnimalService(String jdbcUrl){
		this.repository  = new AnimalRepository(jdbcUrl);
	}

	public ArrayList<Animal> getAnimals(){
		return repository.listAnimals();
	}

	public void addAnimal(Animal animal){
		if(animal != null){
			repository.addAnimal(animal);

		}
	}

	public void updateAnimal(Animal animal){
		repository.updateAnimal(animal);
	}

	public void deleteAnimal(Animal animal){
		repository.deleteAnimal(animal);
	}

	public Animal getAnimalByName(String name){
		return repository.getAnimalByName(name);
	}
}
