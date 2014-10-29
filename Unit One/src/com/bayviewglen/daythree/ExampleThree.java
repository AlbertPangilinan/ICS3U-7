/*
 *Looked at some of the quirky things about concatenation
 */
package com.bayviewglen.daythree;

public class ExampleThree {

	public static void main(String[] args) {
		int x = 7, y = 3;
		
		System.out.println(x + y + " are my values.");		// Performs regular math when it has regular numbers
				
		System.out.println(x + " and " + y + " are my values.");	// one of the two operands needs to be a
																	// string to perform string concatenation

		System.out.println("" + x + y + " are my values.");
		
		System.out.println("" + (x + y) + " are my values.");
	}

}
