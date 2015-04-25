package com.bayviewglen.ccc;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter an English word: ");
		String word = keyboard.nextLine();
		keyboard.close();
		String translated = "";
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != 'a' && word.charAt(i) != 'e' && word.charAt(i) != 'i' && word.charAt(i) != 'o' && word.charAt(i) != 'u') {
				translated += word.charAt(i);
				for (int j = i, k = i; j < alphabet.length && k > 0; j++, k--) {
					if ((alphabet[j] == 'a' || alphabet[j] == 'e' || alphabet[j] == 'i' || alphabet[j] == 'o' || alphabet[j] == 'u') && (alphabet[k] == 'a' || alphabet[k] == 'e' || alphabet[k] == 'i' || alphabet[k] == 'o' || alphabet[k] == 'u')) {
						translated += alphabet[k];
					} else if ((alphabet[j] == 'a' || alphabet[j] == 'e' || alphabet[j] == 'i' || alphabet[j] == 'o' || alphabet[j] == 'u') && (alphabet[k] != 'a' || alphabet[k] != 'e' || alphabet[k] != 'i' || alphabet[k] != 'o' || alphabet[k] != 'u')) {
						translated += alphabet[j];
					} else if ((alphabet[j] != 'a' || alphabet[j] != 'e' || alphabet[j] != 'i' || alphabet[j] != 'o' || alphabet[j] != 'u') && (alphabet[k] == 'a' || alphabet[k] == 'e' || alphabet[k] == 'i' || alphabet[k] == 'o' || alphabet[k] == 'u')) {
						translated += alphabet[k];
					}
				}
			} else if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') {
				translated += word.charAt(i);
			}
		}
		System.out.println(translated);
	}

}
