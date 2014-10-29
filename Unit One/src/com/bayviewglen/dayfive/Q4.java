package com.bayviewglen.dayfive;

import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		double vInitial, vFinal, accel, timeElapsed;
		
		System.out.print("Please enter the initial velocity of the car: ");
		vInitial = keyboard.nextDouble();
		
		System.out.print("Please enter the acceleration of the car: ");
		accel = keyboard.nextDouble();
		
		System.out.print("Please enter the time elapsed: ");
		timeElapsed = keyboard.nextDouble();

		vFinal = vInitial + (accel * timeElapsed);
		
		System.out.print("The final velocity of the car is: " + vFinal + ".");
		
		keyboard.close();
	}

}
