package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a 'square' or 'cell' in the game world. 
 * Has a terrain type, and can contain any number of Items.
 * 
 * @author Michael 300273397
 */
public class Location {

	private final int x, y; 
	private final Terrain terrain; 
	private ArrayList<Item> items;
	private final LockableItem door;
	
	/**
	 * Construct a Location from char symbol.
	 * @param x - east/west coordinate
	 * @param y - north/south coordinate
	 * @param c - terrain charCode
	 */
	public Location(int x, int y, char c) {
		this.x = x;
		this.y = y;
		items = new ArrayList<Item>();
		terrain = Terrain.terrainSymbols.get(c);
		door = terrain.equals(Terrain.DOOR)? new Door(): null;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	
	public LockableItem getDoor() {
		return door;
	}
	
	public String toString() {
		String s = "Location ("+x+", "+y+"): \n"
				+ "Terrain = " + terrain +"\n"
				+ "Items = " + items.toString();
		return s;
	}
	
	// === Terrain Type === \\
	// (intended to be expanded upon with additional types as needed)
	public static enum Terrain {
		WALL(false, '#'), FLOOR(true, '.'), DOOR(true, '/');

		private final boolean isTraversable;
		private final char symbol;
		
		// This static Map allows concise conversion from char symbol to enum value
		public static final Map<Character, Terrain> terrainSymbols;
		static{
			Map<Character, Terrain> tempMap = new HashMap<Character, Terrain>();
			tempMap.put(Character.valueOf('#'), WALL);
			tempMap.put(Character.valueOf('.'), FLOOR);
			tempMap.put(Character.valueOf('/'), DOOR);
			terrainSymbols = Collections.unmodifiableMap(tempMap);
		}

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
	}

}
