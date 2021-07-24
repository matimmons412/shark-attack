package player;

public class Player {

	private String player1 = "Player 1";
	private String player2 = "Player 2";
	private int[] cellLocations;
	
	public Player(String player1Name, String player2Name, int[] cellLocationsGiven) {
		this.player1 = player1Name;
		this.player2 = player2Name;
		this.cellLocations = cellLocationsGiven;
	}

	public String getPlayer1() {
		return player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public int[] getCellLocations() {
		return cellLocations;
	}
	
	
}
