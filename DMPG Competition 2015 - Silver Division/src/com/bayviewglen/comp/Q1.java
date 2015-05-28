package com.bayviewglen.comp;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int c = s.nextInt();
		int r = s.nextInt();
		int w = s.nextInt();
		int b = s.nextInt();
		int y = s.nextInt();
		int g = s.nextInt();
		
		int rCars = r / 4;
		int wCars = w / 5;
		int bCars = b / 4;
		int yCars = y / 3;
		int gCars = g / 6;
		
		if (r % 4 != 0) {
			rCars++;
		}
		if (w % 5 != 0) {
			wCars++;
		}
		if (b % 4 != 0) {
			bCars++;
		}
		if (y % 3 != 0) {
			yCars++;
		}
		if (g % 6 != 0) {
			gCars++;
		}
		
		int sumCars = rCars + wCars + bCars + yCars + gCars;
		
		System.out.print(c - sumCars);
	}

}
