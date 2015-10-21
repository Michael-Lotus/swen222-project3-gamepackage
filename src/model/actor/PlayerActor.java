package model.actor;

import model.item.Item;

public class PlayerActor extends Actor {

	private ActorProfession profession;

	public PlayerActor(ActorProfession profession) {
		super();
		this.profession = profession;
		stats.setStrength(profession.getSTR());
		stats.setAgility(profession.getAGI());
		stats.setIntellect(profession.getINT());
		inventory.setTotalSlots(stats.getStrength());
	}

	
	@Override
	public String pickUp() {
		Item item = cell.popItem();
		if(inventory.addItem(item)){
			return "Picked up " + item.title();
		} else if (item != null){
			cell.addItem(item);
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
