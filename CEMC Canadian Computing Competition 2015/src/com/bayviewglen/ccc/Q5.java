package com.bayviewglen.ccc;

import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("How many pieces of pie are there? ");
		int piePieces = keyboard.nextInt();
		System.out.print("How many people are in line? ");
		int people = keyboard.nextInt();
		keyboard.close();

		int[] piecesGiven = new int[people];
		int count = 1;

		for (int i = 0; i < people - 1; i++) {
			piecesGiven[i] = 1;
		}

		piecesGiven[people - 1] = piePieces - (people - 1);

		for (int i = people - 1; i > 0; i--) {
			while (!(piecesGiven[i] <= piecesGiven[i - 1])) {
				piecesGiven[i - 1]++;
				piecesGiven[i]--;
				count++;
			}
		}
		System.out.println(count);
	}

}
