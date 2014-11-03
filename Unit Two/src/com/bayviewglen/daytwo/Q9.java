package com.bayviewglen.daytwo;

import java.util.Scanner;

public class Q9 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter a string: ");
		String a = keyboard.nextLine();

		System.out.print("Please enter another string: ");
		String b = keyboard.nextLine();

		if (a.length() < b.length()) {
			System.out.println(a + b + a);
		}

		if (a.length() > b.length()) {
			System.out.println(b + a + b);
		}

		keyboard.close();
	}

}
