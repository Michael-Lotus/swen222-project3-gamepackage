package model.actor;

import model.item.Item;

public class PlayerActor extends AbstractActor {

	private ActorClassType classType;

	public PlayerActor(ActorClassType playerClass) {
		super();
		classType = playerClass;
		stats.STR = classType.getSTR();
		stats.AGI = classType.getAGI();
		stats.INT = classType.getINT();
	}

	@Override
	public String pickUp() {
		Item item = location.popItem();
		if(inventory.addItem(item)){
			return "Picked up " + item.title();
		} else if (item != null){
			location.addItem(item);
			return "Inventory full.";
		}
		return null;
	}

	@Override
	public void interact() {
		// TODO Auto-generated method stub
	}
}
