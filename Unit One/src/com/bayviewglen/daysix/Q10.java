package com.bayviewglen.daysix;

import java.util.Scanner;

public class Q10 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
				double length, width;
		
		System.out.print("Please enter the length of the rectange: ");
		length = keyboard.nextDouble();
		
		System.out.print("Please enter the width of the rectange: ");
		width = keyboard.nextDouble();
		
		double area = (length * width);
		double perimeter = (length * 2) + (width * 2);
		
		System.out.println("The area of the rectange is: " + area + ".");
		System.out.println("The perimeter of the rectange is: " + perimeter + ".");
		
		keyboard.close();
	}

}
