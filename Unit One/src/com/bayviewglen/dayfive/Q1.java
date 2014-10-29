package com.bayviewglen.dayfive;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a number: ");
		
		double x = keyboard.nextDouble();
		
		double xSquared = x * x;
		
		System.out.print("The square of " + x + " is: " + xSquared);
		
		keyboard.close();

	}

}
