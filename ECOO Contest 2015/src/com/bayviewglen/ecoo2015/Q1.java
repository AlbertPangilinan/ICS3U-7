package com.bayviewglen.ecoo2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("DATA12.txt"));

		for (int j = 0; j < 10; j++) {

			String[] smarties = new String[200];

			int manyItems = 0;
			int numSeconds = 0;
			int[] colours = new int[7];

			int i = 0;

			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				
				if (temp.equals("end of box")) {
					break;
				} else {
					smarties[i] = temp;
					i++;
					manyItems = i;
				}
			}

			for (int i1 = 0; i1 < manyItems - 1; i1++) {
				if (smarties[i1].equals("red")) {
					numSeconds += 16;
				} else if (smarties[i1].equals("brown")) {
					colours[0] += 1;
				} else if (smarties[i1].equals("violet")) {
					colours[1] += 1;
				} else if (smarties[i1].equals("blue")) {
					colours[2] += 1;
				} else if (smarties[i1].equals("pink")) {
					colours[3] += 1;
				} else if (smarties[i1].equals("yellow")) {
					colours[4] += 1;
				} else if (smarties[i1].equals("green")) {
					colours[5] += 1;
				} else if (smarties[i1].equals("orange")) {
					colours[6] += 1;
				}
			}

			for (int i1 = 0; i1 < colours.length; i1++) {
				if (colours[i1] < 7) {
					numSeconds += 13;
				} else if (colours[i1] % 7 > 0) {
					numSeconds += (((colours[i1] / 7) + 1)) * 13;
				} else if (colours[i1] % 7 == 0) {
					numSeconds += ((colours[i1] / 7) * 13);
				}
			}

			System.out.println(numSeconds);
		}

	}
}
