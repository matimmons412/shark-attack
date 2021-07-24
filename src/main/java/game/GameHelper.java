package game;

import java.util.ArrayList;
import java.util.Scanner;

public class GameHelper {

	private Scanner keyboard = new Scanner(System.in);
	private static final String ROWS = "ABCDEFGH";
	private int gridLength = 8;
	private int gridSize = 64;
	private int [] grid = new int[gridSize];
	private int boatCount = 0;
	
	public String getUserGuess() {
		System.out.println("Please enter your guess: ");
		String stringGuess = keyboard.next();		
		return stringGuess;
	}
	
	public ArrayList<String> placeBoat(int boatSize){
		ArrayList<String> boatCells = new ArrayList<String>();
		int[] coordinates = new int[boatSize];
		int attempts = 0;
		boolean success = false;
		int location = 0;		
		boatCount++;
		int increment = 1;
		if((boatCount % 2) == 1) {
			increment = gridLength;
		}		
		while(!success & attempts++ < 200) {
			location = (int) (Math.random() * gridSize);
//			System.out.print("Hint: try " + location);
			int x = 0;
			success = true;
			while (success && x < boatSize) {
				if(grid[location] == 0) {
					coordinates[x++] = location;
					location += increment;
					if(location >= gridSize) {
						success = false;
					}
					if(x > 0 && (location % gridLength == 0)) {
						success = false;
					}
				} else {
//					System.out.print(" used " + location);
					success = false;
				}
			}
		}
		
		boatCells = setBoatCells(boatSize, coordinates);
		return boatCells;
	}
	
	private ArrayList<String> setBoatCells(int boatSize, int[] coordinates) {
		ArrayList<String> boatCells = new ArrayList<String>();
		int x = 0;
		int row = 0;
		int column = 0;
		String temp = null;
		
		while(x < boatSize) {
			grid[coordinates[x]] = 1;
			row = (int) (coordinates[x] / gridLength);
			column = coordinates[x] % gridLength;
			temp = String.valueOf(ROWS.charAt(column));
			
			boatCells.add(temp.concat(Integer.toString(row)));
			x++;
		}
		System.out.println("boatCells: " + boatCells);
		return boatCells;
	}
	
}
