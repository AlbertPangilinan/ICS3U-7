package com.bayviewglen.dayfour;

public class Q1g {

	public static void main(String[] args) {
		
		int alphabet = 26;
		
		int startingValue = 97;
		
		int randomLetterInt = (int)((Math.random() * alphabet) + startingValue);
		
		char randomChar = (char)randomLetterInt;
		
		System.out.print("Random lowercase letter: " + randomChar);

	}

}
