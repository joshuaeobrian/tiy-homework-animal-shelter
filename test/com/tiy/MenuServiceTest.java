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
	public void testWaitForInt(){

	}

	@Test
	public void testWaitForString(){

	}

	@Test
	public void checkYesOrNo(){

	}
	@Test
	public void testPromptForMenu(){

	}





}
