package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q7 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a string: ");
		String string = keyboard.nextLine();
		
		int halfway = string.length()/2;
		
		String half1 = string.substring(0, halfway);
				
		System.out.println(half1);
		
		keyboard.close();

	}

}
