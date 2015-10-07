package model.item;

import model.actor.AbstractActor;

/**
 * Represents some number of gold pieces.
 * 
 * @author Michael
 */
public class Gold extends Item {
	
	private int amount;
	
	public Gold() {
		this(1);
	}
	
	public Gold(int amount) {
		this.amount = amount;
	}

	public void adjustAmount(int amount) {
		this.amount += amount;
	}
	
	public int getAmount() {
		return amount;
	}

	public void interaction(AbstractActor actor) {
		// TODO
	}

	public boolean isContainable() {
		return true;
	}

	public int slotsNeeded() {
		return 0;
	}

	public String title() {
		return amount+" gold";
	}

	public String description() {
		return "Oooh, shiny...";
	}

}
