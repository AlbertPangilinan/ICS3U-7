package com.bayviewglen.daysix;

import java.util.Scanner;

public class Q11 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		double mass, speed, kineticEnergy;
		
		System.out.print("Please enter the mass of the object: ");
		mass = keyboard.nextDouble();
		
		System.out.print("Please enter the speed of the object: ");
		speed = keyboard.nextDouble();

		kineticEnergy = 0.5 * mass * (speed * speed);
		
		System.out.print("The kinetic energy of the object is: " + kineticEnergy + ".");
		
		keyboard.close();
	}

}
