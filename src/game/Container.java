package game;

import java.util.ArrayList;

/**
 * A Container is anything that can hold Items. 
 * 
 * @author Michael 300273397
 */
public interface Container {
	
	/**
	 * Total amount of space this Container has to store Items.
	 */
	public int getCapacity();
	
	/**
	 * Amount of space currently occupied by Items.
	 */
	public int getCurrentLoad();
	
	/**
	 * @return List of all Items currently stored in this Container.
	 */
	public ArrayList<Item> getInventory();
	
	/**
	 * Attempt to add an Item to this Container.
	 * 
	 * @return true if item was successfully added.
	 */
	public boolean addItem(Item item);
	
	/**
	 * Remove specified Item from this Container
	 */
	public void removeItem(Item item);

}
