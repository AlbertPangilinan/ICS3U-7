package com.bayviewglen.dayfour;

public class Q1a {

	public static void main(String[] args) {
		
		int sampleSize = 100;
		
		int startNum = 1;
		
		int randomNumber = (int)(Math.random() * sampleSize) + startNum;
		
		System.out.println("Random number between 1 and 100 inclusive: " + randomNumber);
		
	}

}
