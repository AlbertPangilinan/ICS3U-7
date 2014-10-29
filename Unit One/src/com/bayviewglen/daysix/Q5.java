package com.bayviewglen.daysix;

public class Q5 {

	public static void main(String[] args) {
		double gamesWon, gamesLost, totalGames;
		gamesWon = 110;
		gamesLost = 44;
		totalGames = gamesWon + gamesLost;
		
		double winPercentage = gamesWon/totalGames;
		double winPercentageRounded = (int)(winPercentage * 1000) / 10.0;
		
		System.out.println("The 1927 New York Yankees' win percentage is: " + winPercentageRounded + "%.");

	}

}
