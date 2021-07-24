package game;

import java.util.ArrayList;

public class Boat {
	private ArrayList<String> locationCells;
	private String name;
	private int size;
	
	public Boat(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	public ArrayList<String> getLocationCells(){
		return this.locationCells;
	}
	public void setLocationCells(ArrayList<String> newLocation) {
		this.locationCells = newLocation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	public String checkBoatLocation(String userGuess) {
		String result = "Miss!";
		int index = locationCells.indexOf(userGuess);
		
		if(index >= 0) {
			locationCells.remove(index);
			if(locationCells.isEmpty()) {
				result = "Sunk!";
			} else {
				result = "Hit!";
			}
		}
		
		return result;
	}

}
