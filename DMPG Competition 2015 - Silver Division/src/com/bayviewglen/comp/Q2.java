package com.bayviewglen.comp;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		int unlocked = 0;

		Scanner s = new Scanner(System.in);

		int r = s.nextInt();
		int n = s.nextInt();

		/*s.nextLine();

		String[] songs = new String[r];
		for (int i = 0; i < r; i++) {
			songs[i] = s.nextLine();
		}

		String[][] songSplits = new String[songs.length][4];
		for (int i = 0; i < songs.length; i++) {
			String[] split = songs[i].split(" ");
			for (int j = 0; j < 4; j++) {
				songSplits[i][j] = split[j];
			}
		}

		String[] tps = new String[n];
		for (int i = 0; i < n; i++) {
			tps[i] = s.nextLine();
		}

		String[][] tpsSplits = new String[n][2];
		for (int i = 0; i < n; i++) {
			String[] split = tps[i].split(" ");
			for (int j = 0; j < 2; j++) {
				tpsSplits[i][j] = split[j];
			}
		}
*/
		
		int[][] songSplits = new int[r][4];
		int[][] tpsSplits = new int[n][2];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < 4; j++){
				songSplits[i][j] = s.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++){
				tpsSplits[i][j] = s.nextInt();
			}
		}
		
		for (int i = 0; i < songSplits.length; i++) {
						
			for (int j = 0; j < tpsSplits.length; j++) {
				if ((tpsSplits[j][0] < songSplits[i][2] && tpsSplits[j][0] > songSplits[i][0]) && tpsSplits[j][1] < songSplits[i][3] && tpsSplits[j][1] > songSplits[i][1]) {
					unlocked++;
					break;
				}
			}
		}

		
		
/*		for (int i = 0; i < tpsSplits.length; i++) {
			int x = songSplits[i][2] - songSplits[i][0];
			int y = songSplits[i][3] - songSplits[i][1];

			if (tpsSplits[i][0] <= x && tpsSplits[i][1] <= y) {
				unlocked++;
			}
		}
		
		*/
		
/*		for (int i = 0; i < tpsSplits.length; i++) {
			int x = Integer.parseInt(songSplits[i][2]) - Integer.parseInt(songSplits[i][0]);
			int y = Integer.parseInt(songSplits[i][3]) - Integer.parseInt(songSplits[i][1]);

			if (Integer.parseInt(tpsSplits[i][0]) <= x && Integer.parseInt(tpsSplits[i][1]) <= y) {
				unlocked++;
			}
		} */
		

		System.out.print(unlocked);

	}

}
