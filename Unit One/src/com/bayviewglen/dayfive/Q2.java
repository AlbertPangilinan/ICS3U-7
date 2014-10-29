package com.bayviewglen.dayfive;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		double total, mark;
		double percent;

		System.out.print("Please enter the total amount of marks: ");
		total = keyboard.nextDouble();

		System.out.print("Please enter the student's mark: ");
		mark = keyboard.nextDouble();

		percent = (mark / total) * 100;

		System.out.print("This student scored: " + percent + "%.");

		keyboard.close();
	}

}
