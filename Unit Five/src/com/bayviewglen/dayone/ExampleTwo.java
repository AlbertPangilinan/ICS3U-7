package com.bayviewglen.dayone;

import java.text.NumberFormat;
import java.util.Locale;

public class ExampleTwo {

	public static void main(String[] args) {
		Locale l = Locale.CANADA;
		NumberFormat f = NumberFormat.getCurrencyInstance(l);
		
		double money = 345;
		
		print(money,f);
	}

	private static void print(double money, NumberFormat f) {
		System.out.print(f.format(money));
	}

}