package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter a string: ");
		String a = keyboard.nextLine();

		System.out.print("Please enter another string: ");
		String b = keyboard.nextLine();

		int lengthA = a.length();
		int lengthB = b.length();
		
		String aNoFirstLetter = a.substring(1,lengthA);
		String bNoFirstLetter = b.substring(1,lengthB);
		
		String aAndB = aNoFirstLetter + bNoFirstLetter;
		
		System.out.println(aAndB);
		
		keyboard.close();

	}

}
