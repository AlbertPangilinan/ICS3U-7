package com.bayviewglen.dayfour;

import java.util.Scanner;

public class Q1c {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter an integer: ");
		int x = keyboard.nextInt();

		System.out.print("Please enter another integer: ");
		int y = keyboard.nextInt();
		
		if (x < y) {
			int sampleSize = y - +x;
			
			int startNum = x;
			
			int randomNumber = (int)(Math.random() * sampleSize) + startNum;
			
			System.out.println("Random number between " + x + " and " + y + " inclusive: " + randomNumber);
		}
		
		if (y < x) {
			int sampleSize = x - +y;
			
			int startNum = y;
			
			int randomNumber = (int)(Math.random() * sampleSize) + startNum;
			
			System.out.println("Random number between " + y + " and " + x + " inclusive: " + randomNumber);
			
		}
		
			keyboard.close();	
	}

}
