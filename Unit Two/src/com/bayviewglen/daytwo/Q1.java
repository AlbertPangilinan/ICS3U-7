package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter a name: ");
		String name = keyboard.nextLine();
		
		String helloName = "Hello " + name + "!";
		
		System.out.println(helloName);
		
		keyboard.close();

	}

}
