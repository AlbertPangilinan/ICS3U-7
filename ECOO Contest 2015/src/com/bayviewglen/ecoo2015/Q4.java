package com.bayviewglen.ecoo2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("DATA12.txt"));
		
		int windowSize = s.nextInt();
		
	//	String temp = s.nextLine();		
		String str = s.nextLine();
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				count++;
			}
		}
		
		int numberOfWords = count + 1;
		String[] words = new String[100];
		int[] wordsLength = new int[100];
	//	int count1 = wordsLength[0];
	//	int j = 0;
			
		System.out.println(windowSize);
		
//		int currentIndex = 0;
//		int i = 0;
//		for (int wordCount = 0; wordCount < numberOfWords - 1; wordCount++) {
//			String word = str.substring(currentIndex, str.indexOf(' '));
//			currentIndex += word.length();
//			words[i] = word;
//			i++;
//		}
		
		String line = s.nextLine();
		System.out.println(line);
		words = line.split(" ");
		
//		String lastWord = str.substring(currentIndex);
		
		int count2 = 0;
		int position = 0;
		while(count2 <= numberOfWords) {
		int k = 0;
		while (position <= windowSize) {
			System.out.print(words[k] + " ");
			position += wordsLength[k];
			k++;
		}
		position = 0;
		count2++;
		}
		
		s.close();
	}

}
