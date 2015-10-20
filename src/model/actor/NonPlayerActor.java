package model.actor;

import model.item.Item;

public class NonPlayerActor extends Actor {
	
	// determines whether this npc helps, ignores, or attacks the player
	protected Disposition disposition; 	

	
	public NonPlayerActor() {
		super();
		disposition = Disposition.NEUTRAL;
	}


	public void setDisposition(Disposition d) {
		disposition = d;
	}

	
	@Override
	public String pickUp() {
		Item item = cell.popItem();
		if(!inventory.addItem(item)){
			cell.addItem(item);
		}
		return null;
	}

	
	@Override
	public void interact() {
		// TODO Auto-generated method stub
	}

	
	public enum Disposition { FRIENDLY, NEUTRAL, HOSTILE; }
}
