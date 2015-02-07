/*******************************************************************************
 * Author: Albert Pangilinan												   *
 * Course: ICS3U-AP															   *
 * 																			   *
 * Horse Racing Assignment													   *
 * 																			   *
 * This program simulates a series of horse races, where a single or multiple  *
 * players bet on their chosen horse. Each player starts with $500 in their    *
 * wallet. This version includes new features such as a spectator mode, where  *
 * no bet is required, and the ability to create your own player.			   *
 * 									        								   *
 *******************************************************************************/
package com.bayviewglen.horseracing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class HorseRacing {

	// Start - Main Method
	public static void main(String[] args) {
		final int TRACK_LENGTH = 75;
		boolean quit = false;
		System.out.println("Welcome to EA Sports Horse Racing 2015!");
		System.out.println("New features this year: ");
		System.out.println(" ~ Create your own player!");
		System.out.println(" ~ Spectator Mode - no bets required!");
		System.out.println("----------------------------------------");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
		}
		while (!quit) {
			int[] wallets = getPlayerWallets();
			int[] bets = new int[wallets.length];
			int[] horsesBetOn = new int[wallets.length];
			for (int i = 0; i < horsesBetOn.length; i++) {
				horsesBetOn[i] = -1;
			}
			String[] horses = getHorses();
			int numberHorses = numberHorses();
			String[] horsesInRace = horsesInRace(horses, numberHorses);
			String[] players = getPlayers();
			int playerAction = 0;
			while (playerAction != 1) {
				displayHorses(horsesInRace);
				playerAction = options();
				
				// Start - Race
				if (playerAction == 1) {
					countdown();
					String[][] horsePaths = makeHorsePaths(numberHorses, TRACK_LENGTH);
					int[] movementCount = new int[numberHorses];
					int farthestDistance = 0;
					makeRaceTrack(horsesInRace, numberHorses, horsePaths, TRACK_LENGTH);
					try {
						Thread.sleep(1500);
					} catch (InterruptedException ie) {
					}
					while (farthestDistance < TRACK_LENGTH - 1) {
						System.out.println("\n\n");
						movementCount = movementCount(movementCount, numberHorses);
						farthestDistance = farthestDistance(movementCount);
						String[][] horseMovement = horseMovement(horsePaths, movementCount, numberHorses, TRACK_LENGTH);
						makeRaceTrack(horsesInRace, numberHorses, horsePaths, TRACK_LENGTH);
						try {
							Thread.sleep(1500);
						} catch (InterruptedException ie) {
						}
					}
					int winnerIndex = winner(movementCount);
					System.out.println("\n\n\nWinning Horse: " + horsesInRace[winnerIndex] + "\n\n");
					wallets = betOutcomes(winnerIndex, horsesBetOn, players, wallets, bets);
					displayPlayers(players, wallets);
					saveToFile(players, wallets);
					System.out.println("\n\n");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ie) {
					}
					System.out.println("Horses in the next race:");
					// End - Race
					
					// Start - Bet
				} else if (playerAction == 2 && players.length != 0) {
					int totalMoney = 0;
					for (int i = 0; i < wallets.length; i++) {
						totalMoney += wallets[i];
					}
					if (totalMoney == 0) {
						System.out.println("\nNo one has any money to bet with.");
					} else {
						System.out.println("\nNote: Your bet is automatically deducted from your wallet.");
						displayPlayers(players, wallets);
						int selectedPlayer = choosePlayer(players, wallets);
						if (bets[selectedPlayer - 1] == 0) {
							bets[selectedPlayer - 1] = getBet(wallets, selectedPlayer);
							horsesBetOn[selectedPlayer - 1] = getHorsesBetOn(horsesBetOn, horsesInRace, numberHorses);
							wallets = subtractBet(bets, wallets, selectedPlayer);
						} else {
							System.out.println("\nThis player has already betted in this race.");
						}
					}
				} else if (playerAction == 2 && players.length == 0) {
					System.out.println("Please create a player first.");
					// End - Bet

					// Start - Create Player
				} else if (playerAction == 3) {
					createPlayer(players, wallets);
					players = getPlayers();
					wallets = getPlayerWallets();
					bets = new int[wallets.length];
					horsesBetOn = new int[wallets.length];
					for (int i = 0; i < horsesBetOn.length; i++) {
						horsesBetOn[i] = -1;
					}
					// End - Create Player
					
					// Start - Quit & Save to File
				} else if (playerAction == 4) {
					saveToFile(players, wallets);
					System.exit(0);
				}
			}
		}
	}
	// End - Main Method

	// Precondition: The file horseData.dat must exist.
	// Postcondition: Returns a String array containing the names of all the horses in the file.
	public static String[] getHorses() {
		String[] horses = null;
		try {
			Scanner scanner = new Scanner(new File("input/horseData.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];
			for (int i = 0; i < numHorses; i++) {
				horses[i] = scanner.nextLine();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return horses;
	}

	// Precondition: None
	// Postcondition: Returns a random number between 5 and 8 inclusive.
	public static int numberHorses() {
		int numberHorses = (int) ((Math.random() * 4) + 5);
		return numberHorses;
	}
	
	// Precondition: The String array containing the horses must have already been created.
	// Postcondition: Returns a random horse from the array.
	public static String chooseHorse(String[] horses) {
		int horseIndex = (int) ((Math.random() * 85));
		String horse = horses[horseIndex];
		return horse;
	}

	// Precondition: The String array containing the horses must have already been created and a random number between 5 and 8 inclusive must have already been generated.
	// Postcondition: Returns the list of 5 to 8 (inclusive) horses that will be racing
	public static String[] horsesInRace(String[] horses, int numberHorses) {
		String[] horsesInRace = new String[numberHorses];
		int i = 0;
		while (i < numberHorses) {
			String horse = chooseHorse(horses);
			boolean alreadyInRace = alreadyInRace(horse, horsesInRace);
			if (!alreadyInRace) {
				horsesInRace[i] = horse;
				i++;
			}
		}
		return horsesInRace;
	}

	// Precondition: A random horse must have already been created.
	// Postcondition: Returns true if the horse has not already been chosen, and false if it has already been chosen.
	public static boolean alreadyInRace(String horse, String[] horsesInRace) {
		for (int i = 0; i < horsesInRace.length; i++) {
			if (horsesInRace[i] != null && horsesInRace[i].equalsIgnoreCase(horse)) {
				return true;
			}
		}
		return false;
	}
	
	// Precondition: The file playerData.dat must exist.
	// Postcondition: Returns a String array of the current list of players in the game.
	public static String[] getPlayers() {
		String[] players = null;
		try {
			Scanner scanner = new Scanner(new File("input/playerData.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			players = new String[numPlayers];
			for (int i = 0; i < numPlayers; i++) {
				players[i] = scanner.next();
				String s = scanner.next();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return players;
	}
	
	// Precondition: The file playerData.dat must exist.
	// Postcondition: Returns an int array of the current players' wallets.
	public static int[] getPlayerWallets() {
		int[] wallets = null;
		try {
			Scanner scanner = new Scanner(new File("input/playerData.dat"));
			int numPlayers = Integer.parseInt(scanner.nextLine());
			wallets = new int[numPlayers];
			for (int i = 0; i < numPlayers; i++) {
				String s = scanner.next();
				wallets[i] = scanner.nextInt();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wallets;
	}
	
	// Precondition: The horses that will be racing must have already been randomly generated.
	// Postcondition: Displays the horses that will be racing to the console.
	public static void displayHorses(String[] horsesInRace) {
		System.out.printf("\n %-15s %-20s", "Horse Number", "Horse Name");
		System.out.println("\n -------------------------------");
		for (int i = 0; i < horsesInRace.length; i++) {
			System.out.printf("\n %-15s %-20s", i + 1, horsesInRace[i]);
		}
	}

	// Precondition: The horses that will be racing must have already been displayed.
	// Postcondition: Returns the user's action.
	public static int options() {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false, inRange = false;
		int playerChoiceInt = 0;
		while ((!validInput) || (!inRange)) {
			System.out.println("\n\nWhat would you like to do?");
			System.out.println("1. Start Race   2. Place a Bet   3. Create Player   4. Quit and Save Data to File");
			String playerChoiceStr = keyboard.nextLine();
			try {
				playerChoiceInt = Integer.parseInt(playerChoiceStr);
				validInput = true;
			} catch (NumberFormatException ex) {
				System.out.println("\nInvalid input. Please try again...");
			}
			if (validInput) {
				if (playerChoiceInt >= 1 && playerChoiceInt <= 4) {
					inRange = true;
				} else {
					inRange = false;
					System.out.println("\nInvalid input. Please try again...");
				}
			}
		}
		return playerChoiceInt;
	}

	// Precondition: The user must have selected "3. Create Player" from the menu.
	// Postcondition: Adds a player to the String array and to playerData.dat.
	public static void createPlayer(String[] players, int[] wallets) {
		Scanner keyboard = new Scanner(System.in);
		try {
			PrintWriter writer = new PrintWriter("input/playerData.dat", "UTF-8");
			writer.println(players.length + 1);
			for (int i = 0; i < players.length; i++) {
				writer.println(players[i] + " " + wallets[i]);
			}
			System.out.println("Please enter your name: ");
			String playerName = keyboard.next();
			writer.println(playerName + " 500");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Precondition: The int array containing the players must have already been created.
	// Postcondition: Displays the list of players to the console.
	public static void displayPlayers(String[] players, int[] wallets) {
		System.out.printf("\n\n %-15s %-20s %-8s", "Player Number", "Player Name", "Wallet");
		System.out.println("\n --------------------------------------------");
		for (int i = 0; i < players.length; i++) {
			System.out.printf("\n %-15s %-20s %-8s", i + 1, players[i], "$" + wallets[i]);
		}
	}

	// Precondition: The user must have selected "2. Place a Bet" from the menu.
	// Postcondition: Returns the number of the player the user will be betting with.
	public static int choosePlayer(String[] players, int[] wallets) {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false, inRange = false;
		int playerInt = 0;
		while ((!validInput) || (!inRange)) {
			System.out.println("\n\nPlease select a player from the list above.");
			String selectedPlayer = keyboard.nextLine();
			try {
				playerInt = Integer.parseInt(selectedPlayer);
				validInput = true;
			} catch (NumberFormatException ex) {
				System.out.println("\nInvalid input. Please try again...");
			}
			if (validInput) {
				if (playerInt >= 1 && playerInt <= players.length && wallets[playerInt - 1] != 0) {
					inRange = true;
				} else if (playerInt >= 1 && playerInt <= players.length && wallets[playerInt - 1] <= 0) {
					System.out.println("\nThis player has no money left.");
				} else {
					System.out.println("\nInvalid input. Please try again...");
				}
			}
		}
		return playerInt;
	}

	// Precondition: The user must have already selected a player to bet with.
	// Postcondition: Returns the amount of money the selected player would like to bet.
	public static int getBet(int[] wallets, int selectedPlayer) {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false, inRange = false;
		int betInt = 0;
		int wallet = wallets[selectedPlayer - 1];
		while ((!validInput) || (!inRange)) {
			System.out.println("\nYou have $" + wallet + ".");
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
					System.out.println("\nYou do not have enough money.");
				} else {
					return betInt;
				}
			}
		}
		return betInt;
	}

	// Precondition: The selected player must have already entered their bet.
	// Postcondition: Returns the horse that the selected player would like to bet on.
	public static int getHorsesBetOn(int[] horsesBetOn, String[] horsesInRace, int numberHorses) {
		Scanner keyboard = new Scanner(System.in);
		boolean validInput = false, inRange = false;
		int horseInt = 0;
		while ((!validInput) || (!inRange)) {
			System.out.println("\nWhich horse would you like to bet on? ");
			System.out.print("Selecting 0 will also display the list of horses in this race ");
			String horseSelect = keyboard.nextLine();
			try {
				horseInt = Integer.parseInt(horseSelect);
				validInput = true;
			} catch (NumberFormatException ex) {
				System.out.println("\nInvalid input. Please try again...");
			}
			if (validInput) {
				if (horseInt < 0) {
					System.out.println("\nInvalid input. Please try again...");
				} else if (horseInt == 0) {
					displayHorses(horsesInRace);
				} else if (horseInt > numberHorses) {
					System.out.println("\nInvalid input. Please try again...");
				} else {
					return horseInt - 1;
				}
			}
		}
		return horseInt;
	}

	// Precondition: The selected player must have already entered their bet.
	// Postcondition: Subtracts the selected player's bet from their wallet.
	public static int[] subtractBet(int[] bets, int[] wallets, int selectedPlayer) {
		wallets[selectedPlayer - 1] -= bets[selectedPlayer - 1];
		return wallets;
	}

	// Precondition: The user must have selected "1. Start Race" from the menu.
	// Postcondition: Counts down 3 seconds and displays this countdown to the console.
	public static void countdown() {
		System.out.println("\nRace starts in:");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
		}
		;
		System.out.println("3");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
		}
		System.out.println("2");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
		}
		System.out.println("1");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
		}
		System.out.println("GO!");
	}

	// Precondition: The race countdown must have reached "Go!".	
	// Postcondition: Creates a two-dimensional String array with the paths the horses must take.
	public static String[][] makeHorsePaths(int numberHorses, int trackLength) {
		String[][] horsePaths = new String[numberHorses][trackLength];
		for (int i = 0; i < numberHorses; i++) {
			horsePaths[i][0] = String.valueOf(i + 1);
		}
		for (int row = 0; row != numberHorses; row++) {
			for (int col = 1; col != trackLength; col++) {
				horsePaths[row][col] = " ";
				horsePaths[row][trackLength - 1] = "|";
			}
		}
		return horsePaths;
	}

	// Precondition: The horses' paths must have already been created.
	// Postcondition: Creates the track's borders.
	public static void makeBorders(int trackLength) {
		System.out.println();
		for (int i = 0; i < trackLength + 27; i++) {
			System.out.print("-");
		}
	}
	
	// Precondition: The components of the race track (paths and borders) must have already been created.
	// Postcondition: Combines the components to make the complete race track.
	public static void makeRaceTrack(String[] horsesInRace, int numberHorses, String[][] horsePaths, int trackLength) {
		for (int row = 0; row != numberHorses; row++) {
			makeBorders(trackLength);
			for (int col = 0; col != trackLength; col++) {
				if (col == 0) {
					System.out.printf("\n %-25s", horsesInRace[row]);
					System.out.print("|");
				}
				System.out.print(horsePaths[row][col]);
			}
		}
		makeBorders(trackLength);
	}

	// Precondition: The race must have already started.
	// Postcondition: Chooses a random number of spaces between 1 and 10 (inclusive) for each horse to move.
	public static int[] movementCount(int[] movementCount, int numberHorses) {
		for (int i = 0; i < numberHorses; i++) {
			int spacesMoved = (int) ((Math.random() * 10) + 1);
			movementCount[i] += spacesMoved;
			if (movementCount[i] >= 75) {
				movementCount[i] = 74;
			}
		}
		return movementCount;
	}
	
	// Precondition: Each horse must have a number of spaces to move.
	// Postcondition: Moves each horse down their respective paths by the amount chosen earlier.
	public static String[][] horseMovement(String[][] horsePaths, int[] movementCount, int numberHorses, int trackLength) {
		for (int row = 0; row != numberHorses; row++) {
			for (int col = 0; col != trackLength; col++) {
				horsePaths[row][col] = " ";
				horsePaths[row][trackLength - 1] = "|";
			}
		}
		for (int i = 0; i < numberHorses; i++) {
			horsePaths[i][movementCount[i]] = String.valueOf(i + 1);
		}
		return horsePaths;
	}

	// Precondition: Each horses' movement must be recorded.
	// Postcondition: Returns the distance moved of the horse in first place.
	public static int farthestDistance(int[] movementCount) {
		int max = movementCount[0];
		for (int i = 1; i < movementCount.length; i++) {
			if (movementCount[i] > max) {
				max = movementCount[i];
			}
		}
		return max;
	}

	// Precondition: Each horses' movement must be recorded.
	// Postcondition: Returns the number of the winning horse if they travel 74 spaces.
	public static int winner(int[] movementCount) {
		int i = 0;
		while (i < movementCount.length) {
			if (movementCount[i] == 74) {
				return i;
			}
			i++;
		}
		return i;
	}

	// Precondition: The winner of the race must have already been decided.
	// Postcondition: Displays the outcomes of each player's bet to the console, and adds double the player's bet back if they chose correctly.
	public static int[] betOutcomes(int winner, int[] horsesBetOn, String[] players, int[] wallets, int[] bets) {
		for (int i = 0; i < wallets.length; i++) {
			int horseChoice = horsesBetOn[i];
			if (horseChoice >= 0 && winner == horseChoice) {
				wallets[i] += (bets[i] * 2);
				System.out.println(players[i] + " won: $" + bets[i]);
			} else if (horseChoice >= 0 && winner != horseChoice) {
				System.out.println(players[i] + " lost: $" + bets[i]);
			}
		}
		return wallets;
	}

	// Precondition: The player's names and wallet must have already been saved in String and int arrays respectively.
	// Postcondition: Overwrites playerData.dat with the new data.
	public static void saveToFile(String[] players, int[] wallets) {
		try {
			PrintWriter writer = new PrintWriter("input/playerData.dat", "UTF-8");
			writer.println(players.length);
			for (int i = 0; i < players.length; i++) {
				writer.println(players[i] + " " + wallets[i]);
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
// End of Program