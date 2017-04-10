package com.tiy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.*;
/**
 * Created by josh on 4/9/17.
 */
public class AnimalServiceTest {
	private String jdbcURL = "jdbc:h2:mem:animalshelter";
	private Connection conn;
	private AnimalService service;
	private ArrayList<Animal> animals = new ArrayList<>();

	@Before
	public void before(){
		try{
			conn = DriverManager.getConnection(jdbcURL+";INIT=RUNSCRIPT FROM 'classpath:./animalshelter.sql'");
			service = new AnimalService(jdbcURL);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	@Test
	public void testConstructorWithSting(){
		try{
			conn = DriverManager.getConnection(jdbcURL);
			service = new AnimalService(jdbcURL);
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	@Test
	public void testGetListOfAnimals(){
		animals = service.getAnimals();
		boolean returnSize = animals.size() >0;
		assertThat(returnSize, equalTo(true));
	}

	@Test
	public void testAddingAnimal(){
		Animal animal = new Animal(0,
				"Bob",
				"Cat",
				"Maine Coon",
				3,
				"Male",
				"oye",
				LocalDate.now()
		);
		service.addAnimal(animal);
		assertThat(service.getAnimalByName("bob").getName(),equalTo("Bob"));
		assertThat(service.getAnimalByName("bob").getId(),equalTo(3));

	}
	@Test
	public void testDeletingAnimal(){
		Animal animal = new Animal(0,
				"Bob",
				"Cat",
				"Maine Coon",
				3,
				"Male",
				"oye",
				LocalDate.now()
		);
		service.addAnimal(animal);
		assertThat(service.getAnimalByName("bob").getName(),equalTo("Bob"));
		assertThat(service.getAnimalByName("bob").getId(),equalTo(3));
		animal = service.getAnimalByName("bob");
		service.deleteAnimal(animal);
	}

	@Test
	public void testUpdatingAnimal(){
		Animal animal = service.getAnimalByName("Pablo");
		int id = animal.getId();
		animal.setName("Mike");
		service.updateAnimal(animal);
		assertThat(service.getAnimalByName("Mike").getId(),equalTo(id));

	}
	@Test
	public void testMethodsForUpdateAnimal(){
		String MethodName ="";
		for (Method method : AnimalService.class.getDeclaredMethods()) {
			String name = method.getName();
			if(name.equals("updateAnimal")){
				MethodName = name;
			}

		}
		assertThat(MethodName,equalTo("updateAnimal"));
	}
	@Test
	public void testMethodsForGetAnimals(){
		String MethodName ="";
		for (Method method : AnimalService.class.getDeclaredMethods()) {
			String name = method.getName();
			if(name.equals("getAnimals")){
				MethodName = name;
			}

		}
		assertThat(MethodName,equalTo("getAnimals"));
	}
	@Test
	public void testMethodsForAddAnimal(){
		String MethodName ="";
		for (Method method : AnimalService.class.getDeclaredMethods()) {
			String name = method.getName();
			if(name.equals("addAnimal")){
				MethodName = name;
			}

		}
		assertThat(MethodName,equalTo("addAnimal"));
	}
	@Test
	public void testMethodsForGetAnimalByName(){
		String MethodName ="";
		for (Method method : AnimalService.class.getDeclaredMethods()) {
			String name = method.getName();
			if(name.equals("getAnimalByName")){
				MethodName = name;
			}

		}
		assertThat(MethodName,equalTo("getAnimalByName"));
	}

	@Test
	public void testMethodsForDeleteAnimal(){
		String MethodName ="";
		for (Method method : AnimalService.class.getDeclaredMethods()) {
			String name = method.getName();
			if(name.equals("deleteAnimal")){
				MethodName = name;
			}

		}
		assertThat(MethodName,equalTo("deleteAnimal"));
	}

	@Test
	public void test(){
		Class clazz = AnimalService.class;
		for (Constructor constructor: clazz.getConstructors()){
			String name = constructor.toString();
			System.out.println(name);
		}
		assertThat(clazz.getConstructors().length >0,equalTo(true));
		assertThat(clazz.getConstructors()[0].toString(),equalTo("public com.tiy.AnimalService()"));
		assertThat(clazz.getConstructors()[1].toString(),equalTo("public com.tiy.AnimalService(java.lang.String)"));

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
