/*
 * Albert Pangilinan - ICS3U-AP
 * Blackjack Assignment
 */
package com.bayviewglen.blackjack;

import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class Blackjack {

	public static void main(String[] args) {
		boolean quit = false;
		boolean gameOver = false;
		int wallet = 500;

		while (!quit) {
			String name = getUserName();
			Locale location = getLocale();

			while (!gameOver) {
				int bet = getBet(wallet, location);
				String playerCard1 = drawCard();
				String playerCard2 = drawCard();
				String dealerCard1 = drawCard();
				String dealerCard2 = drawCard();
				String playerCards = playerCard1 + " " + playerCard2;
				String dealerCards = dealerCard1 + " XX";
				int playerTotal = getPlayerTotal(playerCard1, playerCard2);

				int playerAction = getFirstAction(playerCards, dealerCards, name, bet, wallet);

				// Start - Hit

				while (playerAction == 1) {
					if (playerTotal < 21) {
						String playerCard = drawCard();
						int playerCardValue = getValue(playerCard);
						playerTotal += playerCardValue;
						if (playerCardValue == 11 && playerTotal > 21) {
							playerCardValue = 1;
							playerTotal -= 10;
						}
						playerCards += " " + playerCard;
						playerAction = getNextAction(playerCards, dealerCards, name, bet, wallet);
					} else if (playerTotal > 21) {
						int dealerTotal = getDealerTotal(dealerCard1, dealerCard2, dealerCards);
						wallet = betResult(dealerCards, playerCards, dealerTotal, playerTotal, name, wallet, bet, location);
						String winner = whoWins(dealerTotal, playerTotal);
						gameOver = playAgain(wallet, bet, winner);
						playerTotal = 0;
						playerAction = 0;
					} else if (playerTotal == 21) {
						int dealerTotal = getDealerTotal(dealerCard1, dealerCard2, dealerCards);
						wallet = betResult(dealerCards, playerCards, dealerTotal, playerTotal, name, wallet, bet, location);
						String winner = whoWins(dealerTotal, playerTotal);
						gameOver = playAgain(wallet, bet, winner);
						playerTotal = 0;
						playerAction = 0;
					}
				}

				// End - Hit
				// Start - Stay

				if (playerAction == 2) {
					int dealerTotal = getDealerTotal(dealerCard1, dealerCard2, dealerCards);
					wallet = betResult(dealerCards, playerCards, dealerTotal, playerTotal, name, wallet, bet, location);
					String winner = whoWins(dealerTotal, playerTotal);
					gameOver = playAgain(wallet, bet, winner);
				}

				// End - Stay
				// Start - Double Down

				else if (playerAction == 3) {
					bet *= 2;

					String playerCard = drawCard();
					int playerCardValue = getValue(playerCard);
					playerTotal += playerCardValue;
					if (playerCardValue == 11 && playerTotal > 21) {
						playerCardValue = 1;
						playerTotal -= 10;
					}
					playerCards += " " + playerCard;

					int dealerTotal = getDealerTotal(dealerCard1, dealerCard2, dealerCards);
					wallet = betResult(dealerCards, playerCards, dealerTotal, playerTotal, name, wallet, bet, location);
					String winner = whoWins(dealerTotal, playerTotal);
					gameOver = playAgain(wallet, bet, winner);
				}

				// End - Double Down

			}
		}
	}

	// Precondition:
	// Postcondition:
	private static String getUserName() {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter your name: ");
		String name = keyboard.nextLine();

		if (name.equalsIgnoreCase("quit")) {
			System.exit(0);
		} else {
			return name;
		}
		return null;
	}

	// Precondition:
	// Postcondition:
	private static Locale getLocale() {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false;
		boolean inRange = false;
		int localeInt = 0;

		// Start - Locale Ask & Validation

		while ((!validInput) || (!inRange)) {
			System.out.println("\n1. Canada (English)");
			System.out.println("2. Canada (French)");
			System.out.println("3. China");
			System.out.println("4. France");
			System.out.println("5. Germany");
			System.out.println("6. Italy");
			System.out.println("7. Japan");
			System.out.println("8. Korea");
			System.out.println("9. People's Republic of China");
			System.out.println("10. Taiwan");
			System.out.println("11. United Kingdom");
			System.out.println("12. United States of America");
			System.out.print("\nPlease enter the number corresponding to your location: ");
			String localeSelect = keyboard.nextLine();

			try {
				localeInt = Integer.parseInt(localeSelect);
				validInput = true;
			} catch (NumberFormatException ex) {
				System.out.println("\nInvalid Input");
			}
			if (validInput) {
				if (localeInt >= 1 && localeInt <= 12) {
					inRange = true;
				} else {
					inRange = false;
					System.out.println("\nInvalid Input");
				}
			}
		}

		Locale loc = Locale.CANADA;

		// End - Locale Ask & Validation
		// Start - Locale Conversion

		if (localeInt == 1) {
			loc = Locale.CANADA;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		} else if (localeInt == 2) {
			loc = Locale.CANADA_FRENCH;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		} else if (localeInt == 3) {

			loc = Locale.CHINA;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		} else if (localeInt == 4) {
			loc = Locale.FRANCE;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		} else if (localeInt == 5) {
			loc = Locale.GERMANY;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		} else if (localeInt == 6) {
			loc = Locale.ITALY;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		} else if (localeInt == 7) {
			loc = Locale.JAPAN;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		} else if (localeInt == 8) {
			loc = Locale.KOREA;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		} else if (localeInt == 9) {
			loc = Locale.PRC;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		} else if (localeInt == 10) {
			loc = Locale.TAIWAN;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		} else if (localeInt == 11) {
			loc = Locale.UK;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		} else if (localeInt == 12) {
			loc = Locale.US;
			String localeName = loc.getISO3Country();
			System.out.println("You have selected " + localeName + " as your location.\n");
			return loc;
		}
		return loc;

		// End - Locale Conversion
	}

	// Precondition:
	// Postcondition:
	private static int getBet(int wallet, Locale location) {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false;
		boolean inRange = false;

		int betInt = 0;

		// Start - Bet Ask & Validation

		while ((!validInput) || (!inRange)) {

			NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(location);
			String newWallet = moneyFormatter.format(wallet);

			System.out.println("You have " + newWallet + ".");
			System.out.print("How much would you like to bet? ");
			String betSelect = keyboard.nextLine();

			try {
				betInt = Integer.parseInt(betSelect);
				validInput = true;
			} catch (NumberFormatException ex) {
				System.out.println("\nInvalid Input");
			}

			if (validInput) {
				if (betInt > wallet) {
					inRange = false;
					System.out.println("\nNot enough money");
				} else {
					return betInt;
				}
			}

			// End - Bet Ask & Validation

		}

		return betInt;

	}

	// Precondition:
	// Postcondition:
	private static String drawCard() {
		final int NUMBER_OF_CARDS = 13;
		final int NUMBER_OF_SUITS = 4;
		final int STARTING_NUMBER = 1;

		String cardValue = null;
		String suitValue = null;

		// Start - Draw Card

		int chooseCardValue = ((int) (Math.random() * NUMBER_OF_CARDS) + STARTING_NUMBER);
		int chooseSuitValue = ((int) (Math.random() * NUMBER_OF_SUITS) + STARTING_NUMBER);

		if (chooseCardValue == 1) {
			cardValue = "A";
		} else if (chooseCardValue >= 2 && chooseCardValue <= 10) {
			cardValue = String.valueOf(chooseCardValue);
		} else if (chooseCardValue == 11) {
			cardValue = "J";
		} else if (chooseCardValue == 12) {
			cardValue = "Q";
		} else if (chooseCardValue == 13) {
			cardValue = "K";
		}
		if (chooseSuitValue == 1) {
			suitValue = "S";
		} else if (chooseSuitValue == 2) {
			suitValue = "D";
		} else if (chooseSuitValue == 3) {
			suitValue = "C";
		} else if (chooseSuitValue == 4) {
			suitValue = "H";
		}

		// End - Draw Card

		String card = cardValue + suitValue;
		return card;
	}

	private static int getPlayerTotal(String playerCard1, String playerCard2) {
		int playerCard1Int = 0, playerCard2Int = 0, playerTotal = 0;

		// Start - Card 1 Calculations

		if (playerCard1.length() == 2) {
			char playerCard1Char = playerCard1.charAt(0);
			if (playerCard1Char == 'J' || playerCard1Char == 'Q' || playerCard1Char == 'K') {
				playerCard1Int = 10;
			} else if (playerCard1Char == 'A') {
				playerCard1Int = 11;
			} else {
				playerCard1Int = Character.getNumericValue(playerCard1Char);
			}

		} else if (playerCard1.length() == 3) {
			playerCard1Int = 10;
		}

		// End - Card 1 Calculations
		// Start - Card 2 Calculations

		if (playerCard2.length() == 2) {
			char playerCard2Char = playerCard2.charAt(0);
			if (playerCard2Char == 'J' || playerCard2Char == 'Q' || playerCard2Char == 'K') {
				playerCard2Int = 10;
			} else if (playerCard2Char == 'A') {
				playerCard2Int = 11;
			} else {
				playerCard2Int = Character.getNumericValue(playerCard2Char);
			}

		} else if (playerCard2.length() == 3) {
			playerCard2Int = 10;
		}

		// End - Card 2 Calculations
		// Start - Ace Check

		if (playerCard1Int == 11 && playerCard2Int == 11) {
			playerCard2Int = 1;
		}

		// End - Ace Check

		playerTotal = playerCard1Int + playerCard2Int;
		return playerTotal;

	}

	private static int getFirstAction(String playerCards, String dealerCards, String name, int bet, int wallet) {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false;
		boolean inRange = false;
		String playerAction;
		int playerActionInt = 0;

		// Start - Display Cards

		System.out.println();
		System.out.println("Dealer: " + dealerCards);
		System.out.println("Player: " + playerCards);

		// End - Display Cards
		// Start - Double Down Check

		while (!validInput || !inRange) {

			if (bet > (wallet / 2)) {
				System.out.println("\nWhat will " + name + " do?");
				System.out.println("1. Hit   2. Stay");
				playerAction = keyboard.nextLine();

				// Start - Action Validation
				try {
					playerActionInt = Integer.parseInt(playerAction);
					validInput = true;
				} catch (NumberFormatException ex) {
					System.out.println("\nInvalid Input");
				}
				if (validInput) {
					if (playerActionInt == 1 || playerActionInt == 2) {
						inRange = true;
					} else {
						inRange = false;
						System.out.println("\nInvalid Input");
					}
				}

				// End - Action Validation

			} else if (bet <= (wallet / 2)) {
				System.out.println("\nWhat will " + name + " do?");
				System.out.println("1. Hit   2. Stay   3. Double Down");
				playerAction = keyboard.nextLine();

				// Start - Action Validation
				try {
					playerActionInt = Integer.parseInt(playerAction);
					validInput = true;
				} catch (NumberFormatException ex) {
					System.out.println("\nInvalid Input");
				}
				if (validInput) {
					if (playerActionInt >= 1 && playerActionInt <= 3) {
						inRange = true;
					} else {
						inRange = false;
						System.out.println("\nInvalid Input");
					}
				}

				// End - Action Validation
			}
		}
		// End - Double Down Check

		return playerActionInt;
	}

	private static int getValue(String playerCard) {
		int playerCardInt = 0;

		// Start - Card Calculations

		if (playerCard.length() == 2) {
			char playerCardChar = playerCard.charAt(0);
			if (playerCardChar == 'J' || playerCardChar == 'Q' || playerCardChar == 'K') {
				playerCardInt = 10;
			} else if (playerCardChar == 'A') {
				playerCardInt = 11;
			} else {
				playerCardInt = Character.getNumericValue(playerCardChar);
			}

		} else if (playerCard.length() == 3) {
			playerCardInt = 10;
		}

		// End - Card Calculations

		return playerCardInt;
	}

	private static int getNextAction(String playerCards, String dealerCards, String name, int bet, int wallet) {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false;
		boolean inRange = false;
		String playerAction;
		int playerActionInt = 0;

		// Start - Display Cards

		System.out.println();
		System.out.println("Dealer: " + dealerCards);
		System.out.println("Player: " + playerCards);

		// End - Display Cards
		// Start - Double Down Check

		while (!validInput || !inRange) {
			System.out.println("\nWhat will " + name + " do?");
			System.out.println("1. Hit   2. Stay");
			playerAction = keyboard.nextLine();

			// Start - Action Validation
			try {
				playerActionInt = Integer.parseInt(playerAction);
				validInput = true;
			} catch (NumberFormatException ex) {
				System.out.println("\nInvalid Input");
			}
			if (validInput) {
				if (playerActionInt == 1 || playerActionInt == 2) {
					inRange = true;
				} else {
					inRange = false;
					System.out.println("\nInvalid Input");
				}
			}
			// End - Action Validation
		}
		// End - Double Down Check

		return playerActionInt;
	}

	private static int getDealerTotal(String dealerCard1, String dealerCard2, String dealerCards) {
		int dealerCard1Int = 0, dealerCard2Int = 0, dealerTotal = 0;

		// Start - Card 1 Calculations

		if (dealerCard1.length() == 2) {
			char dealerCard1Char = dealerCard1.charAt(0);
			if (dealerCard1Char == 'J' || dealerCard1Char == 'Q' || dealerCard1Char == 'K') {
				dealerCard1Int = 10;
			} else if (dealerCard1Char == 'A') {
				dealerCard1Int = 11;
			} else {
				dealerCard1Int = Character.getNumericValue(dealerCard1Char);
			}

		} else if (dealerCard1.length() == 3) {
			dealerCard1Int = 10;
		}

		// End - Card 1 Calculations
		// Start - Card 2 Calculations

		if (dealerCard2.length() == 2) {
			char dealerCard2Char = dealerCard2.charAt(0);
			if (dealerCard2Char == 'J' || dealerCard2Char == 'Q' || dealerCard2Char == 'K') {
				dealerCard2Int = 10;
			} else if (dealerCard2Char == 'A') {
				dealerCard2Int = 11;
			} else {
				dealerCard2Int = Character.getNumericValue(dealerCard2Char);
			}

		} else if (dealerCard2.length() == 3) {
			dealerCard2Int = 10;
		}

		// End - Card 2 Calculations
		// Start - Ace Check

		if (dealerCard1Int == 11 && dealerCard2Int == 11) {
			dealerCard2Int = 1;
		}

		// End - Ace Check
		// Start Dealer Play

		dealerTotal = dealerCard1Int + dealerCard2Int;
		while (dealerTotal < 17) {
			String dealerCard = drawCard();
			int dealerCardValue = getValue(dealerCard);
			dealerTotal += dealerCardValue;
			if (dealerCardValue == 11 && dealerTotal > 21) {
				dealerCardValue = 1;
				dealerTotal -= 10;
			}
			dealerCards += " " + dealerCard;
			if (dealerTotal >= 17) {
				return dealerTotal;
			}
		}
		return dealerTotal;
	}

	private static int betResult (String dealerCards, String playerCards, int dealerTotal, int playerTotal, String name, int wallet, int bet, Locale location) {
		NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(location);
		int newWallet = 0;
		String newWalletFormat = null;
		String winner = null;

		System.out.println();
		System.out.println("Dealer: " + dealerCards);
		System.out.println("Player: " + playerCards);
		System.out.println("\nDealer Total: " + dealerTotal);
		System.out.println("Player Total: " + playerTotal);

		if (dealerTotal == playerTotal) {
			System.out.println("\nTie!");
			newWallet = wallet;
			winner = "tie";
		} else if (dealerTotal == 21) {
			System.out.println("\nWinner: Dealer!");
			newWallet = wallet - bet;
			winner = "dealer";
		} else if (playerTotal > 21) {
			System.out.println("\nWinner: Dealer!");
			newWallet = wallet - bet;
			winner = "dealer";
		} else if (dealerTotal > playerTotal && dealerTotal < 21) {
			System.out.println("\nWinner: Dealer!");
			newWallet = wallet - bet;
			winner = "dealer";
		} else if (playerTotal == 21) {
			System.out.println("\nWinner: " + name + "!");
			newWallet = wallet + bet;
			winner = "player";
		} else if (dealerTotal > 21) {
			System.out.println("\nWinner: " + name + "!");
			newWallet = wallet + bet;
			winner = "player";
		} else if (playerTotal > dealerTotal && playerTotal < 21) {
			System.out.println("\nWinner: " + name + "!");
			newWallet = wallet + bet;
			winner = "player";
		}
		
		newWalletFormat = moneyFormatter.format(newWallet);
		System.out.println("Money: " + newWalletFormat);
		return newWallet;
	}
	
	private static String whoWins (int dealerTotal, int playerTotal) {
		String winner = null;

		if (dealerTotal == playerTotal) {
			winner = "tie";
		} else if (dealerTotal == 21) {
			winner = "dealer";
		} else if (playerTotal > 21) {
			winner = "dealer";
		} else if (dealerTotal > playerTotal && dealerTotal < 21) {
			winner = "dealer";
		} else if (playerTotal == 21) {
			winner = "player";
		} else if (dealerTotal > 21) {
			winner = "player";
		} else if (playerTotal > dealerTotal && playerTotal < 21) {
			winner = "player";
		}
		return winner;
	}

	private static boolean playAgain(int wallet, int bet, String winner) {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false;
		
		while (!validInput){
			if (winner.equals("dealer") && wallet - bet == 0) {
				System.out.println("You are out of money!");
				System.out.println("\n\nGAME OVER\n\n");
				validInput = true;
				return true;
			} else {
				System.out.println("\nPlay again? Y/N");
				String newGame = keyboard.nextLine();
				if (newGame.equalsIgnoreCase("y")) {
					validInput = true;
					return false;
				} else if (newGame.equalsIgnoreCase("n")) {
					validInput = true;
					return true;
				} else {
					System.out.println("Invalid Input");
				}
			}
		}
		return (Boolean) null;
	}
}