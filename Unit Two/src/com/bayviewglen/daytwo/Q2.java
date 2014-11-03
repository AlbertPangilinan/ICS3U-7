package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter string A: ");
		String a= keyboard.nextLine();
		
		System.out.print("Please enter string B: ");
		String b = keyboard.nextLine();
		
		String abba = a + b + b + a;
				
		System.out.println(abba);
		
		keyboard.close();

	}

}
