package com.bayviewglen.dayone;

import java.util.Scanner;

public class ExampleThree {

	public static void main(String[] args) {

		boolean validInput = false;
		Scanner s = new Scanner(System.in);

		while (!validInput) {
			System.out.print("Enter an integer: ");
			String temp = s.nextLine();
			int number;

			try {
				number = Integer.parseInt(temp);
				System.out.println(number);
				validInput = true;
			}

			catch (NumberFormatException ex) {
				System.out.println(temp	+ " is not a number on earth in any language.");
			}

		}

		System.out.println("I am happy!!!!");

		s.close();
	}

}