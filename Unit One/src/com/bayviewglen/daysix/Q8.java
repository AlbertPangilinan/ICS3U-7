package com.bayviewglen.daysix;

import java.util.Scanner;

public class Q8 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		double number;

		System.out.print("Please enter a number: ");
		number = keyboard.nextDouble();

		double square = number * number;
		double root = Math.sqrt(number);

		System.out.println("The square of " + number + " is " + square + ".");
		System.out
				.println("The square root of " + number + " is " + root + ".");

		keyboard.close();
	}

}
