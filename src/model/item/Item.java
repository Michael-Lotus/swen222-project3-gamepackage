package model.item;

import model.actor.AbstractActor;

/**
 * An Item is any inanimate object that can be interacted with by a Character.
 * 
 * @author Michael 300273397
 */
public abstract class Item {
	
	public abstract void interaction(AbstractActor actor);
	
	/**
	 * Whether or not this Item can be stored in a Container.
	 */
	public abstract boolean isContainable();
	
	/**
	 * How many 'slots' this item takes up inside a Container.
	 */
	public abstract int slotsNeeded();
	
	/**
	 * @return short (one sentence) description of this item.
	 */
	public abstract String title();
	
	/**
	 * @return long (flavour text) description of this item.
	 */
	public abstract String description();
	
	
	public abstract String id();
	
	
}
