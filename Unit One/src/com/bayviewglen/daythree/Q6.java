package com.bayviewglen.daythree;

public class Q6 {

	public static void main(String[] args) {
		int a = 3, b = -20, c = -50;
		double x1, x2;

		x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
		x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;

		System.out.println("Roots: " + x1 + " and " + x2);

	}

}
