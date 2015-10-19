package model.item;

public class LockableChest extends Chest implements Lockable {

	private boolean locked;
	private Key key;
	
	
	public LockableChest(int size) {
		super(size);
	}
	

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

}
