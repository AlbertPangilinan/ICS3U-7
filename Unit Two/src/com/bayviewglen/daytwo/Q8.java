package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q8 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter a string: ");
		String string = keyboard.nextLine();

		int secondLastChar = string.length() - 1;
		
		String copy = string.substring(1,secondLastChar);

		System.out.println(copy);
		
		keyboard.close();

	}

}
