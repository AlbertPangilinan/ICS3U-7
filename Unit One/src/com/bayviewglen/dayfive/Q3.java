package com.bayviewglen.dayfive;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int number, product, digit2, digit4;
		
		System.out.print("Please enter a 5 digit number: ");
		number = keyboard.nextInt();
		
		digit2 = number % 100 / 10;
		digit4 = number % 10000 / 1000;
		
		product = digit2 * digit4;
		
		System.out.print("The product of the digits "
				+ digit4 + " and " + digit2 + " is: " + product + ".");
		
		keyboard.close();

	}

}
