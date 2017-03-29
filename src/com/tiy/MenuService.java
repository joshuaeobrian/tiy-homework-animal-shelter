package com.tiy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by josh on 3/24/17.
 */
public class MenuService {


	private Scanner scanner;

	public MenuService(Scanner scanner) {
		this.scanner = scanner;
	}

	public int waitForInt(String prompt) {
		System.out.printf(prompt);
		if(!scanner.hasNextInt()){
			String badInput = scanner.next();
			System.out.printf("%nSorry, %s is a invalid option.",badInput);
			return waitForInt(prompt);
		}else{
			return scanner.nextInt();
		}
	}

	public String waitForString(String prompt) {
		System.out.printf(prompt);
		return scanner.next();
	}
}

