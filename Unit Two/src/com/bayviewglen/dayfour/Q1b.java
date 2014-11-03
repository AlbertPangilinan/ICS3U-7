package com.bayviewglen.dayfour;

public class Q1b {

	public static void main(String[] args) {
		
		int sampleSize = 100;
		
		int startNum = -50;
		
		int randomNumber = (int)(Math.random() * sampleSize) + startNum;
		
		System.out.println("Random number between -50 and 50 inclusive: " + randomNumber);

	}

}
