package com.techelevator;

import java.util.Scanner;

public class RockPaperScissors {

	/*
	 * Command Line programs follow this structure:  Take Input, Calculate Data, Give Output
	 * 
	 * How could we use this structure, with what we know of Java, so far, to write a simple game
	 * like Rock, Paper, Scissors?
	 */
	public static void main(String[] args) {
		
		String[] choices = { "Rock", "Paper", "Scissors" };
		Scanner in = new Scanner(System.in);
		
		int playerWins = 0;
		int computerWins = 0;
		int ties = 0;
		
		for ( ; true ; ) {
			
			System.out.print("Please choose (1) Rock (2) Paper (3) Scissors or (0) to quit >>>");
			
			int userChoice = in.nextInt();
			in.nextLine();
			
			if (userChoice < 0 || userChoice > 3) {
				System.out.println("Invalid choice, please try again!");
				continue;
			}
			
			if (userChoice == 0) {
				break;
			}
			
			int computerChoice = (int) (Math.random() * 3) + 1;
			
			
			System.out.println("The player choose " + choices[userChoice - 1] + " and the computer choose " + choices[computerChoice - 1]);
			
			if (userChoice == computerChoice) {
				System.out.println("It's a TIE!");
				ties++;
			} else if ( (userChoice == 1 && computerChoice == 3) || 
					    (userChoice == 2 && computerChoice == 1) || 
					    (userChoice == 3 && computerChoice == 2) ) {
				System.out.println("The Player Wins!");
				playerWins++;
			} else {
				System.out.println("The Computer Wins!");
				computerWins++;
			}
		}
		
		System.out.println();
		System.out.println("The Final Score is");
		System.out.println("----------------------------------");
		System.out.println("Player Wins: " + playerWins);
		System.out.println("Computer Wins: " + computerWins);
		System.out.println("Ties: " + ties);
		System.out.println("Thank for playing!");
		
	}
	
	
}
