package com.bayviewglen.dayseven;

import java.util.Scanner;

public class BVGPools {

	static final double square = 2.0;
	static final double triangleArea = 0.5;
	static final double twoSides = 0.5;
	static final double water = 0.9;

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Start User Inputs

		System.out.print("Please enter the length of the pool in metres: ");
		double lengthTotal = keyboard.nextDouble();

		System.out.print("Please enter the width of the pool in metres: ");
		double width = keyboard.nextDouble();

		System.out.print("Please enter the depth of the shallow end in metres: ");
		double depthShallow = keyboard.nextDouble();

		System.out.print("Please enter the depth of the deep end in metres: ");
		double depthDeep = keyboard.nextDouble();

		System.out.print("Please enter the length of the transition between"
				+ " the shallow end and the deep end in metres: ");
		double transitionLength = keyboard.nextDouble();

		System.out.print("Please enter the length of the shallow end in metres: ");
		double lengthShallow = keyboard.nextDouble();

		System.out.print("Please enter the price of the first liner: ");
		double liner1 = keyboard.nextDouble();

		System.out.print("Please enter the price of the second liner: ");
		double liner2 = keyboard.nextDouble();

		System.out.print("Please enter the price of the third liner: ");
		double liner3 = keyboard.nextDouble();

		// End User Inputs

		// Start Pool Volume

		double volumeShallow = lengthShallow * width * depthShallow;

		double depthDifference = depthDeep - depthShallow;
		double transitionLeg = (Math.pow(transitionLength, square)) - (Math.pow(depthDifference, square));
		double lengthDeep = lengthTotal - lengthShallow - transitionLeg;
		double volumeDeep = lengthDeep * width * depthDeep;

		double volumeTransition1 = transitionLeg * width * depthShallow;
		double volumeTransition2 = triangleArea	* (transitionLeg * depthDifference);
		double volumeTransitionTotal = volumeTransition1 + volumeTransition2;

		double volumeTotal = volumeShallow + volumeDeep + volumeTransitionTotal;

		// End Pool Volume

		// Start Water Volume

		double volumeWater = water * volumeTotal;

		// End Water Volume

		// Start Surface Area

		double surfaceAreaFront = depthShallow * width;

		double surfaceAreaBack = depthDeep * width;

		double surfaceAreaSides1 = twoSides * (lengthShallow * depthShallow);
		double surfaceAreaSides2 = twoSides * (lengthDeep * depthDeep);
		double surfaceAreaSides3 = twoSides * (transitionLeg * depthShallow);
		double surfaceAreaSides4 = transitionLeg * depthDifference;
		double surfaceAreaSidesTotal = surfaceAreaSides1 + surfaceAreaSides2 + surfaceAreaSides3 + surfaceAreaSides4;

		double surfaceAreaSidesBottom = lengthTotal * width;

		double surfaceAreaTotal = surfaceAreaFront + surfaceAreaBack + surfaceAreaSidesTotal + surfaceAreaSidesBottom;

		// End Surface Area

		// Start Cost

		double liner1Cost = liner1 * surfaceAreaTotal;

		double liner2Cost = liner2 * surfaceAreaTotal;

		double liner3Cost = liner3 * surfaceAreaTotal;

		// End Cost

		// Start User Inputs Table
		
		System.out.println("\n\nPool Dimensions and Liner Costs:");
		
		System.out.println("\nThe length of the pool is: " + lengthTotal + "m.");
		
		System.out.println("The width of the pool is: " + width + "m.");
		
		System.out.println("The depth of the shallow end is: " + depthShallow + "m.");
	
		System.out.println("The depth of the deep end is: " + depthDeep + "m.");
		
		System.out.println("The length of the transition between the shallow end and the deep end is: "
				+ transitionLength + "m.");
	
		System.out.println("The length of the shallow end is: " + lengthShallow + "m.");
		
		System.out.println("The price of the first liner is: $" + liner1 + "/m^2.");
	
		System.out.println("The price of the second liner is: $" + liner2 + "/m^2.");
		
		System.out.println("The price of the third liner is: $" + liner3 + "/m^2.");
		
		// End User Inputs Table
		
		// Start Calculations Table
		
		System.out.println("\n\nThe amount of water needed to keep the pool 90% full is: " + volumeWater + "L.");
	
		System.out.println("The amount of liner needed to create the pool is: " + surfaceAreaTotal + "m^2.");
		
		System.out.println("The cost for the first liner is: $" + liner1Cost + ".");
	
		System.out.println("The cost for the second liner is: $" + liner2Cost + ".");
		
		System.out.println("The cost for the third liner is: $" + liner3Cost + ".");
		
		// End Calculations Table
		
		keyboard.close();
	}
}
