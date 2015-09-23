package game;

/**
 * Represents some number of gold pieces.
 * 
 * @author Michael
 */
public class Gold extends Item {
	
	private int amount;
	
	public void adjustAmount(int amount) {
		this.amount += amount;
	}
	
	public int getAmount() {
		return amount;
	}

	public void interaction(Actor actor) {
		// TODO
	}

	public boolean isContainable() {
		return true;
	}

	public int slotsNeeded() {
		return 0;
	}

	public String title() {
		return amount+" Gold";
	}

	public String description() {
		// TODO
		return null;
	}

}
