package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q12 {

	public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a string: ");
		String string = keyboard.nextLine();
		
		int last2Chars = string.length() - 2;
		
		String upToLast2Chars = string.substring(0,last2Chars);
		
		String Last2Chars = string.substring(last2Chars,string.length());
		
		String rotatedRight2 = Last2Chars + upToLast2Chars;
		
		System.out.println(rotatedRight2);
		
		keyboard.close();

	}

}
