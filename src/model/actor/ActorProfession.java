package model.actor;

public enum ActorProfession {
	
	WARRIOR("Warrior", 14, 12, 8), ROGUE("Rogue", 10, 14, 10), MAGE("Mage", 8, 12, 14);

	
	private int STR, AGI, INT;
	private String title;
	
	ActorProfession(String title, int strength, int agility, int intellect) {
		this.title = title;
		STR = strength;
		AGI = agility;
		INT = intellect;
	}

	public int getSTR() {
		return STR;
	}

	public int getAGI() {
		return AGI;
	}

	public int getINT() {
		return INT;
	}

	public String getTitle() {
		return title;
	}
}