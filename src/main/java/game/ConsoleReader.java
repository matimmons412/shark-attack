package game;

import java.util.Scanner;

public class ConsoleReader implements Reader {

	private Scanner keyboard = new Scanner(System.in);
	
	@Override
	public String getInput() {
		System.out.println("Please enter your guess: ");
		String stringGuess = keyboard.next();		
		return stringGuess;
	}

}
