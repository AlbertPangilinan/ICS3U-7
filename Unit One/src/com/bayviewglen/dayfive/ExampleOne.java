/*
 * Declaring a Scanner to read input from the Keyboard.
 * Reading integer data.
 * Prompt the user for three different integers and display the average as the three numbers.
 */
package com.bayviewglen.dayfive;

import java.util.Scanner;

public class ExampleOne {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter three integers: ");
		
		int number1 = keyboard.nextInt(); // Gets the next integer in the queue or buffer
		int number2 = keyboard.nextInt(); // Gets the next integer in the queue or buffer
		int number3 = keyboard.nextInt(); // Gets the next integer in the queue or buffer
		
		double avg = (number1 + number2 + number3)/3.0;
		
		System.out.println("The average of the numbers " 
			+ number1 + ", " + number2 + ", and " +  number3 + " is: " + avg);
		
		keyboard.close();
		
	}

}