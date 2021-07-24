package game;

//import java.util.ArrayList;

public class GameApplication {

//	private GameHelper helper = new GameHelper();
//	private ArrayList<Boat> shipList = new ArrayList<>();
//	private int numOfGuesses = 0;
	
	
	public static void main(String[] args) {
		GameBoard newBoard = new GameBoard();
		newBoard.printGameBoard();
		newBoard.setUpGameBoard();
		newBoard.startPlaying();
		
	}
	
}
