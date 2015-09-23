package game;

import java.util.ArrayList;
import java.util.List;

/**
 * Here there be treasuuurrrre!
 * 
 * @author Michael 300273397
 */
public class TreasureChest extends Item implements Container {

	private final int totalSlots;
	private int slotsUsed;
	private List<Item> items;
	
	public TreasureChest(int size) {
		totalSlots = size;
		slotsUsed = 0;
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

	public boolean contains(Item item) {
		return items.contains(item);
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

	public void interaction(Actor actor) {
		// TODO 
	}

	public boolean isContainable() {
		return false;
	}

	public int slotsNeeded() {
		return Integer.MAX_VALUE;
	}

	public String title() {
		return "Treasure Chest";
	}

	public String description() {
		// TODO
		return null;
	}

}
