/*
 *Used variables, assignment operator, string concatenation
 *primitive data types (int and double), but our example used only int
 */
package com.bayviewglen.daythree;

public class ExampleTwo {

	public static void main(String[] args) {
		int numberOne, numberTwo;
		int sum;

		numberOne = 7;		// numberOne is assigned 7
		numberTwo = 23;		// numberTwo is assigned 23

		sum = numberOne + numberTwo;
		
		System.out.println(sum);
		System.out.println(numberOne + "+" + numberTwo + "=" + sum);
	}

}