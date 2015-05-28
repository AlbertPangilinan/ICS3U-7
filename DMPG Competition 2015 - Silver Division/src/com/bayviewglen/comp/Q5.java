package com.bayviewglen.comp;

import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int counter = 0;
		
		int[][] arr = new int[100][100];
		
		for (int i = 0; i < arr[0].length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = -1;
			}
		}
		
		
		int[] x = new int[m];
		int[] y = new int[m];
		int[] w = new int[m];
		int[] h = new int[m];
		
		for (int i = 0; i < m; i++) {
			x[i] = s.nextInt();
			y[i] = s.nextInt();
			w[i] = s.nextInt();
			h[i] = s.nextInt();
		}
		
		for (int a = 0; a < m; a++) {
		

			
		for (int i = x[a]; i  < x[a]+w[a] ; i++) {
			for (int j = y[a]; j < j+h[a] ; j++) {
				int temp = arr[i][j];
				arr[i][j] = -1 * temp;
			}
		}
		
		if (a == m-1) {
		for (int i = x[a]; i  < x[a]+w[a]; i++) {
			for (int j = y[a]; j < j+h[a]; j++) {
				if (arr[i][j] == 1) {
					counter++;
				}
			}
		}
		} else {
		}
		}
		System.out.println(counter);
	}

}
