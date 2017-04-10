package com.tiy;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by josh on 4/5/17.
 */
public class AnimalService {
	private AnimalRepository repository;

	public AnimalService() throws SQLException {
			this.repository = new AnimalRepository("jdbc:postgresql://localhost:5432/animalshelter");
	}
	public AnimalService(String jdbcUrl) throws SQLException {
		this.repository  = new AnimalRepository(jdbcUrl);
	}

	public ArrayList<Animal> getAnimals() throws SQLException {
		return repository.listAnimals();
	}

	public void addAnimal(Animal animal) throws SQLException {
		if(animal != null){
			repository.addAnimal(animal);

		}
	}

	public void updateAnimal(Animal animal) throws SQLException {
		repository.updateAnimal(animal);
	}

	public void deleteAnimal(Animal animal) throws SQLException {
		repository.deleteAnimal(animal);
	}

	public Animal getAnimalByName(String name) throws SQLException {
		return repository.getAnimalByName(name);
	}
}
