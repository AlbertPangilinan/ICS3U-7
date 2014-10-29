package com.bayviewglen.daysix;

public class Q4 {

	public static void main(String[] args) {
		double speedLight = 3 * (Math.pow(10.0, 8.0));
		
		int sec, min, hour, day, year;
		sec = 1;
		min = sec * 60;
		hour = min * 60;
		day = hour * 24;
		year = day * 365;
		
		System.out.println("The amount of distance light travels in one year is: " + (speedLight * year) + "m.");
	}

}
