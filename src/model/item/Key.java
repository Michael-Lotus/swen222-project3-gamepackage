package model.item;

import model.actor.AbstractActor;

public class Key extends Item {

	public void interaction(AbstractActor actor) {
		// TODO 
	}

	public boolean isContainable() {
		return true;
	}

	public int slotsNeeded() {
		return 1;
	}

	public String title() {
		return "Key";
	}

	public String description() {
		return "Wonder what this unlocks...";
	}

}
