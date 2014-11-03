package com.bayviewglen.dayfour;

public class Q1d {

	public static void main(String[] args) {

		int sampleSize = 6;
		
		int startNum = 1;
		
		int randomNumber = (int)(Math.random() * sampleSize) + startNum;
		
		System.out.println("On a 6-sided die, you rolled a " + randomNumber + ".");

	}

}
