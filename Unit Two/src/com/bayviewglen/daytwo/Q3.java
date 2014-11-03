package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

			
		System.out.print("Please enter the tag: ");
		String tag = keyboard.nextLine();

		System.out.print("Please enter the string: ");
		String string = keyboard.nextLine();
		
		System.out.print("<" + tag + ">" + string + "</" + tag + ">");

		keyboard.close();
	}

}
