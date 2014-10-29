package com.bayviewglen.daysix;

import java.util.Scanner;

public class Q9 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		int itemsSold;
		
		System.out.print("Please enter the number of items sold: ");
		itemsSold = keyboard.nextInt();
		
		double pay, totalPay;
		pay = 0.27;
		totalPay = itemsSold * pay;
		
		System.out.println("If " + itemsSold + " items are sold, then the salesperson is paid: $"
				+ totalPay + ".");
		
		keyboard.close();
	}

}
