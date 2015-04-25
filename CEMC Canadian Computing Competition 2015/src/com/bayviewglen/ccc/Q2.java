package com.bayviewglen.ccc;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter a message: ");
		String message = keyboard.nextLine();
		keyboard.close();

		int happyCount = 0, sadCount = 0;

		for (int i = 0; i < message.length() - 3; i++) {
			if (message.charAt(i) == ':' && message.charAt(i + 1) == '-' && message.charAt(i + 2) == ')') {
				happyCount++;
			} else if (message.charAt(i) == ':' && message.charAt(i + 1) == '-' && message.charAt(i + 2) == '(') {
				sadCount++;
			}
		}

		if (happyCount == 0 && sadCount == 0) {
			System.out.println("none");
		} else if (happyCount == sadCount ) {
			System.out.println("unsure");
		} else if (happyCount < sadCount ) {
			System.out.println("sad");
		} else if (happyCount > sadCount ) {
			System.out.println("happy");
		}
		
	}
}
