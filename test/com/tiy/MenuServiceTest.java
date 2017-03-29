package com.tiy;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by josh on 3/28/17.
 */
public class MenuServiceTest {
	private ByteArrayOutputStream outputStream;
	@Before
	public void before(){
		this.outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
	}

	@Test
	public void testMenuServiceConstructor(){
		String input = "1";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
	}

	@Test
	public void testWaitForIntReturn(){
		String input = "1";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
		int response = menuService.waitForInt("Prompt For Option: ");

		assertThat(outputStream.toString(), containsString("Prompt For Option: "));
		assertThat(response, equalTo(1));

	}
	@Test
	public void testWaitForStringOutputAndReturn(){
		String input = "Bob";
		Scanner scanner = new Scanner(input);
		MenuService menuService = new MenuService(scanner);
		String response = menuService.waitForString("%nPlease type a name: ");

		assertThat(outputStream.toString(),containsString("Please type a name:"));
		assertThat(response,equalTo("Bob"));

	}

	@Test
	public void checkYesOrNo(){

	}
	@Test
	public void testPromptForMenu(){

	}





}
