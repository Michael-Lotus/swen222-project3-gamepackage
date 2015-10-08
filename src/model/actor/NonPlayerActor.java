package model.actor;

import model.item.Item;

public class NonPlayerActor extends AbstractActor {
	
	public enum Disposition { FRIENDLY, NEUTRAL, HOSTILE; }
	
	// determines whether this npc helps, ignores, or attacks the player
	protected Disposition disposition;

	public NonPlayerActor(String type) {
		super();
		disposition = Disposition.NEUTRAL;
	}

	@Override
	public String pickUp() {
		Item item = location.popItem();
		if(!inventory.addItem(item)){
			location.addItem(item);
		}
		return null;
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub

	}

}
