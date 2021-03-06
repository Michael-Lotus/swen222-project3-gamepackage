package model;

import java.util.List;

import model.item.Item;

/**
 * A Container is anything that can hold Items.
 * 
 * @author Michael 300273397
 */
public interface Container {

	/**
	 * Total amount of space this Container has to store Items.
	 */
	int getTotalSlots();

	/**
	 * Set the size of this Container.
	 */
	void setTotalSlots(int size);

	/**
	 * Amount of space currently occupied by Items.
	 */
	int getSlotsUsed();

	/**
	 * @return List of all Items currently stored in this Container.
	 */
	List<Item> getItems();

	/**
	 * @return true if this Container contains the specified Item.
	 */
	boolean contains(Item item);

	/**
	 * Attempt to add an Item to this Container.
	 * 
	 * @return true if item was successfully added.
	 */
	boolean addItem(Item item);

	/**
	 * Remove specified Item from this Container
	 */
	void removeItem(Item item);

}
