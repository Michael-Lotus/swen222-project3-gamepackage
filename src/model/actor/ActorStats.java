package model.actor;

/**
 * STR: Strength determines weapon damage and inventory size
 * AGI: Agility determines weapon hit chance and speed
 * INT: Intellect determines spell damage and literacy
 */
class ActorStats {

	private int STR, AGI, INT;
	
	
	public ActorStats() {
		STR = 10;
		AGI = 10;
		INT = 10;
	}
	
	
	public int getStrength() {
		return STR;
	}
	

	public void setStrength(int strength) {
		STR = strength;
	}
	

	public int getAgility() {
		return AGI;
	}
	

	public void setAgility(int agility) {
		AGI = agility;
	}
	

	public int getIntellect() {
		return INT;
	}
	

	public void setIntellect(int intellect) {
		INT = intellect;
	}

}