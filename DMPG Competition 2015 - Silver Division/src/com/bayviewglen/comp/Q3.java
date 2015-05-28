package com.bayviewglen.comp;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int totalLevel = 0;
		
		int n = s.nextInt();
		
		int[] flowerLevels = new int[n];
		
		for (int i = 0; i < n; i++) {
			flowerLevels[i] = s.nextInt();
		}
		
		int m = s.nextInt();
		
		int[][] disturbanceLevels = new int[m][2];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 2; j++){
				disturbanceLevels[i][j] = s.nextInt();
			}
		}
		
		for (int i = 0; i < flowerLevels.length; i++) {
			totalLevel += flowerLevels[i];
		}
		
/*		for (int i = 0; i < flowerLevels.length; i++) {
			System.out.println(flowerLevels[i]);
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println(disturbanceLevels[i][j]);
			}
		}*/
		/*
		for (int i = 0; i < m; i++) {
			if ((flowerLevels[disturbanceLevels[i][0]] + flowerLevels[disturbanceLevels[i][0] - 1]) < disturbanceLevels[i][1]) {
				totalLevel -= Math.min(flowerLevels[disturbanceLevels[i][0]], flowerLevels[disturbanceLevels[i][0] - 1]);
			} else if ((flowerLevels[disturbanceLevels[i][0]] + flowerLevels[disturbanceLevels[i][0] - 1]) >= disturbanceLevels[i][1]) {
				totalLevel -= disturbanceLevels[i][1];
			}
		}
		*/
		for (int i = 0; i < m; i++) {
		
		if (flowerLevels[disturbanceLevels[i][0]] + flowerLevels[disturbanceLevels[i][0] + 1] < disturbanceLevels[i][1]) {
			if (flowerLevels[disturbanceLevels[i][0]] < flowerLevels[disturbanceLevels[i][0] + 1]) {
				flowerLevels[disturbanceLevels[i][0] + 1] = 0;
				disturbanceLevels[i][1] = 0;
			} else {
				flowerLevels[disturbanceLevels[i][0]] = 0;
				disturbanceLevels[i][1] = 0;
			}
		}
		}
		
		for (int i = 0; i < m; i++) {
			totalLevel += flowerLevels[disturbanceLevels[i][0]] + flowerLevels[disturbanceLevels[i][0] + 1] - disturbanceLevels[i][1];
		}
		
		
		
		System.out.print(totalLevel);
	}

}
