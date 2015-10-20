package model.actor;

import model.Container;
import model.Cell;

/**
 * An Actor is anything that can move and interact with Items, and has an inventory.
 * 
 * @author Michael 300273397
 */
public abstract class Actor {

	protected final ActorStats stats;
	protected final Container inventory;
	protected Cell cell;
	
	
	public Actor() {
		stats = new ActorStats();
		inventory = new ActorInventory(stats.getStrength());
	}
	
	
	public ActorStats getStats() {
		return stats;
	}
	
	
	public Container getInventory() {
		return inventory;
	}
	
	
	public Cell getCell() {
		return cell;
	}
	
	
	public void setCell(Cell loc) {
		cell = loc;
	}
	
	
	/**
	 * Attempt to pick up any Item(s) at current Location.
	 */
	public abstract String pickUp();
	
	
	/**
	 * Interact with any Item(s) at current Location.
	 */
	public abstract void interact();

	
	public String id() {
		return "Actor_Default";
	}
	
}
