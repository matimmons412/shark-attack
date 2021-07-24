package game;

import java.util.ArrayList;

public class GameBoard implements Board {

	private GameHelper helper = new GameHelper();
	private ArrayList<Boat> boatList = new ArrayList<>();
	private int numOfGuesses = 0;
	
	private static final String[] RANKS = {"A","B","C","D","E","F","G","H"};
	private static final String[] FILES = {"0","1","2","3","4","5","6","7"};
	private int gridSize = 64;
	private int [] grid = new int[gridSize];
	
	public void printGameBoard() {
		System.out.println("****** GAME BOARD ******");
		for(int i = 0; i < FILES.length; i++) {
			for(int j = 0; j < RANKS.length; j++) {
				if (j != 7) {
					System.out.print(RANKS[j]+FILES[i] + " ");
				} else {
					System.out.println(RANKS[j]+FILES[i]);
				}
			}
		}
	}
	
	@Override
	public void setUpGameBoard() {
		Boat boatOne = new Boat("Fishing Boat", 3);
		Boat boatTwo = new Boat("Dinghy Boat", 4);
		Boat boatThree = new Boat("Bowrider", 5);
		boatList.add(boatOne);
		boatList.add(boatTwo);
		boatList.add(boatThree);
		
		System.out.println("\n\nGoal: Sink all 3 boats!");
		System.out.println("The 3 boats are: " + boatOne.getName() + ", " + boatTwo.getName() + ", " + boatThree.getName());
		System.out.println("Sink the boats in the fewest number of guesses!");
		
		for (Boat boatToSet : boatList) {
			ArrayList<String> newLocation = helper.placeBoat(boatToSet.getSize());
			boatToSet.setLocationCells(newLocation);
			System.out.println(boatToSet.getName() + " is at: " + boatToSet.getLocationCells());
		}
	}
	
	public void startPlaying() {
		while(!boatList.isEmpty()) {
			String userGuess = helper.getUserGuess();
//			Boat boat = new Boat();
			checkPlayerGuess(userGuess);
		}
		finishGame();
	}
	
	private void finishGame() {
		System.out.println("You sunk all boats!");
		System.out.println("It took you " + numOfGuesses + " guesses to sink all the boats!");
	}
	
	public void checkPlayerGuess(String userGuess) {
		numOfGuesses++;
		String result = "Miss!";
		for (Boat boatToTest : boatList) {
			result = boatToTest.checkBoatLocation(userGuess);
			if(result.equals("Hit!")) {
				break;
			}
			if(result.equals("Sunk!")) {
				boatList.remove(boatToTest);
				break;
			}
		}
		System.out.println(result);
	}
	
	public String[] getRanks() {
		return RANKS;
	}
	
	public int getBoardLength() {
		return FILES.length;
	}
	
	public int getGridSize() {
		return FILES.length * RANKS.length;
	}
}
