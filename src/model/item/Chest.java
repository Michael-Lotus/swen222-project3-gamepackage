package model.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Container;
import model.actor.Actor;

/**
 * A Chest is an immovable Item and Container
 * 
 * @author Michael 300273397
 */
public class Chest extends Item implements Container {

	private int totalSlots;
	private int slotsUsed;
	private List<Item> items;
	
	
	public Chest() {
		this(10);
	}
	
	public Chest(int size) {
		totalSlots = size;
		slotsUsed = 0;
		items = new ArrayList<>();
	}
	
	
	public int getTotalSlots() {
		return totalSlots;
	}


	public void setTotalSlots(int size) {
		totalSlots = size;
	}
	

	public int getSlotsUsed() {
		return slotsUsed;
	}

	
	public List<Item> getItems() {
		return Collections.unmodifiableList(items);
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
		for(Item i: items){
			if (!actor.getInventory().addItem(i)){
				// TODO inventory full; notify
			}
		}
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
	
	
	@Override
	public String toString() {
		String s = "Chest contents: [ ";
		for(Item i: items){
			s = s.concat(i.title()+", ");
		}
		s = (!items.isEmpty())? s.substring(0, s.lastIndexOf(",")) : s;
		s = s.concat(" ]");
		return s;
	}

	
	@Override
	public String id() {
		return items.isEmpty()? "Chest_Open": "Chest_Closed";
	}

	
	
	/*
	public static void main(String[] args) {
		Chest chest = new Chest(10);
		System.out.println("new TreasureChest(10)");
		System.out.println("totalSlots = " + chest.getTotalSlots());
		System.out.println("slotsUsed = " + chest.getSlotsUsed());
		System.out.println(chest.toString());
		System.out.println("\nadding Key to chest...");
		chest.addItem(new Key());
		System.out.println("slotsUsed = " + chest.getSlotsUsed());
		System.out.println(chest.toString());
		System.out.println("\nadding 100 gold to chest...");
		chest.addItem(new Gold(100));
		System.out.println("slotsUsed = " + chest.getSlotsUsed());
		System.out.println(chest.toString());
		System.out.println("\nadding Door to chest...");
		chest.addItem(new Door());
		System.out.println("slotsUsed = " + chest.getSlotsUsed());
		System.out.println(chest.toString());
	}
	*/

	
}
