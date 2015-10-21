package model.item;

import model.actor.Actor;

public class Key extends Item {

	public void interaction(Actor actor) {
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

	@Override
	public String id() {
		return "Key";
	}

}
