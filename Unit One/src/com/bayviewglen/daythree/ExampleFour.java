/*
 *Integer & double division
 */
package com.bayviewglen.daythree;

public class ExampleFour {

	public static void main(String[] args) {
		int a = 7, b = 3;
		int c;

		double d = 2.1, e = 3.7;
		double f;

		c = a * b;
		System.out.println(c);

		f = d * e;
		System.out.println(f);
		
		f = d/e;
		System.out.println(f);
		
		c = a/b;
		System.out.println(c);
		
		f = a/b;					// If both operators are integers then it performs integer division
		System.out.println(f);

		f = a/d;
		System.out.println(f);
	}

}
