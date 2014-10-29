/* 
 * Double and Integer Division
 */

package com.bayviewglen.dayfour;

public class ExampleOne {

	public static void main(String[] args) {
		System.out.println(4+3);		// Yields 7 because both operands and integers
		System.out.println(4.1+3);		// Yields a double because one of the operands is a double
		
		System.out.println(4/3);		// Yields an integer because both operands and integers
		System.out.println(2/3);		// 0
		
		System.out.println(23%2);		// 1 so it must be odd
		System.out.println(83524%10);	// Get 4 - the last digit in the number
	}

}
