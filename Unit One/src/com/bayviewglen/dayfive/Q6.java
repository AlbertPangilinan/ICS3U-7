package com.bayviewglen.dayfive;

public class Q6 {

	public static void main(String[] args) {

		double x = 5.5, y = 3.0, z = -2.0;
		int i = 5, j = 4, k = 3;
		
		x += y;
		y += y;
		z += x - y;
		i *= j + k;
		j /= k;
		
		System.out.print(x + " , " + y + " , " + z + " , " + i + " , " + j);

	}

}
