package model.actor;

public enum ActorProfession {

	WARRIOR("Warrior", 14, 12, 8), 
	ROGUE("Rogue", 10, 14, 10), 
	MAGE("Mage", 8, 12, 14);

	private int strength, agility, intellect;
	private String title;

	ActorProfession(String title, int strength, int agility, int intellect) {
		this.title = title;
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
	}

	public int getStrength() {
		return strength;
	}

	public int getAgility() {
		return agility;
	}

	public int getIntellect() {
		return intellect;
	}

	public String getTitle() {
		return title;
	}
}