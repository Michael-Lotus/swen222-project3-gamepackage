package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.actor.AbstractActor;
import model.item.Door;
import model.item.Item;

/**
 * Represents a 'square' or 'cell' in the game world. 
 * Has a terrain type, and can contain up to 1 Actor and any number of Items.
 * 
 * @author Michael 300273397
 */
public class Location implements Container{

	private final int x, y; 
	private final Terrain terrain;
	private Door door;

	private List<Item> items;
	private AbstractActor actor;

	/**
	 * Construct a Location with specified coordinates and terrain type.
	 * @param x - east/west coordinate
	 * @param y - north/south coordinate
	 * @param t - Terrain enum
	 */
	public Location(int x, int y, Terrain t) {
		this.x = x;
		this.y = y;
		terrain = t;
		items = new ArrayList<>();
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
		return Collections.unmodifiableList(items);
	}

	
	/**
	 * Removes the first (containable) Item found at this Location and returns it.
	 */
	public Item popItem() {
		for (Item item: items){
			if (item.isContainable()){
				return item;
			}
		}
		return null;
	}
	

	public AbstractActor getActor() {
		return actor;
	}
	

	public boolean setActor(AbstractActor a) {
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
		String s = "Location ("+x+", "+y+") \n"
				+ "Terrain: " + terrain +"\n"
				+ "Items: " + items.toString();
		return s;
	}
	

	@Override
	public int getTotalSlots() {
		return Integer.MAX_VALUE;
	}
	

	@Override
	public int getSlotsUsed() {
		return 0;
	}
	

	@Override
	public boolean contains(Item item) {
		return items.contains(item);
	}
	

	@Override
	public boolean addItem(Item item) {
		if (item instanceof Door){
			door = (Door) item;
			return true;
		} else {
			return items.add(item);
		}
	}

	
	@Override
	public void removeItem(Item item) {
		items.remove(item);
	}


	public boolean isEmpty() {
		return items.isEmpty();
	}


}
