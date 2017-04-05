package com.tiy;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by josh on 4/3/17.
 */
public class AnimalRepository {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement prestmt;
	private ResultSet rs;
	//starts connection to server
	public AnimalRepository(String conn){

		try{
			this.conn = DriverManager.getConnection(conn);

		}catch (SQLException e){
			e.printStackTrace();
		}

	}
	//returns an array list of animals in the database
	public ArrayList<Animal> listAnimals(){
		ArrayList<Animal> animals = new ArrayList<>();
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT a.id as id, a.animal_name AS name, b.breed_type as breed, s.species_type as species, a.age as age" +
					", g.gender_type as gender, a.description as description, a.receive_date as date\n" +
					" FROM animal as a\n" +
					"  JOIN gender as g ON a.gender_id = g.id\n" +
					"  JOIN animal_type as at ON a.id = at.animal_id\n" +
					"  JOIN breed as b ON at.breed_id = b.id\n" +
					"  JOIN species as s on b.species_id = s.id;"
			);
			while(rs.next()){


				animals.add(new Animal(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("species"),
						rs.getString("breed"),
						rs.getInt("age"),
						rs.getString("gender"),
						rs.getString("description"),
						LocalDate.parse(rs.getString("date"))));
			}

		}catch (SQLException sqle){
			System.out.println(sqle.getMessage());
		}

		return animals;
	}
	//gets animal by name will be for spring
	public Animal getAnimalByName(String name) {
		Animal animal = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT a.id as id, a.animal_name AS name, b.breed_type as breed, s.species_type as species, a.age as age" +
					", g.gender_type as gender, a.description as description, a.receive_date as date\n" +
					" FROM animal as a\n" +
					"  JOIN gender as g ON a.gender_id = g.id\n" +
					"  JOIN animal_type as at ON a.id = at.animal_id\n" +
					"  JOIN breed as b ON at.breed_id = b.id\n" +
					"  JOIN species as s on b.species_id = s.id\n" +
					"   WHERE lower(animal_name)='"+name.toLowerCase()+"';"
			);
			if(rs.next()){


				animal = new Animal(rs.getInt("id"),
						rs.getString("name"),
						rs.getString("species"),
						rs.getString("breed"),
						rs.getInt("age"),
						rs.getString("gender"),
						rs.getString("description"),
						LocalDate.parse(rs.getString("date")));
			}

		}catch (SQLException sqle){
			System.out.println(sqle.getMessage());
		}
		return animal;
	}

	//Adds animal to database
	public int addAnimal(Animal animal){
		int response = 0;
		try {
			prestmt = conn.prepareStatement("INSERT INTO animal(animal_name, age, description, receive_date, gender_id) VALUES (\n" +
					"    '"+animal.getName()+"',\n" +
					"    "+animal.getAge()+",\n" +
					"    '"+animal.getDescription()+"',\n" +
					"    now(),\n" +
					"    (SELECT id FROM gender WHERE lower(gender_type)='"+animal.getGender().toLowerCase()+"')\n" +
					");");
			response += prestmt.executeUpdate();
			//could be removed in future when in the web
			checkForSpecies(animal.getSpecies());
			//could be removed in future when in the web
			checkForBreed(animal.getBreed(),animal.getSpecies());

			prestmt = conn.prepareStatement("INSERT INTO animal_type (animal_id, breed_id) VALUES (" +
					"(SELECT id FROM animal where lower(animal_name)='"+animal.getName().toLowerCase()+"')," +
					"(SELECT id FROM breed where lower(breed_type)='"+animal.getBreed().toLowerCase()+"'));");
			response += prestmt.executeUpdate();

		}catch (SQLException sqle){
			sqle.printStackTrace();
		}
		System.out.println(response);
		return response;
	}

	//check to see if species exist
	public boolean checkForSpecies(String species){
		boolean specieExists = false;
		try{
			prestmt = conn.prepareStatement("SELECT id FROM species WHERE lower(species_type)='"+species.toLowerCase()+"'");
			rs = prestmt.executeQuery();
			if(rs.isBeforeFirst()) {
				rs.next();
				if (rs.getInt("id") > 0) {
					specieExists = true;
				}
			}else{
				prestmt = conn.prepareStatement("INSERT INTO species(species_type)VALUES ('"+species.toLowerCase()+"')");
				prestmt.executeUpdate();
			}

		}catch (SQLException sqle){
				sqle.printStackTrace();
		}
		return specieExists;
	}

	public boolean checkForBreed(String breed,String species){
		boolean breedExists = false;
		try{
			prestmt = conn.prepareStatement("SELECT id FROM breed WHERE lower(breed_type)=lower('"+breed+"')");
			rs = prestmt.executeQuery();

				if(rs.isBeforeFirst()) {
					rs.next();
					if (rs.getInt("id") > 0) {
						breedExists = true;
					}
				}else{
					prestmt = conn.prepareStatement("INSERT INTO breed(breed_type, species_id)VALUES ('"+breed.toLowerCase()+"'," +
							"(SELECT id FROM species WHERE lower(species_type)='"+species.toLowerCase()+"'))");
					prestmt.executeUpdate();
				}
		}catch (SQLException sqle){
			sqle.printStackTrace();
		}

		return breedExists;
	}
	//updates animal
	public void updateAnimal(Animal animal){
		try {
			prestmt = conn.prepareStatement("UPDATE animal SET " +
					" animal_name='"+animal.getName()+"'," +
					" age='"+animal.getAge()+"'," +
					" description='"+animal.getDescription()+"'," +
					"gender_id=(SELECT id from gender where lower(gender_type)='"+animal.getGender().toLowerCase()+"')" +
					"WHERE id="+animal.getId()+"");
			prestmt.executeUpdate();
			checkForSpecies(animal.getSpecies());
			checkForBreed(animal.getBreed(),animal.getSpecies());

			prestmt = conn.prepareStatement("UPDATE animal_type SET breed_id=(SELECT id FROM breed where lower(breed_type)='"+animal.getBreed().toLowerCase()+"') " +
					"WHERE animal_id="+animal.getId()+"");
			prestmt.executeUpdate();
			//update animal where id=1
		}catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
	//for website use
	public void setAnimalVisiblitiy(Animal animal){
		try {
			prestmt = conn.prepareStatement("UPDATE animal SET " +
					"isvisible=NOT (SELECT isvisible FROM animal WHERE id="+animal.getId()+")");

		}catch (SQLException sqle){
			sqle.printStackTrace();
		}
	}
	//deletes animal
	public void deleteAnimal(Animal animal){
		try {

			prestmt = conn.prepareStatement("DELETE FROM animal_type WHERE animal_id="+animal.getId()+";");
			prestmt.executeUpdate();

			prestmt = conn.prepareStatement("DELETE FROM animal" +
					" WHERE id="+animal.getId()+";");
			prestmt.executeUpdate();

		}catch (SQLException sqle){
			sqle.printStackTrace();
		}

	}
	public ArrayList<String> getListOfSpecies() throws SQLException {
		ArrayList<String> species = new ArrayList<>();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * from species");
		while(rs.next()){
			species.add(rs.getString("species_type"));
		}
		return species;
	}

	public ArrayList<String> getListOfBreedsOfSpeciesType(String species){
		ArrayList<String> breeds = new ArrayList<>();
		try {
			prestmt.executeQuery("SELECT breed_type from breed where " +
					"species_id=(SELECT id FROM species where lower(species_type)='" + species.toLowerCase() + "')");
			rs = prestmt.executeQuery();
			while(rs.next()){
				breeds.add(rs.getString("breed_type"));
			}
		}catch (SQLException sqle){

		}
		return breeds;
	}

}
