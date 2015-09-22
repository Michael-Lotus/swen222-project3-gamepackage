package game;

public abstract class LockableItem implements Item {
	
	private boolean isOpen;
	private boolean isLocked;
	private final Key key;

	public LockableItem() {
		isOpen = false;
		isLocked = false;
		key = null;
	}
	
	public LockableItem(Key key) {
		isOpen = false;
		isLocked = true;
		this.key = key;
	}
	
	public void lock(Key key) {
		if(this.key==key){
			isOpen = false;
			isLocked = true;
		}
	}
	
	public void unlock(Key key) {
		if(this.key==key){
			isLocked = false;
		}
	}
	
	public void interact(Actor actor) {
		if(!isLocked){
			isOpen = !isOpen;
		}
		// TODO 
	}

	public boolean isContainable() {
		return false;
	}

	public int getSize() {
		return 0;
	}

	public String getDescription() {
		// TODO
		return null;
	}

	public String getDetailedDescription() {
		// TODO
		return null;
	}

}
