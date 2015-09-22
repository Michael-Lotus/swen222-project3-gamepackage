package game;

import java.util.ArrayList;

/**
 * An Actor is anything that can move and interact with Items, and has an inventory.
 * 
 * @author Michael 300273397
 */
public abstract class Actor implements Container {

	private ArrayList<Item> inventory;
	private int capacity;
	private int currentLoad;
	private Location currentLocation;
	
	public Location getCurrentLocation() {
		return currentLocation;
	}
	
	public void setCurrentLocation(Location loc) {
		currentLocation = loc;
	}
	
	/**
	 * Attempt to pick up any Item(s) at current Location.
	 */
	public abstract void pickUp();
	
	/**
	 * Interact with any Item(s) at current Location.
	 */
	public abstract void interact();
	
	
	// === Container Methods === \\
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getCurrentLoad() {
		return currentLoad;
	}
	
	public ArrayList<Item> getInventory() {
		return new ArrayList<Item>(inventory);
	}
	
	public boolean addItem(Item item) {
		if ( (item.getSize()+currentLoad) > capacity ){
			return false;
		}
		inventory.add(item);
		currentLoad += item.getSize();
		return true;
	}

	public void removeItem(Item item) {
		inventory.remove(item);
		currentLoad -= item.getSize();
	}
	
}
