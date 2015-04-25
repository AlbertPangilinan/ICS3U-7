package com.bayviewglen.ecoo2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner s = new Scanner(new File("DATA12.txt"));
		
		int windowSize = Integer.parseInt(s.nextLine());
		
		int count = 0;
		
		String line = s.nextLine();
		
		String[] str = line.split(" ");
		
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		
		
		for (int i = 0; i < str.length; i++) {
		if (count <= windowSize) {
			System.out.print(str[i]);
			count += str[i].length();
			System.out.println(str[i].length());
		} else {
			count = 0;
		}
		}
		
//		String temp = s.nextLine();		
//		String str = s.nextLine();
//		int count = 0;
//		
//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) == ' ') {
//				count++;
//			}
//		}
//		
//		int numberOfWords = count + 1;
//		String[] words = new String[100];
//		int[] wordsLength = new int[100];
//		int count1 = wordsLength[0];
//		int j = 0;
//			
//		System.out.println(windowSize);
//		
//String[] word = str.split(" ");
//System.out.println(word.toString());
//				
//		for (int k = 0; k < words.length; k++) {
//			count1 += wordsLength[k];
//			if (count1 <= windowSize) {
//				System.out.print(words[k] + " ");
//				
//			} else {
//				System.out.println("");
//				count1 = 0;
//				k--;
//			}
//		}
////		while (j <= words.length) {
////		while (count <= windowSize) {
////			System.out.print(words[j]);
////			count += wordsLength[j];
////			j++;
////		}
////		System.out.println("");
////		count = 0;
////		}
		



	
}
}