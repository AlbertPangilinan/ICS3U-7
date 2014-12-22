/*******************************************************************************
 * Author: Albert Pangilinan												   *
 * Course: ICS3U-AP															   *
 * 																			   *
 * Blackjack Assignment														   *
 * 																			   *
 * This program simulates a one-player game of Blackjack,					   *
 * where the player plays against a computer generated player – the dealer.    *																		   *
 *******************************************************************************/
package com.bayviewglen.blackjack;

import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;

public class Blackjack {

	// Main Method
	public static void main(String[] args) {
		boolean quit = false;

		while (!quit) {
			boolean gameOver = false;
			int wallet = 500;
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
				int playerTotal = getTotal(playerCard1, playerCard2);
				int dealerTotal = getTotal(dealerCard1, dealerCard2);

				if (playerTotal == 21) {
					dealerCards = dealerCard1 + " " + dealerCard2;
					wallet = betResult(dealerCards, playerCards, dealerTotal, playerTotal, name, wallet, bet, location);
					String winner = whoWins(dealerTotal, playerTotal);
					gameOver = playAgain(wallet, bet, winner);
					playerTotal = 0;
				} else if (playerTotal != 21) {

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
						}
						if (playerTotal < 21) {
							playerAction = getNextAction(playerCards, dealerCards, name, bet, wallet);
						} else if (playerTotal > 21) {
							dealerCards = dealerCard1 + " " + dealerCard2;
							wallet = betResult(dealerCards, playerCards, dealerTotal, playerTotal, name, wallet, bet, location);
							String winner = whoWins(dealerTotal, playerTotal);
							gameOver = playAgain(wallet, bet, winner);
							playerTotal = 0;
							playerAction = 0;
						} else if (playerTotal == 21) {
							dealerCards = dealerCard1 + " " + dealerCard2;
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
						dealerCards = dealerCard1 + " " + dealerCard2;
						boolean dealerDone = false;
						while (!dealerDone) {
							if (playerTotal >= 21) {
								dealerDone = true;
							} else if (playerTotal < 21) {
								if (dealerTotal >= 17) {
									dealerDone = true;
								}
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
										dealerDone = true;
									}
								}
							}
						}
						wallet = betResult(dealerCards, playerCards, dealerTotal, playerTotal, name, wallet, bet, location);
						String winner = whoWins(dealerTotal, playerTotal);
						gameOver = playAgain(wallet, bet, winner);
						playerTotal = 0;
						playerAction = 0;
					// End - Stay

					// Start - Double Down
					} else if (playerAction == 3) {
						bet *= 2;
						String playerCard = drawCard();
						int playerCardValue = getValue(playerCard);
						playerTotal += playerCardValue;
						if (playerCardValue == 11 && playerTotal > 21) {
							playerCardValue = 1;
							playerTotal -= 10;
						}
						playerCards += " " + playerCard;
						dealerCards = dealerCard1 + " " + dealerCard2;
						boolean dealerDone = false;
						while (!dealerDone) {
							if (playerTotal >= 21) {
								dealerDone = true;
							} else if (playerTotal < 21) {
								if (dealerTotal >= 17) {
									dealerDone = true;
								}
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
										dealerDone = true;
									}
								}
							}
						}
						wallet = betResult(dealerCards, playerCards, dealerTotal, playerTotal, name, wallet, bet, location);
						String winner = whoWins(dealerTotal, playerTotal);
						gameOver = playAgain(wallet, bet, winner);
						playerTotal = 0;
						playerAction = 0;
					}
					// End - Double Down
				}
			}
		}
	}

	// Precondition: Prompts the player for their name.
	// Postcondition: Returns the name entered, or exits if the player enters
	// "quit"
	private static String getUserName() {
		Scanner keyboard = new Scanner(System.in);

		System.out.print("\nPlease enter your name: ");
		String name = keyboard.nextLine();

		if (name.equalsIgnoreCase("quit")) {
			System.exit(0);
		} else {
			return name;
		}
		return null;
	}

	// Precondition: Prompts the player for their choice of locale
	// Postcondition: Returns the player's choice of locale
	private static Locale getLocale() {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false;
		boolean inRange = false;
		int localeInt = 0;

		// Start - Locale Validation
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
				System.out.println("\nInvalid input. Please try again...");
			}
			if (validInput) {
				if (localeInt >= 1 && localeInt <= 12) {
					inRange = true;
				} else {
					inRange = false;
					System.out.println("\nInvalid input. Please try again...");
				}
			}
		}

		Locale loc = Locale.CANADA;
		// End - Locale Validation

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

	// Precondition: Takes in amount of money the player has and their locale
	// choice,
	// and prompts the player for the amount of money they wan to bet.
	// Postcondition: Returns the amount of money the player wants to bet.
	private static int getBet(int wallet, Locale location) {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false;
		boolean inRange = false;

		int betInt = 0;

		// Start - Bet Validation
		while ((!validInput) || (!inRange)) {

			NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(location);
			String newWallet = moneyFormatter.format(wallet);

			System.out.println("\nYou have " + newWallet + ".");
			System.out.print("How much would you like to bet? ");
			String betSelect = keyboard.nextLine();

			try {
				betInt = Integer.parseInt(betSelect);
				validInput = true;
			} catch (NumberFormatException ex) {
				System.out.println("\nInvalid input. Please try again...");
			}

			if (validInput) {
				if (betInt <= 0) {
					System.out.println("\nInvalid input. Please try again...");
				} else if (betInt > wallet) {
					System.out.println("\nYou do not have enough money");
				} else {
					return betInt;
				}
			}
			// End - Bet Validation
		}
		return betInt;
	}

	// Precondition: The player must have already entered a valid bet.
	// Postcondition: Returns a String with a random card value and a random
	// suit value.
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

	// Precondition: Takes in two cards from either the player or the dealer.
	// Postcondition: Returns the total of the two cards.
	private static int getTotal(String card1, String card2) {
		int card1Int = 0, card2Int = 0, total = 0;

		// Start - Card 1 Calculations
		if (card1.length() == 2) {
			char card1Char = card1.charAt(0);
			if (card1Char == 'J' || card1Char == 'Q' || card1Char == 'K') {
				card1Int = 10;
			} else if (card1Char == 'A') {
				card1Int = 11;
			} else {
				card1Int = Character.getNumericValue(card1Char);
			}
		} else if (card1.length() == 3) {
			card1Int = 10;
		}
		// End - Card 1 Calculations

		// Start - Card 2 Calculations
		if (card2.length() == 2) {
			char card2Char = card2.charAt(0);
			if (card2Char == 'J' || card2Char == 'Q' || card2Char == 'K') {
				card2Int = 10;
			} else if (card2Char == 'A') {
				card2Int = 11;
			} else {
				card2Int = Character.getNumericValue(card2Char);
			}
		} else if (card2.length() == 3) {
			card2Int = 10;
		}
		// End - Card 2 Calculations

		// Start - Ace Check
		if (card1Int == 11 && card2Int == 11) {
			card2Int = 1;
		}
		// End - Ace Check

		total = card1Int + card2Int;
		return total;
	}

	// Precondition: The player and dealer must have already drawn their cards.
	// Postcondition: Returns the first action of the player.
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

		
		while (!validInput || !inRange) {
			// Start - No Double Down
			if (bet > (wallet / 2)) {
				System.out.println("\nWhat will " + name + " do?");
				System.out.println("1. Hit   2. Stay");
				playerAction = keyboard.nextLine();

				// Start - Action Validation
				try {
					playerActionInt = Integer.parseInt(playerAction);
					validInput = true;
				} catch (NumberFormatException ex) {
					System.out.println("\nInvalid input. Please try again...");
				}
				if (validInput) {
					if (playerActionInt == 1 || playerActionInt == 2) {
						inRange = true;
					} else {
						inRange = false;
						System.out.println("\nInvalid input. Please try again...");
					}
				}
				// End - Action Validation
			// End - No Double Down

			// Start - Double Down Check
			} else if (bet <= (wallet / 2)) {
				System.out.println("\nWhat will " + name + " do?");
				System.out.println("1. Hit   2. Stay   3. Double Down");
				playerAction = keyboard.nextLine();

				// Start - Action Validation
				try {
					playerActionInt = Integer.parseInt(playerAction);
					validInput = true;
				} catch (NumberFormatException ex) {
					System.out.println("\nInvalid input. Please try again...");
				}
				if (validInput) {
					if (playerActionInt >= 1 && playerActionInt <= 3) {
						inRange = true;
					} else {
						inRange = false;
						System.out.println("\nInvalid input. Please try again...");
					}
				}
				// End - Action Validation
			}
		}
		// End - Double Down Check

		return playerActionInt;
	}

	// Precondition: Takes in a card, from either the player or the dealer.
	// Postcondition: Returns the value of the card.
	private static int getValue(String card) {
		int cardInt = 0;

		// Start - Card Calculations
		if (card.length() == 2) {
			char cardChar = card.charAt(0);
			if (cardChar == 'J' || cardChar == 'Q' || cardChar == 'K') {
				cardInt = 10;
			} else if (cardChar == 'A') {
				cardInt = 11;
			} else {
				cardInt = Character.getNumericValue(cardChar);
			}
		} else if (card.length() == 3) {
			cardInt = 10;
		}
		// End - Card Calculations

		return cardInt;
	}

	// Precondition: The player must have already chosen their first action.
	// Postcondition: Returns the next action of the player.
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

		while (!validInput || !inRange) {
			System.out.println("\nWhat will " + name + " do?");
			System.out.println("1. Hit   2. Stay");
			playerAction = keyboard.nextLine();

			// Start - Action Validation
			try {
				playerActionInt = Integer.parseInt(playerAction);
				validInput = true;
			} catch (NumberFormatException ex) {
				System.out.println("\nInvalid input. Please try again...");
			}
			if (validInput) {
				if (playerActionInt == 1 || playerActionInt == 2) {
					inRange = true;
				} else {
					inRange = false;
					System.out.println("\nInvalid input. Please try again...");
				}
			}
			// End - Action Validation
		}
		return playerActionInt;
	}

	// Precondition: The player must have already chosen to stay or double down,
	//               or has a total greater than or equal to 21.
	// Postcondition: Returns the player's new amount of money after the bet is
	//                added or subtracted.
	private static int betResult(String dealerCards, String playerCards, int dealerTotal, int playerTotal, String name, int wallet, int bet, Locale location) {
		NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(location);
		int newWallet = 0;
		String newWalletFormat = null;

		// Start - Display Totals
		System.out.println();
		System.out.println("Dealer: " + dealerCards);
		System.out.println("Player: " + playerCards);
		System.out.println("\nDealer Total: " + dealerTotal);
		System.out.println("Player Total: " + playerTotal);
		// End - Display Totals
		
		// Start - Wallet Calculations
		if (dealerTotal == playerTotal) {
			System.out.println("\nTie!");
			newWallet = wallet;
		} else if (dealerTotal == 21) {
			System.out.println("\nWinner: Dealer!");
			newWallet = wallet - bet;
		} else if (playerTotal > 21) {
			System.out.println("\nWinner: Dealer!");
			newWallet = wallet - bet;
		} else if (dealerTotal > playerTotal && dealerTotal < 21) {
			System.out.println("\nWinner: Dealer!");
			newWallet = wallet - bet;
		} else if (playerTotal == 21) {
			System.out.println("\nWinner: " + name + "!");
			newWallet = wallet + bet;
		} else if (dealerTotal > 21) {
			System.out.println("\nWinner: " + name + "!");
			newWallet = wallet + bet;
		} else if (playerTotal > dealerTotal && playerTotal < 21) {
			System.out.println("\nWinner: " + name + "!");
			newWallet = wallet + bet;
		}
		// End - Wallet Calculations

		newWalletFormat = moneyFormatter.format(newWallet);
		System.out.println("Money: " + newWalletFormat);
		return newWallet;
	}

	// Precondition: The player must have already chosen to stay or double down,
	// 				 or has a total greater than or equal to 21.
	// Postcondition: Returns the winner of the hand.
	private static String whoWins(int dealerTotal, int playerTotal) {
		String winner = null;

		// Start - Winner Decision
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
		// End - Winner Decision
		
		return winner;
	}

	// Precondition: The winner of the hand must have already been decided.
	// Postcondition: Returns a boolean value stating whether the player would
	//                like to play another game,
	//                or ends the game when the player has no money left.
	private static boolean playAgain(int wallet, int bet, String winner) {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false;

		while (!validInput) {
			
			// Start - Game Over
			if (winner.equals("dealer") && wallet == 0) {
				System.out.println("\nYou are out of money!");
				System.out.println("\n\nGAME OVER\n");
				validInput = true;
				return true;
			// End - Game Over
				
			// Start - Play Again
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
					System.out.println("Invalid input. Please try again...");
				}
			// End - Play Again
				
			}
		}
		return (Boolean) null;
	}
}
// End of Program