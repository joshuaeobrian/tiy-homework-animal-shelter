package com.tiy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 * Created by josh on 4/3/17.
 */
public class AnimalRepository {
	private Connection conn;

	public AnimalRepository(){
		ServerConfig serverConfig = new ServerConfig();
		try{
			conn = DriverManager.getConnection(serverConfig.getDatabasePath());

		}catch (Exception e){

		}

	}

	public ArrayList<Animal> listAnimals(){
		ArrayList<Animal> animals = new ArrayList<>();
		try{

		}catch (Exception e){

		}

		return animals;
	}

	public void addAnimal(Animal animal){

		//insert animal

		//insert breed / species

	}

	public void updateAnimal(Animal animal){

		//update animal where id=

	}

	public void setAnimalVisiblitiy(Animal animal){

	}

	public void deleteAnimal(Animal animal){

	}


}
