package model;

import java.util.Arrays;

/**
 * Represents the different types of terrain, and whether they are traversable or not.
 * 
 * @author Michael 300273397
 */
public enum Terrain {
	
	WALL(false, '#'), 
	FLOOR(true, '.'), 
	DOOR(true, '/');

	private final boolean isTraversable;
	private final char symbol;

	private Terrain(boolean traversable, char symbol) {
		isTraversable = traversable;
		this.symbol = symbol;
	}

	public boolean isTraversable() {
		return isTraversable;
	}

	public char getSymbol() {
		return symbol;
	}
	
	/**
	 * Returns the Terrain enum value whose symbol is equal to the specified char,
	 * or null if there is no such Terrain.
	 */
	public static Terrain forSymbol(char c) {
		return Arrays.stream(Terrain.values()).filter(t -> t.symbol == c).findFirst().orElse(null);
	}
}