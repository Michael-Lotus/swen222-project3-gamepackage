package game;

/**
 * An Item is any inanimate object that can be interacted with by a Character.
 * 
 * @author Michael 300273397
 */
public interface Item {
	

	public void interact(Actor actor);
	
	/**
	 * Whether or not this Item can be stored in a Container.
	 */
	public boolean isContainable();
	
	/**
	 * How many 'slots' this item takes up inside a Container.
	 */
	public int getSize();
	
	/**
	 * @return short (one sentence) description of this item.
	 */
	public String getDescription();
	
	/**
	 * @return long (flavour text) description of this item.
	 */
	public String getDetailedDescription();
}
