package model.actor;

enum ActorClassType {
	WARRIOR(14, 12, 8), ROGUE(10, 14, 10), MAGE(8, 12, 14);
	
	private int STR, AGI, INT;
	
	ActorClassType(int strength, int agility, int intellect) {
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
}