package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter the \"out\" string (length must be 4): ");
		String outString = keyboard.nextLine();

		System.out.print("Please enter the \"in\" string: ");
		String inString = keyboard.nextLine();

		String outStringHalf1 = outString.substring(0,2);
		String outStringHalf2 = outString.substring(2,4);
		
		System.out.print(outStringHalf1 + inString + outStringHalf2);
		
		keyboard.close();
		
	}

}
