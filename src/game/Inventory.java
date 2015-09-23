package game;

import java.util.ArrayList;
import java.util.List;

/**
 * The collection of Items carried by an Actor.
 * 
 * @author Michael 300273397
 */
public class Inventory implements Container {

	private final int totalSlots;
	private int slotsUsed;
	private List<Item> items;
	
	public Inventory(int size) {
		totalSlots = size;
		items = new ArrayList<>();
	}

	public int getTotalSlots() {
		return totalSlots;
	}
	
	public int getSlotsUsed() {
		return slotsUsed;
	}
	
	public List<Item> getItems() {
		return new ArrayList<Item>(items);
	}
	
	public boolean addItem(Item item) {
		if ( !item.isContainable() || (item.slotsNeeded()+slotsUsed) > totalSlots ){
			return false;
		}
		items.add(item);
		slotsUsed += item.slotsNeeded();
		return true;
	}

	public void removeItem(Item item) {
		items.remove(item);
		slotsUsed -= item.slotsNeeded();
	}

	public boolean contains(Item item) {
		return items.contains(item);
	}

}
