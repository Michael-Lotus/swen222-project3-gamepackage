package model.actor;

import model.Container;
import model.Location;

/**
 * An Actor is anything that can move and interact with Items, and has an inventory.
 * 
 * @author Michael 300273397
 */
public abstract class AbstractActor {

	protected final ActorStats stats;
	protected final Container inventory;
	protected Location location;
	
	public AbstractActor() {
		stats = new ActorStats();
		stats.STR = 10;
		stats.AGI = 10;
		stats.INT = 10;
		inventory = new Inventory(stats.STR);
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
	
	/**
	 * STR: Strength determines weapon damage and inventory size
	 * AGI: Agility determines weapon hit chance and speed
	 * INT: Intellect determines spell damage and literacy
	 */
	protected class ActorStats {
		public int STR, AGI, INT;
	}
	
}
