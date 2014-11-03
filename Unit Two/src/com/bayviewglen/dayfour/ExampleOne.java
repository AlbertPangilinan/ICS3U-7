/* 
 * Display a random uppercase character 
 */
package com.bayviewglen.dayfour;

public class ExampleOne {

	public static void main(String[] args) {

		final int NUMBER_OF_LETTERS = 26;
		final int STARTING_NUMBER = 65;
								
		char letter = (char)((int)(Math.random() * NUMBER_OF_LETTERS) + STARTING_NUMBER);
		
		System.out.print("Random letter: " + letter);

	}

}
