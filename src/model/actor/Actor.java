package model.actor;

import model.Container;
import model.Location;

/**
 * An Actor is anything that can move and interact with Items, and has an inventory.
 * 
 * @author Michael 300273397
 */
public abstract class Actor {

	protected final ActorStats stats;
	protected final Container inventory;
	protected Location location;
	
	public Actor() {
		stats = new ActorStats();
		inventory = new Inventory(stats.getStrength());
	}
	
	public ActorStats getStats() {
		return stats;
	}
	
	public Container getInventory() {
		return inventory;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location loc) {
		location = loc;
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
