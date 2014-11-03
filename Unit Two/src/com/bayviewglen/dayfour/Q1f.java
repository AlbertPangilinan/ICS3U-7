package com.bayviewglen.dayfour;

public class Q1f {

	public static void main(String[] args) {
		
		int alphabet = 26;
		
		int startingValue = 65;
		
		int randomLetterInt = (int)((Math.random() * alphabet) + startingValue);
		
		char randomChar = (char)randomLetterInt;
		
		System.out.print("Random uppercase letter: " + randomChar);

	}

}
