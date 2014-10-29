/*
 *Escape Sequences & System.out.println
 */
package com.bayviewglen.daythree;

public class ExampleOne {

	public static void main(String[] args) {
		System.out.println("This is not a problem.");
		System.out.println("This is \"not\" a problem.");	// The quote " is special so
															// I must use the backslash \ to escape it.
		
		System.out.println("A backslash is special \\see.");	// Escaped the backslash because it has purpose
		
		System.out.println("This\nis\na\nnew\nline.");
		}
}