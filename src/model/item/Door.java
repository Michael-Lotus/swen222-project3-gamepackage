package model.item;

import model.actor.AbstractActor;

public class Door extends Item implements Lockable {

	private boolean open;
	private boolean locked;
	private Key key;

	public void lock(Key key) {
		this.key = key;
		locked = true;
	}

	public boolean unlock(Key key) {
		if (this.key == key) {
			locked = false;
			return true;
		}
		return false;
	}

	public boolean isLocked() {
		return locked;
	}

	public boolean isOpen() {
		return open;
	}

	public void interaction(AbstractActor actor) {
		if (locked) {
			if (actor.getInventory().contains(key)) {
				locked = false;
				open = true;
				// TODO notify player that their key worked
			}
			// TODO notify player that door is locked
		} else {
			open = !open;
		}
	}

	public boolean isContainable() {
		return false;
	}

	public int slotsNeeded() {
		return Integer.MAX_VALUE;
	}

	public String title() {
		return "Door";
	}

	public String description() {
		// TODO 
		return null;
	}

	@Override
	public String id() {
		return open? "door_open": "door_closed";
	}

}
