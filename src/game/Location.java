package game;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a 'square' or 'cell' in the game world. 
 * Has a terrain type, and can contain up to 1 Actor and any number of Items.
 * 
 * @author Michael 300273397
 */
public class Location {

	private final int x, y; 
	private final Terrain terrain; 
	private final Door door;
	private List<Item> items;
	private Actor actor;

	/**
	 * Construct a Location from char symbol.
	 * @param x - east/west coordinate
	 * @param y - north/south coordinate
	 * @param c - terrain charCode
	 */
	public Location(int x, int y, Terrain t) {
		this.x = x;
		this.y = y;
		terrain = t;
		door = terrain.equals(Terrain.DOOR)? new Door(): null;
		items = new ArrayList<Item>();
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

	public Door getDoor() {
		return door;
	}

	public List<Item> getItems() {
		return items;
	}

	public Actor getActor() {
		return actor;
	}

	public boolean setActor(Actor a) {
		if (actor==null) {
			actor = a;
			return true;
		} else {
			return false;
		}
	}
	
	public void removeActor() {
		actor = null;
	}

	public String toString() {
		String s = "Location ("+x+", "+y+"): \n"
				+ "Terrain = " + terrain +"\n"
				+ "Items = " + items.toString();
		return s;
	}

}
