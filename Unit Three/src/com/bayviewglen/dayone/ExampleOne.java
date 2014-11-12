/*
 *  Write a program that accepts a numerical grade (int) and displays a letter grade
 */
package com.bayviewglen.dayone;

import java.util.Scanner;

public class ExampleOne {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter a numerical grade: ");
		int grade = keyboard.nextInt();

		if (grade >= 80) {
			System.out.println("You get an A!");
		}

		else if (grade >= 70) {
			System.out.println("You get a B.");
		}

		else if (grade >= 60) {
			System.out.println("You get a C.");
		}

		else if (grade >= 50) {
			System.out.println("You get a D...");
		} else {
			System.out.println("You get a F... You suck.");
		}

		keyboard.close();
	}

}
