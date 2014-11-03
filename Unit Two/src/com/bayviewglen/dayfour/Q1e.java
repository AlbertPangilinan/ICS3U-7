package com.bayviewglen.dayfour;

import java.util.Scanner;

public class Q1e {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter some text: ");
		String text = keyboard.nextLine();
		
			
		int randomIndex = (int)(Math.random() * text.length());
		
		char randomChar = text.charAt(randomIndex);
		
		System.out.print("Random character in " + text + ": " + randomChar);
		
		keyboard.close();

	}

}
