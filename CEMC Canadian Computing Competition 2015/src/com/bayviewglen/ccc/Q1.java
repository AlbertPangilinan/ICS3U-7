package com.bayviewglen.ccc;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("What month is it? ");
		int month = keyboard.nextInt();
		System.out.print("What day of the month is it? ");
		int day = keyboard.nextInt();
		keyboard.close();

		if (month < 2) {
			System.out.println("Before");
		} else if (month > 2) {
			System.out.println("After");
		} else if (month == 2) {
			if (day < 18) {
				System.out.println("Before");
			} else if (day > 18) {
				System.out.println("After");
			} else if (day == 18) {
				System.out.println("Special");
			}
		}
	}
}