package com.tiy;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
/**
 * Created by josh on 3/29/17.
 */
public class MainTest {
	private ByteArrayOutputStream outputStream;
	@Before
	public void before(){
		this.outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
	}

	@Test
	public void testOptionOneAtMain() throws Exception{
		ByteArrayInputStream inputStream = new ByteArrayInputStream(("1\n" +
				"6\n"
		).getBytes());

		System.setIn(inputStream);

		Main.main(null);
		System.out.println(outputStream.toString());


		assertThat(outputStream.toString(),containsString("-- List Animals --"));
		assertThat(outputStream.toString(),containsString("Exiting"));


	}

	@Test
	public void testOptionTwoAtMain() throws Exception{
		ByteArrayInputStream inputStream = new ByteArrayInputStream((
				"2\n" +
				"Bob\n" +
				"Cat\n" +
				"\n" +
				"Fat and fluffy\n" +
				"6\n"
		).getBytes());
		System.setIn(inputStream);

		Main.main(null);

		assertThat(outputStream.toString(),containsString("Name:"));
		assertThat(outputStream.toString(),containsString("Species:"));
		assertThat(outputStream.toString(),containsString("Breed"));
		assertThat(outputStream.toString(),containsString("Description:"));

		assertThat(outputStream.toString(),containsString("Exiting"));
	}

	@Test
	public void testOptionThreeAtMain(){
		ByteArrayInputStream inputStream = new ByteArrayInputStream((
						"2\n" +
						"Bob\n" +
						"Cat\n" +
						"Shorthair\n" +
						"Fat and fluffy\n" +
						"3\n" +
						"1\n" +
						"1\n" +
						"6\n"
		).getBytes());

		System.setIn(inputStream);

		Main.main(null);
		assertThat(outputStream.toString(),containsString("-- Create Animal --"));
		assertThat(outputStream.toString(),containsString("Name:"));
		assertThat(outputStream.toString(),containsString("Species:"));
		assertThat(outputStream.toString(),containsString("Breed"));
		assertThat(outputStream.toString(),containsString("Description:"));

		//assertThat(outputStream.toString(),containsString("-- View an Animal --"));
		assertThat(outputStream.toString(),containsString("Bob"));
		assertThat(outputStream.toString(),containsString("Cat"));


		assertThat(outputStream.toString(),containsString("Exiting"));
	}

	@Test
	public void testOptionFourAtMain(){
		ByteArrayInputStream inputStream = new ByteArrayInputStream((
				"2\n" +
						"Bob\n" +
						"Cat\n" +
						"\n" +
						"Fat and fluffy\n" +
						"4\n" +
						"1\n" +
						"Larry\n" +
						"Dog\n" +
						"Mut\n" +
						"Likes to lick\n" +

						"6\n"
		).getBytes());

		System.setIn(inputStream);

		Main.main(null);
		assertThat(outputStream.toString(),containsString("-- Create Animal --"));
		assertThat(outputStream.toString(),containsString("Name:"));
		assertThat(outputStream.toString(),containsString("Species:"));
		assertThat(outputStream.toString(),containsString("Breed (optional):"));
		assertThat(outputStream.toString(),containsString("Description:"));

		assertThat(outputStream.toString(),containsString("-- Edit Animal --"));
		assertThat(outputStream.toString(),containsString("Name [Bob]:"));
		assertThat(outputStream.toString(),containsString("Species [Cat]:"));
		assertThat(outputStream.toString(),containsString("Breed []:"));
//		assertThat(outputStream.toString(),containsString("Description [Fat and fluffy]:"));




		assertThat(outputStream.toString(),containsString("Exiting"));
	}

	@Test
	public void testOptionFiveAtMain(){
		ByteArrayInputStream inputStream = new ByteArrayInputStream((
				//Selecting Create
				"2\n" +
						//Creating animal
						"Bob\n" +
						"Cat\n" +
						"\n" +
						"Fat and fluffy\n" +
						//Deleting animal
						"5\n" +
						//Selecting animal in array
						"1\n" +
						//con
						"y\n" +
						"1\n" +
						"6\n"
		).getBytes());

		System.setIn(inputStream);

		Main.main(null);
		assertThat(outputStream.toString(),containsString("-- Create Animal --"));
		assertThat(outputStream.toString(),containsString("Name:"));
		assertThat(outputStream.toString(),containsString("Species:"));
		assertThat(outputStream.toString(),containsString("Breed (optional):"));
		assertThat(outputStream.toString(),containsString("Description:"));

		assertThat(outputStream.toString(),containsString("-- Delete an Animal --"));

		assertThat(outputStream.toString(),containsString("What is the numeric ID of the animal you want to delete?:"));

		assertThat(outputStream.toString(),containsString("Success: The animal has been deleted!"));

		assertThat(outputStream.toString(),containsString("Exiting"));
	}

	@Test
	public void testOptionSixAtMain() throws Exception{
		ByteArrayInputStream inputStream = new ByteArrayInputStream((
				"6\n"
		).getBytes());

		System.setIn(inputStream);

		Main.main(null);
		System.out.println(outputStream.toString());

		assertThat(outputStream.toString(),containsString("Exiting"));


	}

}
