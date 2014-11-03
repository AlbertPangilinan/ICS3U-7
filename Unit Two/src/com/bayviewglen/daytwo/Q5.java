package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter a string: ");
		String string = keyboard.nextLine();

		int last2chars = string.length() - 2;

		String newString = (string.substring(last2chars)) + (string.substring(last2chars)) + (string.substring(last2chars));

		System.out.println(newString);

		keyboard.close();
	}

}
