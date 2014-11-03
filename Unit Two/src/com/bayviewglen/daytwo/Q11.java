package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q11 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a string: ");
		String string = keyboard.nextLine();
		
		String first2Chars = string.substring(0,2);
		
		String char3ToEnd = string.substring(2,string.length());
		
		String rotatedLeft2 = char3ToEnd + first2Chars;
		
		System.out.println(rotatedLeft2);
		
		keyboard.close();

	}

}
