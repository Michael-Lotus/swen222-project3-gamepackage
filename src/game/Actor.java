package game;

/**
 * An Actor is anything that can move and interact with Items, and has an inventory.
 * 
 * @author Michael 300273397
 */
public abstract class Actor {

	private final Container inventory;
	private Location location;
	
	public Actor(int inventorySize) {
		inventory = new Inventory(inventorySize);
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
	public abstract void pickUp();
	
	/**
	 * Interact with any Item(s) at current Location.
	 */
	public abstract void interact();
	
	
	
}
