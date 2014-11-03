package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter a string: ");
		String string = keyboard.nextLine();

		if (string.length() < 2) {
			String newString = string.substring(0);
			System.out.println(newString);
		}

		if (string.length() > 2) {
			String newString = string.substring(0, 2);
			System.out.println(newString);
		}

		if (string.length() == 0) {
			System.out.println(string);
		}

		keyboard.close();

	}
}
