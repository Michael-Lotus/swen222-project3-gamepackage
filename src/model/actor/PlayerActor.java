package model.actor;

import model.item.Item;

public class PlayerActor extends Actor {

	private ActorProfession profession;

	public PlayerActor(ActorProfession playerClass) {
		super();
		profession = playerClass;
		stats.setStrength(profession.getSTR());
		stats.setAgility(profession.getAGI());
		stats.setIntellect(profession.getINT());
		inventory.setTotalSlots(stats.getStrength());
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
		
	}
	
	
	@Override
	public String id() {
		return "Actor_"+profession.getTitle();
	}
	
}
